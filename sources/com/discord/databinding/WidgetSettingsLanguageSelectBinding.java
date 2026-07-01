package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsLanguageSelectBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaxHeightRecyclerView f2628b;

    public WidgetSettingsLanguageSelectBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaxHeightRecyclerView maxHeightRecyclerView) {
        this.a = nestedScrollView;
        this.f2628b = maxHeightRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
