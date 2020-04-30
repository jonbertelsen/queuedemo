package Frontend;

import Entities.DanishPhrases;
import Entities.EnglishPhrases;
import Entities.IPhrases;
import Entities.SupportTicket;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    //static Queue<Entities.SupportTicket> supportQueue = new LinkedList<>();
    static BlockingQueue<SupportTicket> supportQueue = new ArrayBlockingQueue<>(2);

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        IPhrases phrases = new EnglishPhrases();

       boolean finish = false;
       String choice;

       while (!finish){
           System.out.println(phrases.getPhrase(1));
           showMenu();
           System.out.println("Indtast valg: ");
           choice = input.nextLine();
           switch (choice){
               case "1": addTicket(); break;
               case "2": nextTicket(); break;
               case "3": showQueue();
                         phrases = new DanishPhrases(); break;
               case "4": finish = true;
           }

       }
       System.out.println("Tak for i dag");
    }

    private static void showQueue() {
        for (SupportTicket supportTicket : supportQueue) {
            System.out.println(supportTicket.getName() + " bad om hjælp " + supportTicket.getTicketTime());
        }
    }

    private static void showMenu() {
        System.out.println("**** Menu ******");
        System.out.println("1. Tilføj til kø");
        System.out.println("2. Hent næste sag fra kø");
        System.out.println("3. Vis alle i køen");
        System.out.println("4. Afslut");
    }

    private static void nextTicket() {
        SupportTicket ticket = supportQueue.poll();
        if (ticket != null){
            System.out.println("Du skal nu hjælpe : " + ticket.toString());
        } else
        {
            System.out.println("Køen er tom - tag en kop kaffe");
        }
    }

    private static void addTicket() {
        System.out.println("Indtast navn: ");
        String name = input.nextLine();
        if (supportQueue.offer(new SupportTicket(name))){
            System.out.println("Du har indsat " + name + " i køen");
        } else {
            System.out.println("Der er ikke plads til flere i køen");
        }
    }
}
