package com.enki.controller.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Bean;

/**
 * @author Enki
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class R {
    private Boolean flag;
    private Object data;
    public R(Object data){
        this.data = data;
    }
    public R(Boolean flag) {
        this.flag = flag;
    }
}
