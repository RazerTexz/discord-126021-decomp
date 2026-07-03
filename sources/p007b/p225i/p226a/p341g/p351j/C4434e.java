package p007b.p225i.p226a.p341g.p351j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.g.j.e */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4434e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4430a f11787a;

    public C4434e(C4430a c4430a) {
        this.f11787a = c4430a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f11787a.f11821c.setScaleX(fFloatValue);
        this.f11787a.f11821c.setScaleY(fFloatValue);
    }
}
