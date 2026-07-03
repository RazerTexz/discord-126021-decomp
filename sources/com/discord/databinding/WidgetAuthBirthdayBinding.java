package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthBirthdayBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15670a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f15671b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f15672c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15673d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialCheckBox f15674e;

    public WidgetAuthBirthdayBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputLayout textInputLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout, @NonNull MaterialCheckBox materialCheckBox, @NonNull DimmerView dimmerView) {
        this.f15670a = coordinatorLayout;
        this.f15671b = linkifiedTextView;
        this.f15672c = textInputLayout;
        this.f15673d = materialButton;
        this.f15674e = materialCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15670a;
    }
}
