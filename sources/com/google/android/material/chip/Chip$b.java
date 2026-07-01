package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class Chip$b extends ViewOutlineProvider {
    public final /* synthetic */ Chip a;

    public Chip$b(Chip chip) {
        this.a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public void getOutline(View view, @NonNull Outline outline) {
        if (Chip.access$000(this.a) != null) {
            Chip.access$000(this.a).getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
