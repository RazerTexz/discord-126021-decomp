package com.discord.stores;

import com.discord.models.domain.ModelGuildTemplate;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildTemplates$requestGuildTemplate$1 extends o implements Function1<ModelGuildTemplate, Unit> {
    public final /* synthetic */ StoreGuildTemplates this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildTemplates$requestGuildTemplate$1(StoreGuildTemplates storeGuildTemplates) {
        super(1);
        this.this$0 = storeGuildTemplates;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildTemplate modelGuildTemplate) {
        invoke2(modelGuildTemplate);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelGuildTemplate modelGuildTemplate) {
        m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
        StoreGuildTemplates.access$getDispatcher$p(this.this$0).schedule(new StoreGuildTemplates$requestGuildTemplate$1$1(this, modelGuildTemplate));
    }
}
