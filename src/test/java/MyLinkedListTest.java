import com.clevertec.list.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedListTest {
    @Test
    public void createList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Assertions.assertNotNull(list);
        List<Integer> l = new LinkedList<>();
    }

    @Test
    public void addElementsToEndOfEmptyList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 228);
        Assertions.assertEquals(list.get(2), 337);
    }

    @Test
    public void removeElementByValueWithExistingValue() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertDoesNotThrow(() -> list.remove(Integer.valueOf(123)));
    }

    @Test
    public void removeElementByValueWithoutExistingValue() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(Integer.valueOf(999)));
    }

}
