package lombok.core.configuration;

import lombok.core.JavaIdentifiers;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/TypeName.SCL.lombok */
public final class TypeName implements ConfigurationValueType {
    private final String name;

    private TypeName(String name) {
        this.name = name;
    }

    public static TypeName valueOf(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        String trimmedName = name.trim();
        for (String identifier : trimmedName.split("\\.")) {
            if (!JavaIdentifiers.isValidJavaIdentifier(identifier)) {
                throw new IllegalArgumentException("Invalid type name " + trimmedName + " (part " + identifier + ")");
            }
        }
        return new TypeName(trimmedName);
    }

    public static String description() {
        return "type-name";
    }

    public static String exampleValue() {
        return "<fully.qualified.Type>";
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeName) {
            return this.name.equals(((TypeName) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }

    public String getName() {
        return this.name;
    }

    public char[] getCharArray() {
        return this.name.toCharArray();
    }
}
