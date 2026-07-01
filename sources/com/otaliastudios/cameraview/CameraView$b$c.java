package com.otaliastudios.cameraview;

import b.o.a.p.b;
import b.o.a.p.d;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$b$c implements Runnable {
    public final /* synthetic */ b j;
    public final /* synthetic */ CameraView$b k;

    public CameraView$b$c(CameraView$b cameraView$b, b bVar) {
        this.k = cameraView$b;
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k.f3177b.a(0, "dispatchFrame: executing. Passing", Long.valueOf(this.j.a()), "to processors.");
        Iterator<d> it = this.k.c.E.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(this.j);
            } catch (Exception e) {
                this.k.f3177b.a(2, "Frame processor crashed:", e);
            }
        }
        this.j.b();
    }
}
