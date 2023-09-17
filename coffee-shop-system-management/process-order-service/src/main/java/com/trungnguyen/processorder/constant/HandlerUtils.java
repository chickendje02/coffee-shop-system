package com.trungnguyen.processorder.constant;

import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class HandlerUtils {

    public static Map<String, Object> buildSuccessMapResponse(Map<String, Object> result){
        result.put("message", CommonConstant.SUCCESS_MESSAGE);
        result.put("code", CommonConstant.SUCCESS_CODE);
        return result;
    }
}
