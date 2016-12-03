package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import beans.Result;
import configs.MainConfig;
import main.ResultPrinter;

//Przykladowe wykorzystanie testow jednostowych - paczka main
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MainConfig.class})
public class mainTest {

    @Autowired
    @Qualifier("printer")
    ResultPrinter printer;
    
    @Test
    public void testBooltTo01Works() {
        assertEquals(ResultPrinter.boolTo01(true), 1);
        assertEquals(ResultPrinter.boolTo01(false), 0);
    }
    
    @Test
    public void testGettingXMLWorks() {
    	Result result = new Result();
    	result.setName("ziemniak");
    	result.setDeck("opis");
    	List<Result> results = new ArrayList<Result>();
    	results.add(result);
    	String xml = ResultPrinter.returnXML(results);
        assertEquals(xml.startsWith("<"), true);    
    }
    
    @Test
    public void testGettingJSONWorks() {
    	Result result = new Result();
    	result.setName("ziemniak");
    	result.setDeck("opis");
    	List<Result> results = new ArrayList<Result>();
    	results.add(result);
    	String json = ResultPrinter.returnJSON(results);
        assertEquals(json.startsWith("["), true);    
    }
}