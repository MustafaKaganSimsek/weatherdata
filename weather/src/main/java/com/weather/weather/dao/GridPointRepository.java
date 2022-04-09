package com.weather.weather.dao;

import com.weather.weather.model.GridPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GridPointRepository  extends JpaRepository<GridPoints,Long> {
//    @Query("select s from GridPoints s WHERE :city_code ")
//    List<GridPoints> getAllByJobs(@Param("city_name") String name);
}
