package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetPhoneCountryCodeListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17366a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17367b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ConstraintLayout f17368c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17369d;

    public WidgetPhoneCountryCodeListItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2) {
        this.f17366a = constraintLayout;
        this.f17367b = textView;
        this.f17368c = constraintLayout2;
        this.f17369d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17366a;
    }
}
