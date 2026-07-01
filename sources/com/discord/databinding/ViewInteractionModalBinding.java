package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewInteractionModalBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2200b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final SimpleDraweeView e;

    @NonNull
    public final MaterialButton f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    public ViewInteractionModalBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout3, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f2200b = imageView;
        this.c = linearLayout2;
        this.d = linearLayout3;
        this.e = simpleDraweeView;
        this.f = materialButton;
        this.g = textView;
        this.h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
