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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f17132a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f17133b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f17134c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17135d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinkifiedTextView f17136e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f17137f;

    public WidgetHomePanelCenterNsfwBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.f17132a = linearLayout;
        this.f17133b = imageView;
        this.f17134c = materialButton;
        this.f17135d = materialButton2;
        this.f17136e = linkifiedTextView;
        this.f17137f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17132a;
    }
}
