package com.otaliastudios.cameraview;

import android.graphics.PointF;
import android.view.View;
import b.o.a.q.a;
import b.o.a.s.b;
import b.o.a.s.c;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$b$f implements Runnable {
    public final /* synthetic */ PointF j;
    public final /* synthetic */ a k;
    public final /* synthetic */ CameraView$b l;

    public CameraView$b$f(CameraView$b cameraView$b, PointF pointF, a aVar) {
        this.l = cameraView$b;
        this.j = pointF;
        this.k = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.l.c.K;
        PointF[] pointFArr = {this.j};
        View view = cVar.j.get(1);
        if (view != null) {
            view.clearAnimation();
            PointF pointF = pointFArr[0];
            float width = (int) (pointF.x - (view.getWidth() / 2));
            float height = (int) (pointF.y - (view.getHeight() / 2));
            view.setTranslationX(width);
            view.setTranslationY(height);
        }
        b.o.a.s.a aVar = this.l.c.C;
        if (aVar != null) {
            aVar.a(this.k != null ? b.GESTURE : b.METHOD, this.j);
        }
        Iterator<b.o.a.a> it = this.l.c.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
