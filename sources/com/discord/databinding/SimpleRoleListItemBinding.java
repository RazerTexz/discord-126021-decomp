package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class SimpleRoleListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f15240a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15241b;

    public SimpleRoleListItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f15240a = textView;
        this.f15241b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15240a;
    }
}
