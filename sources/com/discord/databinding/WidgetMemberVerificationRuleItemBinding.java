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

    @NonNull
    public final RoundedRelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SimpleDraweeSpanTextView f2493b;

    @NonNull
    public final View c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RoundedRelativeLayout e;

    public WidgetMemberVerificationRuleItemBinding(@NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull LinearLayout linearLayout, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull View view, @NonNull TextView textView, @NonNull RoundedRelativeLayout roundedRelativeLayout2) {
        this.a = roundedRelativeLayout;
        this.f2493b = simpleDraweeSpanTextView;
        this.c = view;
        this.d = textView;
        this.e = roundedRelativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
