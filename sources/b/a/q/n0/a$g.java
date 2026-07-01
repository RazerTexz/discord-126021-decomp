package b.a.q.n0;

import java.util.TimerTask;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$g extends TimerTask {
    public final /* synthetic */ a j;

    public a$g(a aVar) {
        this.j = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.j.m(new a$g$a(this));
    }
}
