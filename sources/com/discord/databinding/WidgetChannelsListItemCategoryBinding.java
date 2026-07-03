package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChannelsListItemCategoryBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16007a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f16008b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16009c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16010d;

    public WidgetChannelsListItemCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.f16007a = linearLayout;
        this.f16008b = imageView;
        this.f16009c = imageView2;
        this.f16010d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16007a;
    }
}
