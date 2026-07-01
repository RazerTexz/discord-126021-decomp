package b.i.a.c.g3;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.v2.DecoderCounters;
import b.i.a.c.v2.DecoderReuseEvaluation;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.g3.x, reason: use source file name */
/* JADX INFO: compiled from: VideoRendererEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoRendererEventListener2 {

    /* JADX INFO: renamed from: b.i.a.c.g3.x$a */
    /* JADX INFO: compiled from: VideoRendererEventListener.java */
    public static final class a {

        @Nullable
        public final Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final VideoRendererEventListener2 f995b;

        public a(@Nullable Handler handler, @Nullable VideoRendererEventListener2 videoRendererEventListener2) {
            if (videoRendererEventListener2 != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.a = handler;
            this.f995b = videoRendererEventListener2;
        }
    }

    void F(int i, long j);

    void K(Object obj, long j);

    @Deprecated
    void O(Format2 format2);

    void P(DecoderCounters decoderCounters);

    void Q(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void V(Exception exc);

    void Z(DecoderCounters decoderCounters);

    void f(VideoSize videoSize);

    void h0(long j, int i);

    void l(String str);

    void n(String str, long j, long j2);
}
