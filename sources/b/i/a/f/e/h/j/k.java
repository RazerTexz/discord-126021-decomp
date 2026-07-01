package b.i.a.f.e.h.j;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class k<L> {
    public final k$c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public volatile L f1366b;

    @Nullable
    public volatile k$a<L> c;

    public k(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.a = new k$c(this, looper);
        b.c.a.a0.d.z(l, "Listener must not be null");
        this.f1366b = l;
        b.c.a.a0.d.w(str);
        this.c = new k$a<>(l, str);
    }

    public final void a(k$b<? super L> k_b) {
        b.c.a.a0.d.z(k_b, "Notifier must not be null");
        this.a.sendMessage(this.a.obtainMessage(1, k_b));
    }
}
