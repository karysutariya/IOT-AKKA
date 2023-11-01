package services;

import org.junit.Test;

import static org.junit.Assert.*;

public class AtomicCounterTest {
    @Test
    public void testnextCount(){
        AtomicCounter atomicCounter = new AtomicCounter();
        var a =atomicCounter.nextCount();
        assertNotNull(a);
    }
}