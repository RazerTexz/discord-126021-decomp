package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoticeDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17295a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinearLayout f17296b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinkifiedTextView f17297c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17298d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17299e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final LinearLayout f17300f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialButton f17301g;

    public WidgetNoticeDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull MaterialButton materialButton2) {
        this.f17295a = linearLayout;
        this.f17296b = linearLayout2;
        this.f17297c = linkifiedTextView;
        this.f17298d = materialButton;
        this.f17299e = textView;
        this.f17300f = linearLayout3;
        this.f17301g = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17295a;
    }
}
