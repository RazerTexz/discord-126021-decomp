package p007b.p195g.p196a.p205c;

import p007b.p195g.p196a.p205c.p221z.InterfaceC2387e;

/* JADX INFO: renamed from: b.g.a.c.w */
/* JADX INFO: compiled from: SerializationFeature.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2373w implements InterfaceC2387e {
    WRAP_ROOT_VALUE(false),
    INDENT_OUTPUT(false),
    FAIL_ON_EMPTY_BEANS(true),
    FAIL_ON_SELF_REFERENCES(true),
    WRAP_EXCEPTIONS(true),
    FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS(true),
    WRITE_SELF_REFERENCES_AS_NULL(false),
    CLOSE_CLOSEABLE(false),
    FLUSH_AFTER_WRITE_VALUE(true),
    WRITE_DATES_AS_TIMESTAMPS(true),
    WRITE_DATE_KEYS_AS_TIMESTAMPS(false),
    WRITE_DATES_WITH_ZONE_ID(false),
    WRITE_DURATIONS_AS_TIMESTAMPS(true),
    WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS(false),
    WRITE_ENUMS_USING_TO_STRING(false),
    WRITE_ENUMS_USING_INDEX(false),
    WRITE_ENUM_KEYS_USING_INDEX(false),
    WRITE_NULL_MAP_VALUES(true),
    WRITE_EMPTY_JSON_ARRAYS(true),
    WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED(false),
    WRITE_BIGDECIMAL_AS_PLAIN(false),
    WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS(true),
    ORDER_MAP_ENTRIES_BY_KEYS(false),
    EAGER_SERIALIZER_FETCH(true),
    USE_EQUALITY_FOR_OBJECT_ID(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    EnumC2373w(boolean z2) {
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

    /* JADX INFO: renamed from: h */
    public boolean m2238h(int i) {
        return (i & this._mask) != 0;
    }
}
