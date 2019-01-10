package com.michaelcgood.Service;

import com.michaelcgood.dao.CustomerRepository;
import com.michaelcgood.dao.TemporaryRepository;
import com.michaelcgood.model.Customer;
import com.michaelcgood.model.TemporaryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class TemporaryServices {

    @Autowired
    private TemporaryRepository temporaryRepository;

    @Autowired
    private CustomerRepository customerRepository;

    private JavaMailSender javaMailSender;
    private int code;

    @Autowired
    public TemporaryServices(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public String saveCustomerTemporaryData(TemporaryModel temporaryModel){

        // temporaryRepository.verifyUsername(temporaryModel.getUsername())

            TemporaryModel temporaryModelUser = temporaryRepository.getCustomerDatails(temporaryModel.getUsername());

            if(temporaryModelUser == null){

                sendNotification(temporaryModel);
                temporaryModel.setStatus("InProgress");
                temporaryModel.setCode(getCode());
                temporaryRepository.save(temporaryModel);

                return "Your Have Successfully Registered";
            }else if(temporaryModelUser.getUsername() != null && temporaryModelUser.getStatus().equals("InProgress")){


                return "Your status is in progress";

            }else if(temporaryModelUser.getUsername() != null && temporaryModelUser.getStatus().equals("Active")){

                return "Your status is active";
            }



            return "Something went wrong";

//        }else {
//
//            return "You have Already Registered";
//        }

    }

    public Customer SaveCustomerToPermanentDatabase(TemporaryModel temporaryModel){

        long code = temporaryModel.getCode();
        Customer customer = new Customer();

            customer.setUsername(temporaryModel.getUsername());
            customer.setFirstName(temporaryModel.getFirstName());
            customer.setLastName(temporaryModel.getLastName());
            customer.setPassword(temporaryModel.getPassword());
            customer.setPasswordVerify(temporaryModel.getPasswordVerify());
            customer.setPhoneNumber(temporaryModel.getPhoneNumber());
            customer.setGender(temporaryModel.getGender());
            customer.setTitle(temporaryModel.getTitle());


            return customerRepository.save(customer);
    }

    public int generateRandomNumber(){

        Random random = new Random();
       final int randomNumber = random.nextInt(50)*100+1;

        return randomNumber;

    }

    public void sendNotification(TemporaryModel temporaryModel){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        setCode(generateRandomNumber());
        mailMessage.setTo(temporaryModel.getUsername());
        mailMessage.setFrom("molebogeng.kubyana@gmail.com");
        mailMessage.setCc("givenkubyana@gmail.com");
        mailMessage.setSubject("Registration Code");
        mailMessage.setText("Hi " + temporaryModel.getFirstName() +" "+
                temporaryModel.getLastName() +
                " Your Registration code is :"+ getCode());

        javaMailSender.send(mailMessage);

    }

    private void setCode(int code){
        this.code = code;
    }

    private int getCode(){
        return code;
    }




}
