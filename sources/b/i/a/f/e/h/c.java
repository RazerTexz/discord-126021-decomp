package b.i.a.f.e.h;

import android.os.Looper;
import androidx.annotation.NonNull;
import b.i.a.f.e.h.a;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class c {
    public static final Set<c> a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    @Deprecated
    public interface a extends b.i.a.f.e.h.j.f {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    @Deprecated
    public interface b extends b.i.a.f.e.h.j.l {
    }

    public <A extends a.b, R extends h, T extends b.i.a.f.e.h.j.d<R, A>> T a(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends a.b, T extends b.i.a.f.e.h.j.d<? extends h, A>> T b(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public Looper c() {
        throw new UnsupportedOperationException();
    }
}
