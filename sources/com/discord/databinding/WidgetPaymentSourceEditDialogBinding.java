package com.discord.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;
import com.discord.widgets.settings.billing.PaymentSourceView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetPaymentSourceEditDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Toolbar f2508b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final LoadingButton d;

    @NonNull
    public final TextInputLayout e;

    @NonNull
    public final TextInputLayout f;

    @NonNull
    public final TextInputLayout g;

    @NonNull
    public final TextInputLayout h;

    @NonNull
    public final CheckBox i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextInputLayout l;

    @NonNull
    public final TextInputLayout m;

    @NonNull
    public final TextInputLayout n;

    @NonNull
    public final PaymentSourceView o;

    public WidgetPaymentSourceEditDialogBinding(@NonNull LinearLayout linearLayout, @NonNull Toolbar toolbar, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputLayout textInputLayout3, @NonNull TextInputLayout textInputLayout4, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout5, @NonNull TextInputLayout textInputLayout6, @NonNull TextInputLayout textInputLayout7, @NonNull PaymentSourceView paymentSourceView) {
        this.a = linearLayout;
        this.f2508b = toolbar;
        this.c = materialButton;
        this.d = loadingButton;
        this.e = textInputLayout;
        this.f = textInputLayout2;
        this.g = textInputLayout3;
        this.h = textInputLayout4;
        this.i = checkBox;
        this.j = textView;
        this.k = textView2;
        this.l = textInputLayout5;
        this.m = textInputLayout6;
        this.n = textInputLayout7;
        this.o = paymentSourceView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
