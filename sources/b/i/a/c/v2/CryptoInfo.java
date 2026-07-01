package b.i.a.c.v2;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.v2.c, reason: use source file name */
/* JADX INFO: compiled from: CryptoInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CryptoInfo {

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
    public final MediaCodec.CryptoInfo i;

    @Nullable
    public final b j;

    /* JADX INFO: renamed from: b.i.a.c.v2.c$b */
    /* JADX INFO: compiled from: CryptoInfo.java */
    @RequiresApi(24)
    public static final class b {
        public final MediaCodec.CryptoInfo a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f1142b = new MediaCodec.CryptoInfo.Pattern(0, 0);

        public b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this.a = cryptoInfo;
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.j = Util2.a >= 24 ? new b(cryptoInfo, null) : null;
    }
}
