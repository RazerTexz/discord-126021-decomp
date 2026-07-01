package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$sendMessage$createRequest$1$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $displayName;
    public final /* synthetic */ String $mimeType;
    public final /* synthetic */ int $numFiles;
    public final /* synthetic */ StoreMessages$sendMessage$createRequest$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$sendMessage$createRequest$1$2$1(StoreMessages$sendMessage$createRequest$1$2 storeMessages$sendMessage$createRequest$1$2, int i, String str, String str2) {
        super(0);
        this.this$0 = storeMessages$sendMessage$createRequest$1$2;
        this.$numFiles = i;
        this.$displayName = str;
        this.$mimeType = str2;
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
        messageUploads.onPreprocessing(nonce, this.$numFiles, this.$displayName, this.$mimeType);
    }
}
