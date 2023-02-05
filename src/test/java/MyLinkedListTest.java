import com.clevertec.list.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        list.add(8888);
        list.add(1111);
        list.add(7777);
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 228);
        Assertions.assertEquals(list.get(2), 337);
        Assertions.assertEquals(list.get(3), 8888);
        Assertions.assertEquals(list.get(4), 1111);
        Assertions.assertEquals(list.get(5), 7777);
    }
}
