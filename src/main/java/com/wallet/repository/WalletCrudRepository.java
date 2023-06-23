package com.wallet.repository;

import com.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletCrudRepository extends JpaRepository<Wallet, Integer> {

}
