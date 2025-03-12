package org.example.entities;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private Train train;

    public Ticket(Date dateOfTravel, String destination, String source, String ticketId, Train train, String userId) {
        this.dateOfTravel = dateOfTravel;
        this.destination = destination;
        this.source = source;
        this.ticketId = ticketId;
        this.train = train;
        this.userId = userId;
    }

    public Ticket() {
    }

    public String getTicketInfo(){
        return String.format("Ticket Id: %s belongs to User %s from %s to %s on %s",ticketId,userId,source,destination,dateOfTravel);
    }
    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
