package b.i.a.c.t2;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import b.i.a.c.v2.DecoderReuseEvaluation;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.t2.r, reason: use source file name */
/* JADX INFO: compiled from: AudioRendererEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface AudioRendererEventListener2 {

    /* JADX INFO: renamed from: b.i.a.c.t2.r$a */
    /* JADX INFO: compiled from: AudioRendererEventListener.java */
    public static final class a {

        @Nullable
        public final Handler a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final AudioRendererEventListener2 f1126b;

        public a(@Nullable Handler handler, @Nullable AudioRendererEventListener2 audioRendererEventListener2) {
            if (audioRendererEventListener2 != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.a = handler;
            this.f1126b = audioRendererEventListener2;
        }

        public void a(final DecoderCounters decoderCounters) {
            synchronized (decoderCounters) {
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.t2.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener2.a aVar = this.j;
                        DecoderCounters decoderCounters2 = decoderCounters;
                        Objects.requireNonNull(aVar);
                        synchronized (decoderCounters2) {
                        }
                        AudioRendererEventListener2 audioRendererEventListener2 = aVar.f1126b;
                        int i = Util2.a;
                        audioRendererEventListener2.k(decoderCounters2);
                    }
                });
            }
        }
    }

    void B(String str);

    void C(String str, long j, long j2);

    void I(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void N(Exception exc);

    void R(long j);

    void T(Exception exc);

    @Deprecated
    void U(Format2 format2);

    void d(boolean z2);

    void e0(int i, long j, long j2);

    void k(DecoderCounters decoderCounters);

    void m(DecoderCounters decoderCounters);
}
