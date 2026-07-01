package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import com.discord.stores.StoreInviteSettings$InviteCode;
import d0.z.d.m;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel$Companion$observeStoreState$2<T1, T2, T3, T4, R> implements Func4<StoreInviteSettings$InviteCode, ModelInvite, StoreGuildTemplates$GuildTemplateState, String, WidgetAuthLandingViewModel$StoreState> {
    public static final WidgetAuthLandingViewModel$Companion$observeStoreState$2 INSTANCE = new WidgetAuthLandingViewModel$Companion$observeStoreState$2();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetAuthLandingViewModel$StoreState call(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, ModelInvite modelInvite, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState, String str) {
        return call2(storeInviteSettings$InviteCode, modelInvite, storeGuildTemplates$GuildTemplateState, str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetAuthLandingViewModel$StoreState call2(StoreInviteSettings$InviteCode storeInviteSettings$InviteCode, ModelInvite modelInvite, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState, String str) {
        m.checkNotNullExpressionValue(storeGuildTemplates$GuildTemplateState, "guildTemplate");
        return new WidgetAuthLandingViewModel$StoreState(storeInviteSettings$InviteCode, modelInvite, storeGuildTemplates$GuildTemplateState, str);
    }
}
