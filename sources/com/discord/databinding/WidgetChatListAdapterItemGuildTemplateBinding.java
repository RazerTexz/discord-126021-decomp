package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemGuildTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16228a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f16229b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16230c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16231d;

    public WidgetChatListAdapterItemGuildTemplateBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ConstraintLayout constraintLayout2) {
        this.f16228a = constraintLayout;
        this.f16229b = materialButton;
        this.f16230c = textView2;
        this.f16231d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16228a;
    }
}
