package d0.e0.p.d;

import java.util.Comparator;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i$f<T> implements Comparator<d0.e0.p.d.m0.c.u> {
    public static final i$f j = new i$f();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(d0.e0.p.d.m0.c.u uVar, d0.e0.p.d.m0.c.u uVar2) {
        return compare2(uVar, uVar2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(d0.e0.p.d.m0.c.u uVar, d0.e0.p.d.m0.c.u uVar2) {
        Integer numCompare = d0.e0.p.d.m0.c.t.compare(uVar, uVar2);
        if (numCompare != null) {
            return numCompare.intValue();
        }
        return 0;
    }
}
