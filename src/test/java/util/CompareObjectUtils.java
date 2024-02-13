package util;

import anno.FieldMeta;
import com.sun.deploy.util.StringUtils;
import domain.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CompareObjectUtils {

    public static String compare(Object oldObject, Object newObject) throws IllegalAccessException {
        ArrayList<String> strings = new ArrayList<>();
        // 获取class
        Class<?> oldClazz = oldObject.getClass();
        Class<?> newClazz = newObject.getClass();
        // 获取属性列表
        Field[] oldFields = oldClazz.getDeclaredFields();
        Field[] newFields = newClazz.getDeclaredFields();
        Map<String, Field> newFieldMap = Arrays.stream(newFields)
                .collect(Collectors.toMap(Field::getName, field -> field));
        for (Field oldField : oldFields) {
            // 获取属性名
            String fieldName = oldField.getName();
            if (!newFieldMap.containsKey(fieldName)) {
                continue;
            }
            Field newField = newFieldMap.get(fieldName);
            if (!oldField.isAnnotationPresent(FieldMeta.class) || !newField.isAnnotationPresent(FieldMeta.class)) {
                continue;
            }
            oldField.setAccessible(true);
            newField.setAccessible(true);
            String fieldDesc = oldField.getAnnotation(FieldMeta.class).description();
            Object oldValue = oldField.get(oldObject);
            Object newValue = newField.get(newObject);
            if (Objects.nonNull(oldValue) && Objects.nonNull(newValue) && !oldValue.equals(newValue)) {
                strings.add(fieldDesc + ":" + oldValue + "修改为" + newValue);
            }
        }
        return strings.stream().collect(Collectors.joining(",", "", ""));
    }


    public static void main(String[] args) {
        String recordDetail = "dataStartDate=Mon Mar 13 00:00:00 GMT+08:00 2023, dataEndDate=Mon Mar 13 00:00:00 GMT+08:00 2023, commodityName=权限打包测试大屏, commodityDesc=权限打包测试大屏, commodityLabels=数据标签一,测试标签";
        String s1 = StringUtils.trimWhitespace(recordDetail);
        System.out.println(s1);
        String[] split = recordDetail.split(",");
        String commodityName = Arrays.stream(split)
                .map(String::trim)
                .filter(s -> s.startsWith("commodityName"))
                .map(s -> s.substring(s.indexOf("commodityName") + "commodityName".length() + 1)).collect(
                        Collectors.joining());
        System.out.println(commodityName);
    }

}
