package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthRegisterAccountInformationBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f2236b;

    @NonNull
    public final LoadingButton c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final TextInputLayout e;

    @NonNull
    public final MaterialCheckBox f;

    public WidgetAuthRegisterAccountInformationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LoadingButton loadingButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull MaterialCheckBox materialCheckBox) {
        this.a = coordinatorLayout;
        this.f2236b = linkifiedTextView;
        this.c = loadingButton;
        this.d = textInputLayout;
        this.e = textInputLayout2;
        this.f = materialCheckBox;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
