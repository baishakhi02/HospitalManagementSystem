package org.anudip.hospitalManagementSystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import org.anudip.hospitalManagementSystem.bean.Doctor;
import org.anudip.hospitalManagementSystem.bean.Ward;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	public double doctorFeeCalculation(Doctor doctor, int noOfVisits) {
		double doctorFees = doctor.getFee();
		return doctorFees * noOfVisits;
	}

	public double wardExpenseCalculation(Ward ward, String admitDate, String releaseDate) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate admissionDate = LocalDate.parse(admitDate, dateFormat);
		LocalDate releaseDate1 = LocalDate.parse(releaseDate, dateFormat);
		Period period = Period.between(admissionDate, releaseDate1);
		int dateDiff = period.getDays();
		double bedRatePerDay = ward.getFarePerDay();
		double wardFare = dateDiff * bedRatePerDay;
		return wardFare;
	}
}
