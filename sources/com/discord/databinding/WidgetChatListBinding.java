package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RecyclerView f16354a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f16355b;

    public WidgetChatListBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f16354a = recyclerView;
        this.f16355b = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16354a;
    }
}
