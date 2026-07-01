package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.discord.views.ScreenTitleView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubWaitlistBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2478b;

    @NonNull
    public final TextInputEditText c;

    @NonNull
    public final TextInputLayout d;

    public WidgetHubWaitlistBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextInputEditText textInputEditText, @NonNull ScreenTitleView screenTitleView, @NonNull TextInputLayout textInputLayout) {
        this.a = linearLayout;
        this.f2478b = loadingButton;
        this.c = textInputEditText;
        this.d = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
