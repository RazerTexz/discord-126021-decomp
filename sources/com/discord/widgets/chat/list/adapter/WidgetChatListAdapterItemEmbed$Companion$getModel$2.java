package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.widgets.chat.list.entries.EmbedEntry;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$Companion$getModel$2<T1, T2, T3, T4, R> implements Func4<Long, Map<Long, ? extends String>, HashMap<Long, String>, Map<Long, ? extends GuildRole>, WidgetChatListAdapterItemEmbed$Model> {
    public final /* synthetic */ EmbedEntry $embedEntry;
    public final /* synthetic */ Collection $parsedDescription;
    public final /* synthetic */ List $parsedFields;

    public WidgetChatListAdapterItemEmbed$Companion$getModel$2(EmbedEntry embedEntry, Collection collection, List list) {
        this.$embedEntry = embedEntry;
        this.$parsedDescription = collection;
        this.$parsedFields = list;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemEmbed$Model call(Long l, Map<Long, ? extends String> map, HashMap<Long, String> map2, Map<Long, ? extends GuildRole> map3) {
        return call2(l, (Map<Long, String>) map, map2, (Map<Long, GuildRole>) map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemEmbed$Model call2(Long l, Map<Long, String> map, HashMap<Long, String> map2, Map<Long, GuildRole> map3) {
        EmbedEntry embedEntry = this.$embedEntry;
        Collection collection = this.$parsedDescription;
        List list = this.$parsedFields;
        m.checkNotNullExpressionValue(l, "myId");
        return new WidgetChatListAdapterItemEmbed$Model(embedEntry, collection, list, map, map2, map3, l.longValue());
    }
}
