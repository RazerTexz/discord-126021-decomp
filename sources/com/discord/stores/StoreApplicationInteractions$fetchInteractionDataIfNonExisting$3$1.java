package com.discord.stores;

import com.discord.api.commands.ApplicationCommandData;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ApplicationCommandData $interactionDetail;
    public final /* synthetic */ StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3$1(StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3 storeApplicationInteractions$fetchInteractionDataIfNonExisting$3, ApplicationCommandData applicationCommandData) {
        super(0);
        this.this$0 = storeApplicationInteractions$fetchInteractionDataIfNonExisting$3;
        this.$interactionDetail = applicationCommandData;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationInteractions$fetchInteractionDataIfNonExisting$3 storeApplicationInteractions$fetchInteractionDataIfNonExisting$3 = this.this$0;
        StoreApplicationInteractions.access$handleInteractionDataFetchSuccess(storeApplicationInteractions$fetchInteractionDataIfNonExisting$3.this$0, storeApplicationInteractions$fetchInteractionDataIfNonExisting$3.$interactionId, this.$interactionDetail);
    }
}
