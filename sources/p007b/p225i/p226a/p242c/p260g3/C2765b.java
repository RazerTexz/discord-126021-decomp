package p007b.p225i.p226a.p242c.p260g3;

import android.util.Log;
import android.view.Display;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p260g3.C2785v;

/* JADX INFO: renamed from: b.i.a.c.g3.b */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2765b implements C2785v.b.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2785v f6810a;

    /* JADX INFO: renamed from: a */
    public final void m3120a(Display display) {
        C2785v c2785v = this.f6810a;
        Objects.requireNonNull(c2785v);
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            c2785v.f6936k = refreshRate;
            c2785v.f6937l = (refreshRate * 80) / 100;
        } else {
            Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            c2785v.f6936k = -9223372036854775807L;
            c2785v.f6937l = -9223372036854775807L;
        }
    }
}
