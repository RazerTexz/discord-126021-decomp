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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15650a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeView f15651b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15652c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15653d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ProgressBar f15654e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15655f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15656g;

    public WidgetApplicationCommandBottomSheetBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ProgressBar progressBar, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f15650a = constraintLayout;
        this.f15651b = simpleDraweeView;
        this.f15652c = textView;
        this.f15653d = materialButton;
        this.f15654e = progressBar;
        this.f15655f = textView3;
        this.f15656g = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15650a;
    }
}
