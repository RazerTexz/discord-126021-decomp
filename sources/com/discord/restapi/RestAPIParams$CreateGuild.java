package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$CreateGuild {
    private final List<RestAPIParams$CreateGuildChannel> channels;
    private final String icon;
    private final String name;
    private final Long systemChannelId;

    public RestAPIParams$CreateGuild(String str, String str2, List<RestAPIParams$CreateGuildChannel> list, Long l) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
        this.icon = str2;
        this.channels = list;
        this.systemChannelId = l;
    }

    public /* synthetic */ RestAPIParams$CreateGuild(String str, String str2, List list, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : l);
    }
}
