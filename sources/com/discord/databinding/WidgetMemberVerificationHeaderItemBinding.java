package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationHeaderItemBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2489b;

    public WidgetMemberVerificationHeaderItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f2489b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
