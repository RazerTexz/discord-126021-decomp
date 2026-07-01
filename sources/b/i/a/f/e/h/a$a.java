package b.i.a.f.e.h;

import android.content.Context;
import android.os.Looper;
import b.i.a.f.e.h.a$f;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a$a<T extends a$f, O> extends a$e<T, O> {
    @Deprecated
    public T a(Context context, Looper looper, b.i.a.f.e.k.c cVar, O o, c$a c_a, c$b c_b) {
        return (T) b(context, looper, cVar, o, c_a, c_b);
    }

    public T b(Context context, Looper looper, b.i.a.f.e.k.c cVar, O o, b.i.a.f.e.h.j.f fVar, b.i.a.f.e.h.j.l lVar) {
        throw new UnsupportedOperationException("buildClient must be implemented");
    }
}
