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

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2675b;

    @NonNull
    public final TextView c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final ProgressBar f;

    @NonNull
    public final LinkifiedTextView g;

    public WidgetTosReportViolationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull ProgressBar progressBar, @NonNull LinkifiedTextView linkifiedTextView) {
        this.a = coordinatorLayout;
        this.f2675b = loadingButton;
        this.c = textView;
        this.d = linearLayout;
        this.e = textView2;
        this.f = progressBar;
        this.g = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
