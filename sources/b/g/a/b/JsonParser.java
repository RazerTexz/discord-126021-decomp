package b.g.a.b;

import b.g.a.b.t.JacksonFeatureSet;
import java.io.Closeable;

/* JADX INFO: renamed from: b.g.a.b.f, reason: use source file name */
/* JADX INFO: compiled from: JsonParser.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonParser implements Closeable {

    /* JADX INFO: renamed from: b.g.a.b.f$a */
    /* JADX INFO: compiled from: JsonParser.java */
    public enum a {
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

        a(boolean z2) {
            this._defaultState = z2;
        }

        public static int f() {
            a[] aVarArrValues = values();
            int i = 0;
            for (int i2 = 0; i2 < 15; i2++) {
                a aVar = aVarArrValues[i2];
                if (aVar._defaultState) {
                    i |= aVar._mask;
                }
            }
            return i;
        }
    }

    /* JADX INFO: renamed from: b.g.a.b.f$b */
    /* JADX INFO: compiled from: JsonParser.java */
    public enum b {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }

    static {
        JacksonFeatureSet.a(StreamReadCapability.values());
    }

    public JsonParser() {
    }

    public abstract JsonLocation a();

    public JsonParser(int i) {
    }
}
