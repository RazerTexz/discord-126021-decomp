package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ViewAppcommandsOptionheadingListitemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15367a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f15368b;

    public ViewAppcommandsOptionheadingListitemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull View view) {
        this.f15367a = constraintLayout;
        this.f15368b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15367a;
    }
}
