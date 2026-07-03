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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15680a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15681b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f15682c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f15683d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final PhoneOrEmailInputView f15684e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f15685f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f15686g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final DimmerView f15687h;

    public WidgetAuthLoginBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull DimmerView dimmerView) {
        this.f15680a = coordinatorLayout;
        this.f15681b = materialButton;
        this.f15682c = linearLayout;
        this.f15683d = textView;
        this.f15684e = phoneOrEmailInputView;
        this.f15685f = textView2;
        this.f15686g = textInputLayout;
        this.f15687h = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15680a;
    }
}
