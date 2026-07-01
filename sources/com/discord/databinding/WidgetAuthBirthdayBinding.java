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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f2230b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final MaterialCheckBox e;

    public WidgetAuthBirthdayBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputLayout textInputLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout, @NonNull MaterialCheckBox materialCheckBox, @NonNull DimmerView dimmerView) {
        this.a = coordinatorLayout;
        this.f2230b = linkifiedTextView;
        this.c = textInputLayout;
        this.d = materialButton;
        this.e = materialCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
