package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import b.c.a.LottieDrawable;

/* JADX INFO: renamed from: b.c.a.y.m.f, reason: use source file name */
/* JADX INFO: compiled from: NullLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class NullLayer extends BaseLayer2 {
    public NullLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        super(lottieDrawable, layer2);
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void j(Canvas canvas, Matrix matrix, int i) {
    }
}
