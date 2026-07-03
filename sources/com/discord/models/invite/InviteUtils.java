package com.discord.models.invite;

import com.discord.BuildConfig;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InviteUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InviteUtils {
    public static final InviteUtils INSTANCE = new InviteUtils();

    private InviteUtils() {
    }

    public final String createLinkFromCode(String code, Long guildScheduledEventId) {
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        return guildScheduledEventId != null ? C1643a.m828P(new Object[]{BuildConfig.HOST_INVITE, code, guildScheduledEventId}, 3, ModelInvite.URL_FORMAT_WITH_EVENT, "java.lang.String.format(format, *args)") : C1643a.m828P(new Object[]{BuildConfig.HOST_INVITE, code}, 2, ModelInvite.URL_FORMAT, "java.lang.String.format(format, *args)");
    }
}
