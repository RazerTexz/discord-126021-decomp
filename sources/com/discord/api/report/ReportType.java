package com.discord.api.report;


/* JADX INFO: compiled from: InAppReportsMenu.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ReportType {
    Message("message"),
    StageChannel("stage_channel"),
    DirectoryServer("guild_directory_entry"),
    GuildScheduledEvent("guild_scheduled_event");

    private final String pathValue;

    ReportType(String str) {
        this.pathValue = str;
    }

    public final String getPathValue() {
        return this.pathValue;
    }
}
