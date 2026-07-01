package com.discord.widgets.guilds.join;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens$State;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildWelcomeSheetViewModel$StoreState {
    private final Guild guild;
    private final StoreGuildWelcomeScreens$State guildWelcomeScreen;

    public WidgetGuildWelcomeSheetViewModel$StoreState(Guild guild, StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State) {
        this.guild = guild;
        this.guildWelcomeScreen = storeGuildWelcomeScreens$State;
    }

    public static /* synthetic */ WidgetGuildWelcomeSheetViewModel$StoreState copy$default(WidgetGuildWelcomeSheetViewModel$StoreState widgetGuildWelcomeSheetViewModel$StoreState, Guild guild, StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetGuildWelcomeSheetViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            storeGuildWelcomeScreens$State = widgetGuildWelcomeSheetViewModel$StoreState.guildWelcomeScreen;
        }
        return widgetGuildWelcomeSheetViewModel$StoreState.copy(guild, storeGuildWelcomeScreens$State);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreGuildWelcomeScreens$State getGuildWelcomeScreen() {
        return this.guildWelcomeScreen;
    }

    public final WidgetGuildWelcomeSheetViewModel$StoreState copy(Guild guild, StoreGuildWelcomeScreens$State guildWelcomeScreen) {
        return new WidgetGuildWelcomeSheetViewModel$StoreState(guild, guildWelcomeScreen);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildWelcomeSheetViewModel$StoreState)) {
            return false;
        }
        WidgetGuildWelcomeSheetViewModel$StoreState widgetGuildWelcomeSheetViewModel$StoreState = (WidgetGuildWelcomeSheetViewModel$StoreState) other;
        return m.areEqual(this.guild, widgetGuildWelcomeSheetViewModel$StoreState.guild) && m.areEqual(this.guildWelcomeScreen, widgetGuildWelcomeSheetViewModel$StoreState.guildWelcomeScreen);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final StoreGuildWelcomeScreens$State getGuildWelcomeScreen() {
        return this.guildWelcomeScreen;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State = this.guildWelcomeScreen;
        return iHashCode + (storeGuildWelcomeScreens$State != null ? storeGuildWelcomeScreens$State.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", guildWelcomeScreen=");
        sbU.append(this.guildWelcomeScreen);
        sbU.append(")");
        return sbU.toString();
    }
}
