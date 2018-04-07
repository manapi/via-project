package interfaceCroisiere;

import java.util.ArrayList;
import java.util.List;

import core.Section;


public class Paquebot {
	private List<SectionPaquebot> sections;

	public Paquebot() {
		sections = new ArrayList<SectionPaquebot>();
	}
	
	public void addSection(SectionPaquebot section) {
		//TODO : check type of section is unique
		sections.add(section);
	}
	
	public void removeSection(SectionPaquebot section) {
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