package com.aero.champ.enlistment;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

import java.util.Objects;

class Schedule {
	
	private final Days days;
	private final Period period;
	
	Schedule(Days days, Period period){
		notNull(days);
		notNull(period);
		this.days = days;
		this.period = period;
	}
	@Override
	public String toString() {
		return days + " " + period;
	}

	@Override
	public int hashCode() {
		return Objects.hash(days, period);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return days == other.days && period == other.period;
	}

}

enum Days {
	MTH, TF, WS
	
}

enum Period {
	H0830, H1000, H1130, H1300, H1430, H1600
}

