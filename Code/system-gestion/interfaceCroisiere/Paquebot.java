package interfaceCroisiere;

import java.util.ArrayList;
import java.util.List;


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
}