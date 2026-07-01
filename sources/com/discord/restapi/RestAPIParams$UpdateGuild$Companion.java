package com.discord.restapi;

import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIParams$UpdateGuild$Companion {
    private RestAPIParams$UpdateGuild$Companion() {
    }

    public final RestAPIParams$UpdateGuild createForExplicitContentFilter(GuildExplicitContentFilter explicitContentFilter) {
        m.checkNotNullParameter(explicitContentFilter, "explicitContentFilter");
        return new RestAPIParams$UpdateGuild(null, null, null, null, null, null, null, explicitContentFilter, null, null, null, null, null, null, null, 32639, null);
    }

    public final RestAPIParams$UpdateGuild createForVerificationLevel(GuildVerificationLevel verificationLevel) {
        m.checkNotNullParameter(verificationLevel, "verificationLevel");
        return new RestAPIParams$UpdateGuild(null, null, null, null, null, null, verificationLevel, null, null, null, null, null, null, null, null, 32703, null);
    }

    public /* synthetic */ RestAPIParams$UpdateGuild$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
