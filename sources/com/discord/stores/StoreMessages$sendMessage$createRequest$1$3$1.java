package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$1$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $uploads;
    public final /* synthetic */ StoreMessages$sendMessage$createRequest$1$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$1$3$1(StoreMessages$sendMessage$createRequest$1$3 storeMessages$sendMessage$createRequest$1$3, List list) {
        super(0);
        this.this$0 = storeMessages$sendMessage$createRequest$1$3;
        this.$uploads = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreMessageUploads messageUploads = StoreMessages.access$getStream$p(this.this$0.this$0.this$0).getMessageUploads();
        String nonce = this.this$0.this$0.$localMessage.getNonce();
        m.checkNotNull(nonce);
        messageUploads.bindUpload(nonce, this.$uploads);
    }
}
