package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetOutboundPromoTermsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17345a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17346b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f17347c;

    public WidgetOutboundPromoTermsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f17345a = linearLayout;
        this.f17346b = textView;
        this.f17347c = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17345a;
    }
}
