package displaylist.collectionbdclient.utils;

import static junit.framework.TestCase.assertNotNull;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import displaylist.collectionbdclient.bean.Bd;
import displaylist.collectionbdclient.bean.Serie;

public class SerieUtilsTest {

    @Test
    public void testGetStringPossede_vide() {
        Serie s = new Serie();
        Bd bd = new Bd(1L, "numero", "titre", "url");
        List<Bd> listPossede = new ArrayList<>();
        listPossede.add(bd);
        s.setListPossede(listPossede);
        String result = SerieUtils.getStringPossede(s);
        assertNotNull(result);
    }
}