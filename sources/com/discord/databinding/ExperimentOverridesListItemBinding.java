package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.experiments.ExperimentOverrideView;

/* JADX INFO: loaded from: classes.dex */
public final class ExperimentOverridesListItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f15063a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ExperimentOverrideView f15064b;

    public ExperimentOverridesListItemBinding(@NonNull CardView cardView, @NonNull ExperimentOverrideView experimentOverrideView) {
        this.f15063a = cardView;
        this.f15064b = experimentOverrideView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15063a;
    }
}
