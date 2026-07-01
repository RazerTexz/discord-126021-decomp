package com.discord.stores;

import android.content.Context;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink$storeLinkIfExists$3 extends o implements Function1<StoreDynamicLink$DynamicLinkData, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ StoreDynamicLink this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreDynamicLink$storeLinkIfExists$3(StoreDynamicLink storeDynamicLink, Context context) {
        super(1);
        this.this$0 = storeDynamicLink;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData) {
        invoke2(storeDynamicLink$DynamicLinkData);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreDynamicLink$DynamicLinkData storeDynamicLink$DynamicLinkData) {
        StoreDynamicLink.access$handleDataReceived(this.this$0, storeDynamicLink$DynamicLinkData, this.$context);
    }
}
