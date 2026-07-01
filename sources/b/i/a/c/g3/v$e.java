package b.i.a.c.g3;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer$FrameCallback;
import b.i.a.c.f3.e0;
import java.util.Objects;

/* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v$e implements Choreographer$FrameCallback, Handler$Callback {
    public static final v$e j = new v$e();
    public volatile long k = -9223372036854775807L;
    public final Handler l;
    public final HandlerThread m;
    public Choreographer n;
    public int o;

    public v$e() {
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        this.m = handlerThread;
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        int i = e0.a;
        Handler handler = new Handler(looper, this);
        this.l = handler;
        handler.sendEmptyMessage(0);
    }

    @Override // android.view.Choreographer$FrameCallback
    public void doFrame(long j2) {
        this.k = j2;
        Choreographer choreographer = this.n;
        Objects.requireNonNull(choreographer);
        choreographer.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.n = Choreographer.getInstance();
            return true;
        }
        if (i == 1) {
            int i2 = this.o + 1;
            this.o = i2;
            if (i2 == 1) {
                Choreographer choreographer = this.n;
                Objects.requireNonNull(choreographer);
                choreographer.postFrameCallback(this);
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        int i3 = this.o - 1;
        this.o = i3;
        if (i3 == 0) {
            Choreographer choreographer2 = this.n;
            Objects.requireNonNull(choreographer2);
            choreographer2.removeFrameCallback(this);
            this.k = -9223372036854775807L;
        }
        return true;
    }
}
