package reflect;

import java.lang.reflect.Method;

public class ReflectTest {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws Exception {
        Class klass = Class.forName("ReflectTest");
        Method method = klass.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            method.invoke(null, i);
        }
    }

//    @Test
//    public void test() throws IOException {
//        byte[] encoded = Files.readAllBytes(Paths.get("/Users/lixin/Downloads/area_format_object (2).json"));
//        String jsonString = new String(encoded, StandardCharsets.UTF_8);
//        JSONObject jsonObject = JSONObject.parseObject(jsonString);
//        ArrayList<StreetInfo> list = new ArrayList<>();
//        // 省
//        for (String key : jsonObject.keySet()) {
//            JSONObject province = jsonObject.getJSONObject(key);
//            // 市
//            JSONObject city = province.getJSONObject("c");
//            for (String s : city.keySet()) {
//                // 区
//                JSONObject county = city.getJSONObject(s);
//                JSONObject street = county.getJSONObject("c");
//                if (street.isEmpty()) {
//                    continue;
//                }
//                for (String s1 : street.keySet()) {
//                    JSONObject obj = street.getJSONObject(s1);
//                    JSONObject obj2 = obj.getJSONObject("c");
//                    if (obj2.isEmpty()) {
//                        StreetInfo info = new StreetInfo();
//                        info.setProvince(province.getString("n"));
//                        info.setCity(county.getString("n"));
//                        info.setCounty(street.getString("n"));
//                        list.add(info);
//                        continue;
//                    }
//                    for (String s2 : obj2.keySet()) {
//                        JSONObject sss = obj2.getJSONObject(s2);
//                        StreetInfo info = new StreetInfo();
//                        info.setProvince(province.getString("n"));
//                        info.setCity(county.getString("n"));
//                        info.setCounty(obj.getString("n"));
//                        info.setStreet(sss.getString("n"));
//                        list.add(info);
//                    }
//                }
//            }
//        }
//        System.out.println(list);
//        String fileName = "全国省市区县街道信息.xlsx";
//        writeDataToExcel(list, fileName);
//    }
//
//    public void writeDataToExcel(List<StreetInfo> list, String fileName) {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("全国省市区县街道信息");
//
//        // 创建表头
//        Row headerRow = sheet.createRow(0);
//        String[] headers = {"省", "市", "区", "街道"};
//        for (int i = 0; i < headers.length; i++) {
//            Cell headerCell = headerRow.createCell(i);
//            headerCell.setCellValue(headers[i]);
//        }
//
//        // 填充数据
//        for (int i = 0; i < list.size(); i++) {
//            StreetInfo info = list.get(i);
//            Row dataRow = sheet.createRow(i + 1);
//            dataRow.createCell(0).setCellValue(info.getProvince());
//            dataRow.createCell(1).setCellValue(info.getCity());
//            dataRow.createCell(2).setCellValue(info.getCounty());
//            dataRow.createCell(3).setCellValue(info.getStreet());
//        }
//
//        // 自动调整列宽
//        for (int i = 0; i < headers.length; i++) {
//            sheet.autoSizeColumn(i);
//        }
//
//        // 将数据写入文件
//        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
//            workbook.write(fileOut);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 关闭工作簿
//        try {
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public class StreetInfo {
//        @ExcelProperty("省")
//        private String province;
//        @ExcelProperty("市")
//        private String city;
//        @ExcelProperty("区")
//        private String county;
//        @ExcelProperty("街道")
//        private String street;
//    }
}
