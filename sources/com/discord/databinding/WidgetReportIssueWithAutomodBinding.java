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

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2520b;

    @NonNull
    public final CheckedSetting c;

    @NonNull
    public final CheckedSetting d;

    @NonNull
    public final MaterialButton e;

    public WidgetReportIssueWithAutomodBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f2520b = imageView;
        this.c = checkedSetting;
        this.d = checkedSetting2;
        this.e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
