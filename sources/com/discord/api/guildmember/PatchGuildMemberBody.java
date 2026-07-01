package com.discord.api.guildmember;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.m;

/* JADX INFO: compiled from: PatchGuildMemberBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PatchGuildMemberBody {
    private final NullSerializable<String> avatar;
    private final NullSerializable<String> banner;
    private final String bio;
    private final String nick;

    public PatchGuildMemberBody() {
        this(null, null, null, null, 15);
    }

    public PatchGuildMemberBody(String str, NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, String str2) {
        this.nick = str;
        this.avatar = nullSerializable;
        this.banner = nullSerializable2;
        this.bio = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatchGuildMemberBody)) {
            return false;
        }
        PatchGuildMemberBody patchGuildMemberBody = (PatchGuildMemberBody) other;
        return m.areEqual(this.nick, patchGuildMemberBody.nick) && m.areEqual(this.avatar, patchGuildMemberBody.avatar) && m.areEqual(this.banner, patchGuildMemberBody.banner) && m.areEqual(this.bio, patchGuildMemberBody.bio);
    }

    public int hashCode() {
        String str = this.nick;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        NullSerializable<String> nullSerializable = this.avatar;
        int iHashCode2 = (iHashCode + (nullSerializable != null ? nullSerializable.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable2 = this.banner;
        int iHashCode3 = (iHashCode2 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
        String str2 = this.bio;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("PatchGuildMemberBody(nick=");
        sbU.append(this.nick);
        sbU.append(", avatar=");
        sbU.append(this.avatar);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", bio=");
        return a.J(sbU, this.bio, ")");
    }

    public PatchGuildMemberBody(String str, NullSerializable nullSerializable, NullSerializable nullSerializable2, String str2, int i) {
        str = (i & 1) != 0 ? null : str;
        nullSerializable = (i & 2) != 0 ? null : nullSerializable;
        int i2 = i & 4;
        int i3 = i & 8;
        this.nick = str;
        this.avatar = nullSerializable;
        this.banner = null;
        this.bio = null;
    }
}
