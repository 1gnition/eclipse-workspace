package orip;


public interface UserDetailsDao {
	void save(UserDetails u);
	UserDetails get(int id);
	UserDetails get(UserId id);
}
