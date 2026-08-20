package lombok.core;

import com.adjust.sdk.Constants;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/JavaIdentifiers.SCL.lombok */
public class JavaIdentifiers {
    private static final LombokImmutableList<String> KEYWORDS = LombokImmutableList.m10924of("public", "private", "protected", "default", "switch", "case", "for", "do", "goto", "const", "strictfp", "while", "if", "else", "byte", "short", "int", Constants.LONG, "float", "double", "void", "boolean", "char", "null", "false", "true", "continue", "break", "return", "instanceof", "synchronized", "volatile", "transient", "final", "static", "interface", "class", "extends", "implements", "throws", "throw", "catch", "try", "finally", "abstract", "assert", "enum", "import", "package", "native", "new", "super", "this");
    private static final Pattern PRIMITIVE_TYPE_NAME_PATTERN = Pattern.compile("^(?:boolean|byte|short|int|long|float|double|char)$");

    private JavaIdentifiers() {
    }

    public static boolean isValidJavaIdentifier(String identifier) {
        if (identifier == null || identifier.isEmpty() || !Character.isJavaIdentifierStart(identifier.charAt(0))) {
            return false;
        }
        for (int i = 1; i < identifier.length(); i++) {
            if (!Character.isJavaIdentifierPart(identifier.charAt(i))) {
                return false;
            }
        }
        return !isKeyword(identifier);
    }

    public static boolean isKeyword(String keyword) {
        return KEYWORDS.contains(keyword);
    }

    public static boolean isPrimitive(String typeName) {
        return PRIMITIVE_TYPE_NAME_PATTERN.matcher(typeName).matches();
    }
}
