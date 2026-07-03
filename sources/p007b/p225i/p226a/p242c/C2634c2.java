package p007b.p225i.p226a.p242c;

import java.util.Collection;
import java.util.HashMap;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0;

/* JADX INFO: renamed from: b.i.a.c.c2 */
/* JADX INFO: compiled from: PlaylistTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2634c2 extends AbstractC2842r0 {

    /* JADX INFO: renamed from: n */
    public final int f6170n;

    /* JADX INFO: renamed from: o */
    public final int f6171o;

    /* JADX INFO: renamed from: p */
    public final int[] f6172p;

    /* JADX INFO: renamed from: q */
    public final int[] f6173q;

    /* JADX INFO: renamed from: r */
    public final AbstractC2832o2[] f6174r;

    /* JADX INFO: renamed from: s */
    public final Object[] f6175s;

    /* JADX INFO: renamed from: t */
    public final HashMap<Object, Integer> f6176t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2634c2(Collection<? extends InterfaceC2910t1> collection, InterfaceC2550k0 interfaceC2550k0) {
        super(false, interfaceC2550k0);
        int iMo2557p = 0;
        int size = collection.size();
        this.f6172p = new int[size];
        this.f6173q = new int[size];
        this.f6174r = new AbstractC2832o2[size];
        this.f6175s = new Object[size];
        this.f6176t = new HashMap<>();
        int iMo2555i = 0;
        int i = 0;
        for (InterfaceC2910t1 interfaceC2910t1 : collection) {
            this.f6174r[i] = interfaceC2910t1.mo2931a();
            this.f6173q[i] = iMo2557p;
            this.f6172p[i] = iMo2555i;
            iMo2557p += this.f6174r[i].mo2557p();
            iMo2555i += this.f6174r[i].mo2555i();
            this.f6175s[i] = interfaceC2910t1.getUid();
            this.f6176t.put(this.f6175s[i], Integer.valueOf(i));
            i++;
        }
        this.f6170n = iMo2557p;
        this.f6171o = iMo2555i;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: i */
    public int mo2555i() {
        return this.f6171o;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
    /* JADX INFO: renamed from: p */
    public int mo2557p() {
        return this.f6170n;
    }
}
