package com.discord.stores;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationInteractions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationInteractions$sendComponentInteraction$1$4$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $it;
    public final /* synthetic */ StoreApplicationInteractions$sendComponentInteraction$1$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationInteractions$sendComponentInteraction$1$4$1(StoreApplicationInteractions$sendComponentInteraction$1$4 storeApplicationInteractions$sendComponentInteraction$1$4, Error error) {
        super(0);
        this.this$0 = storeApplicationInteractions$sendComponentInteraction$1$4;
        this.$it = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreLocalActionComponentState storeLocalActionComponentStateAccess$getStoreLocalActionComponentState$p = StoreApplicationInteractions.access$getStoreLocalActionComponentState$p(this.this$0.this$0.this$0);
        StoreApplicationInteractions$sendComponentInteraction$1 storeApplicationInteractions$sendComponentInteraction$1 = this.this$0.this$0;
        storeLocalActionComponentStateAccess$getStoreLocalActionComponentState$p.clearState(storeApplicationInteractions$sendComponentInteraction$1.$messageId, Integer.valueOf(storeApplicationInteractions$sendComponentInteraction$1.$componentIndex));
        this.this$0.this$0.this$0.getComponentInteractions().remove(this.this$0.this$0.$nonce);
        StoreApplicationInteractions$sendComponentInteraction$1 storeApplicationInteractions$sendComponentInteraction$2 = this.this$0.this$0;
        StoreApplicationInteractions storeApplicationInteractions = storeApplicationInteractions$sendComponentInteraction$2.this$0;
        long j = storeApplicationInteractions$sendComponentInteraction$2.$messageId;
        int i = storeApplicationInteractions$sendComponentInteraction$2.$componentIndex;
        Error$Response response = this.$it.getResponse();
        m.checkNotNullExpressionValue(response, "it.response");
        StoreApplicationInteractions.access$addInteractionStateToComponent(storeApplicationInteractions, j, i, new StoreApplicationInteractions$InteractionSendState$Failed(response.getMessage()));
    }
}
