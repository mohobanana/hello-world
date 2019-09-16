import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ft_test {

    public static class OutDto{
        private String name;
        private String number;
        private Date createDate;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }
    }

    public static void main(String[] args) throws Exception{
        Map<String,Object> outputMap = new HashMap<String, Object>();
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("name","aa");
        model.put("number","11");
        model.put("createDate","20190712");
        outputMap.put("model",model);
        OutDto outDto = new OutDto();
        mapToBean(model,outDto);
    }

    public static void mapToBean(Map<String,Object> map,Object bean) throws Exception{
        System.out.println(bean.getClass());
        Method[] methods = bean.getClass().getMethods();
        for(Method method:methods) {
            String beanValue = "";
            if (method.getName().startsWith("set")) {
                System.out.println(method.getName());
                beanValue = method.getName().substring(3);
                beanValue = beanValue.toLowerCase().charAt(0) + beanValue.substring(1);
                String mapValue = map.get(beanValue).toString();
                if (method.getName().contains("Date")) {
                    method.invoke(stringToDate(mapValue));
                }
                else method.invoke(mapValue);
            }
        }
    }

    public static Date stringToDate(String s){
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return format.parse(s);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
