package Entities;

import java.util.Date;

public class SupportTicket {

    private String name;
    private Date ticketTime;

    public SupportTicket(String name) {
        this.name = name;
        this.ticketTime = new Date();
    }

    public String getName() {
        return name;
    }

    public Date getTicketTime() {
        return ticketTime;
    }

    @Override
    public String toString() {
        return "Entities.SupportTicket{" +
                "name='" + name + '\'' +
                ", ticketTime=" + ticketTime +
                '}';
    }
}
