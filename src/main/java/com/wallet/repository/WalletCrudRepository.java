package com.wallet.repository;

import com.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletCrudRepository extends JpaRepository<Wallet, Integer> {

    @Query("FROM Wallet WHERE name = :name")
    Wallet findByName(@Param("name") String name);

}
