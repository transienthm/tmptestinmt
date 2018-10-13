package org.java.bin.effective;

/**
 * 描述:
 *
 * @author Alcalde
 * @create 2018-10-07 8:47 PM
 */
public enum EnumTest {
    MONDAY("星期一",1), SUNDAY("星期天", 7),;

    private final String name;
    private final int code;

    EnumTest(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public static void main(String[] args) {

        for (EnumTest day : EnumTest.values()) {
            System.out.println(day.getName() + " " + day.getCode());
        }

    }
}
