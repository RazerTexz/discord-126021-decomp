package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsLanguageSelectBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f17999a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaxHeightRecyclerView f18000b;

    public WidgetSettingsLanguageSelectBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaxHeightRecyclerView maxHeightRecyclerView) {
        this.f17999a = nestedScrollView;
        this.f18000b = maxHeightRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17999a;
    }
}
