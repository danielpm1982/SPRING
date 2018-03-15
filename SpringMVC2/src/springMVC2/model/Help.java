package springMVC2.model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Help {
	public static String calculateAge(LocalDate birthDate) {
		final long DAYS_SINCE_BIRTH = birthDate.until(LocalDate.now(),ChronoUnit.DAYS);
		final long HOURS_SINCE_BIRTH = DAYS_SINCE_BIRTH*24;
		final long YEAR_TOTAL_HOURS = 8766; //exact e fix value
		final long MONTH_TOTAL_HOURS = 720; //rounding to a 30-day pattern month, varying value
		final long DAY_TOTAL_HOURS = 24;
		long totalYears = HOURS_SINCE_BIRTH/YEAR_TOTAL_HOURS;
		long subYearHourAge = HOURS_SINCE_BIRTH%YEAR_TOTAL_HOURS;
		long totalMonths = subYearHourAge/MONTH_TOTAL_HOURS;
		long subMonthHourAge = subYearHourAge%MONTH_TOTAL_HOURS;
		long totaldays = subMonthHourAge/DAY_TOTAL_HOURS;
		return totalYears+" years and approximately "+totalMonths+" months and "+totaldays+" days";
	}
	public static String calculateAge2(LocalDate birthDate) {
		final long DAYS_SINCE_BIRTH = birthDate.until(LocalDate.now(),ChronoUnit.DAYS);
		final long HOURS_SINCE_BIRTH = DAYS_SINCE_BIRTH*24;
		final long YEAR_TOTAL_HOURS = 8766; //exact e fix value
		final long DAY_TOTAL_HOURS = 24;
		long totalYears = HOURS_SINCE_BIRTH/YEAR_TOTAL_HOURS;
		long subYearHourAge = HOURS_SINCE_BIRTH%YEAR_TOTAL_HOURS;
		long totaldays = subYearHourAge/DAY_TOTAL_HOURS;
		return totalYears+" years and "+totaldays+" days";
	}
}
