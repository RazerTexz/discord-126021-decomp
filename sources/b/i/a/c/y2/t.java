package b.i.a.c.y2;

import android.media.MediaCodec$BufferInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: MediaCodecAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface t {
    boolean a();

    void b(int i, int i2, b.i.a.c.v2.c cVar, long j, int i3);

    @RequiresApi(21)
    void c(int i, long j);

    int d();

    int e(MediaCodec$BufferInfo mediaCodec$BufferInfo);

    @RequiresApi(23)
    void f(t$c t_c, Handler handler);

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
