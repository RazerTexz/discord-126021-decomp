package com.discord.widgets.auth;

import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$appViewModels$$inlined$viewModels$1 extends AbstractC12240o implements Function0<ViewModelStore> {
    public final /* synthetic */ Function0 $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$appViewModels$$inlined$viewModels$1(Function0 function0) {
        super(0);
        this.$ownerProducer = function0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
        C12238m.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
