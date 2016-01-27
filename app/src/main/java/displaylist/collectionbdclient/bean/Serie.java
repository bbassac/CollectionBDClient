package displaylist.collectionbdclient.bean;


import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serie {

	private Long id;
	private String nom;
    private List<Bd> listPossede;

    private List<Bd> listManquante;

    private boolean fini;
    private String imageUrl;
    private String editeur;

	// and then "other" stuff:
	protected Map<String,Object> other = new HashMap<String, Object>();

    public Serie(Long id, String nom, boolean fini) {
        this.nom = nom;
        this.id = id;
        this.fini=fini;
    }


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isFini() {
		return fini;
	}

    public void setFini(boolean fini) {
		this.fini = fini;
	}
	// Must have no-argument constructor
	public Serie() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

    public List<Bd> getListPossede() {
        return listPossede;
    }

    public void setListPossede(List<Bd> listPossede) {
        this.listPossede = listPossede;
    }

    public List<Bd> getListManquante() {
        return listManquante;
    }

    public void setListManquante(List<Bd> listManquante) {
        this.listManquante = listManquante;
    }

	// "any getter" needed for serialization
	@JsonAnyGetter
	public Map<String,Object> any() {
		return other;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		other.put(name, value);
	}

	public Object get(String name) {
		return other.get(name);
	}

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
}