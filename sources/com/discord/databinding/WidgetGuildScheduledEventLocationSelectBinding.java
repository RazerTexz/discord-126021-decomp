package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildScheduledEventLocationSelectBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputEditText f2447b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final TextInputEditText e;

    @NonNull
    public final TextInputLayout f;

    @NonNull
    public final CheckedSetting g;

    @NonNull
    public final TextView h;

    @NonNull
    public final MaterialButton i;

    @NonNull
    public final CheckedSetting j;

    @NonNull
    public final TextView k;

    @NonNull
    public final View l;

    @NonNull
    public final CheckedSetting m;

    public WidgetGuildScheduledEventLocationSelectBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull TextInputEditText textInputEditText2, @NonNull TextInputLayout textInputLayout2, @NonNull CheckedSetting checkedSetting, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView2, @NonNull ScreenTitleView screenTitleView, @NonNull ConstraintLayout constraintLayout2, @NonNull View view2, @NonNull CheckedSetting checkedSetting3) {
        this.a = constraintLayout;
        this.f2447b = textInputEditText;
        this.c = textInputLayout;
        this.d = imageView;
        this.e = textInputEditText2;
        this.f = textInputLayout2;
        this.g = checkedSetting;
        this.h = textView;
        this.i = materialButton;
        this.j = checkedSetting2;
        this.k = textView2;
        this.l = view2;
        this.m = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
