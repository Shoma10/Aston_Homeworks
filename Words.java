import java.util.*;

public class Words {
    public static void main(String[] args) {
        String[] words = {
                "apple", "banana", "cherry", "date", "apple", "banana", "fig", "apple", "banana",
                "cherry", "date", "fig", "apple", "banana", "cherry", "date", "fig", "grape"
        };

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Уникальные слова: " + uniqueWords);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Количество встречаний каждого слова: " + wordCount);
    }
}
