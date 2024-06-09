package com.example.shoppaintsserver.service;

import com.example.shoppaintsserver.entity.UsersEntity;
import com.example.shoppaintsserver.repository.UsersRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class UsersService {
    private final UsersRepo repo;

    public List<UsersEntity> findAll() {
        return repo.findAll();
    }

    public UsersEntity save (UsersEntity data) {
        return repo.save(data);
    }

    public void update (UsersEntity data) {
        repo.save(data);
    }

}
