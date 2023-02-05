import com.clevertec.list.MyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    @Test
    public void createList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Assertions.assertNotNull(list);
    }

}
