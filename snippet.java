import java.util.*;

class snippet {

    public void abc() {
        String s = "JuLiEn", s1 = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch))
                s1 += Character.toUpperCase(ch);
            else {
                if (Character.isUpperCase(ch))
                    if (i % 2 != 0)
                        s1 += Character.toLowerCase(s.charAt(i - 1));
            }
        }
        System.out.println(s1);
    }

    public static void main(String[] args) {
        snippet obj = new snippet();
        obj.abc();
    }
}
