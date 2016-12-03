package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import beans.AppHelper;
import beans.PlatformsSearch;
import configs.AppConfig;

//Przykladowe wykorzystanie testow jednostowych - paczka beans
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class beansTest {

    @Autowired
    @Qualifier("ah")
    AppHelper ah;
    
    @Autowired
    @Qualifier("platformsSearch")
    PlatformsSearch platformSearch;

    @Test
    public void testBeanWorks() {
    	AppHelper.setSQL("CALL game()");
    	AppHelper.setYouCanGrabData(true);
    	AppHelper.setDataFormat("XML");
        //assert true
        assertEquals("CALL game()", AppHelper.getSQL());
        assertEquals("XML", AppHelper.getDataFormat());
        assertEquals(AppHelper.isYouCanGrabData(), true);
        
    }
    
    @Test
    public void testPlatformsSearchWorks(){
    	platformSearch.setArcade(true);
    	platformSearch.setPc(false);
    	platformSearch.setPlaystation(true);
    	platformSearch.setXbox(false);
    	assertEquals(platformSearch.isArcade(), true);
    	assertEquals(platformSearch.isPc(), false);
    	assertEquals(platformSearch.isPlaystation(), true);
    	assertEquals(platformSearch.isXbox(),false);
    	
    	
    	
    }

}