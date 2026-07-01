package b.g.a.b;

/* JADX INFO: compiled from: JsonGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public enum d$a {
    AUTO_CLOSE_TARGET(true),
    AUTO_CLOSE_JSON_CONTENT(true),
    FLUSH_PASSED_TO_STREAM(true),
    QUOTE_FIELD_NAMES(true),
    QUOTE_NON_NUMERIC_NUMBERS(true),
    ESCAPE_NON_ASCII(false),
    WRITE_NUMBERS_AS_STRINGS(false),
    WRITE_BIGDECIMAL_AS_PLAIN(false),
    STRICT_DUPLICATE_DETECTION(false),
    IGNORE_UNKNOWN(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    d$a(boolean z2) {
        this._defaultState = z2;
    }

    public static int f() {
        d$a[] d_aArrValues = values();
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            d$a d_a = d_aArrValues[i2];
            if (d_a._defaultState) {
                i |= d_a._mask;
            }
        }
        return i;
    }

    public boolean g(int i) {
        return (i & this._mask) != 0;
    }

    public int h() {
        return this._mask;
    }
}
