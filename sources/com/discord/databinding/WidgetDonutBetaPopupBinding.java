package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetDonutBetaPopupBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16485a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f16486b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f16487c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f16488d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f16489e;

    public WidgetDonutBetaPopupBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView) {
        this.f16485a = constraintLayout;
        this.f16486b = linkifiedTextView;
        this.f16487c = imageView;
        this.f16488d = materialButton;
        this.f16489e = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16485a;
    }
}
