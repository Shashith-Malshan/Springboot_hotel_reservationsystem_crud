package org.example.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Room {

    private String roomId;
    private String type;
    private boolean isAvailable;

}
