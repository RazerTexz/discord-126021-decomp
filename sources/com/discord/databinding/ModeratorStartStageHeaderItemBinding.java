package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ModeratorStartStageHeaderItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15184a;

    public ModeratorStartStageHeaderItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15184a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15184a;
    }
}
