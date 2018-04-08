package misc;
import core.Itineraire;
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

	String visit(Itineraire itineraire);

}