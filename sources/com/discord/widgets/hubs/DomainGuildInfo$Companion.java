package com.discord.widgets.hubs;

import com.discord.api.hubs.GuildInfo;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DomainGuildInfo$Companion {
    private DomainGuildInfo$Companion() {
    }

    public final DomainGuildInfo from(GuildInfo guildInfo) {
        m.checkNotNullParameter(guildInfo, "guildInfo");
        return new DomainGuildInfo(guildInfo.getIcon(), guildInfo.getId(), guildInfo.getName());
    }

    public /* synthetic */ DomainGuildInfo$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
