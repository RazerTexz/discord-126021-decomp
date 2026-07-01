package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthLoginBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2232b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final PhoneOrEmailInputView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextInputLayout g;

    @NonNull
    public final DimmerView h;

    public WidgetAuthLoginBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2232b = materialButton;
        this.c = linearLayout;
        this.d = textView;
        this.e = phoneOrEmailInputView;
        this.f = textView2;
        this.g = textInputLayout;
        this.h = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
