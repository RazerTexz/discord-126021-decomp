package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStartCallSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f18180a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18181b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18182c;

    public WidgetStartCallSheetBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f18180a = linearLayout;
        this.f18181b = textView;
        this.f18182c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18180a;
    }
}
