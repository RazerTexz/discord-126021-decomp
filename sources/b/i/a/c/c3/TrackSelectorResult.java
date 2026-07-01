package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.i.a.c.RendererConfiguration;
import b.i.a.c.TracksInfo;
import b.i.a.c.f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.c3.r, reason: use source file name */
/* JADX INFO: compiled from: TrackSelectorResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectorResult {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RendererConfiguration[] f912b;
    public final ExoTrackSelection2[] c;
    public final TracksInfo d;

    @Nullable
    public final Object e;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection2[] exoTrackSelection2Arr, TracksInfo tracksInfo, @Nullable Object obj) {
        this.f912b = rendererConfigurationArr;
        this.c = (ExoTrackSelection2[]) exoTrackSelection2Arr.clone();
        this.d = tracksInfo;
        this.e = obj;
        this.a = rendererConfigurationArr.length;
    }

    public boolean a(@Nullable TrackSelectorResult trackSelectorResult, int i) {
        return trackSelectorResult != null && Util2.a(this.f912b[i], trackSelectorResult.f912b[i]) && Util2.a(this.c[i], trackSelectorResult.c[i]);
    }

    public boolean b(int i) {
        return this.f912b[i] != null;
    }
}
