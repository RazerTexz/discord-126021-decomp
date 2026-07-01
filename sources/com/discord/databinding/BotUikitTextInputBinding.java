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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextInputEditText f2089b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextInputLayout d;

    public BotUikitTextInputBinding(@NonNull LinearLayout linearLayout, @NonNull TextInputEditText textInputEditText, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout) {
        this.a = linearLayout;
        this.f2089b = textInputEditText;
        this.c = textView;
        this.d = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
