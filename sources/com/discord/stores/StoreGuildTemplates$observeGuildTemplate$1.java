package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildTemplates$observeGuildTemplate$1 extends o implements Function0<StoreGuildTemplates$GuildTemplateState> {
    public final /* synthetic */ String $guildTemplateCode;
    public final /* synthetic */ StoreGuildTemplates this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildTemplates$observeGuildTemplate$1(StoreGuildTemplates storeGuildTemplates, String str) {
        super(0);
        this.this$0 = storeGuildTemplates;
        this.$guildTemplateCode = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGuildTemplates$GuildTemplateState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGuildTemplates$GuildTemplateState invoke() {
        StoreGuildTemplates$GuildTemplateState guildTemplate = this.this$0.getGuildTemplate(this.$guildTemplateCode);
        return guildTemplate != null ? guildTemplate : StoreGuildTemplates$GuildTemplateState$Loading.INSTANCE;
    }
}
