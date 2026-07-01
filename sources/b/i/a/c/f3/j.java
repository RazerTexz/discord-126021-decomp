package b.i.a.c.f3;

/* JADX INFO: compiled from: ConditionVariable.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public final g a = g.a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f971b;

    public synchronized boolean a() {
        boolean z2;
        z2 = this.f971b;
        this.f971b = false;
        return z2;
    }

    public synchronized boolean b() {
        if (this.f971b) {
            return false;
        }
        this.f971b = true;
        notifyAll();
        return true;
    }
}
