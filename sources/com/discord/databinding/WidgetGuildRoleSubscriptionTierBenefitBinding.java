package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionTierBenefitBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2438b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final TextInputLayout f;

    @NonNull
    public final TextInputEditText g;

    @NonNull
    public final SimpleDraweeView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final MaterialButton k;

    @NonNull
    public final MaterialButton l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    public WidgetGuildRoleSubscriptionTierBenefitBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextInputEditText textInputEditText, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull AppBarLayout appBarLayout, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputEditText textInputEditText2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7) {
        this.a = constraintLayout;
        this.f2438b = textView;
        this.c = textView2;
        this.d = textInputLayout;
        this.e = materialButton;
        this.f = textInputLayout2;
        this.g = textInputEditText2;
        this.h = simpleDraweeView;
        this.i = textView3;
        this.j = textView4;
        this.k = materialButton2;
        this.l = materialButton3;
        this.m = linearLayout;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
