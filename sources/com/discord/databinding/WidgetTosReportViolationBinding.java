package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f18301a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f18302b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f18303c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinearLayout f18304d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f18305e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ProgressBar f18306f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final LinkifiedTextView f18307g;

    public WidgetTosReportViolationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull ProgressBar progressBar, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f18301a = coordinatorLayout;
        this.f18302b = loadingButton;
        this.f18303c = textView;
        this.f18304d = linearLayout;
        this.f18305e = textView2;
        this.f18306f = progressBar;
        this.f18307g = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18301a;
    }
}
