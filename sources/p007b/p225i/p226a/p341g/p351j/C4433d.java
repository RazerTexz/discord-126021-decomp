package p007b.p225i.p226a.p341g.p351j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.g.j.d */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4433d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4430a f11786a;

    public C4433d(C4430a c4430a) {
        this.f11786a = c4430a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.f11786a.f11821c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
