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

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2186b;

    @NonNull
    public final RelativeLayout c;

    @NonNull
    public final FrameLayout d;

    @NonNull
    public final MaterialButton e;

    @NonNull
    public final View f;

    @NonNull
    public final AppViewFlipper g;

    @NonNull
    public final MaterialButton h;

    @NonNull
    public final LinkifiedTextView i;

    public ViewGiftEntitlementListItemBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout2, @NonNull MaterialButton materialButton, @NonNull View view, @NonNull AppViewFlipper appViewFlipper, @NonNull MaterialButton materialButton2, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = frameLayout;
        this.f2186b = textView;
        this.c = relativeLayout;
        this.d = frameLayout2;
        this.e = materialButton;
        this.f = view;
        this.g = appViewFlipper;
        this.h = materialButton2;
        this.i = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
