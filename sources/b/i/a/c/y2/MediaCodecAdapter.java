package b.i.a.c.y2;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.Format2;
import b.i.a.c.v2.CryptoInfo;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.i.a.c.y2.t, reason: use source file name */
/* JADX INFO: compiled from: MediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaCodecAdapter {

    /* JADX INFO: renamed from: b.i.a.c.y2.t$a */
    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public static final class a {
        public final MediaCodecInfo a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f1314b;
        public final Format2 c;

        @Nullable
        public final Surface d;

        @Nullable
        public final MediaCrypto e;

        public a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format2 format2, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i, boolean z2) {
            this.a = mediaCodecInfo;
            this.f1314b = mediaFormat;
            this.c = format2;
            this.d = surface;
            this.e = mediaCrypto;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.y2.t$b */
    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public interface b {
        MediaCodecAdapter a(a aVar) throws IOException;
    }

    /* JADX INFO: renamed from: b.i.a.c.y2.t$c */
    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public interface c {
    }

    boolean a();

    void b(int i, int i2, CryptoInfo cryptoInfo, long j, int i3);

    @RequiresApi(21)
    void c(int i, long j);

    int d();

    int e(MediaCodec.BufferInfo bufferInfo);

    @RequiresApi(23)
    void f(c cVar, Handler handler);

    void flush();

    void g(int i);

    MediaFormat getOutputFormat();

    @Nullable
    ByteBuffer h(int i);

    @RequiresApi(23)
    void i(Surface surface);

    @Nullable
    ByteBuffer j(int i);

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void release();

    void releaseOutputBuffer(int i, boolean z2);

    @RequiresApi(19)
    void setParameters(Bundle bundle);
}
