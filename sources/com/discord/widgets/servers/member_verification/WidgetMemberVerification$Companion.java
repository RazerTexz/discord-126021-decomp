package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.google.gson.Gson;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification$Companion {
    private WidgetMemberVerification$Companion() {
    }

    public static /* synthetic */ void create$default(WidgetMemberVerification$Companion widgetMemberVerification$Companion, Context context, long j, String str, ModelInvite modelInvite, int i, Object obj) {
        if ((i & 8) != 0) {
            modelInvite = null;
        }
        widgetMemberVerification$Companion.create(context, j, str, modelInvite);
    }

    public final void create(Context context, long guildId, String location, ModelInvite invite) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intent intent = new Intent();
        intent.putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        intent.putExtra("INTENT_EXTRA_LOCATION", location);
        if ((invite != null ? invite.guild : null) != null) {
            intent.putExtra("INTENT_EXTRA_INVITE_GUILD", new Gson().m(invite.guild));
        }
        j.d(context, WidgetMemberVerification.class, intent);
    }

    public /* synthetic */ WidgetMemberVerification$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
