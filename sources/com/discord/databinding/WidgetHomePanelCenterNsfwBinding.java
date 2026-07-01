package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomePanelCenterNsfwBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f2466b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final LinkifiedTextView e;

    @NonNull
    public final TextView f;

    public WidgetHomePanelCenterNsfwBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.a = linearLayout;
        this.f2466b = imageView;
        this.c = materialButton;
        this.d = materialButton2;
        this.e = linkifiedTextView;
        this.f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
