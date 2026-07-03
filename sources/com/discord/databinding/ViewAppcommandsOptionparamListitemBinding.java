package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewAppcommandsOptionparamListitemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15369a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15370b;

    public ViewAppcommandsOptionparamListitemBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView) {
        this.f15369a = frameLayout;
        this.f15370b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15369a;
    }
}
