package com.discord.stores;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestInitialApplicationCommands$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C5720xe407722c extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Ref$IntRef $offset$inlined;
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5720xe407722c(StoreApplicationCommands storeApplicationCommands, Ref$IntRef ref$IntRef) {
        super(0);
        this.this$0 = storeApplicationCommands;
        this.$offset$inlined = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationCommands storeApplicationCommands = this.this$0;
        storeApplicationCommands.handleDiscoverCommandsUpdate(storeApplicationCommands.builtInCommandsProvider.getBuiltInCommands());
    }
}
