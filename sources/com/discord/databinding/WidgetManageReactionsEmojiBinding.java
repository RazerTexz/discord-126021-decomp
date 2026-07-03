package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetManageReactionsEmojiBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17218a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f17219b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeSpanTextView f17220c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final View f17221d;

    public WidgetManageReactionsEmojiBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull View view) {
        this.f17218a = relativeLayout;
        this.f17219b = textView;
        this.f17220c = simpleDraweeSpanTextView;
        this.f17221d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17218a;
    }
}
