package b.f.j.l;

import com.facebook.imagepipeline.memory.BasePool;

/* JADX INFO: compiled from: NoOpPoolStatsTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class v implements z {
    public static v a;

    public static synchronized v h() {
        if (a == null) {
            a = new v();
        }
        return a;
    }

    @Override // b.f.j.l.z
    public void a(int i) {
    }

    @Override // b.f.j.l.z
    public void b(int i) {
    }

    @Override // b.f.j.l.z
    public void c(BasePool basePool) {
    }

    @Override // b.f.j.l.z
    public void d() {
    }

    @Override // b.f.j.l.z
    public void e(int i) {
    }

    @Override // b.f.j.l.z
    public void f() {
    }

    @Override // b.f.j.l.z
    public void g(int i) {
    }
}
