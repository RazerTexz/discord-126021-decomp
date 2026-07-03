package com.discord.widgets.chat.input.expression;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelStore;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$appActivityViewModels$$inlined$activityViewModels$3 */
/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7848xbf25c4f3 extends AbstractC12240o implements Function0<ViewModelStore> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7848xbf25c4f3(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStore invoke() {
        return C1643a.m870p0(this.$this_activityViewModels, "requireActivity()", "requireActivity().viewModelStore");
    }
}
