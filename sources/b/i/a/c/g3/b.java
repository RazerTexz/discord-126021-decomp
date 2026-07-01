package b.i.a.c.g3;

import android.util.Log;
import android.view.Display;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements v$b$a {
    public final /* synthetic */ v a;

    public /* synthetic */ b(v vVar) {
        this.a = vVar;
    }

    public final void a(Display display) {
        v vVar = this.a;
        Objects.requireNonNull(vVar);
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            vVar.k = refreshRate;
            vVar.l = (refreshRate * 80) / 100;
        } else {
            Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            vVar.k = -9223372036854775807L;
            vVar.l = -9223372036854775807L;
        }
    }
}
