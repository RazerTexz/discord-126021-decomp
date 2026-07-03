package p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b;

/* JADX INFO: renamed from: d0.e0.p.d.m0.d.b.d */
/* JADX INFO: compiled from: LookupLocation.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11482d implements InterfaceC11480b {
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
    public static EnumC11482d[] valuesCustom() {
        EnumC11482d[] enumC11482dArrValuesCustom = values();
        EnumC11482d[] enumC11482dArr = new EnumC11482d[enumC11482dArrValuesCustom.length];
        System.arraycopy(enumC11482dArrValuesCustom, 0, enumC11482dArr, 0, enumC11482dArrValuesCustom.length);
        return enumC11482dArr;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b
    public InterfaceC11479a getLocation() {
        return null;
    }
}
