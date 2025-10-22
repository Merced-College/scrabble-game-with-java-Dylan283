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

    public int getPoints() {
        int length = word.length();
        if (length <= 2) return 0;       // too short, no points
        else if (length <= 4) return 1;  // short words
        else if (length <= 6) return 2;  // medium words
        else if (length <= 8) return 3;  // long words
        else return 5;                   // very long words
    }

}