package com.discord.widgets.servers.community;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelStore;
import b.d.b.a.outline;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep$appActivityViewModels$$inlined$activityViewModels$1 extends Lambda implements Function0<ViewModelStore> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunitySecondStep$appActivityViewModels$$inlined$activityViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStore invoke() {
        return outline.p0(this.$this_activityViewModels, "requireActivity()", "requireActivity().viewModelStore");
    }
}
