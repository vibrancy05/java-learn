package day6.service;

import day6.Result;

public interface UserService {
    Result Register(String username, String password);

    Result Login(String username, String password);
}
