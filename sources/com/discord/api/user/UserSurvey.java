package com.discord.api.user;

import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserSurvey.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserSurvey {
    private final String cta;
    private final List<Long> guild_permissions;
    private final List<String> guild_requirements;
    private final List<Integer> guild_size;
    private final String key;
    private final String prompt;
    private final String url;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getCta() {
        return this.cta;
    }

    /* JADX INFO: renamed from: b */
    public final List<Long> m8315b() {
        return this.guild_permissions;
    }

    /* JADX INFO: renamed from: c */
    public final List<String> m8316c() {
        return this.guild_requirements;
    }

    /* JADX INFO: renamed from: d */
    public final List<Integer> m8317d() {
        return this.guild_size;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserSurvey)) {
            return false;
        }
        UserSurvey userSurvey = (UserSurvey) other;
        return C12238m.areEqual(this.prompt, userSurvey.prompt) && C12238m.areEqual(this.cta, userSurvey.cta) && C12238m.areEqual(this.url, userSurvey.url) && C12238m.areEqual(this.key, userSurvey.key) && C12238m.areEqual(this.guild_requirements, userSurvey.guild_requirements) && C12238m.areEqual(this.guild_size, userSurvey.guild_size) && C12238m.areEqual(this.guild_permissions, userSurvey.guild_permissions);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.prompt;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.cta;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.key;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<String> list = this.guild_requirements;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<Integer> list2 = this.guild_size;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.guild_permissions;
        return iHashCode6 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("UserSurvey(prompt=");
        sbM833U.append(this.prompt);
        sbM833U.append(", cta=");
        sbM833U.append(this.cta);
        sbM833U.append(", url=");
        sbM833U.append(this.url);
        sbM833U.append(", key=");
        sbM833U.append(this.key);
        sbM833U.append(", guild_requirements=");
        sbM833U.append(this.guild_requirements);
        sbM833U.append(", guild_size=");
        sbM833U.append(this.guild_size);
        sbM833U.append(", guild_permissions=");
        return C1643a.m824L(sbM833U, this.guild_permissions, ")");
    }
}
