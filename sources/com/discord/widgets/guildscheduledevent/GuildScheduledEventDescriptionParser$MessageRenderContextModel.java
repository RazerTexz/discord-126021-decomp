package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventDescriptionParser$MessageRenderContextModel {
    private final Map<Long, String> channelNames;
    private final Map<Long, GuildRole> roles;
    private final Map<Long, String> userNames;

    public GuildScheduledEventDescriptionParser$MessageRenderContextModel() {
        this(null, null, null, 7, null);
    }

    public GuildScheduledEventDescriptionParser$MessageRenderContextModel(Map<Long, String> map, Map<Long, String> map2, Map<Long, GuildRole> map3) {
        this.channelNames = map;
        this.userNames = map2;
        this.roles = map3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildScheduledEventDescriptionParser$MessageRenderContextModel copy$default(GuildScheduledEventDescriptionParser$MessageRenderContextModel guildScheduledEventDescriptionParser$MessageRenderContextModel, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = guildScheduledEventDescriptionParser$MessageRenderContextModel.channelNames;
        }
        if ((i & 2) != 0) {
            map2 = guildScheduledEventDescriptionParser$MessageRenderContextModel.userNames;
        }
        if ((i & 4) != 0) {
            map3 = guildScheduledEventDescriptionParser$MessageRenderContextModel.roles;
        }
        return guildScheduledEventDescriptionParser$MessageRenderContextModel.copy(map, map2, map3);
    }

    public final Map<Long, String> component1() {
        return this.channelNames;
    }

    public final Map<Long, String> component2() {
        return this.userNames;
    }

    public final Map<Long, GuildRole> component3() {
        return this.roles;
    }

    public final GuildScheduledEventDescriptionParser$MessageRenderContextModel copy(Map<Long, String> channelNames, Map<Long, String> userNames, Map<Long, GuildRole> roles) {
        return new GuildScheduledEventDescriptionParser$MessageRenderContextModel(channelNames, userNames, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventDescriptionParser$MessageRenderContextModel)) {
            return false;
        }
        GuildScheduledEventDescriptionParser$MessageRenderContextModel guildScheduledEventDescriptionParser$MessageRenderContextModel = (GuildScheduledEventDescriptionParser$MessageRenderContextModel) other;
        return m.areEqual(this.channelNames, guildScheduledEventDescriptionParser$MessageRenderContextModel.channelNames) && m.areEqual(this.userNames, guildScheduledEventDescriptionParser$MessageRenderContextModel.userNames) && m.areEqual(this.roles, guildScheduledEventDescriptionParser$MessageRenderContextModel.roles);
    }

    public final Map<Long, String> getChannelNames() {
        return this.channelNames;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Map<Long, String> getUserNames() {
        return this.userNames;
    }

    public int hashCode() {
        Map<Long, String> map = this.channelNames;
        int iHashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<Long, String> map2 = this.userNames;
        int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map3 = this.roles;
        return iHashCode2 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MessageRenderContextModel(channelNames=");
        sbU.append(this.channelNames);
        sbU.append(", userNames=");
        sbU.append(this.userNames);
        sbU.append(", roles=");
        return a.M(sbU, this.roles, ")");
    }

    public /* synthetic */ GuildScheduledEventDescriptionParser$MessageRenderContextModel(Map map, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : map3);
    }
}
