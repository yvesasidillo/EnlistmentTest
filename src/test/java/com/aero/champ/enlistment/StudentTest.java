package com.aero.champ.enlistment;
import com.aero.champ.enlistment.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import static com.aero.champ.enlistment.Schedule.*;

class StudentTest {

	
	@Test
	void enlist_sections_with_no_conflict() {
		//Given a student & 2 sect w/ no conflict
		Student student = new Student (1);
		Section section1 = new Section("A", new Schedule(Days.MTH, Period.H0830));
		Section section2 = new Section("A", new Schedule(Days.MTH, Period.H0830));
		//When the student enlists in both sect
		student.enlist(section1);
		student.enlist(section2);
		//Then we should find both sect inside the student
		Collection<Section> sections = student.getSections();
		assertAll( 
				() -> assertTrue(sections.containsAll(List.of(section1, section2))),
				() -> assertEquals(2, sections.size()));
	}
	

	@Test
	void enlist_setions_with_schedule_conflict() {
		//Given a student and 2 sect with sched conflict
		Student student = new Student (1);
		Section section1 = new Section("A", new Schedule(Days.MTH, Period.H0830));;
		//When elists both
		student.enlist(section1);
		
		//Then exception thrown on 2n
		assertThrow(Exception.class, () -> student.enlist(section2));
		
	}

}
