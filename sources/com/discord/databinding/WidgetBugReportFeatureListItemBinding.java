package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetBugReportFeatureListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15755a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15756b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f15757c;

    public WidgetBugReportFeatureListItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15755a = constraintLayout;
        this.f15756b = textView;
        this.f15757c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15755a;
    }
}
