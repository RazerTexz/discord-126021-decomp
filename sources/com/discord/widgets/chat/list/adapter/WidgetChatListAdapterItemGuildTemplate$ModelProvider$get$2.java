package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$LoadFailed;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Loading;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Resolved;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2<T, R> implements b<StoreGuildTemplates$GuildTemplateState, Observable<? extends WidgetChatListAdapterItemGuildTemplate$Model>> {
    public static final WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2 INSTANCE = new WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGuildTemplate$Model> call(StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState) {
        return call2(storeGuildTemplates$GuildTemplateState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemGuildTemplate$Model> call2(StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState) {
        if ((storeGuildTemplates$GuildTemplateState instanceof StoreGuildTemplates$GuildTemplateState$Loading) || (storeGuildTemplates$GuildTemplateState instanceof StoreGuildTemplates$GuildTemplateState$LoadFailed)) {
            return new k(WidgetChatListAdapterItemGuildTemplate$Model$Loading.INSTANCE);
        }
        return storeGuildTemplates$GuildTemplateState instanceof StoreGuildTemplates$GuildTemplateState$Resolved ? new k(new WidgetChatListAdapterItemGuildTemplate$Model$Resolved(((StoreGuildTemplates$GuildTemplateState$Resolved) storeGuildTemplates$GuildTemplateState).getGuildTemplate())) : new k(WidgetChatListAdapterItemGuildTemplate$Model$Invalid.INSTANCE);
    }
}
