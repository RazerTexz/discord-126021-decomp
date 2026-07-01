package com.discord.api.message.allowedmentions;

import com.discord.models.domain.ModelGuildMemberListUpdate;

/* JADX INFO: renamed from: com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes, reason: use source file name */
/* JADX INFO: compiled from: MessageAllowedMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public enum MessageAllowedMentions2 {
    USERS("users"),
    ROLES("roles"),
    EVERYONE(ModelGuildMemberListUpdate.EVERYONE_ID);

    private final String apiStringRepresentation;

    MessageAllowedMentions2(String str) {
        this.apiStringRepresentation = str;
    }

    /* JADX INFO: renamed from: serialize, reason: from getter */
    public final String getApiStringRepresentation() {
        return this.apiStringRepresentation;
    }
}
