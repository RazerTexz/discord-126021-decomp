package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetAuthAgeGatedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f15668a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f15669b;

    public WidgetAuthAgeGatedBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f15668a = coordinatorLayout;
        this.f15669b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15668a;
    }
}
