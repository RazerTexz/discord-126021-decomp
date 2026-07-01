package lombok.core.configuration;

import lombok.core.LombokImmutableList;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: app.apk:lombok/core/configuration/NullCheckExceptionType.SCL.lombok */
@ExampleValueString("[NullPointerException | IllegalArgumentException | Assertion | JDK | Guava]")
public abstract class NullCheckExceptionType {
    public static final NullCheckExceptionType ILLEGAL_ARGUMENT_EXCEPTION = new NullCheckExceptionType$1("ILLEGAL_ARGUMENT_EXCEPTION", 0);
    public static final NullCheckExceptionType NULL_POINTER_EXCEPTION = new NullCheckExceptionType$2("NULL_POINTER_EXCEPTION", 1);
    public static final NullCheckExceptionType ASSERTION = new NullCheckExceptionType$3("ASSERTION", 2);
    public static final NullCheckExceptionType JDK = new NullCheckExceptionType$4("JDK", 3);
    public static final NullCheckExceptionType GUAVA = new NullCheckExceptionType$5("GUAVA", 4);
    private static final /* synthetic */ NullCheckExceptionType[] ENUM$VALUES = {ILLEGAL_ARGUMENT_EXCEPTION, NULL_POINTER_EXCEPTION, ASSERTION, JDK, GUAVA};
    private static final LombokImmutableList<String> METHOD_JDK = LombokImmutableList.of("java", "util", "Objects", "requireNonNull");
    private static final LombokImmutableList<String> METHOD_GUAVA = LombokImmutableList.of("com", "google", "common", "base", "Preconditions", "checkNotNull", new String[0]);

    public abstract String getExceptionType();

    public abstract LombokImmutableList<String> getMethod();

    public static NullCheckExceptionType[] values() {
        NullCheckExceptionType[] nullCheckExceptionTypeArr = ENUM$VALUES;
        int length = nullCheckExceptionTypeArr.length;
        NullCheckExceptionType[] nullCheckExceptionTypeArr2 = new NullCheckExceptionType[length];
        System.arraycopy(nullCheckExceptionTypeArr, 0, nullCheckExceptionTypeArr2, 0, length);
        return nullCheckExceptionTypeArr2;
    }

    public static NullCheckExceptionType valueOf(String str) {
        return (NullCheckExceptionType) Enum.valueOf(NullCheckExceptionType.class, str);
    }

    private NullCheckExceptionType(String str, int i) {
        super(str, i);
    }

    /* synthetic */ NullCheckExceptionType(String str, int i, NullCheckExceptionType nullCheckExceptionType) {
        this(str, i);
    }

    static /* synthetic */ LombokImmutableList access$3() {
        return METHOD_JDK;
    }

    static /* synthetic */ LombokImmutableList access$4() {
        return METHOD_GUAVA;
    }

    public String toExceptionMessage(String fieldName, String customMessage) {
        return customMessage == null ? String.valueOf(fieldName) + " is marked non-null but is null" : customMessage.replace("%s", fieldName);
    }
}
