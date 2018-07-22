package springMVC2.entity;

public class Person {
	private String name;
	private String birthDate;
	private String age;
	public Person() {
		
	}
	public Person(Person personToClone) {
		this.name=personToClone.getName();
		this.birthDate=personToClone.getBirthDate();
		this.age=personToClone.getAge();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "name: "+name+" birthDate: "+birthDate+" age: "+age;
	}
}
