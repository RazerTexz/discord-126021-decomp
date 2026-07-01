package b.i.a.c.v2;

import android.media.MediaCodec$CryptoInfo;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;

/* JADX INFO: compiled from: CryptoInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @Nullable
    public byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public byte[] f1141b;
    public int c;

    @Nullable
    public int[] d;

    @Nullable
    public int[] e;
    public int f;
    public int g;
    public int h;
    public final MediaCodec$CryptoInfo i;

    @Nullable
    public final c$b j;

    public c() {
        MediaCodec$CryptoInfo mediaCodec$CryptoInfo = new MediaCodec$CryptoInfo();
        this.i = mediaCodec$CryptoInfo;
        this.j = e0.a >= 24 ? new c$b(mediaCodec$CryptoInfo, null) : null;
    }
}
