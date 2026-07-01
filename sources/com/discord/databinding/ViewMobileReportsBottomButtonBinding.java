package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class ViewMobileReportsBottomButtonBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2202b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final TextView e;

    public ViewMobileReportsBottomButtonBinding(@NonNull View view, @NonNull LoadingButton loadingButton, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.a = view;
        this.f2202b = loadingButton;
        this.c = materialButton;
        this.d = linkifiedTextView;
        this.e = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
