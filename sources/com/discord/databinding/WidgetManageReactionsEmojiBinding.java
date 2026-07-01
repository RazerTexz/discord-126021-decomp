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

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2483b;

    @NonNull
    public final SimpleDraweeSpanTextView c;

    @NonNull
    public final View d;

    public WidgetManageReactionsEmojiBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull View view) {
        this.a = relativeLayout;
        this.f2483b = textView;
        this.c = simpleDraweeSpanTextView;
        this.d = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
