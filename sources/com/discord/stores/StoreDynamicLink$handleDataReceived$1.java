package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink$handleDataReceived$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreDynamicLink$DynamicLinkData $data;
    public final /* synthetic */ StoreDynamicLink this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDynamicLink$handleDataReceived$1(StoreDynamicLink storeDynamicLink, StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData) {
        super(0);
        this.this$0 = storeDynamicLink;
        this.$data = storeDynamicLink$DynamicLinkData;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreAuthentication authentication = StoreDynamicLink.access$getStream$p(this.this$0).getAuthentication();
        StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData = this.$data;
        authentication.setFingerprint(storeDynamicLink$DynamicLinkData != null ? storeDynamicLink$DynamicLinkData.getFingerprint() : null, false);
        StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData2 = this.$data;
        if ((storeDynamicLink$DynamicLinkData2 != null ? storeDynamicLink$DynamicLinkData2.getAuthToken() : null) != null) {
            StoreDynamicLink.access$getStream$p(this.this$0).getAuthentication().setAuthed(this.$data.getAuthToken());
        }
    }
}
