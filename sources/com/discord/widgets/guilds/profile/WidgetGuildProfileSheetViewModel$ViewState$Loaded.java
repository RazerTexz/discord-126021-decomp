package com.discord.widgets.guilds.profile;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$ViewState$Loaded extends WidgetGuildProfileSheetViewModel$ViewState {
    private final WidgetGuildProfileSheetViewModel$Actions actions;
    private final WidgetGuildProfileSheetViewModel$Banner banner;
    private final WidgetGuildProfileSheetViewModel$BottomActions bottomActions;
    private final WidgetGuildProfileSheetViewModel$EmojisData emojisData;
    private final String guildDescription;
    private final String guildIcon;
    private final long guildId;
    private final String guildName;
    private final String guildShortName;
    private final boolean isGuildHub;
    private final MeUser meUser;
    private final Integer memberCount;
    private final Integer onlineCount;
    private final WidgetGuildProfileSheetViewModel$TabItems tabItems;
    private final Integer verifiedPartneredIconRes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheetViewModel$ViewState$Loaded(long j, String str, String str2, String str3, String str4, Integer num, WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner, Integer num2, Integer num3, WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems, WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions, WidgetGuildProfileSheetViewModel$EmojisData widgetGuildProfileSheetViewModel$EmojisData, WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions, boolean z2, MeUser meUser) {
        super(null);
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(str2, "guildShortName");
        m.checkNotNullParameter(widgetGuildProfileSheetViewModel$Banner, "banner");
        m.checkNotNullParameter(widgetGuildProfileSheetViewModel$EmojisData, "emojisData");
        m.checkNotNullParameter(widgetGuildProfileSheetViewModel$BottomActions, "bottomActions");
        m.checkNotNullParameter(meUser, "meUser");
        this.guildId = j;
        this.guildName = str;
        this.guildShortName = str2;
        this.guildIcon = str3;
        this.guildDescription = str4;
        this.verifiedPartneredIconRes = num;
        this.banner = widgetGuildProfileSheetViewModel$Banner;
        this.onlineCount = num2;
        this.memberCount = num3;
        this.tabItems = widgetGuildProfileSheetViewModel$TabItems;
        this.actions = widgetGuildProfileSheetViewModel$Actions;
        this.emojisData = widgetGuildProfileSheetViewModel$EmojisData;
        this.bottomActions = widgetGuildProfileSheetViewModel$BottomActions;
        this.isGuildHub = z2;
        this.meUser = meUser;
    }

    public static /* synthetic */ WidgetGuildProfileSheetViewModel$ViewState$Loaded copy$default(WidgetGuildProfileSheetViewModel$ViewState$Loaded widgetGuildProfileSheetViewModel$ViewState$Loaded, long j, String str, String str2, String str3, String str4, Integer num, WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner, Integer num2, Integer num3, WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems, WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions, WidgetGuildProfileSheetViewModel$EmojisData widgetGuildProfileSheetViewModel$EmojisData, WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions, boolean z2, MeUser meUser, int i, Object obj) {
        return widgetGuildProfileSheetViewModel$ViewState$Loaded.copy((i & 1) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.guildId : j, (i & 2) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.guildName : str, (i & 4) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.guildShortName : str2, (i & 8) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.guildIcon : str3, (i & 16) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.guildDescription : str4, (i & 32) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.verifiedPartneredIconRes : num, (i & 64) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.banner : widgetGuildProfileSheetViewModel$Banner, (i & 128) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.onlineCount : num2, (i & 256) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.memberCount : num3, (i & 512) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.tabItems : widgetGuildProfileSheetViewModel$TabItems, (i & 1024) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.actions : widgetGuildProfileSheetViewModel$Actions, (i & 2048) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.emojisData : widgetGuildProfileSheetViewModel$EmojisData, (i & 4096) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.bottomActions : widgetGuildProfileSheetViewModel$BottomActions, (i & 8192) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.isGuildHub : z2, (i & 16384) != 0 ? widgetGuildProfileSheetViewModel$ViewState$Loaded.meUser : meUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final WidgetGuildProfileSheetViewModel$TabItems getTabItems() {
        return this.tabItems;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final WidgetGuildProfileSheetViewModel$Actions getActions() {
        return this.actions;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final WidgetGuildProfileSheetViewModel$EmojisData getEmojisData() {
        return this.emojisData;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final WidgetGuildProfileSheetViewModel$BottomActions getBottomActions() {
        return this.bottomActions;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getIsGuildHub() {
        return this.isGuildHub;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
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

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getVerifiedPartneredIconRes() {
        return this.verifiedPartneredIconRes;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final WidgetGuildProfileSheetViewModel$Banner getBanner() {
        return this.banner;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getOnlineCount() {
        return this.onlineCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getMemberCount() {
        return this.memberCount;
    }

    public final WidgetGuildProfileSheetViewModel$ViewState$Loaded copy(long guildId, String guildName, String guildShortName, String guildIcon, String guildDescription, Integer verifiedPartneredIconRes, WidgetGuildProfileSheetViewModel$Banner banner, Integer onlineCount, Integer memberCount, WidgetGuildProfileSheetViewModel$TabItems tabItems, WidgetGuildProfileSheetViewModel$Actions actions, WidgetGuildProfileSheetViewModel$EmojisData emojisData, WidgetGuildProfileSheetViewModel$BottomActions bottomActions, boolean isGuildHub, MeUser meUser) {
        m.checkNotNullParameter(guildName, "guildName");
        m.checkNotNullParameter(guildShortName, "guildShortName");
        m.checkNotNullParameter(banner, "banner");
        m.checkNotNullParameter(emojisData, "emojisData");
        m.checkNotNullParameter(bottomActions, "bottomActions");
        m.checkNotNullParameter(meUser, "meUser");
        return new WidgetGuildProfileSheetViewModel$ViewState$Loaded(guildId, guildName, guildShortName, guildIcon, guildDescription, verifiedPartneredIconRes, banner, onlineCount, memberCount, tabItems, actions, emojisData, bottomActions, isGuildHub, meUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildProfileSheetViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetGuildProfileSheetViewModel$ViewState$Loaded widgetGuildProfileSheetViewModel$ViewState$Loaded = (WidgetGuildProfileSheetViewModel$ViewState$Loaded) other;
        return this.guildId == widgetGuildProfileSheetViewModel$ViewState$Loaded.guildId && m.areEqual(this.guildName, widgetGuildProfileSheetViewModel$ViewState$Loaded.guildName) && m.areEqual(this.guildShortName, widgetGuildProfileSheetViewModel$ViewState$Loaded.guildShortName) && m.areEqual(this.guildIcon, widgetGuildProfileSheetViewModel$ViewState$Loaded.guildIcon) && m.areEqual(this.guildDescription, widgetGuildProfileSheetViewModel$ViewState$Loaded.guildDescription) && m.areEqual(this.verifiedPartneredIconRes, widgetGuildProfileSheetViewModel$ViewState$Loaded.verifiedPartneredIconRes) && m.areEqual(this.banner, widgetGuildProfileSheetViewModel$ViewState$Loaded.banner) && m.areEqual(this.onlineCount, widgetGuildProfileSheetViewModel$ViewState$Loaded.onlineCount) && m.areEqual(this.memberCount, widgetGuildProfileSheetViewModel$ViewState$Loaded.memberCount) && m.areEqual(this.tabItems, widgetGuildProfileSheetViewModel$ViewState$Loaded.tabItems) && m.areEqual(this.actions, widgetGuildProfileSheetViewModel$ViewState$Loaded.actions) && m.areEqual(this.emojisData, widgetGuildProfileSheetViewModel$ViewState$Loaded.emojisData) && m.areEqual(this.bottomActions, widgetGuildProfileSheetViewModel$ViewState$Loaded.bottomActions) && this.isGuildHub == widgetGuildProfileSheetViewModel$ViewState$Loaded.isGuildHub && m.areEqual(this.meUser, widgetGuildProfileSheetViewModel$ViewState$Loaded.meUser);
    }

    public final WidgetGuildProfileSheetViewModel$Actions getActions() {
        return this.actions;
    }

    public final WidgetGuildProfileSheetViewModel$Banner getBanner() {
        return this.banner;
    }

    public final WidgetGuildProfileSheetViewModel$BottomActions getBottomActions() {
        return this.bottomActions;
    }

    public final WidgetGuildProfileSheetViewModel$EmojisData getEmojisData() {
        return this.emojisData;
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

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final Integer getMemberCount() {
        return this.memberCount;
    }

    public final Integer getOnlineCount() {
        return this.onlineCount;
    }

    public final WidgetGuildProfileSheetViewModel$TabItems getTabItems() {
        return this.tabItems;
    }

    public final Integer getVerifiedPartneredIconRes() {
        return this.verifiedPartneredIconRes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37, types: [int] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v52 */
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
        Integer num = this.verifiedPartneredIconRes;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner = this.banner;
        int iHashCode6 = (iHashCode5 + (widgetGuildProfileSheetViewModel$Banner != null ? widgetGuildProfileSheetViewModel$Banner.hashCode() : 0)) * 31;
        Integer num2 = this.onlineCount;
        int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.memberCount;
        int iHashCode8 = (iHashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
        WidgetGuildProfileSheetViewModel$TabItems widgetGuildProfileSheetViewModel$TabItems = this.tabItems;
        int iHashCode9 = (iHashCode8 + (widgetGuildProfileSheetViewModel$TabItems != null ? widgetGuildProfileSheetViewModel$TabItems.hashCode() : 0)) * 31;
        WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions = this.actions;
        int iHashCode10 = (iHashCode9 + (widgetGuildProfileSheetViewModel$Actions != null ? widgetGuildProfileSheetViewModel$Actions.hashCode() : 0)) * 31;
        WidgetGuildProfileSheetViewModel$EmojisData widgetGuildProfileSheetViewModel$EmojisData = this.emojisData;
        int iHashCode11 = (iHashCode10 + (widgetGuildProfileSheetViewModel$EmojisData != null ? widgetGuildProfileSheetViewModel$EmojisData.hashCode() : 0)) * 31;
        WidgetGuildProfileSheetViewModel$BottomActions widgetGuildProfileSheetViewModel$BottomActions = this.bottomActions;
        int iHashCode12 = (iHashCode11 + (widgetGuildProfileSheetViewModel$BottomActions != null ? widgetGuildProfileSheetViewModel$BottomActions.hashCode() : 0)) * 31;
        boolean z2 = this.isGuildHub;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode12 + r1) * 31;
        MeUser meUser = this.meUser;
        return i + (meUser != null ? meUser.hashCode() : 0);
    }

    public final boolean isGuildHub() {
        return this.isGuildHub;
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
        sbU.append(", verifiedPartneredIconRes=");
        sbU.append(this.verifiedPartneredIconRes);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", onlineCount=");
        sbU.append(this.onlineCount);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", tabItems=");
        sbU.append(this.tabItems);
        sbU.append(", actions=");
        sbU.append(this.actions);
        sbU.append(", emojisData=");
        sbU.append(this.emojisData);
        sbU.append(", bottomActions=");
        sbU.append(this.bottomActions);
        sbU.append(", isGuildHub=");
        sbU.append(this.isGuildHub);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(")");
        return sbU.toString();
    }
}
