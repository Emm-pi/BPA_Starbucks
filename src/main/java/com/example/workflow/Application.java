package com.example.workflow;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeVariable;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableZeebeClient
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

  @ZeebeWorker(type = "drink_type", autoComplete = true)
  public void getDrinkType(JobClient client, ActivatedJob job, @ZeebeVariable String drink_type) {
    System.out.println("Drink type is " + drink_type);
  }

  @ZeebeWorker(type = "test_type", autoComplete = true)
  public void getSize(JobClient client, ActivatedJob job, @ZeebeVariable String drink_size) {
    System.out.println("Drink size is " + drink_size);
  }

  @ZeebeWorker(type = "drink_to_go_or_to_stay_type", autoComplete = true)
  public void getToGo(JobClient client, ActivatedJob job, @ZeebeVariable String to_go_or_stay) {
    System.out.println("Drink is  " + to_go_or_stay);
  }

  @ZeebeWorker(type = "payment_method_type", autoComplete = true)
  public void getPaymentMethod(JobClient client, ActivatedJob job, @ZeebeVariable String payment_method) {
    System.out.println("Payment method is " + payment_method);
  }


}