package d0.e0.p.d.m0.f.z;

/* JADX INFO: compiled from: Flags.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$b extends b$d<Boolean> {
    public b$b(int i) {
        super(i, 1, null);
    }

    @Override // d0.e0.p.d.m0.f.z.b$d
    public /* bridge */ /* synthetic */ Boolean get(int i) {
        return get(i);
    }

    @Override // d0.e0.p.d.m0.f.z.b$d
    public /* bridge */ /* synthetic */ int toFlags(Boolean bool) {
        return toFlags2(bool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.f.z.b$d
    public Boolean get(int i) {
        Boolean boolValueOf = Boolean.valueOf((i & (1 << this.a)) != 0);
        if (boolValueOf != null) {
            return boolValueOf;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
    }

    /* JADX INFO: renamed from: toFlags, reason: avoid collision after fix types in other method */
    public int toFlags2(Boolean bool) {
        if (bool.booleanValue()) {
            return 1 << this.a;
        }
        return 0;
    }
}
