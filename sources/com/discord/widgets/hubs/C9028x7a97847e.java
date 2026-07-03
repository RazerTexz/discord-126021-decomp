package com.discord.widgets.hubs;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomains$appActivityViewModels$$inlined$activityViewModels$2 */
/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9028x7a97847e extends AbstractC12240o implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9028x7a97847e(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return C1643a.m848e0(this.$this_activityViewModels, "requireActivity()");
    }
}
