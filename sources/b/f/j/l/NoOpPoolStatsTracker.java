package b.f.j.l;

import com.facebook.imagepipeline.memory.BasePool;

/* JADX INFO: renamed from: b.f.j.l.v, reason: use source file name */
/* JADX INFO: compiled from: NoOpPoolStatsTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class NoOpPoolStatsTracker implements PoolStatsTracker {
    public static NoOpPoolStatsTracker a;

    public static synchronized NoOpPoolStatsTracker h() {
        if (a == null) {
            a = new NoOpPoolStatsTracker();
        }
        return a;
    }

    @Override // b.f.j.l.PoolStatsTracker
    public void a(int i) {
    }

    @Override // b.f.j.l.PoolStatsTracker
    public void b(int i) {
    }

    @Override // b.f.j.l.PoolStatsTracker
    public void c(BasePool basePool) {
    }

    @Override // b.f.j.l.PoolStatsTracker
    public void d() {
    }

    @Override // b.f.j.l.PoolStatsTracker
    public void e(int i) {
    }

    @Override // b.f.j.l.PoolStatsTracker
    public void f() {
    }

    @Override // b.f.j.l.PoolStatsTracker
    public void g(int i) {
    }
}
