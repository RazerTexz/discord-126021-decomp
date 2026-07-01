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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2340b;

    @NonNull
    public final ConstraintLayout c;

    @NonNull
    public final TextView d;

    @NonNull
    public final SwitchMaterial e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextInputLayout g;

    public WidgetChatListAdapterItemThreadDraftFormBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2, @NonNull SwitchMaterial switchMaterial, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextInputLayout textInputLayout) {
        this.a = linearLayout;
        this.f2340b = textView;
        this.c = constraintLayout;
        this.d = textView2;
        this.e = switchMaterial;
        this.f = imageView;
        this.g = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
