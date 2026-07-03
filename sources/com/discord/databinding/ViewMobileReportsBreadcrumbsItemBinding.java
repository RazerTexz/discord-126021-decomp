package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewMobileReportsBreadcrumbsItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15518a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15519b;

    public ViewMobileReportsBreadcrumbsItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull TextView textView) {
        this.f15518a = constraintLayout;
        this.f15519b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15518a;
    }
}
