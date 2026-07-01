package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMaskedLinks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMaskedLinks$trustDomain$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $url;
    public final /* synthetic */ StoreMaskedLinks this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMaskedLinks$trustDomain$1(StoreMaskedLinks storeMaskedLinks, String str) {
        super(0);
        this.this$0 = storeMaskedLinks;
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String strAccess$getDomainName = StoreMaskedLinks$Companion.access$getDomainName(StoreMaskedLinks.Companion, this.$url);
        if (strAccess$getDomainName != null) {
            StoreMaskedLinks.access$getUserTrustedDomains$p(this.this$0).add(strAccess$getDomainName);
            this.this$0.markChanged();
        }
    }
}
