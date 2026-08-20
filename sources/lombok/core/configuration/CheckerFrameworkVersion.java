package lombok.core.configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/CheckerFrameworkVersion.SCL.lombok */
public final class CheckerFrameworkVersion implements ConfigurationValueType {
    private final int version;
    private static final int DEFAULT = 3200;
    private static final int MAX_SUPPORTED = 4000;
    public static final String NAME__SIDE_EFFECT_FREE = "org.checkerframework.dataflow.qual.SideEffectFree";
    public static final String NAME__PURE = "org.checkerframework.dataflow.qual.Pure";
    public static final String NAME__UNIQUE = "org.checkerframework.common.aliasing.qual.Unique";
    public static final String NAME__RETURNS_RECEIVER = "org.checkerframework.common.returnsreceiver.qual.This";
    public static final String NAME__NOT_CALLED = "org.checkerframework.checker.calledmethods.qual.NotCalledMethods";
    public static final String NAME__CALLED = "org.checkerframework.checker.calledmethods.qual.CalledMethods";
    public static final CheckerFrameworkVersion NONE = new CheckerFrameworkVersion(0);
    private static final Pattern VERSION = Pattern.compile("^(\\d+)(?:\\.(\\d+))?(?:\\.\\d+)*$");

    private CheckerFrameworkVersion(int v) {
        this.version = v;
    }

    public boolean generateSideEffectFree() {
        return this.version > 0;
    }

    public boolean generateUnique() {
        return this.version > 2899;
    }

    public boolean generatePure() {
        return this.version > 0;
    }

    public boolean generateReturnsReceiver() {
        return this.version > 3999;
    }

    public boolean generateCalledMethods() {
        return this.version > 3999;
    }

    public static CheckerFrameworkVersion valueOf(String versionString) {
        if (versionString != null) {
            versionString = versionString.trim();
        }
        if (versionString == null || versionString.equalsIgnoreCase("false") || versionString.equals("0")) {
            return new CheckerFrameworkVersion(0);
        }
        if (versionString.equalsIgnoreCase("true")) {
            return new CheckerFrameworkVersion(DEFAULT);
        }
        Matcher m = VERSION.matcher(versionString);
        if (!m.matches()) {
            throw new IllegalArgumentException("Expected 'true' or 'false' or a major/minor version, such as '2.9'");
        }
        int major = Integer.parseInt(m.group(1));
        int minor = (m.group(2) == null || m.group(2).isEmpty()) ? 0 : Integer.parseInt(m.group(2));
        if (minor > 999) {
            throw new IllegalArgumentException("Minor version must be between 0 and 999");
        }
        int v = (major * 1000) + minor;
        if (v > 4000) {
            String s2 = String.valueOf(v / 1000) + "." + (v % 1000);
            throw new IllegalArgumentException("Lombok supports at most v" + s2 + "; reduce the value of key 'checkerframework' to " + s2);
        }
        return new CheckerFrameworkVersion(v);
    }

    public static String description() {
        return "checkerframework-version";
    }

    public static String exampleValue() {
        return "major.minor (example: 3.2 - and no higher than 4.0) or true or false";
    }

    public boolean equals(Object obj) {
        return (obj instanceof CheckerFrameworkVersion) && this.version == ((CheckerFrameworkVersion) obj).version;
    }

    public int hashCode() {
        return this.version;
    }
}
