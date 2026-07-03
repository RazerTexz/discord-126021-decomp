package p007b.p109f.p111b.p113b;

import p007b.p109f.p111b.p113b.InterfaceC1660c;

/* JADX INFO: renamed from: b.f.b.b.b */
/* JADX INFO: compiled from: DefaultEntryEvictionComparatorSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class C1659b implements InterfaceC1664g {

    /* JADX INFO: renamed from: b.f.b.b.b$a */
    /* JADX INFO: compiled from: DefaultEntryEvictionComparatorSupplier.java */
    public class a implements InterfaceC1663f {
        public a(C1659b c1659b) {
        }

        @Override // java.util.Comparator
        public int compare(InterfaceC1660c.a aVar, InterfaceC1660c.a aVar2) {
            long jMo945a = aVar.mo945a();
            long jMo945a2 = aVar2.mo945a();
            if (jMo945a < jMo945a2) {
                return -1;
            }
            return jMo945a2 == jMo945a ? 0 : 1;
        }
    }

    @Override // p007b.p109f.p111b.p113b.InterfaceC1664g
    public InterfaceC1663f get() {
        return new a(this);
    }
}
