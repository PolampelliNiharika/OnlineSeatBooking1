package com.capg.service;

import java.time.LocalDate;
import java.util.List;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;

public interface BookingService {

	public String addBooking(Booking booking);

	public List<Booking> listAllbookings() throws BookingNotFoundException;

	public List<Booking> listAllBookingsInDateRange(LocalDate startDate, LocalDate endDate)
			throws BookingNotFoundException;

	public Booking getBookingbyId(int bookingId) throws BookingNotFoundException;

	public Booking deleteBooking(int bookingId) throws BookingNotFoundException;

}