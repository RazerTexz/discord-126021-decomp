package com.discord.stores;

import com.discord.utilities.rest.SendUtils$SendPayload$Preprocessing;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$2$2 extends o implements Function1<SendUtils$SendPayload$Preprocessing, Unit> {
    public final /* synthetic */ StoreMessages$sendMessage$createRequest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$2$2(StoreMessages$sendMessage$createRequest$2 storeMessages$sendMessage$createRequest$2) {
        super(1);
        this.this$0 = storeMessages$sendMessage$createRequest$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SendUtils$SendPayload$Preprocessing sendUtils$SendPayload$Preprocessing) {
        invoke2(sendUtils$SendPayload$Preprocessing);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SendUtils$SendPayload$Preprocessing sendUtils$SendPayload$Preprocessing) {
        m.checkNotNullParameter(sendUtils$SendPayload$Preprocessing, "<name for destructuring parameter 0>");
        StoreMessages.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreMessages$sendMessage$createRequest$2$2$1(this, sendUtils$SendPayload$Preprocessing.getNumFiles(), sendUtils$SendPayload$Preprocessing.getName(), sendUtils$SendPayload$Preprocessing.getMimeType()));
    }
}
