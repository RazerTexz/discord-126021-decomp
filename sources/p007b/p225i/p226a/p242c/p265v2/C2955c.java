package p007b.p225i.p226a.p242c.p265v2;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.v2.c */
/* JADX INFO: compiled from: CryptoInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2955c {

    /* JADX INFO: renamed from: a */
    @Nullable
    public byte[] f7902a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public byte[] f7903b;

    /* JADX INFO: renamed from: c */
    public int f7904c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public int[] f7905d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public int[] f7906e;

    /* JADX INFO: renamed from: f */
    public int f7907f;

    /* JADX INFO: renamed from: g */
    public int f7908g;

    /* JADX INFO: renamed from: h */
    public int f7909h;

    /* JADX INFO: renamed from: i */
    public final MediaCodec.CryptoInfo f7910i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public final b f7911j;

    /* JADX INFO: renamed from: b.i.a.c.v2.c$b */
    /* JADX INFO: compiled from: CryptoInfo.java */
    @RequiresApi(24)
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final MediaCodec.CryptoInfo f7912a;

        /* JADX INFO: renamed from: b */
        public final MediaCodec.CryptoInfo.Pattern f7913b = new MediaCodec.CryptoInfo.Pattern(0, 0);

        public b(MediaCodec.CryptoInfo cryptoInfo, a aVar) {
            this.f7912a = cryptoInfo;
        }
    }

    public C2955c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f7910i = cryptoInfo;
        this.f7911j = C2738e0.f6708a >= 24 ? new b(cryptoInfo, null) : null;
    }
}
