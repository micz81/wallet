package com.wallet.repository;

import com.wallet.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetCrudRepository extends JpaRepository<Asset, Integer> {

}
