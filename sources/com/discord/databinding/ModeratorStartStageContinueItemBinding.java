package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class ModeratorStartStageContinueItemBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    public ModeratorStartStageContinueItemBinding(@NonNull ConstraintLayout constraintLayout) {
        this.a = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
