package displaylist.collectionbdclient.adapter;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import static org.junit.Assert.assertEquals;


@RunWith(RobolectricGradleTestRunner.class)
public class ExampleTest  {

    public void test(){
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }
}