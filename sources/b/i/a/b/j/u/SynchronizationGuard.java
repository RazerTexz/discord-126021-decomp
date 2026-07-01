package b.i.a.b.j.u;

import androidx.annotation.WorkerThread;

/* JADX INFO: renamed from: b.i.a.b.j.u.a, reason: use source file name */
/* JADX INFO: compiled from: SynchronizationGuard.java */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public interface SynchronizationGuard {

    /* JADX INFO: renamed from: b.i.a.b.j.u.a$a */
    /* JADX INFO: compiled from: SynchronizationGuard.java */
    public interface a<T> {
        T execute();
    }

    <T> T a(a<T> aVar);
}
