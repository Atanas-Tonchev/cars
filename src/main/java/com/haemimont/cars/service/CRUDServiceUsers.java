package com.haemimont.cars.service;

import com.haemimont.cars.users.User;

public interface CRUDServiceUsers {
    boolean getUser(User user);
    boolean insertUser(User user);
}
