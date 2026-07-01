package com.discord.widgets.guilds.create;

import com.discord.models.user.User;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildCreateViewModel$2 extends k implements Function2<User, StoreGuildTemplates$GuildTemplateState, WidgetGuildCreateViewModel$StoreState> {
    public static final WidgetGuildCreateViewModel$2 INSTANCE = new WidgetGuildCreateViewModel$2();

    public WidgetGuildCreateViewModel$2() {
        super(2, WidgetGuildCreateViewModel$StoreState.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGuildCreateViewModel$StoreState invoke(User user, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState) {
        return invoke2(user, storeGuildTemplates$GuildTemplateState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildCreateViewModel$StoreState invoke2(User user, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState) {
        m.checkNotNullParameter(user, "p1");
        m.checkNotNullParameter(storeGuildTemplates$GuildTemplateState, "p2");
        return new WidgetGuildCreateViewModel$StoreState(user, storeGuildTemplates$GuildTemplateState);
    }
}
