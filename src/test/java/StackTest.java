import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.EmptyStackException;

import org.junit.Test;

import Containers.Stack;

public class StackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack();
        stack.push(5);
        stack.push(6);
        stack.push(7);

        assertThat(stack.pop(), is(7));
        assertThat(stack.pop(), is(6));
        assertThat(stack.pop(), is(5));

        assertThrows(EmptyStackException.class, () -> stack.pop());
    }

}
