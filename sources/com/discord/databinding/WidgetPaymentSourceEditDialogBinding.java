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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17348a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Toolbar f17349b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17350c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LoadingButton f17351d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextInputLayout f17352e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextInputLayout f17353f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextInputLayout f17354g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextInputLayout f17355h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final CheckBox f17356i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final TextView f17357j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final TextView f17358k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextInputLayout f17359l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final TextInputLayout f17360m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final TextInputLayout f17361n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final PaymentSourceView f17362o;

    public WidgetPaymentSourceEditDialogBinding(@NonNull LinearLayout linearLayout, @NonNull Toolbar toolbar, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputLayout textInputLayout3, @NonNull TextInputLayout textInputLayout4, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout5, @NonNull TextInputLayout textInputLayout6, @NonNull TextInputLayout textInputLayout7, @NonNull PaymentSourceView paymentSourceView) {
        this.f17348a = linearLayout;
        this.f17349b = toolbar;
        this.f17350c = materialButton;
        this.f17351d = loadingButton;
        this.f17352e = textInputLayout;
        this.f17353f = textInputLayout2;
        this.f17354g = textInputLayout3;
        this.f17355h = textInputLayout4;
        this.f17356i = checkBox;
        this.f17357j = textView;
        this.f17358k = textView2;
        this.f17359l = textInputLayout5;
        this.f17360m = textInputLayout6;
        this.f17361n = textInputLayout7;
        this.f17362o = paymentSourceView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17348a;
    }
}
