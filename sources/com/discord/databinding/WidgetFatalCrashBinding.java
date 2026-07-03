package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetFatalCrashBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ScrollView f16616a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f16617b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f16618c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16619d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f16620e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinkifiedTextView f16621f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16622g;

    public WidgetFatalCrashBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView5) {
        this.f16616a = scrollView;
        this.f16617b = textView;
        this.f16618c = textView2;
        this.f16619d = textView3;
        this.f16620e = textView4;
        this.f16621f = linkifiedTextView;
        this.f16622g = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16616a;
    }
}
