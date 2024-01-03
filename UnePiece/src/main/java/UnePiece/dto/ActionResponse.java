package UnePiece.dto;

import UnePiece.model.Evenement;

public class ActionResponse {
    
    private Integer id;
	private Boolean choix;
	private boolean termine;
    private int degatNavire;
    private int degatMembre;
	private int tresor;
    private Evenement event;
    private PartieResponse partie;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Boolean getChoix() {
        return choix;
    }
    public void setChoix(Boolean choix) {
        this.choix = choix;
    }
    public boolean isTermine() {
        return termine;
    }
    public void setTermine(boolean termine) {
        this.termine = termine;
    }
    public int getDegatNavire() {
        return degatNavire;
    }
    public void setDegatNavire(int degatNavire) {
        this.degatNavire = degatNavire;
    }
    public int getDegatMembre() {
        return degatMembre;
    }
    public void setDegatMembre(int degatMembre) {
        this.degatMembre = degatMembre;
    }
    public int getTresor() {
        return tresor;
    }
    public void setTresor(int tresor) {
        this.tresor = tresor;
    }
    public Evenement getEvent() {
        return event;
    }
    public void setEvent(Evenement event) {
        this.event = event;
    }
    public PartieResponse getPartie() {
        return partie;
    }
    public void setPartie(PartieResponse partie) {
        this.partie = partie;
    }

    
}
