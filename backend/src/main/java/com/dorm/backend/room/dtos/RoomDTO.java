package com.dorm.backend.room.dtos;

import com.dorm.backend.shared.data.dtos.PictureDTO;
import com.dorm.backend.profile.dto.ProfileDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {

    private Long id;

    private String name;

    private String description;

    private Integer monthlyPrice;

    private Integer deposit;

    private String availableFrom;

    private Integer minDuration;

    private Integer houseArea;

    private Integer roomsNumber;

    private List<String> amenities;

    private List<PictureDTO> pictures;

    private ProfileDTO owner;

    private AddressDTO address;

}