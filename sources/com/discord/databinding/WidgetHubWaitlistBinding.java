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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17188a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f17189b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputEditText f17190c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f17191d;

    public WidgetHubWaitlistBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextInputEditText textInputEditText, @NonNull ScreenTitleView screenTitleView, @NonNull TextInputLayout textInputLayout) {
        this.f17188a = linearLayout;
        this.f17189b = loadingButton;
        this.f17190c = textInputEditText;
        this.f17191d = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17188a;
    }
}
