package interfaceVol;

import java.util.ArrayList;
import java.util.List;

import core.Section;

public class Avion {
	private List<SectionAvion> sections;

	public Avion() {
		sections = new ArrayList<SectionAvion>();
	}
	
	public void addSection(SectionAvion section) {
		//TODO : check type of section is unique
		sections.add(section);
	}
	
	public void removeSection(SectionAvion section) {
		sections.remove(section);
	}
	
	public int getNombrePlaces(String section) {
		for(Section s : sections) {
			if(s.getType().equalsIgnoreCase(section)) {
				return s.getNombrePlaces();
			}
		}
		return 0;
	}
}