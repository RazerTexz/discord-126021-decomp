package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationPendingDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17250a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17251b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17252c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17253d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17254e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17255f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f17256g;

    public WidgetMemberVerificationPendingDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f17250a = relativeLayout;
        this.f17251b = imageView;
        this.f17252c = materialButton;
        this.f17253d = materialButton2;
        this.f17254e = textView;
        this.f17255f = textView2;
        this.f17256g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17250a;
    }
}
