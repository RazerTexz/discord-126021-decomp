package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.ScreenTitleView;
import com.discord.widgets.auth.AuthInviteInfoView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthLandingBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AuthInviteInfoView f2231b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final AppViewFlipper e;

    public WidgetAuthLandingBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull AuthInviteInfoView authInviteInfoView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView, @NonNull MaterialButton materialButton2, @NonNull AppViewFlipper appViewFlipper, @NonNull ScreenTitleView screenTitleView) {
        this.a = relativeLayout;
        this.f2231b = authInviteInfoView;
        this.c = materialButton;
        this.d = materialButton2;
        this.e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
