package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadSettingsViewModel$ViewState$Valid extends WidgetThreadSettingsViewModel$ViewState {
    private final boolean canManageThread;
    private final Channel channel;
    private final String channelNameDraft;
    private final boolean hasUnsavedChanges;
    private final boolean isPinsEnabled;
    private final int slowModeCooldownDraft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettingsViewModel$ViewState$Valid(Channel channel, String str, int i, boolean z2, boolean z3, boolean z4) {
        super(null);
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.channelNameDraft = str;
        this.slowModeCooldownDraft = i;
        this.hasUnsavedChanges = z2;
        this.canManageThread = z3;
        this.isPinsEnabled = z4;
    }

    public static /* synthetic */ WidgetThreadSettingsViewModel$ViewState$Valid copy$default(WidgetThreadSettingsViewModel$ViewState$Valid widgetThreadSettingsViewModel$ViewState$Valid, Channel channel, String str, int i, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            channel = widgetThreadSettingsViewModel$ViewState$Valid.channel;
        }
        if ((i2 & 2) != 0) {
            str = widgetThreadSettingsViewModel$ViewState$Valid.channelNameDraft;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = widgetThreadSettingsViewModel$ViewState$Valid.slowModeCooldownDraft;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z2 = widgetThreadSettingsViewModel$ViewState$Valid.hasUnsavedChanges;
        }
        boolean z5 = z2;
        if ((i2 & 16) != 0) {
            z3 = widgetThreadSettingsViewModel$ViewState$Valid.canManageThread;
        }
        boolean z6 = z3;
        if ((i2 & 32) != 0) {
            z4 = widgetThreadSettingsViewModel$ViewState$Valid.isPinsEnabled;
        }
        return widgetThreadSettingsViewModel$ViewState$Valid.copy(channel, str2, i3, z5, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getChannelNameDraft() {
        return this.channelNameDraft;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSlowModeCooldownDraft() {
        return this.slowModeCooldownDraft;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHasUnsavedChanges() {
        return this.hasUnsavedChanges;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsPinsEnabled() {
        return this.isPinsEnabled;
    }

    public final WidgetThreadSettingsViewModel$ViewState$Valid copy(Channel channel, String channelNameDraft, int slowModeCooldownDraft, boolean hasUnsavedChanges, boolean canManageThread, boolean isPinsEnabled) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetThreadSettingsViewModel$ViewState$Valid(channel, channelNameDraft, slowModeCooldownDraft, hasUnsavedChanges, canManageThread, isPinsEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetThreadSettingsViewModel$ViewState$Valid)) {
            return false;
        }
        WidgetThreadSettingsViewModel$ViewState$Valid widgetThreadSettingsViewModel$ViewState$Valid = (WidgetThreadSettingsViewModel$ViewState$Valid) other;
        return m.areEqual(this.channel, widgetThreadSettingsViewModel$ViewState$Valid.channel) && m.areEqual(this.channelNameDraft, widgetThreadSettingsViewModel$ViewState$Valid.channelNameDraft) && this.slowModeCooldownDraft == widgetThreadSettingsViewModel$ViewState$Valid.slowModeCooldownDraft && this.hasUnsavedChanges == widgetThreadSettingsViewModel$ViewState$Valid.hasUnsavedChanges && this.canManageThread == widgetThreadSettingsViewModel$ViewState$Valid.canManageThread && this.isPinsEnabled == widgetThreadSettingsViewModel$ViewState$Valid.isPinsEnabled;
    }

    public final boolean getCanManageThread() {
        return this.canManageThread;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getChannelNameDraft() {
        return this.channelNameDraft;
    }

    public final boolean getHasUnsavedChanges() {
        return this.hasUnsavedChanges;
    }

    public final int getSlowModeCooldownDraft() {
        return this.slowModeCooldownDraft;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public int hashCode() {
        Channel channel = this.channel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        String str = this.channelNameDraft;
        int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.slowModeCooldownDraft) * 31;
        boolean z2 = this.hasUnsavedChanges;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z3 = this.canManageThread;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isPinsEnabled;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isPinsEnabled() {
        return this.isPinsEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(channel=");
        sbU.append(this.channel);
        sbU.append(", channelNameDraft=");
        sbU.append(this.channelNameDraft);
        sbU.append(", slowModeCooldownDraft=");
        sbU.append(this.slowModeCooldownDraft);
        sbU.append(", hasUnsavedChanges=");
        sbU.append(this.hasUnsavedChanges);
        sbU.append(", canManageThread=");
        sbU.append(this.canManageThread);
        sbU.append(", isPinsEnabled=");
        return a.O(sbU, this.isPinsEnabled, ")");
    }
}
