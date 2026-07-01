package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.Chip;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetQrScannerBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ZXingScannerView f2515b;

    @NonNull
    public final Chip c;

    public WidgetQrScannerBinding(@NonNull FrameLayout frameLayout, @NonNull ZXingScannerView zXingScannerView, @NonNull Chip chip) {
        this.a = frameLayout;
        this.f2515b = zXingScannerView;
        this.c = chip;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
