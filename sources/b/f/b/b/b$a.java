package b.f.b.b;

/* JADX INFO: compiled from: DefaultEntryEvictionComparatorSupplier.java */
/* JADX INFO: loaded from: classes.dex */
public class b$a implements f {
    public b$a(b bVar) {
    }

    @Override // java.util.Comparator
    public int compare(c$a c_a, c$a c_a2) {
        long jA = c_a.a();
        long jA2 = c_a2.a();
        if (jA < jA2) {
            return -1;
        }
        return jA2 == jA ? 0 : 1;
    }
}
