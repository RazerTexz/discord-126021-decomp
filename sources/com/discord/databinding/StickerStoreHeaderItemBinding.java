package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes.dex */
public final class StickerStoreHeaderItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2155b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final FrameLayout e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public StickerStoreHeaderItemBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull Chip chip, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = linearLayout;
        this.f2155b = frameLayout;
        this.c = relativeLayout;
        this.d = textView;
        this.e = frameLayout2;
        this.f = textView2;
        this.g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
