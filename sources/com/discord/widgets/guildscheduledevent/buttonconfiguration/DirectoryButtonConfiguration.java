package com.discord.widgets.guildscheduledevent.buttonconfiguration;

import android.content.Context;
import android.view.View$OnClickListener;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import d0.z.d.m;

/* JADX INFO: compiled from: DirectoryButtonConfiguration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoryButtonConfiguration implements ButtonConfiguration {
    private final View$OnClickListener extrasButtonOnClickListener;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isAnyButtonVisible;
    private final boolean isDetailView;
    private final boolean isEventActive;
    private final boolean isEventComplete;
    private final boolean isExtrasVisible;
    private final boolean isInGuild;
    private final boolean isRsvped;
    private final boolean isShareVisible;
    private final View$OnClickListener primaryButtonOnClickListener;
    private final boolean primaryButtonVisible;
    private final int secondaryButtonBackground;
    private final boolean secondaryButtonEnabled;
    private final View$OnClickListener secondaryButtonOnClickListener;
    private final int secondaryButtonTextDrawableRes;
    private final boolean secondaryButtonVisible;
    private final View$OnClickListener shareButtonOnClickListener;

    public DirectoryButtonConfiguration(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, View$OnClickListener view$OnClickListener, View$OnClickListener view$OnClickListener2, View$OnClickListener view$OnClickListener3, View$OnClickListener view$OnClickListener4) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEvent = guildScheduledEvent;
        this.isInGuild = z2;
        this.isRsvped = z3;
        this.isDetailView = z4;
        this.primaryButtonOnClickListener = view$OnClickListener;
        this.secondaryButtonOnClickListener = view$OnClickListener2;
        this.shareButtonOnClickListener = view$OnClickListener3;
        this.extrasButtonOnClickListener = view$OnClickListener4;
        boolean z5 = false;
        boolean z6 = guildScheduledEvent.getStatus() == GuildScheduledEventStatus.COMPLETED;
        this.isEventComplete = z6;
        boolean z7 = GuildScheduledEventUtilitiesKt.getEventTiming(guildScheduledEvent) == GuildScheduledEventTiming.LIVE;
        this.isEventActive = z7;
        this.primaryButtonVisible = (z4 && !z7 && z2) ? false : true;
        this.secondaryButtonBackground = z3 ? 2131231010 : 2131231008;
        this.secondaryButtonTextDrawableRes = z3 ? 2131231652 : 2131231575;
        this.secondaryButtonEnabled = true;
        if (z2 && !z7 && !z6) {
            z5 = true;
        }
        this.secondaryButtonVisible = z5;
        this.isShareVisible = z2;
        this.isExtrasVisible = true;
        this.isAnyButtonVisible = true;
    }

    public static /* synthetic */ DirectoryButtonConfiguration copy$default(DirectoryButtonConfiguration directoryButtonConfiguration, GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, View$OnClickListener view$OnClickListener, View$OnClickListener view$OnClickListener2, View$OnClickListener view$OnClickListener3, View$OnClickListener view$OnClickListener4, int i, Object obj) {
        return directoryButtonConfiguration.copy((i & 1) != 0 ? directoryButtonConfiguration.guildScheduledEvent : guildScheduledEvent, (i & 2) != 0 ? directoryButtonConfiguration.isInGuild : z2, (i & 4) != 0 ? directoryButtonConfiguration.isRsvped : z3, (i & 8) != 0 ? directoryButtonConfiguration.isDetailView : z4, (i & 16) != 0 ? directoryButtonConfiguration.getPrimaryButtonOnClickListener() : view$OnClickListener, (i & 32) != 0 ? directoryButtonConfiguration.getSecondaryButtonOnClickListener() : view$OnClickListener2, (i & 64) != 0 ? directoryButtonConfiguration.getShareButtonOnClickListener() : view$OnClickListener3, (i & 128) != 0 ? directoryButtonConfiguration.getExtrasButtonOnClickListener() : view$OnClickListener4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsDetailView() {
        return this.isDetailView;
    }

    public final View$OnClickListener component5() {
        return getPrimaryButtonOnClickListener();
    }

    public final View$OnClickListener component6() {
        return getSecondaryButtonOnClickListener();
    }

    public final View$OnClickListener component7() {
        return getShareButtonOnClickListener();
    }

    public final View$OnClickListener component8() {
        return getExtrasButtonOnClickListener();
    }

    public final DirectoryButtonConfiguration copy(GuildScheduledEvent guildScheduledEvent, boolean isInGuild, boolean isRsvped, boolean isDetailView, View$OnClickListener primaryButtonOnClickListener, View$OnClickListener secondaryButtonOnClickListener, View$OnClickListener shareButtonOnClickListener, View$OnClickListener extrasButtonOnClickListener) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new DirectoryButtonConfiguration(guildScheduledEvent, isInGuild, isRsvped, isDetailView, primaryButtonOnClickListener, secondaryButtonOnClickListener, shareButtonOnClickListener, extrasButtonOnClickListener);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryButtonConfiguration)) {
            return false;
        }
        DirectoryButtonConfiguration directoryButtonConfiguration = (DirectoryButtonConfiguration) other;
        return m.areEqual(this.guildScheduledEvent, directoryButtonConfiguration.guildScheduledEvent) && this.isInGuild == directoryButtonConfiguration.isInGuild && this.isRsvped == directoryButtonConfiguration.isRsvped && this.isDetailView == directoryButtonConfiguration.isDetailView && m.areEqual(getPrimaryButtonOnClickListener(), directoryButtonConfiguration.getPrimaryButtonOnClickListener()) && m.areEqual(getSecondaryButtonOnClickListener(), directoryButtonConfiguration.getSecondaryButtonOnClickListener()) && m.areEqual(getShareButtonOnClickListener(), directoryButtonConfiguration.getShareButtonOnClickListener()) && m.areEqual(getExtrasButtonOnClickListener(), directoryButtonConfiguration.getExtrasButtonOnClickListener());
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View$OnClickListener getExtrasButtonOnClickListener() {
        return this.extrasButtonOnClickListener;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View$OnClickListener getPrimaryButtonOnClickListener() {
        return this.primaryButtonOnClickListener;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public boolean getPrimaryButtonVisible() {
        return this.primaryButtonVisible;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public int getSecondaryButtonBackground() {
        return this.secondaryButtonBackground;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public boolean getSecondaryButtonEnabled() {
        return this.secondaryButtonEnabled;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View$OnClickListener getSecondaryButtonOnClickListener() {
        return this.secondaryButtonOnClickListener;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public int getSecondaryButtonTextDrawableRes() {
        return this.secondaryButtonTextDrawableRes;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public boolean getSecondaryButtonVisible() {
        return this.secondaryButtonVisible;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View$OnClickListener getShareButtonOnClickListener() {
        return this.shareButtonOnClickListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
        boolean z2 = this.isInGuild;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.isRsvped;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.isDetailView;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        View$OnClickListener primaryButtonOnClickListener = getPrimaryButtonOnClickListener();
        int iHashCode2 = (i3 + (primaryButtonOnClickListener != null ? primaryButtonOnClickListener.hashCode() : 0)) * 31;
        View$OnClickListener secondaryButtonOnClickListener = getSecondaryButtonOnClickListener();
        int iHashCode3 = (iHashCode2 + (secondaryButtonOnClickListener != null ? secondaryButtonOnClickListener.hashCode() : 0)) * 31;
        View$OnClickListener shareButtonOnClickListener = getShareButtonOnClickListener();
        int iHashCode4 = (iHashCode3 + (shareButtonOnClickListener != null ? shareButtonOnClickListener.hashCode() : 0)) * 31;
        View$OnClickListener extrasButtonOnClickListener = getExtrasButtonOnClickListener();
        return iHashCode4 + (extrasButtonOnClickListener != null ? extrasButtonOnClickListener.hashCode() : 0);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* JADX INFO: renamed from: isAnyButtonVisible, reason: from getter */
    public boolean getIsAnyButtonVisible() {
        return this.isAnyButtonVisible;
    }

    public final boolean isDetailView() {
        return this.isDetailView;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* JADX INFO: renamed from: isExtrasVisible, reason: from getter */
    public boolean getIsExtrasVisible() {
        return this.isExtrasVisible;
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* JADX INFO: renamed from: isShareVisible, reason: from getter */
    public boolean getIsShareVisible() {
        return this.isShareVisible;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public CharSequence primaryButtonText(Context context) {
        m.checkNotNullParameter(context, "context");
        if (this.isInGuild) {
            return b.h(context, 2131891764, new Object[0], null, 4);
        }
        Object[] objArr = new Object[1];
        Guild guild = this.guildScheduledEvent.getGuild();
        objArr[0] = guild != null ? guild.getName() : null;
        return b.h(context, 2131892661, objArr, null, 4);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public CharSequence secondaryButtonText(Context context) {
        m.checkNotNullParameter(context, "context");
        return b.h(context, 2131892037, new Object[0], null, 4);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public int secondaryButtonTextColor(Context context) {
        m.checkNotNullParameter(context, "context");
        if (getSecondaryButtonEnabled()) {
            return (!this.isRsvped || this.isEventActive || this.isEventComplete) ? ColorCompat.getColor(context, 2131100487) : ColorCompat.getThemedColor(context, 2130968896);
        }
        return ColorCompat.getColor(context, 2131100525);
    }

    public String toString() {
        StringBuilder sbU = a.U("DirectoryButtonConfiguration(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", isInGuild=");
        sbU.append(this.isInGuild);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", isDetailView=");
        sbU.append(this.isDetailView);
        sbU.append(", primaryButtonOnClickListener=");
        sbU.append(getPrimaryButtonOnClickListener());
        sbU.append(", secondaryButtonOnClickListener=");
        sbU.append(getSecondaryButtonOnClickListener());
        sbU.append(", shareButtonOnClickListener=");
        sbU.append(getShareButtonOnClickListener());
        sbU.append(", extrasButtonOnClickListener=");
        sbU.append(getExtrasButtonOnClickListener());
        sbU.append(")");
        return sbU.toString();
    }
}
