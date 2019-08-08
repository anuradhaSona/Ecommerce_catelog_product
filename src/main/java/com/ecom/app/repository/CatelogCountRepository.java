package com.ecom.app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.app.entity.Catelog;
import com.ecom.app.entity.CatelogCount;

@Repository
public interface CatelogCountRepository extends JpaRepository<CatelogCount, Integer> {

	public Optional<CatelogCount> findByCatelog(Catelog catelog);

}
