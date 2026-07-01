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

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f2500b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final TextView e;

    @NonNull
    public final LinearLayout f;

    @NonNull
    public final MaterialButton g;

    public WidgetNoticeDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull MaterialButton materialButton2) {
        this.a = linearLayout;
        this.f2500b = linearLayout2;
        this.c = linkifiedTextView;
        this.d = materialButton;
        this.e = textView;
        this.f = linearLayout3;
        this.g = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
