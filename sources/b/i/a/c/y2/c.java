package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaCodec$OnFrameRenderedListener;
import b.i.a.c.g3.r$b;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements MediaCodec$OnFrameRenderedListener {
    public final /* synthetic */ l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t$c f1303b;

    public /* synthetic */ c(l lVar, t$c t_c) {
        this.a = lVar;
        this.f1303b = t_c;
    }

    @Override // android.media.MediaCodec$OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        l lVar = this.a;
        t$c t_c = this.f1303b;
        Objects.requireNonNull(lVar);
        ((r$b) t_c).b(lVar, j, j2);
    }
}
