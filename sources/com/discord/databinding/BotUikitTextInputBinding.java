package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class BotUikitTextInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f15014a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputEditText f15015b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15016c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextInputLayout f15017d;

    public BotUikitTextInputBinding(@NonNull LinearLayout linearLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout) {
        this.f15014a = linearLayout;
        this.f15015b = textInputEditText;
        this.f15016c = textView;
        this.f15017d = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15014a;
    }
}
