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

    @Test
    public void removeFirstElementByValueWithExistingValue() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertDoesNotThrow(() -> list.remove(Integer.valueOf(123)));
        Assertions.assertEquals(list.get(0), 228);
        Assertions.assertEquals(list.get(1), 337);
    }

    @Test
    public void removeLastElementByValueWithExistingValue() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertDoesNotThrow(() -> list.remove(Integer.valueOf(337)));
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 228);
    }

    @Test
    public void removeMidElementByValueWithExistingValue() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertDoesNotThrow(() -> list.remove(Integer.valueOf(228)));
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 337);
    }

    @Test
    public void removeElementByValueWithoutExistingValue() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(Integer.valueOf(999)));
    }


    @Test
    public void removeFirstElementByIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertDoesNotThrow(() -> list.remove(0));
        Assertions.assertEquals(list.get(0), 228);
        Assertions.assertEquals(list.get(1), 337);
    }

    @Test
    public void removeLastElementByIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertDoesNotThrow(() -> list.remove(2));
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 228);
    }

    @Test
    public void removeMidElementByIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertDoesNotThrow(() -> list.remove(1));
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 337);
    }

    @Test
    public void removeElementByIndexWithBigIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123);
        list.add(228);
        list.add(337);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(Integer.valueOf(999)));
    }

    @Test
    public void addElementByIndexToBegin() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123, 0);
        list.add(444, 0);
        list.add(555, 0);
        Assertions.assertEquals(list.get(0), 555);
        Assertions.assertEquals(list.get(1), 444);
        Assertions.assertEquals(list.get(2), 123);
    }

    @Test
    public void addElementByIndexToMid() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123, 0);
        list.add(444, 1);
        list.add(555, 1);
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 555);
        Assertions.assertEquals(list.get(2), 444);
    }

    @Test
    public void addElementByIndexToEnd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(123, 0);
        list.add(444, 1);
        list.add(555, 2);
        Assertions.assertEquals(list.get(0), 123);
        Assertions.assertEquals(list.get(1), 444);
        Assertions.assertEquals(list.get(2), 555);
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
