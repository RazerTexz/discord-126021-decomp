package com.discord.widgets.servers;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog$Model {
    public static final WidgetServerDeleteDialog$Model$Companion Companion = new WidgetServerDeleteDialog$Model$Companion(null);
    private final Guild guild;
    private final MeUser me;

    public WidgetServerDeleteDialog$Model(MeUser meUser, Guild guild) {
        m.checkNotNullParameter(meUser, "me");
        this.me = meUser;
        this.guild = guild;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMe() {
        return this.me;
    }
}
