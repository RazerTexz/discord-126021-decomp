package b.i.a.c.t2;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: AudioRendererEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r$a {

    @Nullable
    public final Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final r f1126b;

    public r$a(@Nullable Handler handler, @Nullable r rVar) {
        if (rVar != null) {
            Objects.requireNonNull(handler);
        } else {
            handler = null;
        }
        this.a = handler;
        this.f1126b = rVar;
    }

    public void a(b.i.a.c.v2.e eVar) {
        synchronized (eVar) {
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new b(this, eVar));
        }
    }
}
