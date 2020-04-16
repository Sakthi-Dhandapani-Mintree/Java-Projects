package io.httech.yorbitspringboot.service;

import java.util.concurrent.Future;

import io.httech.yorbitspringboot.model.Greeting;

public interface EmailService {
Boolean send(Greeting greet);
void sendAsyn(Greeting greet);
Future<Boolean> sendAsynWithResult(Greeting greeting);

}
