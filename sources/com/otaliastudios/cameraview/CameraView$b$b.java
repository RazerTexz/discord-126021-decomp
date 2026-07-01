package com.otaliastudios.cameraview;

import android.graphics.PointF;
import b.o.a.a;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$b$b implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ float[] k;
    public final /* synthetic */ PointF[] l;
    public final /* synthetic */ CameraView$b m;

    public CameraView$b$b(CameraView$b cameraView$b, float f, float[] fArr, PointF[] pointFArr) {
        this.m = cameraView$b;
        this.j = f;
        this.k = fArr;
        this.l = pointFArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = this.m.c.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
