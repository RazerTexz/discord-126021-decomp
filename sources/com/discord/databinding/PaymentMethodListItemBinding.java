package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.settings.billing.PaymentSourceView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class PaymentMethodListItemBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2134b;

    @NonNull
    public final PaymentSourceView c;

    public PaymentMethodListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull PaymentSourceView paymentSourceView) {
        this.a = relativeLayout;
        this.f2134b = materialButton;
        this.c = paymentSourceView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
