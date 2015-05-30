//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.02 at 01:32:51 PM IDT 
//


package org.ff4j.schema.ff4j;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.ff4j.schema.ff4j package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FeatureTypeProperties_QNAME = new QName("http://www.ff4j.org/schema/ff4j", "properties");
    private final static QName _FeatureTypeSecurity_QNAME = new QName("http://www.ff4j.org/schema/ff4j", "security");
    private final static QName _FeatureTypeFlipstrategy_QNAME = new QName("http://www.ff4j.org/schema/ff4j", "flipstrategy");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.ff4j.schema.ff4j
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Features }
     * 
     */
    public Features createFeatures() {
        return new Features();
    }

    /**
     * Create an instance of {@link FeatureType }
     * 
     */
    public FeatureType createFeatureType() {
        return new FeatureType();
    }

    /**
     * Create an instance of {@link FeatureType.Properties }
     * 
     */
    public FeatureType.Properties createFeatureTypeProperties() {
        return new FeatureType.Properties();
    }

    /**
     * Create an instance of {@link FeatureType.Flipstrategy }
     * 
     */
    public FeatureType.Flipstrategy createFeatureTypeFlipstrategy() {
        return new FeatureType.Flipstrategy();
    }

    /**
     * Create an instance of {@link FeatureType.Security }
     * 
     */
    public FeatureType.Security createFeatureTypeSecurity() {
        return new FeatureType.Security();
    }

    /**
     * Create an instance of {@link Features.FeatureGroup }
     * 
     */
    public Features.FeatureGroup createFeaturesFeatureGroup() {
        return new Features.FeatureGroup();
    }

    /**
     * Create an instance of {@link FeatureType.Properties.Property }
     * 
     */
    public FeatureType.Properties.Property createFeatureTypePropertiesProperty() {
        return new FeatureType.Properties.Property();
    }

    /**
     * Create an instance of {@link FeatureType.Flipstrategy.Param }
     * 
     */
    public FeatureType.Flipstrategy.Param createFeatureTypeFlipstrategyParam() {
        return new FeatureType.Flipstrategy.Param();
    }

    /**
     * Create an instance of {@link FeatureType.Security.Role }
     * 
     */
    public FeatureType.Security.Role createFeatureTypeSecurityRole() {
        return new FeatureType.Security.Role();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureType.Properties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ff4j.org/schema/ff4j", name = "properties", scope = FeatureType.class)
    public JAXBElement<FeatureType.Properties> createFeatureTypeProperties(FeatureType.Properties value) {
        return new JAXBElement<FeatureType.Properties>(_FeatureTypeProperties_QNAME, FeatureType.Properties.class, FeatureType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureType.Security }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ff4j.org/schema/ff4j", name = "security", scope = FeatureType.class)
    public JAXBElement<FeatureType.Security> createFeatureTypeSecurity(FeatureType.Security value) {
        return new JAXBElement<FeatureType.Security>(_FeatureTypeSecurity_QNAME, FeatureType.Security.class, FeatureType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureType.Flipstrategy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ff4j.org/schema/ff4j", name = "flipstrategy", scope = FeatureType.class)
    public JAXBElement<FeatureType.Flipstrategy> createFeatureTypeFlipstrategy(FeatureType.Flipstrategy value) {
        return new JAXBElement<FeatureType.Flipstrategy>(_FeatureTypeFlipstrategy_QNAME, FeatureType.Flipstrategy.class, FeatureType.class, value);
    }

}
