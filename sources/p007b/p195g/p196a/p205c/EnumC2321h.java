package p007b.p195g.p196a.p205c;

import p007b.p195g.p196a.p205c.p221z.InterfaceC2387e;

/* JADX INFO: renamed from: b.g.a.c.h */
/* JADX INFO: compiled from: DeserializationFeature.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2321h implements InterfaceC2387e {
    USE_BIG_DECIMAL_FOR_FLOATS(false),
    USE_BIG_INTEGER_FOR_INTS(false),
    USE_LONG_FOR_INTS(false),
    USE_JAVA_ARRAY_FOR_JSON_ARRAY(false),
    FAIL_ON_UNKNOWN_PROPERTIES(true),
    FAIL_ON_NULL_FOR_PRIMITIVES(false),
    FAIL_ON_NUMBERS_FOR_ENUMS(false),
    FAIL_ON_INVALID_SUBTYPE(true),
    FAIL_ON_READING_DUP_TREE_KEY(false),
    FAIL_ON_IGNORED_PROPERTIES(false),
    FAIL_ON_UNRESOLVED_OBJECT_IDS(true),
    FAIL_ON_MISSING_CREATOR_PROPERTIES(false),
    FAIL_ON_NULL_CREATOR_PROPERTIES(false),
    FAIL_ON_MISSING_EXTERNAL_TYPE_ID_PROPERTY(true),
    FAIL_ON_TRAILING_TOKENS(false),
    WRAP_EXCEPTIONS(true),
    ACCEPT_SINGLE_VALUE_AS_ARRAY(false),
    UNWRAP_SINGLE_VALUE_ARRAYS(false),
    UNWRAP_ROOT_VALUE(false),
    ACCEPT_EMPTY_STRING_AS_NULL_OBJECT(false),
    ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT(false),
    ACCEPT_FLOAT_AS_INT(true),
    READ_ENUMS_USING_TO_STRING(false),
    READ_UNKNOWN_ENUM_VALUES_AS_NULL(false),
    READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE(false),
    READ_DATE_TIMESTAMPS_AS_NANOSECONDS(true),
    ADJUST_DATES_TO_CONTEXT_TIME_ZONE(true),
    EAGER_DESERIALIZER_FETCH(true);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    EnumC2321h(boolean z2) {
        this._defaultState = z2;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.InterfaceC2387e
    /* JADX INFO: renamed from: f */
    public boolean mo2090f() {
        return this._defaultState;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.InterfaceC2387e
    /* JADX INFO: renamed from: g */
    public int mo2091g() {
        return this._mask;
    }
}
