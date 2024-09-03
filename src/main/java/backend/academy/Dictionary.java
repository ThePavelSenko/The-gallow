package backend.academy;

import java.util.*;

public class Dictionary {
    private final List<String> dictionary;
    private static final List<String> categories = Arrays.asList("animals", "food", "colors");
    private static final List<String> difficulties = Arrays.asList("easy", "medium", "hard");

    public Dictionary() {
        String df = difficulties.get(new Random().nextInt(difficulties.size()));
        String ctg = categories.get(new Random().nextInt(categories.size()));
        this.dictionary = initializeDictionary(df, ctg);
    }

    public Dictionary(String df) {
        if (!difficulties.contains(df)) {
            throw new IllegalArgumentException("Invalid difficulty: " + df);
        }
        String ctg = categories.get(new Random().nextInt(categories.size()));
        this.dictionary = initializeDictionary(df, ctg);
    }

    public Dictionary(String df, String ctg) {
        if (!difficulties.contains(df)) {
            throw new IllegalArgumentException("Invalid difficulty: " + df);
        }
        if (!categories.contains(ctg)) {
            throw new IllegalArgumentException("Invalid category: " + ctg);
        }
        this.dictionary = initializeDictionary(df, ctg);
    }

    // The logic of dictionary initialization
    private List<String> initializeDictionary(String df, String ctg) {
        List<String> words = new ArrayList<>();

        switch (ctg) {
            case "animals":
                if (df.equals("easy")) {
                    words = Arrays.asList("cat", "dog", "pig");
                } else if (df.equals("medium")) {
                    words = Arrays.asList("horse", "tiger", "panda");
                } else if (df.equals("hard")) {
                    words = Arrays.asList("cheetah", "giraffe", "leopard");
                }
                break;

            case "food":
                if (df.equals("easy")) {
                    words = Arrays.asList("pie", "egg", "ham");
                } else if (df.equals("medium")) {
                    words = Arrays.asList("chips", "toast", "pizza");
                } else if (df.equals("hard")) {
                    words = Arrays.asList("chicken", "sausage", "pumpkin");
                }
                break;

            case "colors":
                if (df.equals("easy")) {
                    words = Arrays.asList("red", "pink", "blue");
                } else if (df.equals("medium")) {
                    words = Arrays.asList("black", "white", "green");
                } else if (df.equals("hard")) {
                    words = Arrays.asList("orange", "yellow", "purple");
                }
                break;

            default:
                throw new IllegalArgumentException("Unknown category: " + ctg);
        }

        if (words.isEmpty()) {
            throw new IllegalStateException("No words found for the given category and difficulty.");
        }

        return words;
    }

    public String getRandomWord() {
        if (dictionary.isEmpty()) {
            throw new IllegalStateException("Dictionary is empty. No words available to choose from.");
        }
        Random rand = new Random();
        return dictionary.get(rand.nextInt(dictionary.size()));
    }
}
