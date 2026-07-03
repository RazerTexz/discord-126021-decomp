package p007b.p225i.p226a.p341g.p351j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.g.j.i */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4438i implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4437h f11814a;

    public C4438i(C4437h c4437h) {
        this.f11814a = c4437h;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.f11814a.f11821c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
