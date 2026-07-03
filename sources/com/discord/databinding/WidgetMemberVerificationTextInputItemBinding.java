package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationTextInputItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextInputLayout f17265a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputEditText f17266b;

    public WidgetMemberVerificationTextInputItemBinding(@NonNull TextInputLayout textInputLayout, @NonNull TextInputEditText textInputEditText) {
        this.f17265a = textInputLayout;
        this.f17266b = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17265a;
    }
}
