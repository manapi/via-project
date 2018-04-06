package interfaceVol;

import java.util.ArrayList;
import java.util.List;

public class Avion {
	private List<SectionAvion> sections;

	public Avion() {
		sections = new ArrayList<SectionAvion>();
	}
	
	public void addSection(SectionAvion section) {
		//TODO : check type of section is unique
		sections.add(section);
	}
}