package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f18293a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f18294b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f18295c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f18296d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinkifiedTextView f18297e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinkifiedTextView f18298f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f18299g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f18300h;

    public WidgetTosBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull LinkifiedTextView linkifiedTextView3, @NonNull LinkifiedTextView linkifiedTextView4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.f18293a = relativeLayout;
        this.f18294b = materialButton;
        this.f18295c = linkifiedTextView;
        this.f18296d = linkifiedTextView2;
        this.f18297e = linkifiedTextView3;
        this.f18298f = linkifiedTextView4;
        this.f18299g = textView;
        this.f18300h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18293a;
    }
}
