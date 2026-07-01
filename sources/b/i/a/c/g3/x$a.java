package b.i.a.c.g3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: VideoRendererEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x$a {

    @Nullable
    public final Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final x f995b;

    public x$a(@Nullable Handler handler, @Nullable x xVar) {
        if (xVar != null) {
            Objects.requireNonNull(handler);
        } else {
            handler = null;
        }
        this.a = handler;
        this.f995b = xVar;
    }
}
