package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputSlashLoadingItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16120a;

    public WidgetChatInputSlashLoadingItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull Guideline guideline, @NonNull View view2, @NonNull Guideline guideline2, @NonNull View view3, @NonNull Guideline guideline3) {
        this.f16120a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16120a;
    }
}
