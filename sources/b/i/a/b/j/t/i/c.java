package b.i.a.b.j.t.i;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;

/* JADX INFO: compiled from: EventStore.java */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public interface c extends Closeable {
    @Nullable
    h a0(b.i.a.b.j.i iVar, b.i.a.b.j.f fVar);

    long h0(b.i.a.b.j.i iVar);

    int l();

    boolean l0(b.i.a.b.j.i iVar);

    void m(Iterable<h> iterable);

    void n0(Iterable<h> iterable);

    Iterable<h> r(b.i.a.b.j.i iVar);

    void v(b.i.a.b.j.i iVar, long j);

    Iterable<b.i.a.b.j.i> z();
}
