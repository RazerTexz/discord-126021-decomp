package p596e0.p597a.p598a.p599a;

import android.os.HandlerThread;

/* JADX INFO: renamed from: e0.a.a.a.c */
/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class HandlerThreadC12255c extends HandlerThread {

    /* JADX INFO: renamed from: j */
    public AbstractC12253a f25320j;

    public HandlerThreadC12255c(AbstractC12253a abstractC12253a) {
        super("CameraHandlerThread");
        this.f25320j = abstractC12253a;
        start();
    }
}
