package d0.e0.p.d.m0.c.i1;

import java.util.Set;

/* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class o$a$d extends d0.e0.p.d.m0.k.i {
    public final /* synthetic */ Set a;

    public o$a$d(o$a o_a, Set set) {
        this.a = set;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1) {
            objArr[0] = "fromSuper";
        } else if (i != 2) {
            objArr[0] = "fakeOverride";
        } else {
            objArr[0] = "fromCurrent";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
        if (i == 1 || i == 2) {
            objArr[2] = "conflict";
        } else {
            objArr[2] = "addFakeOverride";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.k.j
    public void addFakeOverride(d0.e0.p.d.m0.c.b bVar) {
        if (bVar == null) {
            a(0);
            throw null;
        }
        d0.e0.p.d.m0.k.k.resolveUnknownVisibilityForMember(bVar, null);
        this.a.add(bVar);
    }

    @Override // d0.e0.p.d.m0.k.i
    public void conflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2) {
        if (bVar == null) {
            a(1);
            throw null;
        }
        if (bVar2 != null) {
            return;
        }
        a(2);
        throw null;
    }
}
