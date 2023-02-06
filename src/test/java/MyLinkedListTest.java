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
    public void foreachTest() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        int[] arr = {123, 228, 337};
        int counter = 0;
        for (Integer x : list) {
            Assertions.assertEquals(x, arr[counter++]);
        }
    }
}
