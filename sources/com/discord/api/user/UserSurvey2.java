package com.discord.api.user;


/* JADX INFO: renamed from: com.discord.api.user.SurveyGuildRequirements, reason: use source file name */
/* JADX INFO: compiled from: UserSurvey.kt */
/* JADX INFO: loaded from: classes.dex */
public enum UserSurvey2 {
    IS_OWNER("is_owner"),
    IS_ADMIN("is_admin"),
    IS_COMMUNITY("is_community"),
    GUILD_SIZE("guild_size"),
    IS_HUB("is_hub"),
    GUILD_PERMISSIONS("guild_permissions");

    private final String value;

    UserSurvey2(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
