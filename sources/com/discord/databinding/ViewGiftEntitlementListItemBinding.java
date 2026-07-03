package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGiftEntitlementListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15425a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15426b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final RelativeLayout f15427c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FrameLayout f15428d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f15429e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final View f15430f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final AppViewFlipper f15431g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MaterialButton f15432h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final LinkifiedTextView f15433i;

    public ViewGiftEntitlementListItemBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout2, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull AppViewFlipper appViewFlipper, @NonNull MaterialButton materialButton2, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f15425a = frameLayout;
        this.f15426b = textView;
        this.f15427c = relativeLayout;
        this.f15428d = frameLayout2;
        this.f15429e = materialButton;
        this.f15430f = view;
        this.f15431g = appViewFlipper;
        this.f15432h = materialButton2;
        this.f15433i = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15425a;
    }
}
