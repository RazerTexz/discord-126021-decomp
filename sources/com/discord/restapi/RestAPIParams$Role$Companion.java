package com.discord.restapi;

import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Role$Companion {
    private RestAPIParams$Role$Companion() {
    }

    public final RestAPIParams$Role createForPosition(long id2, int position) {
        return new RestAPIParams$Role(null, null, null, null, Integer.valueOf(position), null, id2, null, 175, null);
    }

    public final RestAPIParams$Role createWithRole(GuildRole role) {
        m.checkNotNullParameter(role, "role");
        return new RestAPIParams$Role(Boolean.valueOf(role.getHoist()), role.getName(), Boolean.valueOf(role.getMentionable()), Integer.valueOf(role.getColor()), Integer.valueOf(role.getPosition()), Long.valueOf(role.getPermissions()), role.getId(), null, 128, null);
    }

    public /* synthetic */ RestAPIParams$Role$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
