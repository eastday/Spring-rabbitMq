package com.eastday.service;

public interface IProductService  {

   void   sendDataToQueue(String routingKey, Object object);

   void   sendDataToExchange(String exchange, String routingKey, Object object);
}
