package utilities;

public class CodeGenerator {

    private static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String generateCode(int length) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < length; i++) {
            code.append(alpha.charAt((int) (Math.random() * (alpha.length()))));
        }
        return code.toString();
    }
}
