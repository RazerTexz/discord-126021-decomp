package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetCreateChannelBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f2357b;

    @NonNull
    public final RadioButton c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final RadioButton e;

    @NonNull
    public final TextInputLayout f;

    @NonNull
    public final RelativeLayout g;

    @NonNull
    public final TextView h;

    @NonNull
    public final SwitchCompat i;

    @NonNull
    public final TextView j;

    @NonNull
    public final RecyclerView k;

    @NonNull
    public final View l;

    @NonNull
    public final TextView m;

    @NonNull
    public final ConstraintLayout n;

    @NonNull
    public final RadioButton o;

    @NonNull
    public final ConstraintLayout p;

    @NonNull
    public final RadioButton q;

    @NonNull
    public final LinearLayout r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f2358s;

    @NonNull
    public final RadioButton t;

    public WidgetCreateChannelBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull RadioButton radioButton, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView2, @NonNull RadioButton radioButton2, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView3, @NonNull SwitchCompat switchCompat, @NonNull TextView textView4, @NonNull RecyclerView recyclerView, @NonNull View view, @NonNull TextView textView5, @NonNull ConstraintLayout constraintLayout3, @NonNull ImageView imageView3, @NonNull RadioButton radioButton3, @NonNull TextView textView6, @NonNull ConstraintLayout constraintLayout4, @NonNull ImageView imageView4, @NonNull RadioButton radioButton4, @NonNull TextView textView7, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout5, @NonNull ImageView imageView5, @NonNull RadioButton radioButton5, @NonNull TextView textView8) {
        this.a = coordinatorLayout;
        this.f2357b = constraintLayout;
        this.c = radioButton;
        this.d = constraintLayout2;
        this.e = radioButton2;
        this.f = textInputLayout;
        this.g = relativeLayout;
        this.h = textView3;
        this.i = switchCompat;
        this.j = textView4;
        this.k = recyclerView;
        this.l = view;
        this.m = textView5;
        this.n = constraintLayout3;
        this.o = radioButton3;
        this.p = constraintLayout4;
        this.q = radioButton4;
        this.r = linearLayout;
        this.f2358s = constraintLayout5;
        this.t = radioButton5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
