package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheetBinding implements ViewBinding {

    @NonNull
    public final AppViewFlipper a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2453b;

    @NonNull
    public final TextView c;

    @NonNull
    public final AppViewFlipper d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final SimpleDraweeView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final FrameLayout h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final MaterialButton k;

    @NonNull
    public final MaterialButton l;

    @NonNull
    public final StickerView m;

    @NonNull
    public final TextView n;

    public WidgetGuildStickerSheetBinding(@NonNull AppViewFlipper appViewFlipper, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull AppViewFlipper appViewFlipper2, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull FrameLayout frameLayout2, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull StickerView stickerView, @NonNull TextView textView6) {
        this.a = appViewFlipper;
        this.f2453b = frameLayout;
        this.c = textView;
        this.d = appViewFlipper2;
        this.e = linearLayout;
        this.f = simpleDraweeView;
        this.g = textView3;
        this.h = frameLayout2;
        this.i = textView4;
        this.j = textView5;
        this.k = materialButton;
        this.l = materialButton2;
        this.m = stickerView;
        this.n = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
