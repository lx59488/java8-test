package optional;

import java.util.Optional;
import org.junit.Test;

public class OptionalTest {

    @Test
    public void createTest() throws Exception {
        // optional创建方式一，Optional.of()传入的值不能为null
        Optional<String> optional1 = Optional.of("创建方式一");
        // 创建方式二 Optional.empty() 一个空的optional
        Optional<Object> optional2 = Optional.empty();
        // 创建方式三 Optional.ofNullable() 支持传入null值的optional
        Optional<String> optional3 = Optional.ofNullable(null);
    }

    @Test
    public void checkTest() throws Exception {
        Optional<String> helloOptional = Optional.of("hello");
        System.out.println(helloOptional.isPresent());
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());
    }

    @Test
    public void ifPresentTest() throws Exception {
        Optional<String> helloOptional = Optional.of("hello");
        Optional<String> emptyOptional = Optional.empty();
        helloOptional.ifPresent(System.out::println);
        helloOptional.ifPresent(o -> System.out.println(o.length()));
        emptyOptional.ifPresent(o -> System.out.println(o.length()));
    }

    @Test
    public void getTest() throws Exception {
        Optional<String> helloOptional = Optional.of("hello");
        System.out.println(helloOptional.get());
        Optional<String> emptyOptional = Optional.empty();
//        System.out.println(emptyOptional.get());

    }

    @Test
    public void whenIsNullTest() throws Exception {
        Optional<String> emptyOptional = Optional.empty();
        String orElse = emptyOptional.orElse("orElse default");
        String orElseGet = emptyOptional.orElseGet(() -> "orElseGet default");
        System.out.println(orElse);
        System.out.println(orElseGet);
    }

    /**
     * orElse 和 orElseGet 的区别
     */
    @Test
    public void orElseAndOrElseGetTest() {
        // 如果没有值，默认值
        Optional<String> emptyOptional = Optional.empty();
        System.out.println("空Optional.orElse");
        String orElse = emptyOptional.orElse(getDefault());
        System.out.println("空Optional.orElseGet");
        String orElseGet = emptyOptional.orElseGet(this::getDefault);
        System.out.println("空Optional.orElse结果：" + orElse);
        System.out.println("空Optional.orElseGet结果：" + orElseGet);
        System.out.println("--------------------------------");
        // 如果没有值，默认值
        Optional<String> stringOptional = Optional.of("hello");
        System.out.println("有值Optional.orElse");
        orElse = stringOptional.orElse(getDefault());
        System.out.println("有值Optional.orElseGet");
        orElseGet = stringOptional.orElseGet(this::getDefault);
        System.out.println("有值Optional.orElse结果：" + orElse);
        System.out.println("有值Optional.orElseGet结果：" + orElseGet);
    }

    public String getDefault() {
        System.out.println("   获取默认值中..run getDeafult method");
        return "hello";
    }

    @Test
    public void whenIsNullThrowExceTest() throws Exception {
        Optional<String> emptyOptional = Optional.empty();
        String value = emptyOptional.orElseThrow(() -> new RuntimeException("发现空值"));
    }


    @Test
    public void functionTest() throws Exception {
        // filter
        Optional<Integer> optional = Optional.of(123);
        optional.filter(e -> e == 123).ifPresent(e -> System.out.println(e));
        Optional<Integer> optional2 = Optional.of(456);
        optional2.filter(e -> e == 123).ifPresent(e -> System.out.println(e));
        // map
        Optional<Integer> optional3 = Optional.of(789);
        optional3.map(String::valueOf).map(String::length).ifPresent(System.out::println);
    }

}
