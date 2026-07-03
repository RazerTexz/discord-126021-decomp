package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsFormBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17205a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f17206b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f17207c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final MaterialButton f17208d;

    public WidgetIssueDetailsFormBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputLayout textInputLayout, @NonNull MaterialButton materialButton) {
        this.f17205a = nestedScrollView;
        this.f17206b = linkifiedTextView;
        this.f17207c = textInputLayout;
        this.f17208d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17205a;
    }
}
