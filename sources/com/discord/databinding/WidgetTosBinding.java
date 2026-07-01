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

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f2674b;

    @NonNull
    public final LinkifiedTextView c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final LinkifiedTextView e;

    @NonNull
    public final LinkifiedTextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    public WidgetTosBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinkifiedTextView linkifiedTextView2, @NonNull LinkifiedTextView linkifiedTextView3, @NonNull LinkifiedTextView linkifiedTextView4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView) {
        this.a = relativeLayout;
        this.f2674b = materialButton;
        this.c = linkifiedTextView;
        this.d = linkifiedTextView2;
        this.e = linkifiedTextView3;
        this.f = linkifiedTextView4;
        this.g = textView;
        this.h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
