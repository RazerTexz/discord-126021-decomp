package com.otaliastudios.cameraview;

import b.o.a.a;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$b$d implements Runnable {
    public final /* synthetic */ CameraException j;
    public final /* synthetic */ CameraView$b k;

    public CameraView$b$d(CameraView$b cameraView$b, CameraException cameraException) {
        this.k = cameraView$b;
        this.j = cameraException;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = this.k.c.D.iterator();
        while (it.hasNext()) {
            it.next().b(this.j);
        }
    }
}
