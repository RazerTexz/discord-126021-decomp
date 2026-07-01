package com.discord.widgets.guild_role_subscriptions.tier.create;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelProvider;
import b.d.b.a.outline;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview$appActivityViewModels$$inlined$activityViewModels$4 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionReview$appActivityViewModels$$inlined$activityViewModels$4(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return outline.e0(this.$this_activityViewModels, "requireActivity()");
    }
}
