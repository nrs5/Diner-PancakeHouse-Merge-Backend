package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepository {

    private static final Logger LOG =
            LoggerFactory.getLogger(CustomerRepository.class);
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "data/customers.txt";

    public CustomerRepository(){
        File file = new File(DATABASE_NAME);
        file.getParentFile().mkdirs();
        try{
            file.createNewFile();
        } catch (IOException e){
            LOG.error(e.getMessage());
        }
    }
    private static void appendToFile(Path path, String content)
            throws IOException{
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
    public Customer findByUsername(String username) throws IOException {
        List<Customer> customers = findAll();
        for(Customer customer : customers) {
            if (customer.username().trim().equalsIgnoreCase(username.trim())) {
                return customer;
            }
        }
        return null;
    }

    public void save(Customer customer) throws Exception{
        Customer cus = findByUsername(customer.username());
        if(cus != null){
            throw new
                    Exception("Username already exists." + "Please choose another one");
        }
        Path path = Paths.get(DATABASE_NAME);
        String data = customer.username() + ","
                + customer.password()//temporary, should never store same password
        + "," + customer.email();
        appendToFile(path, data + NEW_LINE);
    }

    public List<Customer> findAll() throws IOException {
        List<Customer> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            if(!line.trim().isEmpty()) {
                String[] parts = line.split(",");
                if(parts.length == 3) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String email = parts[2].trim();
                    Customer customer = new Customer(username, password, email);
                    result.add(customer);
                }
            }
        }
        return result;
    }
}
