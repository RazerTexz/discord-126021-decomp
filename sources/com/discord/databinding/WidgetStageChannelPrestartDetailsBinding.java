package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelPrestartDetailsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18155a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18156b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18157c;

    public WidgetStageChannelPrestartDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f18155a = constraintLayout;
        this.f18156b = textView;
        this.f18157c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18155a;
    }
}
