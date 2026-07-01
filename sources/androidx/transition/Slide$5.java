package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class Slide$5 extends Slide$CalculateSlideHorizontal {
    public Slide$5() {
        super(null);
    }

    @Override // androidx.transition.Slide$CalculateSlide
    public float getGoneX(ViewGroup viewGroup, View view) {
        return ViewCompat.getLayoutDirection(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
    }
}
