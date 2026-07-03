package com.discord.stores;

import com.discord.models.commands.ApplicationCommandLocalSendData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.stores.StoreApplicationInteractions$fetchInteractionDataIfNonExisting$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C5722xe7ac5bbb extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ long $interactionId$inlined;
    public final /* synthetic */ ApplicationCommandLocalSendData $it;
    public final /* synthetic */ StoreApplicationInteractions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5722xe7ac5bbb(ApplicationCommandLocalSendData applicationCommandLocalSendData, StoreApplicationInteractions storeApplicationInteractions, long j) {
        super(0);
        this.$it = applicationCommandLocalSendData;
        this.this$0 = storeApplicationInteractions;
        this.$interactionId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.handleInteractionDataFetchSuccess(this.$interactionId$inlined, this.$it.toRestApiApplicationCommandDataParam());
    }
}
