package b.i.a.c.g3;

import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(30)
public final class v$a {
    @DoNotInline
    public static void a(Surface surface, float f) {
        try {
            surface.setFrameRate(f, f == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            b.i.a.c.f3.q.b("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }
}
