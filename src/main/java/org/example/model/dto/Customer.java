package org.example.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {

    private String customerId;
    private String name;
    private String phone;
    private String city;

}
