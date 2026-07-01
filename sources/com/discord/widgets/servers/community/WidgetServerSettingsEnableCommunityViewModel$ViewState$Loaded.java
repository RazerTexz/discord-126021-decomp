package com.discord.widgets.servers.community;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded extends WidgetServerSettingsEnableCommunityViewModel$ViewState {
    private final WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig communityGuildConfig;
    private final int currentPage;
    private final boolean isLoading;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded(int i, boolean z2, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig) {
        super(null);
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, "communityGuildConfig");
        this.currentPage = i;
        this.isLoading = z2;
        this.communityGuildConfig = widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;
    }

    public static /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded copy$default(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, int i, boolean z2, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.currentPage;
        }
        if ((i2 & 2) != 0) {
            z2 = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.isLoading;
        }
        if ((i2 & 4) != 0) {
            widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.communityGuildConfig;
        }
        return widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.copy(i, z2, widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentPage() {
        return this.currentPage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig getCommunityGuildConfig() {
        return this.communityGuildConfig;
    }

    public final WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded copy(int currentPage, boolean isLoading, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig communityGuildConfig) {
        m.checkNotNullParameter(communityGuildConfig, "communityGuildConfig");
        return new WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded(currentPage, isLoading, communityGuildConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded = (WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) other;
        return this.currentPage == widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.currentPage && this.isLoading == widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.isLoading && m.areEqual(this.communityGuildConfig, widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.communityGuildConfig);
    }

    public final WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig getCommunityGuildConfig() {
        return this.communityGuildConfig;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int i = this.currentPage * 31;
        boolean z2 = this.isLoading;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig = this.communityGuildConfig;
        return i2 + (widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig != null ? widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig.hashCode() : 0);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(currentPage=");
        sbU.append(this.currentPage);
        sbU.append(", isLoading=");
        sbU.append(this.isLoading);
        sbU.append(", communityGuildConfig=");
        sbU.append(this.communityGuildConfig);
        sbU.append(")");
        return sbU.toString();
    }
}
