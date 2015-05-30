package org.wikibooks.en;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.DoubleType;
import org.hibernate.type.Type;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class Main {

	@PersistenceContext
	private EntityManager em;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		Main main = ctx.getBean("main", Main.class);
		main.jpaCriteria(ctx);

		ctx.close();
	}

	@Transactional
	public void hibernateCriteria(ConfigurableApplicationContext ctx) {
		Session session = em.unwrap(Session.class);

		System.out.println("Select the names of all products in the store");
		session.createCriteria(Product.class)
			.setProjection(Projections.property("name"))
			.list();

		System.out.println("Select the names and the prices of all the products"
				+ " in the store.");
		session.createCriteria(Product.class)
			.setProjection(Projections.projectionList()
				.add(Projections.property("name"))
				.add(Projections.property("price"))
			)
			.list();
		
		System.out.println("Select the name of the products with a price less"
				+ "than or equal to $200.");
		session.createCriteria(Product.class)
			.add(Restrictions.le("price", 200.0))
			.setProjection(Projections.property("price"))
			.list();
		
		System.out.println("Select all the products with a price between $60"
				+ " and $120.");
		session.createCriteria(Product.class)
			.add(Restrictions.between("price", 60.0, 120.0))
			.list();
		
		System.out.println("Select the name and price in cents (i.e., the price"
				+ "must be multiplied by 100.");
		session.createCriteria(Product.class)
			.setProjection(Projections.sqlProjection(
					"price * 100 as price_cents",
					new String[]{"price_cents"},
					new Type[]{new DoubleType()})
			)
			.list();
		
		System.out.println("Compute the average price of all the products.");
		session.createCriteria(Product.class)
			.setProjection(Projections.avg("price"))
			.uniqueResult();
		
		System.out.println("Compute the average price of all products with"
				+ "manufacturer code equal to 2.");
		session.createCriteria(Product.class)
			.add(Restrictions.eq("manufacturer.code", 2))
			.setProjection(Projections.avg("price"))
			.uniqueResult();
		
		System.out.println(" Compute the number of products with a price larger"
				+ "than or equal to $180.");
		session.createCriteria(Product.class)
			.add(Restrictions.ge("price", 180.0))
			.setProjection(Projections.rowCount())
			.uniqueResult();
		
		System.out.println("Select the name and price of all products with a"
				+ "price larger than or equal to $180, and sort first by price"
				+ "(in descending order), and then by name (in ascending order).");
		session.createCriteria(Product.class)
			.add(Restrictions.ge("price", 180.0))
			.addOrder(Order.desc("price"))
			.addOrder(Order.asc("name"))
			.list();
		
		System.out.println(" Select all the data from the products, including"
				+ "all the data for each product's manufacturer.");
		session.createCriteria(Product.class)
			.setFetchMode("manufacturer", FetchMode.JOIN)
			.list();
		
		System.out.println(" Select the product name, price, and manufacturer"
				+ "name of all the products.");
		session.createCriteria(Product.class)
			.createAlias("manufacturer", "manufacturer")
			.setProjection(Projections.projectionList()
					.add(Projections.property("name"))
					.add(Projections.property("price"))
					.add(Projections.property("manufacturer.name"))
			)
			.list();
	}
	
	@Transactional
	public void jpaCriteria(ConfigurableApplicationContext ctx) {
		
		System.out.println("Select the names of all products in the store");
		
		CriteriaBuilder cb1 = em.getCriteriaBuilder();
		CriteriaQuery<Product> c1 = cb1.createQuery(Product.class);
		Root<Product> product1 = c1.from(Product.class);
		CriteriaQuery<Product> query1 = c1.select(product1);
		em.createQuery(query1).getResultList();
		


		System.out.println("Select the names and the prices of all the products"
				+ " in the store.");
		
		CriteriaBuilder cb2 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c2 = cb2.createTupleQuery();
		Root<Product> product2 = c2.from(Product.class);
		CriteriaQuery<Tuple> query2 = c2.multiselect(product2.get("name"));
		em.createQuery(query2).getResultList();
		
		
		System.out.println("Select the names and the prices of all the products"
				+ " in the store (using metamodel).");
		
		CriteriaBuilder cb21 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c21 = cb21.createTupleQuery();
		Root<Product> product21 = c21.from(Product.class);
		CriteriaQuery<Tuple> query21 = c21.multiselect(product21.get(Product_.name));
		em.createQuery(query21).getResultList();
		



		System.out.println("Select the name of the products with a price less"
				+ " than or equal to $200.");
		
		CriteriaBuilder cb3 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c3 = cb3.createTupleQuery();
		Root<Product> product3 = c3.from(Product.class);
		CriteriaQuery<Tuple> query3 = c3
				.multiselect(product3.get("name"), product3.get("price"))
				.where(cb3.le(product3.<Double>get("price"), 200.0));
		em.createQuery(query3).getResultList();
		
		
		System.out.println("Select the name of the products with a price less"
				+ " than or equal to $200 (using subquery).");
		
		CriteriaBuilder cb31 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c31 = cb31.createTupleQuery();
		
		Subquery<Product> sq = c31.subquery(Product.class);
		Root<Product> from = sq.from(Product.class);
		/* mutates the sq object!!! */
		sq.select(from).where(cb31.le(from.<Double>get("price"), 200.0));
		
		Root<Product> product31 = c31.from(Product.class);
		CriteriaQuery<Tuple> query31 = c31
				.multiselect(product31.get("name"), product31.get("price"))
				.where(cb31.in(product31).value(sq));
		em.createQuery(query31).getResultList();



		System.out.println("Select all the products with a price between $60 and"
				+ " $120.");
		
		CriteriaBuilder cb4 = em.getCriteriaBuilder();
		CriteriaQuery<Product> c4 = cb4.createQuery(Product.class);
		Root<Product> product4 = c4.from(Product.class);
		CriteriaQuery<Product> q4 = c4
				.select(product4)
				.where(cb4.between(product4.<Double>get("price"), 60.0, 120.0));
		em.createQuery(q4).getResultList();



		System.out.println("Select the name and price in cents (i.e., the price"
				+ " must be multiplied by 100.");
		
		CriteriaBuilder cb5 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c5 = cb5.createTupleQuery();
		Root<Product> product5 = c5.from(Product.class);
		CriteriaQuery<Tuple> q5 = c5
				.multiselect(
						product5.get("name"),
						cb4.prod(product5.<Double>get("price"), 100.0)
				);
		em.createQuery(q5).getResultList();
		



		System.out.println("Compute the average price of all the products.");
		
		CriteriaBuilder cb6 = em.getCriteriaBuilder();
		CriteriaQuery<Double> c6 = cb6.createQuery(Double.class);
		Root<Product> product6 = c6.from(Product.class);
		CriteriaQuery<Double> q6 = c6.select(cb6.avg(product6.<Double>get("price")));
		em.createQuery(q6).getSingleResult();



		System.out.println("Compute the average price of all products with"
				+ " manufacturer code equal to 2.");
		
		CriteriaBuilder cb7 = em.getCriteriaBuilder();
		CriteriaQuery<Double> c7 = cb7.createQuery(Double.class);
		Root<Product> product7 = c7.from(Product.class);
		CriteriaQuery<Double> q7 = c7
				.select(cb7.avg(product7.<Double>get("price")))
				.where(cb7.equal(product7.<Integer>get("manufacturer"), 2));
		em.createQuery(q7).getSingleResult();
		
		
		System.out.println(" Compute the number of products with a price larger"
				+ " than or equal to $180.");
		
		CriteriaBuilder cb8 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c8 = cb8.createTupleQuery();
		Root<Product> product8 = c8.from(Product.class);
		CriteriaQuery<Tuple> q8 = c8
				.multiselect(cb8.count(product8))
				.where(cb8.ge(product8.<Double>get("price"), 180.0));
		em.createQuery(q8).getSingleResult();



		System.out.println("Select the name and price of all products with a"
				+ " price larger than or equal to $180, and sort first by price"
				+ " (in descending order), and then by name (in ascending order).");
		
		CriteriaBuilder cb9 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c9 = cb9.createTupleQuery();
		Root<Product> product9 = c9.from(Product.class);
		CriteriaQuery<Tuple> q9 = c9
				.multiselect(product9.get("name"), product9.get("price"))
				.where(cb9.ge(product9.<Double>get("price"), 180.0))
				.orderBy(cb9.desc(product9.<Double>get("price")),
						cb9.asc(product9.<String>get("name")));
		em.createQuery(q9).getResultList();
		
		System.out.println("Select the name and price of all products with a"
				+ " price larger than or equal to $180, and sort first by price"
				+ " (in descending order), and then by name (in ascending order)"
				+ " (using criteria parameter).");
		
		CriteriaBuilder cb91 = em.getCriteriaBuilder();
		ParameterExpression<Double> priceArg = cb91.parameter(Double.class, "priceArg");
		CriteriaQuery<Tuple> c91 = cb91.createTupleQuery();
		Root<Product> product91 = c91.from(Product.class);
		CriteriaQuery<Tuple> q91 = c91
				.multiselect(product91.get("name"), product91.get("price"))
				.where(cb91.ge(product91.<Double>get("price"), priceArg))
				.orderBy(cb91.desc(product91.<Double>get("price")),
						cb91.asc(product91.<String>get("name")));
		em.createQuery(q91).setParameter("priceArg", 180.0).getResultList();



		System.out.println(" Select all the data from the products, including"
				+ " all the data for each product's manufacturer (with join).");
		
		CriteriaBuilder cb10 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c10 = cb10.createTupleQuery();
		Root<Product> product10 = c10.from(Product.class);
		Join<Object, Object> manufacturer10 = product10.join("manufacturer");
		CriteriaQuery<Tuple> q10 = c10.multiselect(product10, manufacturer10);
		em.createQuery(q10).getResultList();

		System.out.println(" Select all the data from the products, including"
				+ " all the data for each product's manufacturer(with cartesian"
				+ " product).");
		
		CriteriaBuilder cb101 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c101 = cb101.createTupleQuery();
		Root<Product> product101 = c101.from(Product.class);
		Root<Manufacturer> manufacturer101 = c101.from(Manufacturer.class);
		CriteriaQuery<Tuple> q101 = c101
				.multiselect(product101, manufacturer101)
				.where(cb101.equal(
						product101.<Integer>get("manufacturer"),
						manufacturer101.<Integer>get("code"))
				);
		em.createQuery(q101).getResultList();

		System.out.println(" Select the product name, price, and manufacturer"
				+ " name of all the products (with join).");
		
		CriteriaBuilder cb11 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c11 = cb11.createTupleQuery();
		Root<Product> product11 = c11.from(Product.class);
		Join<Object, Object> manufacturer11 = product11.join("manufacturer");
		CriteriaQuery<Tuple> q11 = c11.multiselect(
				product11.<String>get("name"),
				product11.<Double>get("price"),
				manufacturer11.<String>get("name")
		);
		
		em.createQuery(q11).getResultList();
		
		System.out.println(" Select the product name, price, and manufacturer"
				+ " name of all the products (with path).");
		
		CriteriaBuilder cb12 = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> c12 = cb12.createTupleQuery();
		Root<Product> product12 = c12.from(Product.class);
		CriteriaQuery<Tuple> q12 = c12
				.multiselect(
						product12.<String>get("name"),
						product12.<Double>get("price"),
						product12.get("manufacturer").get("name")
				);
		
		em.createQuery(q12).getResultList();
	}
}
