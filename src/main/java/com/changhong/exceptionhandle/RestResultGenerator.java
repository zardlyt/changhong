package com.changhong.exceptionhandle;

import com.changhong.exceptionhandle.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestResultGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResultGenerator.class);

    /**
     * normal
     * @param success
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genResult(Integer code, T data, String message) {
        RestResult<T> result = RestResult.newInstance();
        result.setResult(code);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    /**
     * success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genSuccessResult(T data) {

        return genResult(0, data, null);
    }

    /**
     * error message
     * @param message error message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genErrorResult(String message) {

        return genResult(-1, null, message);
    }

    /**
     * error
     * @param error error enum
     * @param <T>
     * @return
     */
    /*public static <T> RestResult<T> genErrorResult(ErrorCode error) {

        return genErrorResult(error.getMessage());
    }*/

    /**
     * success no message
     * @return
     */
    public static RestResult genSuccessResult() {
        return genSuccessResult(null);
    }
}
