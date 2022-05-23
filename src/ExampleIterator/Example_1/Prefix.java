package ExampleIterator.Example_1;

public class Prefix implements WordPart {

    private String part;

    public Prefix(String part) {
        this.part = part;
    }

    @Override
    public String getWordPart() {
        return part;
    }
}
