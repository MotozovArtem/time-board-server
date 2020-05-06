package com.timeboard.server.accounts.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timeboard.server.accounts.model.Account;

@Repository
public interface AccountsRepository extends JpaRepository<Account, UUID> {
}
