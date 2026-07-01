package com.discord.api.user;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

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

    public final List<Long> b() {
        return this.guild_permissions;
    }

    public final List<String> c() {
        return this.guild_requirements;
    }

    public final List<Integer> d() {
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
        return Intrinsics3.areEqual(this.prompt, userSurvey.prompt) && Intrinsics3.areEqual(this.cta, userSurvey.cta) && Intrinsics3.areEqual(this.url, userSurvey.url) && Intrinsics3.areEqual(this.key, userSurvey.key) && Intrinsics3.areEqual(this.guild_requirements, userSurvey.guild_requirements) && Intrinsics3.areEqual(this.guild_size, userSurvey.guild_size) && Intrinsics3.areEqual(this.guild_permissions, userSurvey.guild_permissions);
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
        StringBuilder sbU = outline.U("UserSurvey(prompt=");
        sbU.append(this.prompt);
        sbU.append(", cta=");
        sbU.append(this.cta);
        sbU.append(", url=");
        sbU.append(this.url);
        sbU.append(", key=");
        sbU.append(this.key);
        sbU.append(", guild_requirements=");
        sbU.append(this.guild_requirements);
        sbU.append(", guild_size=");
        sbU.append(this.guild_size);
        sbU.append(", guild_permissions=");
        return outline.L(sbU, this.guild_permissions, ")");
    }
}
