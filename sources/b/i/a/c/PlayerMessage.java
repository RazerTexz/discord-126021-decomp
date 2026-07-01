package b.i.a.c;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.SystemHandlerWrapper;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: renamed from: b.i.a.c.b2, reason: use source file name */
/* JADX INFO: compiled from: PlayerMessage.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerMessage {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f837b;
    public final Clock4 c;
    public final Timeline d;
    public int e;

    @Nullable
    public Object f;
    public Looper g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;

    /* JADX INFO: renamed from: b.i.a.c.b2$a */
    /* JADX INFO: compiled from: PlayerMessage.java */
    public interface a {
    }

    /* JADX INFO: renamed from: b.i.a.c.b2$b */
    /* JADX INFO: compiled from: PlayerMessage.java */
    public interface b {
        void r(int i, @Nullable Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(a aVar, b bVar, Timeline timeline, int i, Clock4 clock4, Looper looper) {
        this.f837b = aVar;
        this.a = bVar;
        this.d = timeline;
        this.g = looper;
        this.c = clock4;
        this.h = i;
    }

    public synchronized boolean a(long j) throws InterruptedException, TimeoutException {
        boolean z2;
        AnimatableValueParser.D(this.i);
        AnimatableValueParser.D(this.g.getThread() != Thread.currentThread());
        long jD = this.c.d() + j;
        while (true) {
            z2 = this.k;
            if (z2 || j <= 0) {
                break;
            }
            this.c.c();
            wait(j);
            j = jD - this.c.d();
        }
        if (!z2) {
            throw new TimeoutException("Message delivery timed out.");
        }
        return this.j;
    }

    public synchronized boolean b() {
        return false;
    }

    public synchronized void c(boolean z2) {
        this.j = z2 | this.j;
        this.k = true;
        notifyAll();
    }

    public PlayerMessage d() {
        AnimatableValueParser.D(!this.i);
        AnimatableValueParser.j(true);
        this.i = true;
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = (ExoPlayerImplInternal2) this.f837b;
        synchronized (exoPlayerImplInternal2) {
            if (exoPlayerImplInternal2.I || !exoPlayerImplInternal2.r.isAlive()) {
                Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
                c(false);
            } else {
                ((SystemHandlerWrapper.b) exoPlayerImplInternal2.q.i(14, this)).b();
            }
        }
        return this;
    }

    public PlayerMessage e(@Nullable Object obj) {
        AnimatableValueParser.D(!this.i);
        this.f = obj;
        return this;
    }

    public PlayerMessage f(int i) {
        AnimatableValueParser.D(!this.i);
        this.e = i;
        return this;
    }
}
