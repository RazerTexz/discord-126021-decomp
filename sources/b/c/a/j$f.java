package b.c.a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

/* JADX INFO: compiled from: LottieDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class j$f implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ j a;

    public j$f(j jVar) {
        this.a = jVar;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        j jVar = this.a;
        b.c.a.y.m.c cVar = jVar.f353x;
        if (cVar != null) {
            cVar.o(jVar.l.h());
        }
    }
}
