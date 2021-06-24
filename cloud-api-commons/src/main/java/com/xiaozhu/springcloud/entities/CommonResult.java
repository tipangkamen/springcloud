package com.xiaozhu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//状态码
    private String message;//返回给前端的消息
    private T data;//返回的数据
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
