package Entities;

public class DanishPhrases implements IPhrases {
    @Override
    public String getPhrase(int i) {
        switch (i){
            case 1: return "Velkommen ombord";
            case 2: return "Hund";
        }
        return "Fejl";
    }
}
