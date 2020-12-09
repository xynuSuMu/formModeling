package com.sumu.form.engine;

import com.sumu.form.service.FormService;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-09 15:21
 */
public class FormEngineImpl implements FormEngine {

    private FormService formService;

    public FormEngineImpl(FormService formService) {
        this.formService = formService;
    }

    @Override
    public FormService getFormService() {
        return formService;
    }

}
