package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApp.entity.BookingRecord;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {

}
