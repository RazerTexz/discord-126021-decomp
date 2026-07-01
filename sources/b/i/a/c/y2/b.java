package b.i.a.c.y2;

import android.os.HandlerThread;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements b.i.b.a.l {
    public final /* synthetic */ int j;

    public /* synthetic */ b(int i) {
        this.j = i;
    }

    @Override // b.i.b.a.l
    public final Object get() {
        return new HandlerThread(l.l(this.j, "ExoPlayer:MediaCodecQueueingThread:"));
    }
}
