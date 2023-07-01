package io.github.lvbo.learn.guava.optional;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import org.junit.Test;

/**
 * @author lvbo created on 2023-07-01 19:30
 */
public class OptionalTest {

    @Test
    public void testObjectCreate() {
        // 创建⼀个表示缺失值的 Optional 对象
        Optional<String> absentOptional = Optional.absent();
        System.out.println(absentOptional);

        Optional<Insurance> strOptional = Optional.absent();
        System.out.println(strOptional);

        // 创建⼀个包含给定⾮空引⽤的 Optional 对象
        Optional<Car> optional = Optional.of(new Car());
        System.out.println(optional);

        Optional<String> optional1 = Optional.of("hello");
        System.out.println(optional1);

        // 创建⼀个包含给定引⽤的Optional对象
        Optional<String> optional2 = Optional.fromNullable("hello");
        Optional<String> nullOptional = Optional.fromNullable(null);
    }

    @Test
    public void testUse() {
        // 通过⽅法 isPresent() 检查 Optional 对象是否包含值
        Optional<String> str = Optional.of("张三");
        System.out.println(str.isPresent());

        Optional<String> optIsNotNull = Optional.fromNullable("李四");
        System.out.println(optIsNotNull.isPresent());

        Optional<String> optIsNull = Optional.fromNullable(null);
        System.out.println(optIsNull.isPresent());

        // 通过get()⽅法获取Optional 对象中的值，如果 Optional 对象为空，则抛出 IllegalStateException 异常。
        Optional<String> optional1 = Optional.fromNullable("hello");
        System.out.println(optional1.get());
//        Optional<String> optional2 = Optional.fromNullable(null);
//        System.out.println(optional2.get());

        // 设置默认值
        Optional<String> optional = Optional.absent();
        String defaultValue = "hello";
        String result = optional.or(defaultValue);
        System.out.println(result);

        Optional<String> optional3 = Optional.absent();
        Optional<String> secondChoice = Optional.of("hello");
        Optional<String> result2 = optional3.or(secondChoice);
        System.out.println(result2.get());

        Optional<String> optional4 = Optional.absent();
        String defaultValue2 = "hello";
        Supplier<String> supplier = () -> defaultValue2;
        String result3 = optional4.or(supplier);
        System.out.println(result3);

        // 通过orNull()⽅法来获取Optional实例中的⾮空值，如果它不存在则返回null
        Optional<String> optional5 = Optional.of("hello");
        String result4 = optional5.orNull();
        System.out.println(result4);

        Optional<String> absentOptional = Optional.absent();
        String nullResult = absentOptional.orNull();
        System.out.println(nullResult);
    }


}
