package com.discord.stores;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Type;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildTemplates$requestGuildTemplate$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ StoreGuildTemplates$requestGuildTemplate$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildTemplates$requestGuildTemplate$2$1(StoreGuildTemplates$requestGuildTemplate$2 storeGuildTemplates$requestGuildTemplate$2, Error error) {
        super(0);
        this.this$0 = storeGuildTemplates$requestGuildTemplate$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildTemplates$requestGuildTemplate$2 storeGuildTemplates$requestGuildTemplate$2 = this.this$0;
        StoreGuildTemplates storeGuildTemplates = storeGuildTemplates$requestGuildTemplate$2.this$0;
        String str = storeGuildTemplates$requestGuildTemplate$2.$guildTemplateCode;
        Error$Type type = this.$error.getType();
        m.checkNotNullExpressionValue(type, "error.type");
        StoreGuildTemplates.access$handleRequestGuildTemplateError(storeGuildTemplates, str, type);
    }
}
