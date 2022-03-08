package com.aero.champ.enlistment;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;
import java.util.Objects;

class Section {
	
	 private final String sectionId;
	 private final Schedule schedule;
	 
	 Section(String sectionId, Schedule schedule) {
		 notBlank(sectionId, "sectionId cant be null or empty");
		 isTrue(isAlphanumeric(sectionId),"sectionId must be alphanumberic" + sectionId);
		 
		 notNull(schedule);
		 this.sectionId = sectionId;
		 this.schedule = schedule;
		 }	 
	 
	 public void checkForConclict(Section other){
		 if (this.schedule.equals(other.schedule)) {
			 throw new SchedulConflictException("This section : " +
		 this + " has schedule conflict with other section "+
					 other+ " at schedule " + schedule);
		 }
	 }

	 
	@Override
	public int hashCode() {
		return Objects.hash(sectionId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		return Objects.equals(sectionId, other.sectionId);
	}

}
