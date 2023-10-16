package com.THPS.TampaAmRegistry.domain.models.skaters;

import com.THPS.TampaAmRegistry.domain.registry.models.Skater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SkaterTest {

    @Test
    public void constructorTest(){
        Skater skater = new Skater("Demo", "User", "Element");
        skater.setId(1l);

        String expected = "1 Demo User Element";
        String actual = skater.toString();

        Assertions.assertEquals(expected, actual);
    }
}
