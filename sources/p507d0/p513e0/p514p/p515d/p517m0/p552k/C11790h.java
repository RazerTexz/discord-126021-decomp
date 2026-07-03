package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Comparator;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.h */
/* JADX INFO: compiled from: MemberComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11790h implements Comparator<InterfaceC11450m> {

    /* JADX INFO: renamed from: j */
    public static final C11790h f24409j = new C11790h();

    /* JADX INFO: renamed from: a */
    public static int m9929a(InterfaceC11450m interfaceC11450m) {
        if (C11787e.isEnumEntry(interfaceC11450m)) {
            return 8;
        }
        if (interfaceC11450m instanceof InterfaceC11448l) {
            return 7;
        }
        if (interfaceC11450m instanceof InterfaceC11453n0) {
            return ((InterfaceC11453n0) interfaceC11450m).getExtensionReceiverParameter() == null ? 6 : 5;
        }
        if (interfaceC11450m instanceof InterfaceC11472x) {
            return ((InterfaceC11472x) interfaceC11450m).getExtensionReceiverParameter() == null ? 4 : 3;
        }
        if (interfaceC11450m instanceof InterfaceC11330e) {
            return 2;
        }
        return interfaceC11450m instanceof InterfaceC11475y0 ? 1 : 0;
    }

    @Override // java.util.Comparator
    public int compare(InterfaceC11450m interfaceC11450m, InterfaceC11450m interfaceC11450m2) {
        Integer numValueOf;
        int iM9929a = m9929a(interfaceC11450m2) - m9929a(interfaceC11450m);
        if (iM9929a != 0) {
            numValueOf = Integer.valueOf(iM9929a);
        } else if (C11787e.isEnumEntry(interfaceC11450m) && C11787e.isEnumEntry(interfaceC11450m2)) {
            numValueOf = 0;
        } else {
            int iCompareTo = interfaceC11450m.getName().compareTo(interfaceC11450m2.getName());
            numValueOf = iCompareTo != 0 ? Integer.valueOf(iCompareTo) : null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}
