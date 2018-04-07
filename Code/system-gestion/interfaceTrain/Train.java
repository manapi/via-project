package interfaceTrain;

import java.util.ArrayList;
import java.util.List;

import core.Section;


public class Train {
	private List<SectionTrain> sections;

	public Train() {
		sections = new ArrayList<SectionTrain>();
	}
	
	public void addSection(SectionTrain section) {
		//TODO : check type of section is unique
		sections.add(section);
	}
	
	public void removeSection(SectionTrain section) {
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