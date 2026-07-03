package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoticeNuxSamsungLinkBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17305a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17306b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17307c;

    public WidgetNoticeNuxSamsungLinkBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f17305a = linearLayout;
        this.f17306b = materialButton;
        this.f17307c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17305a;
    }
}
