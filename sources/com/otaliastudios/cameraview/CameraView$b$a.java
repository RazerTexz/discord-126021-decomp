package com.otaliastudios.cameraview;

import android.graphics.PointF;
import b.o.a.a;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$b$a implements Runnable {
    public final /* synthetic */ float j;
    public final /* synthetic */ PointF[] k;
    public final /* synthetic */ CameraView$b l;

    public CameraView$b$a(CameraView$b cameraView$b, float f, PointF[] pointFArr) {
        this.l = cameraView$b;
        this.j = f;
        this.k = pointFArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = this.l.c.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
