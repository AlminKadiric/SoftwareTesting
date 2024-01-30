package at.aau.serg.exercises.tdd;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class MyCollectionTest
{
    MyCollection myCollection;

    @BeforeEach
    public void setUp(){
        myCollection = new MyCollection(3);
        myCollection.add("1");
        myCollection.add("2");
        myCollection.add("3");

    }

    @Test
    public void givenEmptyCollection_whenRemove_thenThrowException() {
   IllegalArgumentException  exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
       myCollection = new MyCollection(0);myCollection.remove("2");
   });
   Assertions.assertEquals("Size of collection is zero.",exception.getMessage());

    }
    @Test
    public void givenCollection_whenRemove_thenReduceCapacity(){
        myCollection.remove("1");
        Assertions.assertEquals(2,myCollection.size());
    }

    @Test
    public void givenCollection_whenEmpty_thenInitializedNewList(){
        myCollection.empty();
        Assertions.assertEquals(0,myCollection.size());
    }
    }
