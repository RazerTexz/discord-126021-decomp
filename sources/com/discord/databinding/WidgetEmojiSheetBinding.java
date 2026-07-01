package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetEmojiSheetBinding implements ViewBinding {

    @NonNull
    public final AppViewFlipper a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f2377b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final AppViewFlipper e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final FrameLayout g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final TextView i;

    @NonNull
    public final FrameLayout j;

    @NonNull
    public final LinearLayout k;

    @NonNull
    public final TextView l;

    @NonNull
    public final SimpleDraweeView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final MaterialButton o;

    @NonNull
    public final TextView p;

    @NonNull
    public final MaterialButton q;

    public WidgetEmojiSheetBinding(@NonNull AppViewFlipper appViewFlipper, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppViewFlipper appViewFlipper2, @NonNull MaterialButton materialButton, @NonNull FrameLayout frameLayout2, @NonNull MaterialButton materialButton2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView5, @NonNull MaterialButton materialButton3, @NonNull TextView textView6, @NonNull MaterialButton materialButton4) {
        this.a = appViewFlipper;
        this.f2377b = frameLayout;
        this.c = textView2;
        this.d = simpleDraweeView;
        this.e = appViewFlipper2;
        this.f = materialButton;
        this.g = frameLayout2;
        this.h = materialButton2;
        this.i = textView3;
        this.j = frameLayout3;
        this.k = linearLayout;
        this.l = textView4;
        this.m = simpleDraweeView2;
        this.n = textView5;
        this.o = materialButton3;
        this.p = textView6;
        this.q = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
