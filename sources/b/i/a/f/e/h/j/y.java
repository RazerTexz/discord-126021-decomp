package b.i.a.f.e.h.j;

import android.os.Looper;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.a.d;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class y<O extends a.d> extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotOnlyInitialized
    public final b.i.a.f.e.h.b<O> f1375b;

    public y(b.i.a.f.e.h.b<O> bVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f1375b = bVar;
    }

    @Override // b.i.a.f.e.h.c
    public final <A extends a.b, R extends b.i.a.f.e.h.h, T extends d<R, A>> T a(@NonNull T t) {
        this.f1375b.d(0, t);
        return t;
    }

    @Override // b.i.a.f.e.h.c
    public final <A extends a.b, T extends d<? extends b.i.a.f.e.h.h, A>> T b(@NonNull T t) {
        this.f1375b.d(1, t);
        return t;
    }

    @Override // b.i.a.f.e.h.c
    public final Looper c() {
        return this.f1375b.e;
    }
}
