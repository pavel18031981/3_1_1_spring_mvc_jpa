package web.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findOne(int id);

    public void save(User user);
}
