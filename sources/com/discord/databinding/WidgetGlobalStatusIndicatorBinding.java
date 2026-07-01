package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalStatusIndicatorBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2405b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final MaterialButton g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final TextView i;

    public WidgetGlobalStatusIndicatorBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull MaterialButton materialButton2, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f2405b = textView;
        this.c = linearLayout2;
        this.d = materialButton;
        this.e = linearLayout3;
        this.f = linearLayout4;
        this.g = materialButton2;
        this.h = imageView;
        this.i = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
