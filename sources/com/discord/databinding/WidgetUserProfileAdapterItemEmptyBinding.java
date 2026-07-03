package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserProfileAdapterItemEmptyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f18359a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f18360b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18361c;

    public WidgetUserProfileAdapterItemEmptyBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f18359a = linearLayout;
        this.f18360b = imageView;
        this.f18361c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18359a;
    }
}
