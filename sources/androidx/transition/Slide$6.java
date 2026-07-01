package androidx.transition;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class Slide$6 extends Slide$CalculateSlideVertical {
    public Slide$6() {
        super(null);
    }

    @Override // androidx.transition.Slide$CalculateSlide
    public float getGoneY(ViewGroup viewGroup, View view) {
        return view.getTranslationY() + viewGroup.getHeight();
    }
}
