package com.haemimont.cars.service;

import com.haemimont.cars.users.User;

public interface CRUDServiceUsers {


    boolean insertUser(User user);

    boolean loginCheck(User user);


}
