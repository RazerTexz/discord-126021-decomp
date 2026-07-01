package d0.e0.p.d.m0.d.b;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.d, reason: use source file name */
/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum LookupLocation3 implements LookupLocation2 {
    FROM_IDE,
    FROM_BACKEND,
    FROM_TEST,
    FROM_BUILTINS,
    WHEN_CHECK_DECLARATION_CONFLICTS,
    WHEN_CHECK_OVERRIDES,
    FOR_SCRIPT,
    FROM_REFLECTION,
    WHEN_RESOLVE_DECLARATION,
    WHEN_GET_DECLARATION_SCOPE,
    WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS,
    FOR_ALREADY_TRACKED,
    WHEN_GET_ALL_DESCRIPTORS,
    WHEN_TYPING,
    WHEN_GET_SUPER_MEMBERS,
    FOR_NON_TRACKED_SCOPE,
    FROM_SYNTHETIC_SCOPE,
    FROM_DESERIALIZATION,
    FROM_JAVA_LOADER,
    WHEN_GET_LOCAL_VARIABLE,
    WHEN_FIND_BY_FQNAME,
    WHEN_GET_COMPANION_OBJECT,
    FOR_DEFAULT_IMPORTS;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static LookupLocation3[] valuesCustom() {
        LookupLocation3[] lookupLocation3ArrValuesCustom = values();
        LookupLocation3[] lookupLocation3Arr = new LookupLocation3[lookupLocation3ArrValuesCustom.length];
        System.arraycopy(lookupLocation3ArrValuesCustom, 0, lookupLocation3Arr, 0, lookupLocation3ArrValuesCustom.length);
        return lookupLocation3Arr;
    }

    @Override // d0.e0.p.d.m0.d.b.LookupLocation2
    public LookupLocation getLocation() {
        return null;
    }
}
