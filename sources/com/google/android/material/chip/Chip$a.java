package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import com.google.android.material.resources.TextAppearanceFontCallback;

/* JADX INFO: loaded from: classes3.dex */
public class Chip$a extends TextAppearanceFontCallback {
    public final /* synthetic */ Chip a;

    public Chip$a(Chip chip) {
        this.a = chip;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(@NonNull Typeface typeface, boolean z2) {
        Chip chip = this.a;
        chip.setText(Chip.access$000(chip).shouldDrawText() ? Chip.access$000(this.a).getText() : this.a.getText());
        this.a.requestLayout();
        this.a.invalidate();
    }
}
