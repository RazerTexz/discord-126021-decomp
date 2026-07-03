package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildRoleSubscriptionTierReviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f16972a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RecyclerView f16973b;

    public WidgetGuildRoleSubscriptionTierReviewBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView) {
        this.f16972a = linearLayout;
        this.f16973b = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16972a;
    }
}
