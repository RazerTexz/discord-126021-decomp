package p007b.p195g.p196a.p205c;

import p007b.p195g.p196a.p205c.p221z.InterfaceC2387e;

/* JADX INFO: renamed from: b.g.a.c.p */
/* JADX INFO: compiled from: MapperFeature.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC2366p implements InterfaceC2387e {
    USE_ANNOTATIONS(true),
    USE_GETTERS_AS_SETTERS(true),
    PROPAGATE_TRANSIENT_MARKER(false),
    AUTO_DETECT_CREATORS(true),
    AUTO_DETECT_FIELDS(true),
    AUTO_DETECT_GETTERS(true),
    AUTO_DETECT_IS_GETTERS(true),
    AUTO_DETECT_SETTERS(true),
    REQUIRE_SETTERS_FOR_GETTERS(false),
    ALLOW_FINAL_FIELDS_AS_MUTATORS(true),
    INFER_PROPERTY_MUTATORS(true),
    INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES(true),
    ALLOW_VOID_VALUED_PROPERTIES(false),
    CAN_OVERRIDE_ACCESS_MODIFIERS(true),
    OVERRIDE_PUBLIC_ACCESS_MODIFIERS(true),
    USE_STATIC_TYPING(false),
    USE_BASE_TYPE_AS_DEFAULT_IMPL(false),
    INFER_BUILDER_TYPE_BINDINGS(true),
    DEFAULT_VIEW_INCLUSION(true),
    SORT_PROPERTIES_ALPHABETICALLY(false),
    SORT_CREATOR_PROPERTIES_FIRST(true),
    ACCEPT_CASE_INSENSITIVE_PROPERTIES(false),
    ACCEPT_CASE_INSENSITIVE_ENUMS(false),
    ACCEPT_CASE_INSENSITIVE_VALUES(false),
    USE_WRAPPER_NAME_AS_PROPERTY_NAME(false),
    USE_STD_BEAN_NAMING(false),
    ALLOW_EXPLICIT_PROPERTY_RENAMING(false),
    ALLOW_COERCION_OF_SCALARS(true),
    IGNORE_DUPLICATE_MODULE_REGISTRATIONS(true),
    IGNORE_MERGE_FOR_UNMERGEABLE(true),
    BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES(false);

    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    EnumC2366p(boolean z2) {
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
    public boolean m2222h(int i) {
        return (i & this._mask) != 0;
    }
}
