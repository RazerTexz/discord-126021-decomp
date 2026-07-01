package com.discord.widgets.hubs;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelProvider$Factory;
import b.d.b.a.a;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains$appActivityViewModels$$inlined$activityViewModels$2 extends o implements Function0<ViewModelProvider$Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains$appActivityViewModels$$inlined$activityViewModels$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider$Factory invoke() {
        return a.e0(this.$this_activityViewModels, "requireActivity()");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider$Factory invoke() {
        return invoke();
    }
}
