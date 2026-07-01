package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class Slide$CalculateSlideHorizontal implements Slide$CalculateSlide {
    private Slide$CalculateSlideHorizontal() {
    }

    @Override // androidx.transition.Slide$CalculateSlide
    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY();
    }

    public /* synthetic */ Slide$CalculateSlideHorizontal(Slide$1 slide$1) {
        this();
    }
}
