package com.umlanche.app.adapters.controllers.reponses;

public class DataResponse<T> {
  public T data;

  public DataResponse(T data){
    this.data = data;
  }
}
