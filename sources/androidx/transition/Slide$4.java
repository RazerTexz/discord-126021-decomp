package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Slide$4 extends Slide$CalculateSlideHorizontal {
    public Slide$4() {
        super(null);
    }

    @Override // androidx.transition.Slide$CalculateSlide
    public float getGoneX(ViewGroup viewGroup, View view) {
        return view.getTranslationX() + viewGroup.getWidth();
    }
}
