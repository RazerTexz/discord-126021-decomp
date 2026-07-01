package com.discord.widgets.guilds.join;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.guild.welcome.GuildWelcomeChannel;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildWelcomeSheetViewModel$ViewState$Loaded extends WidgetGuildWelcomeSheetViewModel$ViewState {
    private final String guildDescription;
    private final String guildIcon;
    private final long guildId;
    private final String guildName;
    private final String guildShortName;
    private final List<GuildWelcomeChannel> welcomeChannelsData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheetViewModel$ViewState$Loaded(long j, String str, String str2, String str3, String str4, List<GuildWelcomeChannel> list) {
        super(null);
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(str2, "guildShortName");
        this.guildId = j;
        this.guildName = str;
        this.guildShortName = str2;
        this.guildIcon = str3;
        this.guildDescription = str4;
        this.welcomeChannelsData = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildWelcomeSheetViewModel$ViewState$Loaded copy$default(WidgetGuildWelcomeSheetViewModel$ViewState$Loaded widgetGuildWelcomeSheetViewModel$ViewState$Loaded, long j, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        return widgetGuildWelcomeSheetViewModel$ViewState$Loaded.copy((i & 1) != 0 ? widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildId : j, (i & 2) != 0 ? widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildName : str, (i & 4) != 0 ? widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildShortName : str2, (i & 8) != 0 ? widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildIcon : str3, (i & 16) != 0 ? widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildDescription : str4, (i & 32) != 0 ? widgetGuildWelcomeSheetViewModel$ViewState$Loaded.welcomeChannelsData : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGuildShortName() {
        return this.guildShortName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getGuildIcon() {
        return this.guildIcon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGuildDescription() {
        return this.guildDescription;
    }

    public final List<GuildWelcomeChannel> component6() {
        return this.welcomeChannelsData;
    }

    public final WidgetGuildWelcomeSheetViewModel$ViewState$Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, List<GuildWelcomeChannel> welcomeChannelsData) {
        m.checkNotNullParameter(guildName, "guildName");
        m.checkNotNullParameter(guildShortName, "guildShortName");
        return new WidgetGuildWelcomeSheetViewModel$ViewState$Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, welcomeChannelsData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildWelcomeSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetGuildWelcomeSheetViewModel$ViewState$Loaded widgetGuildWelcomeSheetViewModel$ViewState$Loaded = (WidgetGuildWelcomeSheetViewModel$ViewState$Loaded) other;
        return this.guildId == widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildId && m.areEqual(this.guildName, widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildName) && m.areEqual(this.guildShortName, widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildShortName) && m.areEqual(this.guildIcon, widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildIcon) && m.areEqual(this.guildDescription, widgetGuildWelcomeSheetViewModel$ViewState$Loaded.guildDescription) && m.areEqual(this.welcomeChannelsData, widgetGuildWelcomeSheetViewModel$ViewState$Loaded.welcomeChannelsData);
    }

    public final String getGuildDescription() {
        return this.guildDescription;
    }

    public final String getGuildIcon() {
        return this.guildIcon;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final String getGuildShortName() {
        return this.guildShortName;
    }

    public final List<GuildWelcomeChannel> getWelcomeChannelsData() {
        return this.welcomeChannelsData;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.guildName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.guildShortName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.guildIcon;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.guildDescription;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<GuildWelcomeChannel> list = this.welcomeChannelsData;
        return iHashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildShortName=");
        sbU.append(this.guildShortName);
        sbU.append(", guildIcon=");
        sbU.append(this.guildIcon);
        sbU.append(", guildDescription=");
        sbU.append(this.guildDescription);
        sbU.append(", welcomeChannelsData=");
        return a.L(sbU, this.welcomeChannelsData, ")");
    }
}
