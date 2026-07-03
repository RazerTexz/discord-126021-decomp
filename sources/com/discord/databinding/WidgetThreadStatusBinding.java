package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadStatusBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18289a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ConstraintLayout f18290b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LoadingButton f18291c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f18292d;

    public WidgetThreadStatusBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull LoadingButton loadingButton, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f18289a = constraintLayout;
        this.f18290b = constraintLayout2;
        this.f18291c = loadingButton;
        this.f18292d = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18289a;
    }
}
