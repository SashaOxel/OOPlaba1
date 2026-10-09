public class TextManipulator {
    String text;

    // Конструктор без параметров: текст - пустая строка.
    public TextManipulator () {
        this.text = "";
    }

    public TextManipulator (String text) {
        this.text=text;
    }

    // Конструктор копирования: копирует текст из другого объекта.
    public TextManipulator (TextManipulator other) {
        this.text = other.text;
    }

    public String sortByLength () {
        String[] words = this.text.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                boolean needSwap = false;

                if (words[j].length() > words[j + 1].length()) {
                    needSwap = true;
                } else if (words[j].length() == words[j + 1].length()) {
                    if (words[j].compareTo(words[j + 1]) > 0) {
                        needSwap = true;
                    }
                }
                if (needSwap) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[i] + " ";
        }
        return result;
    }

    public String deleteIdentical () {
        this.text = this.text.toLowerCase();
        String[] words = this.text.split(" ");

        String result = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);

            if (first != last) {
                result = result + word + " ";
            }
        }
        return result;
    }

    public double detectAverageCountLetters () {
        this.text = this.text.toLowerCase();

        String letters = "";
        for (int i = 0; i < this.text.length(); i++) {
            char c = this.text.charAt(i);
            if (Character.isLetter(c)) {
                letters = letters + c;
            }
        }

        int total = letters.length();
        int different = calculateDifferentLetters(letters);

        if (different == 0) {
            System.out.println("В предложении нет букв.");
            return 0;
        }

        return (double) total /different;
    }

    private int calculateDifferentLetters (String letters) {
        int different = 0;
        for (int i = 0; i < letters.length(); i++) {
            boolean alreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (letters.charAt(j) == letters.charAt(i)) {
                    alreadySeen = true;
                }
            }
            if (!alreadySeen) {
                different++;
            }
        }
        return different;
    }
}
