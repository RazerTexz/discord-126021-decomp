package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFriendsAddByIdBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f16652a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16653b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f16654c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f16655d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextInputLayout f16656e;

    public WidgetFriendsAddByIdBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout) {
        this.f16652a = nestedScrollView;
        this.f16653b = textView;
        this.f16654c = linearLayout;
        this.f16655d = materialButton;
        this.f16656e = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16652a;
    }
}
