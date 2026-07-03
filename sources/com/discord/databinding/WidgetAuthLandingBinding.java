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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f15675a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final AuthInviteInfoView f15676b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f15677c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f15678d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final AppViewFlipper f15679e;

    public WidgetAuthLandingBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull AuthInviteInfoView authInviteInfoView, @NonNull MaterialButton materialButton, @NonNull ImageView imageView, @NonNull MaterialButton materialButton2, @NonNull AppViewFlipper appViewFlipper, @NonNull ScreenTitleView screenTitleView) {
        this.f15675a = relativeLayout;
        this.f15676b = authInviteInfoView;
        this.f15677c = materialButton;
        this.f15678d = materialButton2;
        this.f15679e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15675a;
    }
}
