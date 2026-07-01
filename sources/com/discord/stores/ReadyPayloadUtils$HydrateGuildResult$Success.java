package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: ReadyPayloadUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ReadyPayloadUtils$HydrateGuildResult$Success extends ReadyPayloadUtils$HydrateGuildResult {
    private final Guild guild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadyPayloadUtils$HydrateGuildResult$Success(Guild guild) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
    }

    public static /* synthetic */ ReadyPayloadUtils$HydrateGuildResult$Success copy$default(ReadyPayloadUtils$HydrateGuildResult$Success readyPayloadUtils$HydrateGuildResult$Success, Guild guild, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = readyPayloadUtils$HydrateGuildResult$Success.guild;
        }
        return readyPayloadUtils$HydrateGuildResult$Success.copy(guild);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final ReadyPayloadUtils$HydrateGuildResult$Success copy(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        return new ReadyPayloadUtils$HydrateGuildResult$Success(guild);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ReadyPayloadUtils$HydrateGuildResult$Success) && m.areEqual(this.guild, ((ReadyPayloadUtils$HydrateGuildResult$Success) other).guild);
        }
        return true;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public int hashCode() {
        Guild guild = this.guild;
        if (guild != null) {
            return guild.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Success(guild=");
        sbU.append(this.guild);
        sbU.append(")");
        return sbU.toString();
    }
}
