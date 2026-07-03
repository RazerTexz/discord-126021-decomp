package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailUpdateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f18325a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f18326b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f18327c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f18328d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final DimmerView f18329e;

    public WidgetUserEmailUpdateBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull DimmerView dimmerView) {
        this.f18325a = relativeLayout;
        this.f18326b = materialButton;
        this.f18327c = textInputLayout;
        this.f18328d = textInputLayout2;
        this.f18329e = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18325a;
    }
}
