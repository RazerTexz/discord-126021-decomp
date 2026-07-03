package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetBugReportFeatureHeaderListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15752a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f15753b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15754c;

    public WidgetBugReportFeatureHeaderListItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull TextView textView) {
        this.f15752a = constraintLayout;
        this.f15753b = view;
        this.f15754c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15752a;
    }
}
