package ExampleIterator;

public class Suffix implements WordPart {

    private String part;

    public Suffix(String part) {
        this.part = part;
    }

    @Override
    public String getWordPart() {
        return part;
    }
}