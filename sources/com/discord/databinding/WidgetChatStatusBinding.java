package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatStatusBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16370a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f16371b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16372c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16373d;

    public WidgetChatStatusBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f16370a = linearLayout;
        this.f16371b = linearLayout2;
        this.f16372c = imageView;
        this.f16373d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16370a;
    }
}
