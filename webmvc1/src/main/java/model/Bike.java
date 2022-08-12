package model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bike {
    
    private int bike_id;
    private String bike_name;
    private String bike_engine_capacity;
    private int bike_top_speed;
    private double bike_price;


}
