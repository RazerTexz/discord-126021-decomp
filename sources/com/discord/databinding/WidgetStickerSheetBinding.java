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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f18207a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f18208b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18209c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f18210d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f18211e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final Chip f18212f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final RelativeLayout f18213g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final StickerView f18214h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final StickerView f18215i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final StickerView f18216j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final StickerView f18217k;

    public WidgetStickerSheetBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton, @NonNull Chip chip, @NonNull RelativeLayout relativeLayout, @NonNull StickerView stickerView, @NonNull StickerView stickerView2, @NonNull StickerView stickerView3, @NonNull StickerView stickerView4) {
        this.f18207a = linearLayout;
        this.f18208b = loadingButton;
        this.f18209c = textView;
        this.f18210d = textView2;
        this.f18211e = materialButton;
        this.f18212f = chip;
        this.f18213g = relativeLayout;
        this.f18214h = stickerView;
        this.f18215i = stickerView2;
        this.f18216j = stickerView3;
        this.f18217k = stickerView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18207a;
    }
}
