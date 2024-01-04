package com.umlanche.app.adapters.controllers.reponses;

import com.umlanche.infra.response.HttpResponse;

public class CreatedResponse extends HttpResponse {
    public CreatedResponse(String message) {
        this.message = message;
    }
}
