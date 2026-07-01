package com.discord.restapi;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$CreateGuildChannel {
    private final Long id;
    private final String name;
    private final Long parentId;
    private final List<RestAPIParams$ChannelPermissionOverwrites> permissionOverwrites;
    private final String topic;
    private final int type;

    public RestAPIParams$CreateGuildChannel(int i, Long l, String str, Long l2, List<RestAPIParams$ChannelPermissionOverwrites> list, String str2) {
        this.type = i;
        this.id = l;
        this.name = str;
        this.parentId = l2;
        this.permissionOverwrites = list;
        this.topic = str2;
    }
}
