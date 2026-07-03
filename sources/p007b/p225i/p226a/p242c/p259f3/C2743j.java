package p007b.p225i.p226a.p242c.p259f3;

/* JADX INFO: renamed from: b.i.a.c.f3.j */
/* JADX INFO: compiled from: ConditionVariable.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2743j {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2740g f6727a = InterfaceC2740g.f6720a;

    /* JADX INFO: renamed from: b */
    public boolean f6728b;

    /* JADX INFO: renamed from: a */
    public synchronized boolean m3025a() {
        boolean z2;
        z2 = this.f6728b;
        this.f6728b = false;
        return z2;
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m3026b() {
        if (this.f6728b) {
            return false;
        }
        this.f6728b = true;
        notifyAll();
        return true;
    }
}
