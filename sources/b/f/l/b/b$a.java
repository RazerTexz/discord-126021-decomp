package b.f.l.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.graphics.Matrix;

/* JADX INFO: compiled from: AnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ b a;

    public b$a(b bVar) {
        this.a = bVar;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        b bVar = this.a;
        Matrix matrix = bVar.r;
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        for (int i = 0; i < 9; i++) {
            bVar.p[i] = (bVar.o[i] * fFloatValue) + ((1.0f - fFloatValue) * bVar.n[i]);
        }
        matrix.setValues(bVar.p);
        b bVar2 = this.a;
        Matrix matrix2 = bVar2.r;
        b.f.d.e.a.i(c.class, "setTransform");
        bVar2.h.set(matrix2);
        bVar2.i();
    }
}
