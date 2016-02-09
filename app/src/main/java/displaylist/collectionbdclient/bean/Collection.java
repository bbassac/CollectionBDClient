package displaylist.collectionbdclient.bean;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Collection {

    private Long id;

    private List<Serie> listeSerie;

    public Collection() {
        listeSerie = new ArrayList<Serie>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Serie> getListeSerie() {
        return listeSerie;
    }


    public void setListeSerie(List<Serie> listeSerie) {
        this.listeSerie = listeSerie;
    }

    public void addBD(Serie serie) {
        listeSerie.add(serie);
    }


    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (IOException e) {
            return "[]";
        }
    }
}
