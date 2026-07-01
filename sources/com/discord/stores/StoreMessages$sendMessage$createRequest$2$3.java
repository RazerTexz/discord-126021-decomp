package com.discord.stores;

import com.discord.utilities.rest.SendUtils$FileUpload;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$2$3 extends o implements Function1<List<? extends SendUtils$FileUpload>, Unit> {
    public final /* synthetic */ StoreMessages$sendMessage$createRequest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$2$3(StoreMessages$sendMessage$createRequest$2 storeMessages$sendMessage$createRequest$2) {
        super(1);
        this.this$0 = storeMessages$sendMessage$createRequest$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SendUtils$FileUpload> list) {
        invoke2((List<SendUtils$FileUpload>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<SendUtils$FileUpload> list) {
        m.checkNotNullParameter(list, "uploads");
        StoreMessages.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreMessages$sendMessage$createRequest$2$3$1(this, list));
    }
}
