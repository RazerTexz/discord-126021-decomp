package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemThreadDraftFormBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16329a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16330b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f16331c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16332d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SwitchMaterial f16333e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f16334f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f16335g;

    public WidgetChatListAdapterItemThreadDraftFormBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2, @NonNull SwitchMaterial switchMaterial, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextInputLayout textInputLayout) {
        this.f16329a = linearLayout;
        this.f16330b = textView;
        this.f16331c = constraintLayout;
        this.f16332d = textView2;
        this.f16333e = switchMaterial;
        this.f16334f = imageView;
        this.f16335g = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16329a;
    }
}
