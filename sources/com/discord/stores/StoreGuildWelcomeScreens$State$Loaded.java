package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreGuildWelcomeScreens.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreGuildWelcomeScreens$State$Loaded extends StoreGuildWelcomeScreens$State {
    private final GuildWelcomeScreen data;

    public StoreGuildWelcomeScreens$State$Loaded(GuildWelcomeScreen guildWelcomeScreen) {
        super(null);
        this.data = guildWelcomeScreen;
    }

    public static /* synthetic */ StoreGuildWelcomeScreens$State$Loaded copy$default(StoreGuildWelcomeScreens$State$Loaded storeGuildWelcomeScreens$State$Loaded, GuildWelcomeScreen guildWelcomeScreen, int i, Object obj) {
        if ((i & 1) != 0) {
            guildWelcomeScreen = storeGuildWelcomeScreens$State$Loaded.data;
        }
        return storeGuildWelcomeScreens$State$Loaded.copy(guildWelcomeScreen);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildWelcomeScreen getData() {
        return this.data;
    }

    public final StoreGuildWelcomeScreens$State$Loaded copy(GuildWelcomeScreen data) {
        return new StoreGuildWelcomeScreens$State$Loaded(data);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreGuildWelcomeScreens$State$Loaded) && m.areEqual(this.data, ((StoreGuildWelcomeScreens$State$Loaded) other).data);
        }
        return true;
    }

    public final GuildWelcomeScreen getData() {
        return this.data;
    }

    public int hashCode() {
        GuildWelcomeScreen guildWelcomeScreen = this.data;
        if (guildWelcomeScreen != null) {
            return guildWelcomeScreen.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
