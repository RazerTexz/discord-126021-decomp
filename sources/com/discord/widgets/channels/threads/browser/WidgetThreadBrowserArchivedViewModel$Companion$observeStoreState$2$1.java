package com.discord.widgets.channels.threads.browser;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import d0.t.h0;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends GuildMember>> {
    public final /* synthetic */ WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2 this$0;

    public WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2$1(WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2 widgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2) {
        this.this$0 = widgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<Long, ? extends GuildMember> call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
        return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<Long, GuildMember> call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
        Map<Long, GuildMember> map2 = map.get(Long.valueOf(this.this$0.$guildId));
        return map2 != null ? map2 : h0.emptyMap();
    }
}
