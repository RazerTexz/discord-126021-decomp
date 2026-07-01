package com.discord.api.commands;

import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;

/* JADX INFO: compiled from: Application.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Application implements Serializable {
    private final User bot;
    private final boolean builtIn;
    private final int commandCount;
    private final String icon;
    private final long id;
    private final String name;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final User getBot() {
        return this.bot;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getCommandCount() {
        return this.commandCount;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final long getId() {
        return this.id;
    }
}
