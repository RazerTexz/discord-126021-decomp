package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildTemplates$setDynamicLinkGuildTemplateCode$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $guildTemplateCode;
    public final /* synthetic */ StoreGuildTemplates this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildTemplates$setDynamicLinkGuildTemplateCode$1(StoreGuildTemplates storeGuildTemplates, String str) {
        super(0);
        this.this$0 = storeGuildTemplates;
        this.$guildTemplateCode = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildTemplates.access$setDynamicLinkGuildTemplateCode$p(this.this$0, this.$guildTemplateCode);
        this.this$0.markChanged();
    }
}
