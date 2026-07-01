package com.discord.restapi;

import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$Message$AllowedMentions {
    public static final RestAPIParams$Message$AllowedMentions$Companion Companion = new RestAPIParams$Message$AllowedMentions$Companion(null);
    private final List<String> parse;
    private final Boolean repliedUser;
    private final List<Long> roles;
    private final List<Long> users;

    public RestAPIParams$Message$AllowedMentions(List<String> list, List<Long> list2, List<Long> list3, Boolean bool) {
        this.parse = list;
        this.users = list2;
        this.roles = list3;
        this.repliedUser = bool;
    }

    public final List<String> getParse() {
        return this.parse;
    }

    public final Boolean getRepliedUser() {
        return this.repliedUser;
    }

    public final List<Long> getRoles() {
        return this.roles;
    }

    public final List<Long> getUsers() {
        return this.users;
    }
}
