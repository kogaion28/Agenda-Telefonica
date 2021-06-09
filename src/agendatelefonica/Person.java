package agendatelefonica;

public class Person {
    
    private String name;
    private String city;
    private String phone;

    public Person(int id){
        this("name" + id, "city" + id, "phone" + id);
    }

    public Person(String name , String city, String phone ){
        this.name = name;
        this.city = city;
        this.phone = phone;
    }

    // primeste metoda
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    public String getPhone(){
        return this.phone;
    }

    // seteaza metoda
    public void setName(String name){
        this.name= name;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
}
