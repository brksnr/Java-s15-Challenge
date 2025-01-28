package person;


public class Author extends Person {

    public Author(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return "Ben bir yazarım.";
    }
}

