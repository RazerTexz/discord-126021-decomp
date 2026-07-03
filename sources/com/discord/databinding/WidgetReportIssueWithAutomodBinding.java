package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetReportIssueWithAutomodBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f17411a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17412b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final CheckedSetting f17413c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CheckedSetting f17414d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f17415e;

    public WidgetReportIssueWithAutomodBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView2) {
        this.f17411a = constraintLayout;
        this.f17412b = imageView;
        this.f17413c = checkedSetting;
        this.f17414d = checkedSetting2;
        this.f17415e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17411a;
    }
}
