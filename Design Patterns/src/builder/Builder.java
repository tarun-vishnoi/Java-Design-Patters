package builder;

class User {
	private final String firstName; // required
	private final String lastName; // required
	private int age; // optional

	public User(UserBuilder userBuilder) {
		this.firstName = userBuilder.firstName;
		this.lastName = userBuilder.lastName;
		this.age = userBuilder.age;
	}

	// All getter, and NO setter to provde immutability
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "User: " + this.firstName + ", " + this.lastName + ", " + this.age;
	}

	public static class UserBuilder {
		private final String firstName;
		private final String lastName;
		private int age;

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public User build() {
			User user = new User(this);
			return user;
		}
	}
}

public class Builder {
	public static void main(String[] args) {
		User user = new User.UserBuilder("Tarun", "Vishnoi").age(27).build();
		System.out.println(user.toString());
	}
}
