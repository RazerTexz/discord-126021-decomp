package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetMemberVerificationRuleItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RoundedRelativeLayout f17257a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SimpleDraweeSpanTextView f17258b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final View f17259c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17260d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RoundedRelativeLayout f17261e;

    public WidgetMemberVerificationRuleItemBinding(@NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull LinearLayout linearLayout, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull View view, @NonNull TextView textView, @NonNull RoundedRelativeLayout roundedRelativeLayout2) {
        this.f17257a = roundedRelativeLayout;
        this.f17258b = simpleDraweeSpanTextView;
        this.f17259c = view;
        this.f17260d = textView;
        this.f17261e = roundedRelativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17257a;
    }
}
