package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetDebuggingAdapterItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16447a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16448b;

    public WidgetDebuggingAdapterItemBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f16447a = linearLayout;
        this.f16448b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16447a;
    }
}
