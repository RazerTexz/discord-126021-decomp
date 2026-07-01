package com.discord.models.invite;

import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import d0.z.d.m;

/* JADX INFO: compiled from: InviteUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InviteUtils {
    public static final InviteUtils INSTANCE = new InviteUtils();

    private InviteUtils() {
    }

    public final String createLinkFromCode(String code, Long guildScheduledEventId) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return guildScheduledEventId != null ? a.P(new Object[]{BuildConfig.HOST_INVITE, code, guildScheduledEventId}, 3, ModelInvite.URL_FORMAT_WITH_EVENT, "java.lang.String.format(format, *args)") : a.P(new Object[]{BuildConfig.HOST_INVITE, code}, 2, ModelInvite.URL_FORMAT, "java.lang.String.format(format, *args)");
    }
}
