package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelSelectorItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f15893a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15894b;

    public WidgetChannelSelectorItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f15893a = textView;
        this.f15894b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15893a;
    }
}
