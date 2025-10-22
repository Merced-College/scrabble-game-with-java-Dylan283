public class word implements Comparable<word> {
    private String word;
    private String definition;

    public word() {
        word = "none";
        definition = "none";
    }

    public word(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    //getters and setters
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    
    @Override
    public String toString() {
        return word + ": " + definition;
    }

    @Override
    public int compareTo(word other) {
        return this.word.compareTo(other.word);
    }


}