package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoticeNuxOverlayBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17302a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f17303b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17304c;

    public WidgetNoticeNuxOverlayBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f17302a = linearLayout;
        this.f17303b = materialButton;
        this.f17304c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17302a;
    }
}
