package d0.e0.p.d.m0.k;

import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.y0;
import java.util.Comparator;

/* JADX INFO: compiled from: MemberComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements Comparator<d0.e0.p.d.m0.c.m> {
    public static final h j = new h();

    public static int a(d0.e0.p.d.m0.c.m mVar) {
        if (e.isEnumEntry(mVar)) {
            return 8;
        }
        if (mVar instanceof d0.e0.p.d.m0.c.l) {
            return 7;
        }
        if (mVar instanceof n0) {
            return ((n0) mVar).getExtensionReceiverParameter() == null ? 6 : 5;
        }
        if (mVar instanceof x) {
            return ((x) mVar).getExtensionReceiverParameter() == null ? 4 : 3;
        }
        if (mVar instanceof d0.e0.p.d.m0.c.e) {
            return 2;
        }
        return mVar instanceof y0 ? 1 : 0;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
        return compare2(mVar, mVar2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
        Integer numValueOf;
        int iA = a(mVar2) - a(mVar);
        if (iA != 0) {
            numValueOf = Integer.valueOf(iA);
        } else if (e.isEnumEntry(mVar) && e.isEnumEntry(mVar2)) {
            numValueOf = 0;
        } else {
            int iCompareTo2 = mVar.getName().compareTo2(mVar2.getName());
            numValueOf = iCompareTo2 != 0 ? Integer.valueOf(iCompareTo2) : null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
