package Entities;

public class EnglishPhrases implements IPhrases {
    @Override
    public String getPhrase(int i) {
        switch (i){
            case 1: return "Welcome to the support system";
            case 2: return "Dog";
        }
        return "Error";
    }
}
