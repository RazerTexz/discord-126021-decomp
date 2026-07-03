package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetNuxGuildTemplateBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17323a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17324b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f17325c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17326d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17327e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RecyclerView f17328f;

    public WidgetNuxGuildTemplateBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RecyclerView recyclerView) {
        this.f17323a = linearLayout;
        this.f17324b = materialButton;
        this.f17325c = linearLayout2;
        this.f17326d = textView;
        this.f17327e = textView2;
        this.f17328f = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17323a;
    }
}
