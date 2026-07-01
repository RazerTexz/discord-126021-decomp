package b.i.a.c.y2;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;
import b.i.a.c.j1;

/* JADX INFO: compiled from: MediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t$a {
    public final u a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaFormat f1314b;
    public final j1 c;

    @Nullable
    public final Surface d;

    @Nullable
    public final MediaCrypto e;

    public t$a(u uVar, MediaFormat mediaFormat, j1 j1Var, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i, boolean z2) {
        this.a = uVar;
        this.f1314b = mediaFormat;
        this.c = j1Var;
        this.d = surface;
        this.e = mediaCrypto;
    }
}
