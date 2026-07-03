package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetRadioSelectorBottomSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17401a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17402b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RecyclerView f17403c;

    public WidgetRadioSelectorBottomSheetBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView) {
        this.f17401a = linearLayout;
        this.f17402b = textView;
        this.f17403c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17401a;
    }
}
