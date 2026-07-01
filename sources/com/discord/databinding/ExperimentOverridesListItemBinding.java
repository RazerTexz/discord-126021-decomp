package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.experiments.ExperimentOverrideView;

/* JADX INFO: loaded from: classes.dex */
public final class ExperimentOverridesListItemBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExperimentOverrideView f2104b;

    public ExperimentOverridesListItemBinding(@NonNull CardView cardView, @NonNull ExperimentOverrideView experimentOverrideView) {
        this.a = cardView;
        this.f2104b = experimentOverrideView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
