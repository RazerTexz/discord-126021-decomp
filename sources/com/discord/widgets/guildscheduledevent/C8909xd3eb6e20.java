package com.discord.widgets.guildscheduledevent;

import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$appViewModels$$inlined$viewModels$1 */
/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8909xd3eb6e20 extends AbstractC12240o implements Function0<ViewModelStore> {
    public final /* synthetic */ Function0 $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8909xd3eb6e20(Function0 function0) {
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
