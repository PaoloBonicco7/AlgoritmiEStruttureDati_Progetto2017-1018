package distancetest;

import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import distance.Distance;

public class TestDistanceDynamic{

  String s1;
  String s2;
  Distance distance = null;

    @Before
    public void prepareData(){
      s1="";
      s2="";
    }

    @Test
    public void testEmptyString(){
      distance = new Distance(s1, s2);
      assertEquals(distance.editDistanceDynInit(), 0);
    }

    @Test
    public void testSimpleString(){
      s1="casa";
      s2="cassa";
      distance = new Distance(s1, s2);
      assertEquals(distance.editDistanceDynInit(), 1);
    }

    @Test
    public void testSimpleString2(){
      s1="palla";
      s2="pollo";
      distance = new Distance(s1, s2);
      assertEquals(distance.editDistanceDynInit(), 4);
    }

    @Test
    public void testSimpleString3(){
      s1="casa";
      s2="cara";
      distance = new Distance(s1, s2);
      assertEquals(distance.editDistanceDynInit(), 2);
    }

    @Test
    public void testSimpleString4(){
      s1="tassa";
      s2="passato";
      distance = new Distance(s1, s2);
      assertEquals(distance.editDistanceDynInit(), 4);
    }

    @Test
    public void testEqualString(){
      s1="pioppo";
      s2="pioppo";
      distance = new Distance(s1, s2);
      assertEquals(distance.editDistanceDynInit(), 0);
    }

    @Test
    public void testHardString(){
      s1="precisamente";
      s2="molto preciso";
      distance = new Distance(s1, s2);
      assertEquals(distance.editDistanceDynInit(), 13);
    }
}
