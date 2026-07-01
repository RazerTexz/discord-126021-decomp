package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class Slide$CalculateSlideVertical implements Slide$CalculateSlide {
    private Slide$CalculateSlideVertical() {
    }

    @Override // androidx.transition.Slide$CalculateSlide
    public float getGoneX(ViewGroup viewGroup, View view) {
        return view.getTranslationX();
    }

    public /* synthetic */ Slide$CalculateSlideVertical(Slide$1 slide$1) {
        this();
    }
}
