package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputApplicationCommandsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16084a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16085b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f16086c;

    public WidgetChatInputApplicationCommandsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull View view) {
        this.f16084a = constraintLayout;
        this.f16085b = textView;
        this.f16086c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16084a;
    }
}
