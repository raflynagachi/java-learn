package raflynagachi.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockTest {
    
    @Test
    void testMock() {
        List<String> list = Mockito.mock(List.class);
    
        Mockito.when(list.get(77)).thenReturn("mantap");
        Mockito.verify(list, Mockito.times(1)).get(77);

        assertEquals("mantap", list.get(77));

    }

    // BEGIN example for mocking an interface like database repository
    // @Mock
    // private PersonRepository personRepository;
    // private PersonService personService;

    // @BeforeEach
    // void setup(){
    //     personService = new PersonService(personRepository);
    // }

    // @Test
    // void testSelectNotFound(){
    //     assertThrows(IllegalArgumentException.class, () -> {
    //         personService.getByID("not found")
    //     })
    // }

    // @Test
    // void testSelectSuccess(){
    //     Mockito.when(personRepository.getByID(1)).thenReturn(new Person("anne"))

    //     var person = personService.getByID(1)

    //     assertNotNull(person);
    // }
    // END example for mocking an interface like database repository
}
