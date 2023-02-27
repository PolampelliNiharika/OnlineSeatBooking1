package com.capg.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Booking;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.BookingRepository;

@Service("BookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public String addBooking(Booking booking) {
		bookingRepository.saveAndFlush(booking);
		return "Request for booking sent";
	}

	@Override
	public List<Booking> listAllbookings() throws BookingNotFoundException {
		return bookingRepository.findAll();
	}

	@Override
	public List<Booking> listAllBookingsInDateRange(LocalDate startDate, LocalDate endDate)
			throws BookingNotFoundException {
		List<Booking> ans = new ArrayList<Booking>();
		try {
			for (Booking i : bookingRepository.findAll()) {
				if (i.getBookingDate().isAfter(startDate) && i.getBookingDate().isBefore(endDate)) {
					ans.add(i);
				}
			}
		} catch (Exception e) {
			throw new BookingNotFoundException("Booking not found");
		}
		return ans;
	}

	@Override
	public Booking getBookingbyId(int bookingId) throws BookingNotFoundException {
		Booking bean = null;
		try {
			bean = bookingRepository.findById(bookingId).get();
		} catch (Exception e) {
			throw new UserNotFoundException("Booking not found!");
		}
		return bean;
	}

	@Override
	public Booking deleteBooking(int bookingId) throws BookingNotFoundException {
		Booking bean = null;
		try {
			bean = bookingRepository.findById(bookingId).get();
		} catch (Exception e) {
			throw new UserNotFoundException("Booking not found!");
		}
		bookingRepository.deleteById(bookingId);
		return bean;
	}

}
