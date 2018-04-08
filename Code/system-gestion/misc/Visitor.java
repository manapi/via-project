package misc;
import interfaceCroisiere.Cabine;
import interfaceCroisiere.ItineraireCroisiere;
import interfaceCroisiere.SectionPaquebot;
import interfaceTrain.ItineraireTrain;
import interfaceTrain.SectionTrain;
import interfaceTrain.SiegeTrain;
import interfaceVol.SectionAvion;
import interfaceVol.SiegeAvion;
import interfaceVol.Vol;

public interface Visitor {

	//void visitTrajet(); 
	//void visitPlace();
	//void visitSection();

	//visit all CONCRETE items:
	void visit(Vol vol);
	void visit(ItineraireTrain itineraireTrain);
	void visit(ItineraireCroisiere itineraireCroisiere);
	
//	void visit(SiegeAvion siegeAvion);
//	void visit(Cabine cabine);
//	void visit(SiegeTrain siegeTrain);
	
	void visit(SectionAvion sectionAvion);
	void visit(SectionTrain sectionTrain);
	void visit(SectionPaquebot sectionPaquebot);

}