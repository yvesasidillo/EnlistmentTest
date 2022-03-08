package com.aero.champ.enlistment;
import java.util.*;
import java.util.Objects;
import static org.apache.commons.lang3.StringUtils.*;
import static org.apache.commons.lang3.Validate.*;

class Student {
	private final Integer studentNumber;
	private final Collection<Section> sections = new HashSet<>();
	Student(int studentNumber, Collection<Section> sections) {
		
	if (studentNumber < 0) {
		throw new IllegalArgumentException("studentNumber can't be negative, was: " + studentNumber);
		
	}
	if (sections == null) {
		throw new NullPointerException("Sections can't be null");
	}
		this.studentNumber = studentNumber;
		this.sections.addAll(sections);
		this.sections.removeIf(Objects::isNull);
	}
	
	Student(int studentNumber){
		this (studentNumber, Collections.emptyList());
	}
	
	
	void enlist (Section newSection) {
		notNull(newSection, "section can't be null");
		sections.forEach(currentSection -> currentSection.checkForConclict(newSection));
		
		sections.add(newSection);
	}
	
	Collection<Section> getSections() {
	return new ArrayList<>(sections);
}

	@Override
	public String toString() {
		return "Student# " + studentNumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(studentNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studentNumber, other.studentNumber);
	}
}
