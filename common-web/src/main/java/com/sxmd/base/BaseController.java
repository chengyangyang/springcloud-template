package com.sxmd.base;


import com.sxmd.constant.ResponseCodeEnum;

/**
 * Description: 返回数据对象
 *
 * @author cy
 * @date 2019年08月06日 15:52
 * Version 1.0
 */
public class BaseController {

	public AjaxResult success() {
		return new AjaxResult();
	}

	public <T> AjaxResult<T> success(T t) {
		return new AjaxResult<T>(t);
	}


	public AjaxResult fail(String message) {
		return new AjaxResult().error(message);
	}

	public AjaxResult fail(ResponseCodeEnum responseCodeEnum) {
		return new AjaxResult().error(responseCodeEnum);
	}

}
