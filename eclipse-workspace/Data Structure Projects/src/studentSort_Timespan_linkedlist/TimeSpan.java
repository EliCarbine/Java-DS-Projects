package studentSort_Timespan_linkedlist;

import java.util.Objects;

class TimeSpan implements Comparable<TimeSpan> {

	private final int totalTime;

	private TimeSpan(int totalTime){
		if(totalTime < 0) {
			throw new IllegalArgumentException();
		}
		this.totalTime = totalTime;	
	}

	public static TimeSpan ofHours(int hours) {
		if (hours < 0) {
			throw new IllegalArgumentException();
		}
		return new TimeSpan(hours*60);

	}
	public static TimeSpan ofMinutes(int totalMinutes) {
		if (totalMinutes < 0) {
			throw new IllegalArgumentException();
		}
		return new TimeSpan(totalMinutes);	
	}

	public static TimeSpan ofHoursAndMinutes(int hours, int minutes) {
		if (hours < 0 || minutes < 0 ) {
			throw new IllegalArgumentException();
		}
		return new TimeSpan((hours*60) + minutes);	
	}

	public int getHours() {
		return totalTime /60;
	}

	public int getMinutes() {
		return totalTime % 60;
	}

	public int getTotalMinutes() {
		return totalTime;
	}

	@Override
	public String toString() {
		return getHours()+"h"+ getMinutes()+"m";	
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}

		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		TimeSpan copy = (TimeSpan) other;
		return totalTime == copy.totalTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalTime);
	}

	@Override
	public int compareTo(TimeSpan other) {
		return Integer.compare(this.getTotalMinutes(), other.getTotalMinutes());
	}

	public TimeSpan plus(TimeSpan other) {
		return new TimeSpan(this.getTotalMinutes() + other.getTotalMinutes());	
	}

	public TimeSpan plusHours(int hours) {
		if (hours < 0) {
			throw new IllegalArgumentException();
		}
		return new TimeSpan(this.totalTime + (hours*60));
	}

	public TimeSpan plusMinutes(int minutes) {
		if (minutes < 0) {
			throw new IllegalArgumentException();
		}
		return new TimeSpan(this.totalTime + minutes);

	}

	public TimeSpan plusHoursAndMinutes(int hours, int minutes) {
		if (hours < 0 || minutes < 0 ) {
			throw new IllegalArgumentException();
		}
		return new TimeSpan(this.totalTime+ (hours*60) + minutes);
	}
}
