package com.discord.api.commands;

import java.util.List;

/* JADX INFO: compiled from: GuildApplicationCommands.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildApplicationCommands {
    private final List<ApplicationCommand> applicationCommands;
    private final List<Application> applications;
    private final long guildId;
    private final String nonce;
    private final long updatedAt;

    public final List<ApplicationCommand> a() {
        return this.applicationCommands;
    }

    public final List<Application> b() {
        return this.applications;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }
}
