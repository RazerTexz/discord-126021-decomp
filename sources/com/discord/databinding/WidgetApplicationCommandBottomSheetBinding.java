package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetApplicationCommandBottomSheetBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeView f2226b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final ProgressBar e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public WidgetApplicationCommandBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.a = constraintLayout;
        this.f2226b = simpleDraweeView;
        this.c = textView;
        this.d = materialButton;
        this.e = progressBar;
        this.f = textView3;
        this.g = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
