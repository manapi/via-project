package interfaceTrain;

import java.util.ArrayList;
import java.util.List;


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
}