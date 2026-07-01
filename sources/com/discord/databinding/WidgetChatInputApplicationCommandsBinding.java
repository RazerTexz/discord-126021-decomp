package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputApplicationCommandsBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2301b;

    @NonNull
    public final RecyclerView c;

    public WidgetChatInputApplicationCommandsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull View view) {
        this.a = constraintLayout;
        this.f2301b = textView;
        this.c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
