package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.User;
import org.example.utils.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
    private User user;
    private List<User> userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "app/src/main/java/org/example/localDb/users.json";

    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUser();
    }

    public UserBookingService() throws IOException {
        loadUser();
    }

    public List<User> loadUser() throws IOException{
        File users = new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>() {
        });
        return userList;
    }

   public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(u -> u.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(),u.getHashedPassword())).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try {
            if (userList == null) {
                userList = loadUser();
            }
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException e){
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile,userList);
    }

    public void fetchBooking(){
        user.printTickets();
    }
    public Boolean cancelBooking(String ticketId) throws IOException{
        if(ticketId == null || ticketId.isEmpty()){
            System.out.println("Ticket ID cannot be null or empty.");
            return Boolean.FALSE;
        }
        boolean isRemoved = user.getTicketsBooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId));
        if(isRemoved){
            saveUserListToFile();
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return true;
        }else {
            System.out.println("No ticket found with ID " + ticketId);
            return false;
        }
    }
}
