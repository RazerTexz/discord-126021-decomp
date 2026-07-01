package b.g.a.b;

/* JADX INFO: compiled from: JsonParser.java */
/* JADX INFO: loaded from: classes3.dex */
public enum f$a {
    AUTO_CLOSE_SOURCE(true),
    ALLOW_COMMENTS(false),
    ALLOW_YAML_COMMENTS(false),
    ALLOW_UNQUOTED_FIELD_NAMES(false),
    ALLOW_SINGLE_QUOTES(false),
    ALLOW_UNQUOTED_CONTROL_CHARS(false),
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
    ALLOW_NUMERIC_LEADING_ZEROS(false),
    ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
    ALLOW_NON_NUMERIC_NUMBERS(false),
    ALLOW_MISSING_VALUES(false),
    ALLOW_TRAILING_COMMA(false),
    STRICT_DUPLICATE_DETECTION(false),
    IGNORE_UNDEFINED(false),
    INCLUDE_SOURCE_IN_LOCATION(true);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    f$a(boolean z2) {
        this._defaultState = z2;
    }

    public static int f() {
        f$a[] f_aArrValues = values();
        int i = 0;
        for (int i2 = 0; i2 < 15; i2++) {
            f$a f_a = f_aArrValues[i2];
            if (f_a._defaultState) {
                i |= f_a._mask;
            }
        }
        return i;
    }
}
