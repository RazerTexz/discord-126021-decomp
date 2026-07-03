package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsItemAddConnectedAccountBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17972a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17973b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17974c;

    public WidgetSettingsItemAddConnectedAccountBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f17972a = linearLayout;
        this.f17973b = imageView;
        this.f17974c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17972a;
    }
}
