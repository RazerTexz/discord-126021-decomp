package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p265v2.C2955c;

/* JADX INFO: renamed from: b.i.a.c.y2.t */
/* JADX INFO: compiled from: MediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3148t {

    /* JADX INFO: renamed from: b.i.a.c.y2.t$a */
    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C3149u f9107a;

        /* JADX INFO: renamed from: b */
        public final MediaFormat f9108b;

        /* JADX INFO: renamed from: c */
        public final C2811j1 f9109c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public final Surface f9110d;

        /* JADX INFO: renamed from: e */
        @Nullable
        public final MediaCrypto f9111e;

        public a(C3149u c3149u, MediaFormat mediaFormat, C2811j1 c2811j1, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i, boolean z2) {
            this.f9107a = c3149u;
            this.f9108b = mediaFormat;
            this.f9109c = c2811j1;
            this.f9110d = surface;
            this.f9111e = mediaCrypto;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.y2.t$b */
    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        InterfaceC3148t mo3845a(a aVar) throws IOException;
    }

    /* JADX INFO: renamed from: b.i.a.c.y2.t$c */
    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public interface c {
    }

    /* JADX INFO: renamed from: a */
    boolean mo3834a();

    /* JADX INFO: renamed from: b */
    void mo3835b(int i, int i2, C2955c c2955c, long j, int i3);

    @RequiresApi(21)
    /* JADX INFO: renamed from: c */
    void mo3836c(int i, long j);

    /* JADX INFO: renamed from: d */
    int mo3837d();

    /* JADX INFO: renamed from: e */
    int mo3838e(MediaCodec.BufferInfo bufferInfo);

    @RequiresApi(23)
    /* JADX INFO: renamed from: f */
    void mo3839f(c cVar, Handler handler);

    void flush();

    /* JADX INFO: renamed from: g */
    void mo3840g(int i);

    MediaFormat getOutputFormat();

    @Nullable
    /* JADX INFO: renamed from: h */
    ByteBuffer mo3841h(int i);

    @RequiresApi(23)
    /* JADX INFO: renamed from: i */
    void mo3842i(Surface surface);

    @Nullable
    /* JADX INFO: renamed from: j */
    ByteBuffer mo3843j(int i);

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void release();

    void releaseOutputBuffer(int i, boolean z2);

    @RequiresApi(19)
    void setParameters(Bundle bundle);
}
