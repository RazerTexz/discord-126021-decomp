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

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2688b;

    @NonNull
    public final DimmerView c;

    @NonNull
    public final CodeVerificationView d;

    public WidgetUserPhoneVerifyBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull DimmerView dimmerView, @NonNull CodeVerificationView codeVerificationView) {
        this.a = relativeLayout;
        this.f2688b = imageView;
        this.c = dimmerView;
        this.d = codeVerificationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
