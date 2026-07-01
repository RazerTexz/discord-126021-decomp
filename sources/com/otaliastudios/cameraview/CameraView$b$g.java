package com.otaliastudios.cameraview;

import android.graphics.PointF;
import android.media.MediaActionSound;
import b.o.a.q.a;
import b.o.a.s.b;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$b$g implements Runnable {
    public final /* synthetic */ boolean j;
    public final /* synthetic */ a k;
    public final /* synthetic */ PointF l;
    public final /* synthetic */ CameraView$b m;

    public CameraView$b$g(CameraView$b cameraView$b, boolean z2, a aVar, PointF pointF) {
        this.m = cameraView$b;
        this.j = z2;
        this.k = aVar;
        this.l = pointF;
    }

    @Override // java.lang.Runnable
    public void run() {
        CameraView cameraView;
        boolean z2;
        if (this.j && (z2 = (cameraView = this.m.c).l) && z2) {
            if (cameraView.B == null) {
                cameraView.B = new MediaActionSound();
            }
            cameraView.B.play(1);
        }
        b.o.a.s.a aVar = this.m.c.C;
        if (aVar != null) {
            aVar.c(this.k != null ? b.GESTURE : b.METHOD, this.j, this.l);
        }
        Iterator<b.o.a.a> it = this.m.c.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
