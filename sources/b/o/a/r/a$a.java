package b.o.a.r;

import java.util.Comparator;

/* JADX INFO: compiled from: CamcorderProfiles.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements Comparator<b.o.a.x.b> {
    public final /* synthetic */ long j;

    public a$a(long j) {
        this.j = j;
    }

    @Override // java.util.Comparator
    public int compare(b.o.a.x.b bVar, b.o.a.x.b bVar2) {
        b.o.a.x.b bVar3 = bVar;
        b.o.a.x.b bVar4 = bVar2;
        long jAbs = Math.abs(((long) (bVar3.j * bVar3.k)) - this.j);
        long jAbs2 = Math.abs(((long) (bVar4.j * bVar4.k)) - this.j);
        if (jAbs < jAbs2) {
            return -1;
        }
        return jAbs == jAbs2 ? 0 : 1;
    }
}
