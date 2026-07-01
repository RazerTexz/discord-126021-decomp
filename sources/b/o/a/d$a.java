package b.o.a;

import java.io.File;

/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements Runnable {
    public final /* synthetic */ File j;
    public final /* synthetic */ d k;

    public d$a(d dVar, File file) {
        this.k = dVar;
        this.j = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k.m.a(this.j);
    }
}
