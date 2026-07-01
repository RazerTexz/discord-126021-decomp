package com.google.android.material.bottomappbar;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$b implements TransformationCallback<FloatingActionButton> {
    public final /* synthetic */ BottomAppBar a;

    public BottomAppBar$b(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // com.google.android.material.animation.TransformationCallback
    public void onScaleChanged(@NonNull View view) {
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        BottomAppBar.access$400(this.a).setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
    }

    @Override // com.google.android.material.animation.TransformationCallback
    public void onTranslationChanged(@NonNull View view) {
        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
        float translationX = floatingActionButton.getTranslationX();
        if (BottomAppBar.access$500(this.a).getHorizontalOffset() != translationX) {
            BottomAppBar.access$500(this.a).setHorizontalOffset(translationX);
            BottomAppBar.access$400(this.a).invalidateSelf();
        }
        float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
        if (BottomAppBar.access$500(this.a).getCradleVerticalOffset() != fMax) {
            BottomAppBar.access$500(this.a).setCradleVerticalOffset(fMax);
            BottomAppBar.access$400(this.a).invalidateSelf();
        }
        BottomAppBar.access$400(this.a).setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
    }
}
