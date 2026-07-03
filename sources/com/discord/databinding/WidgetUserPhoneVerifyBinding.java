package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerifyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f18355a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f18356b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final DimmerView f18357c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final CodeVerificationView f18358d;

    public WidgetUserPhoneVerifyBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull DimmerView dimmerView, @NonNull CodeVerificationView codeVerificationView) {
        this.f18355a = relativeLayout;
        this.f18356b = imageView;
        this.f18357c = dimmerView;
        this.f18358d = codeVerificationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18355a;
    }
}
