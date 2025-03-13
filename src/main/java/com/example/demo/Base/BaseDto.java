package com.example.demo.Base;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseDto<ID> {

    private ID id;
    private String statusCode;
    private boolean isDeleted;

}
