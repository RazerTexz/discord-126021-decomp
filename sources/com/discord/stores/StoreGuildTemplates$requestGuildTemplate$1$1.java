package com.discord.stores;

import com.discord.models.domain.ModelGuildTemplate;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildTemplates$requestGuildTemplate$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelGuildTemplate $guildTemplate;
    public final /* synthetic */ StoreGuildTemplates$requestGuildTemplate$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildTemplates$requestGuildTemplate$1$1(StoreGuildTemplates$requestGuildTemplate$1 storeGuildTemplates$requestGuildTemplate$1, ModelGuildTemplate modelGuildTemplate) {
        super(0);
        this.this$0 = storeGuildTemplates$requestGuildTemplate$1;
        this.$guildTemplate = modelGuildTemplate;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuildTemplates.access$handleRequestGuildTemplateSuccess(this.this$0.this$0, this.$guildTemplate);
    }
}
