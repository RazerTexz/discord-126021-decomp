package com.discord.restapi;

import com.discord.api.permission.PermissionOverwrite;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$ChannelPermissionOverwrites$Companion {
    private RestAPIParams$ChannelPermissionOverwrites$Companion() {
    }

    public final RestAPIParams$ChannelPermissionOverwrites createForMember(long id2, Long allow, Long deny) {
        return new RestAPIParams$ChannelPermissionOverwrites(1, String.valueOf(id2), allow, deny, null);
    }

    public final RestAPIParams$ChannelPermissionOverwrites createForRole(long id2, Long allow, Long deny) {
        return new RestAPIParams$ChannelPermissionOverwrites(0, String.valueOf(id2), allow, deny, null);
    }

    public final RestAPIParams$ChannelPermissionOverwrites fromPermissionOverwrite(PermissionOverwrite overwrite) {
        m.checkNotNullParameter(overwrite, "overwrite");
        int iOrdinal = overwrite.getType().ordinal();
        int i = 1;
        if (iOrdinal == 0) {
            i = 0;
        } else if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        return new RestAPIParams$ChannelPermissionOverwrites(Integer.valueOf(i), String.valueOf(overwrite.e()), Long.valueOf(overwrite.getAllow()), Long.valueOf(overwrite.getDeny()), null);
    }

    public /* synthetic */ RestAPIParams$ChannelPermissionOverwrites$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
