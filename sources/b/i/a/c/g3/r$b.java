package b.i.a.c.g3;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.f3.e0;
import b.i.a.c.y2.t$c;
import com.google.android.exoplayer2.ExoPlaybackException;

/* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(23)
public final class r$b implements t$c, Handler$Callback {
    public final Handler j;
    public final /* synthetic */ r k;

    public r$b(r rVar, b.i.a.c.y2.t tVar) {
        this.k = rVar;
        int i = e0.a;
        Looper looperMyLooper = Looper.myLooper();
        b.c.a.a0.d.H(looperMyLooper);
        Handler handler = new Handler(looperMyLooper, this);
        this.j = handler;
        tVar.f(this, handler);
    }

    public final void a(long j) {
        r rVar = this.k;
        if (this != rVar.x1) {
            return;
        }
        if (j == RecyclerView.FOREVER_NS) {
            rVar.H0 = true;
            return;
        }
        try {
            rVar.N0(j);
        } catch (ExoPlaybackException e) {
            this.k.I0 = e;
        }
    }

    public void b(b.i.a.c.y2.t tVar, long j, long j2) {
        if (e0.a >= 30) {
            a(j);
        } else {
            this.j.sendMessageAtFrontOfQueue(Message.obtain(this.j, 0, (int) (j >> 32), (int) j));
        }
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        a((e0.L(message.arg1) << 32) | e0.L(message.arg2));
        return true;
    }
}
