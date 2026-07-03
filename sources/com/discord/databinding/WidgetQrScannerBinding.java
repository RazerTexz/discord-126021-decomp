package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.Chip;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetQrScannerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f17395a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ZXingScannerView f17396b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final Chip f17397c;

    public WidgetQrScannerBinding(@NonNull FrameLayout frameLayout, @NonNull ZXingScannerView zXingScannerView, @NonNull Chip chip) {
        this.f17395a = frameLayout;
        this.f17396b = zXingScannerView;
        this.f17397c = chip;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17395a;
    }
}
