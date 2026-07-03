package com.discord.widgets.directories;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$appActivityViewModels$$inlined$activityViewModels$2 */
/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8292x2378b3da extends AbstractC12240o implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8292x2378b3da(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return C1643a.m848e0(this.$this_activityViewModels, "requireActivity()");
    }
}
