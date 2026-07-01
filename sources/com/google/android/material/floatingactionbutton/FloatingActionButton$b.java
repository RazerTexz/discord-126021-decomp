package com.google.android.material.floatingactionbutton;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowViewDelegate;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton$b implements ShadowViewDelegate {
    public final /* synthetic */ FloatingActionButton a;

    public FloatingActionButton$b(FloatingActionButton floatingActionButton) {
        this.a = floatingActionButton;
    }

    @Override // com.google.android.material.shadow.ShadowViewDelegate
    public float getRadius() {
        return this.a.getSizeDimension() / 2.0f;
    }

    @Override // com.google.android.material.shadow.ShadowViewDelegate
    public boolean isCompatPaddingEnabled() {
        return this.a.compatPadding;
    }

    @Override // com.google.android.material.shadow.ShadowViewDelegate
    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        if (drawable != null) {
            FloatingActionButton.access$101(this.a, drawable);
        }
    }

    @Override // com.google.android.material.shadow.ShadowViewDelegate
    public void setShadowPadding(int i, int i2, int i3, int i4) {
        this.a.shadowPadding.set(i, i2, i3, i4);
        FloatingActionButton floatingActionButton = this.a;
        floatingActionButton.setPadding(FloatingActionButton.access$000(floatingActionButton) + i, FloatingActionButton.access$000(this.a) + i2, FloatingActionButton.access$000(this.a) + i3, FloatingActionButton.access$000(this.a) + i4);
    }
}
