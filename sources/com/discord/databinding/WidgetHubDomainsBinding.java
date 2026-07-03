package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHubDomainsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17170a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f17171b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17172c;

    public WidgetHubDomainsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton) {
        this.f17170a = linearLayout;
        this.f17171b = recyclerView;
        this.f17172c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17170a;
    }
}
