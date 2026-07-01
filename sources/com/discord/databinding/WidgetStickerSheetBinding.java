package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.discord.views.sticker.StickerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheetBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2663b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final Chip f;

    @NonNull
    public final RelativeLayout g;

    @NonNull
    public final StickerView h;

    @NonNull
    public final StickerView i;

    @NonNull
    public final StickerView j;

    @NonNull
    public final StickerView k;

    public WidgetStickerSheetBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton, @NonNull Chip chip, @NonNull RelativeLayout relativeLayout, @NonNull StickerView stickerView, @NonNull StickerView stickerView2, @NonNull StickerView stickerView3, @NonNull StickerView stickerView4) {
        this.a = linearLayout;
        this.f2663b = loadingButton;
        this.c = textView;
        this.d = textView2;
        this.e = materialButton;
        this.f = chip;
        this.g = relativeLayout;
        this.h = stickerView;
        this.i = stickerView2;
        this.j = stickerView3;
        this.k = stickerView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
