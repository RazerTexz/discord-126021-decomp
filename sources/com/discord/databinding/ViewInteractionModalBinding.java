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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15499a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f15500b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f15501c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinearLayout f15502d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeView f15503e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final MaterialButton f15504f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f15505g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f15506h;

    public ViewInteractionModalBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout3, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2) {
        this.f15499a = linearLayout;
        this.f15500b = imageView;
        this.f15501c = linearLayout2;
        this.f15502d = linearLayout3;
        this.f15503e = simpleDraweeView;
        this.f15504f = materialButton;
        this.f15505g = textView;
        this.f15506h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15499a;
    }
}
