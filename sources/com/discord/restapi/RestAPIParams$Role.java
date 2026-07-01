package com.discord.restapi;

import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Role {
    public static final RestAPIParams$Role$Companion Companion = new RestAPIParams$Role$Companion(null);
    private Integer color;
    private Boolean hoist;
    private String icon;
    private long id;
    private Boolean mentionable;
    private String name;
    private Long permissions;
    private Integer position;

    public RestAPIParams$Role() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
    }

    public RestAPIParams$Role(Boolean bool, String str, Boolean bool2, Integer num, Integer num2, Long l, long j, String str2) {
        this.hoist = bool;
        this.name = str;
        this.mentionable = bool2;
        this.color = num;
        this.position = num2;
        this.permissions = l;
        this.id = j;
        this.icon = str2;
    }

    public static final RestAPIParams$Role createForPosition(long j, int i) {
        return Companion.createForPosition(j, i);
    }

    public static final RestAPIParams$Role createWithRole(GuildRole guildRole) {
        return Companion.createWithRole(guildRole);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Boolean getHoist() {
        return this.hoist;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    public final Boolean getMentionable() {
        return this.mentionable;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final void setColor(Integer num) {
        this.color = num;
    }

    public final void setHoist(Boolean bool) {
        this.hoist = bool;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setMentionable(Boolean bool) {
        this.mentionable = bool;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPermissions(Long l) {
        this.permissions = l;
    }

    public final void setPosition(Integer num) {
        this.position = num;
    }

    public /* synthetic */ RestAPIParams$Role(Boolean bool, String str, Boolean bool2, Integer num, Integer num2, Long l, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : l, (i & 64) != 0 ? 0L : j, (i & 128) == 0 ? str2 : null);
    }
}
