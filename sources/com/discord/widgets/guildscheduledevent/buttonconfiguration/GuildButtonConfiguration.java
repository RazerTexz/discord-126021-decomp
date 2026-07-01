package com.discord.widgets.guildscheduledevent.buttonconfiguration;

import android.content.Context;
import android.view.View$OnClickListener;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildButtonConfiguration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildButtonConfiguration implements ButtonConfiguration {
    private final boolean canConnect;
    private final boolean canConnectToChannel;
    private final boolean canRsvp;
    private final boolean canStartEvent;
    private final View$OnClickListener extrasButtonOnClickListener;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isAnyButtonVisible;
    private final boolean isConnected;
    private final boolean isDetailView;
    private final boolean isEndEventVisible;
    private final boolean isEventActive;
    private final boolean isEventComplete;
    private final boolean isExtrasVisible;
    private final boolean isInGuild;
    private final boolean isRsvped;
    private final boolean isShareVisible;
    private final View$OnClickListener onEndEventButtonClicked;
    private final View$OnClickListener onExtraButtonClicked;
    private final View$OnClickListener onJoinButtonClicked;
    private final View$OnClickListener onRsvpButtonClicked;
    private final View$OnClickListener onShareButtonClicked;
    private final View$OnClickListener onStartEventButtonClicked;
    private final View$OnClickListener primaryButtonOnClickListener;
    private final boolean primaryButtonVisible;
    private final int secondaryButtonBackground;
    private final boolean secondaryButtonEnabled;
    private final View$OnClickListener secondaryButtonOnClickListener;
    private final int secondaryButtonTextDrawableRes;
    private final boolean secondaryButtonVisible;
    private final View$OnClickListener shareButtonOnClickListener;
    private final GuildScheduledEventTiming timing;

    public GuildButtonConfiguration(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, View$OnClickListener view$OnClickListener, View$OnClickListener view$OnClickListener2, View$OnClickListener view$OnClickListener3, View$OnClickListener view$OnClickListener4, View$OnClickListener view$OnClickListener5, View$OnClickListener view$OnClickListener6) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEvent = guildScheduledEvent;
        this.canRsvp = z2;
        this.canStartEvent = z3;
        this.isConnected = z4;
        this.canConnect = z5;
        this.isInGuild = z6;
        this.isRsvped = z7;
        this.isDetailView = z8;
        this.onRsvpButtonClicked = view$OnClickListener;
        View$OnClickListener view$OnClickListener7 = view$OnClickListener2;
        this.onJoinButtonClicked = view$OnClickListener7;
        this.onEndEventButtonClicked = view$OnClickListener3;
        this.onStartEventButtonClicked = view$OnClickListener4;
        this.onShareButtonClicked = view$OnClickListener5;
        this.onExtraButtonClicked = view$OnClickListener6;
        GuildScheduledEventTiming eventTiming = GuildScheduledEventUtilitiesKt.getEventTiming(guildScheduledEvent);
        this.timing = eventTiming;
        boolean z9 = true;
        boolean z10 = guildScheduledEvent.getStatus() == GuildScheduledEventStatus.COMPLETED;
        this.isEventComplete = z10;
        boolean z11 = eventTiming == GuildScheduledEventTiming.LIVE;
        this.isEventActive = z11;
        this.canConnectToChannel = z5;
        boolean z12 = z8 && z11 && z4 && z3;
        this.isEndEventVisible = z12;
        this.primaryButtonVisible = (!z3 || z10) ? false : eventTiming.isStartable();
        this.primaryButtonOnClickListener = view$OnClickListener4;
        this.secondaryButtonVisible = z2;
        if (z12) {
            view$OnClickListener7 = view$OnClickListener3;
        } else if (!z11) {
            view$OnClickListener7 = view$OnClickListener;
        }
        this.secondaryButtonOnClickListener = view$OnClickListener7;
        this.secondaryButtonEnabled = !z10 && (!z11 || (guildScheduledEvent.getEntityType() != GuildScheduledEventEntityType.EXTERNAL && z5));
        this.secondaryButtonTextDrawableRes = (z11 || !getSecondaryButtonEnabled()) ? 0 : z7 ? 2131231652 : 2131231575;
        int i = 2131231008;
        if (!getSecondaryButtonEnabled()) {
            i = 2131231009;
        } else if (!z12) {
            if (z11) {
                i = 2131231007;
            } else if (z7) {
                i = 2131231010;
            }
        }
        this.secondaryButtonBackground = i;
        this.isShareVisible = !z10;
        this.shareButtonOnClickListener = view$OnClickListener5;
        this.isExtrasVisible = true;
        this.extrasButtonOnClickListener = view$OnClickListener6;
        if (!getSecondaryButtonVisible() && !getPrimaryButtonVisible() && !z12 && !getIsShareVisible()) {
            z9 = false;
        }
        this.isAnyButtonVisible = z9;
    }

    public static /* synthetic */ GuildButtonConfiguration copy$default(GuildButtonConfiguration guildButtonConfiguration, GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, View$OnClickListener view$OnClickListener, View$OnClickListener view$OnClickListener2, View$OnClickListener view$OnClickListener3, View$OnClickListener view$OnClickListener4, View$OnClickListener view$OnClickListener5, View$OnClickListener view$OnClickListener6, int i, Object obj) {
        return guildButtonConfiguration.copy((i & 1) != 0 ? guildButtonConfiguration.guildScheduledEvent : guildScheduledEvent, (i & 2) != 0 ? guildButtonConfiguration.canRsvp : z2, (i & 4) != 0 ? guildButtonConfiguration.canStartEvent : z3, (i & 8) != 0 ? guildButtonConfiguration.isConnected : z4, (i & 16) != 0 ? guildButtonConfiguration.canConnect : z5, (i & 32) != 0 ? guildButtonConfiguration.isInGuild : z6, (i & 64) != 0 ? guildButtonConfiguration.isRsvped : z7, (i & 128) != 0 ? guildButtonConfiguration.isDetailView : z8, (i & 256) != 0 ? guildButtonConfiguration.onRsvpButtonClicked : view$OnClickListener, (i & 512) != 0 ? guildButtonConfiguration.onJoinButtonClicked : view$OnClickListener2, (i & 1024) != 0 ? guildButtonConfiguration.onEndEventButtonClicked : view$OnClickListener3, (i & 2048) != 0 ? guildButtonConfiguration.onStartEventButtonClicked : view$OnClickListener4, (i & 4096) != 0 ? guildButtonConfiguration.onShareButtonClicked : view$OnClickListener5, (i & 8192) != 0 ? guildButtonConfiguration.onExtraButtonClicked : view$OnClickListener6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final View$OnClickListener getOnJoinButtonClicked() {
        return this.onJoinButtonClicked;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final View$OnClickListener getOnEndEventButtonClicked() {
        return this.onEndEventButtonClicked;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final View$OnClickListener getOnStartEventButtonClicked() {
        return this.onStartEventButtonClicked;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final View$OnClickListener getOnShareButtonClicked() {
        return this.onShareButtonClicked;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final View$OnClickListener getOnExtraButtonClicked() {
        return this.onExtraButtonClicked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanRsvp() {
        return this.canRsvp;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsDetailView() {
        return this.isDetailView;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final View$OnClickListener getOnRsvpButtonClicked() {
        return this.onRsvpButtonClicked;
    }

    public final GuildButtonConfiguration copy(GuildScheduledEvent guildScheduledEvent, boolean canRsvp, boolean canStartEvent, boolean isConnected, boolean canConnect, boolean isInGuild, boolean isRsvped, boolean isDetailView, View$OnClickListener onRsvpButtonClicked, View$OnClickListener onJoinButtonClicked, View$OnClickListener onEndEventButtonClicked, View$OnClickListener onStartEventButtonClicked, View$OnClickListener onShareButtonClicked, View$OnClickListener onExtraButtonClicked) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new GuildButtonConfiguration(guildScheduledEvent, canRsvp, canStartEvent, isConnected, canConnect, isInGuild, isRsvped, isDetailView, onRsvpButtonClicked, onJoinButtonClicked, onEndEventButtonClicked, onStartEventButtonClicked, onShareButtonClicked, onExtraButtonClicked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildButtonConfiguration)) {
            return false;
        }
        GuildButtonConfiguration guildButtonConfiguration = (GuildButtonConfiguration) other;
        return m.areEqual(this.guildScheduledEvent, guildButtonConfiguration.guildScheduledEvent) && this.canRsvp == guildButtonConfiguration.canRsvp && this.canStartEvent == guildButtonConfiguration.canStartEvent && this.isConnected == guildButtonConfiguration.isConnected && this.canConnect == guildButtonConfiguration.canConnect && this.isInGuild == guildButtonConfiguration.isInGuild && this.isRsvped == guildButtonConfiguration.isRsvped && this.isDetailView == guildButtonConfiguration.isDetailView && m.areEqual(this.onRsvpButtonClicked, guildButtonConfiguration.onRsvpButtonClicked) && m.areEqual(this.onJoinButtonClicked, guildButtonConfiguration.onJoinButtonClicked) && m.areEqual(this.onEndEventButtonClicked, guildButtonConfiguration.onEndEventButtonClicked) && m.areEqual(this.onStartEventButtonClicked, guildButtonConfiguration.onStartEventButtonClicked) && m.areEqual(this.onShareButtonClicked, guildButtonConfiguration.onShareButtonClicked) && m.areEqual(this.onExtraButtonClicked, guildButtonConfiguration.onExtraButtonClicked);
    }

    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final boolean getCanRsvp() {
        return this.canRsvp;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View$OnClickListener getExtrasButtonOnClickListener() {
        return this.extrasButtonOnClickListener;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final View$OnClickListener getOnEndEventButtonClicked() {
        return this.onEndEventButtonClicked;
    }

    public final View$OnClickListener getOnExtraButtonClicked() {
        return this.onExtraButtonClicked;
    }

    public final View$OnClickListener getOnJoinButtonClicked() {
        return this.onJoinButtonClicked;
    }

    public final View$OnClickListener getOnRsvpButtonClicked() {
        return this.onRsvpButtonClicked;
    }

    public final View$OnClickListener getOnShareButtonClicked() {
        return this.onShareButtonClicked;
    }

    public final View$OnClickListener getOnStartEventButtonClicked() {
        return this.onStartEventButtonClicked;
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
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
        boolean z2 = this.canRsvp;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.canStartEvent;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.isConnected;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        boolean z5 = this.canConnect;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        boolean z6 = this.isInGuild;
        ?? r6 = z6;
        if (z6) {
            r6 = 1;
        }
        int i5 = (i4 + r6) * 31;
        boolean z7 = this.isRsvped;
        ?? r7 = z7;
        if (z7) {
            r7 = 1;
        }
        int i6 = (i5 + r7) * 31;
        boolean z8 = this.isDetailView;
        int i7 = (i6 + (z8 ? 1 : z8)) * 31;
        View$OnClickListener view$OnClickListener = this.onRsvpButtonClicked;
        int iHashCode2 = (i7 + (view$OnClickListener != null ? view$OnClickListener.hashCode() : 0)) * 31;
        View$OnClickListener view$OnClickListener2 = this.onJoinButtonClicked;
        int iHashCode3 = (iHashCode2 + (view$OnClickListener2 != null ? view$OnClickListener2.hashCode() : 0)) * 31;
        View$OnClickListener view$OnClickListener3 = this.onEndEventButtonClicked;
        int iHashCode4 = (iHashCode3 + (view$OnClickListener3 != null ? view$OnClickListener3.hashCode() : 0)) * 31;
        View$OnClickListener view$OnClickListener4 = this.onStartEventButtonClicked;
        int iHashCode5 = (iHashCode4 + (view$OnClickListener4 != null ? view$OnClickListener4.hashCode() : 0)) * 31;
        View$OnClickListener view$OnClickListener5 = this.onShareButtonClicked;
        int iHashCode6 = (iHashCode5 + (view$OnClickListener5 != null ? view$OnClickListener5.hashCode() : 0)) * 31;
        View$OnClickListener view$OnClickListener6 = this.onExtraButtonClicked;
        return iHashCode6 + (view$OnClickListener6 != null ? view$OnClickListener6.hashCode() : 0);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* JADX INFO: renamed from: isAnyButtonVisible, reason: from getter */
    public boolean getIsAnyButtonVisible() {
        return this.isAnyButtonVisible;
    }

    public final boolean isConnected() {
        return this.isConnected;
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
        return b.h(context, 2131895865, new Object[0], null, 4);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public CharSequence secondaryButtonText(Context context) {
        int i;
        m.checkNotNullParameter(context, "context");
        if (this.isEventActive && this.guildScheduledEvent.getEntityType() == GuildScheduledEventEntityType.EXTERNAL) {
            i = 2131890131;
        } else {
            boolean z2 = this.isEventActive;
            if (z2 && !this.canConnectToChannel) {
                i = 2131887550;
            } else if (this.isEndEventVisible) {
                i = 2131888866;
            } else if (z2 && this.isConnected) {
                i = 2131889789;
            } else if (z2 && this.guildScheduledEvent.getEntityType() == GuildScheduledEventEntityType.VOICE) {
                i = 2131890091;
            } else if (this.isEventActive) {
                i = 2131895792;
            } else {
                i = this.isEventComplete ? 2131890087 : 2131892037;
            }
        }
        return b.h(context, i, new Object[0], null, 4);
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
        StringBuilder sbU = a.U("GuildButtonConfiguration(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", canRsvp=");
        sbU.append(this.canRsvp);
        sbU.append(", canStartEvent=");
        sbU.append(this.canStartEvent);
        sbU.append(", isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", canConnect=");
        sbU.append(this.canConnect);
        sbU.append(", isInGuild=");
        sbU.append(this.isInGuild);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", isDetailView=");
        sbU.append(this.isDetailView);
        sbU.append(", onRsvpButtonClicked=");
        sbU.append(this.onRsvpButtonClicked);
        sbU.append(", onJoinButtonClicked=");
        sbU.append(this.onJoinButtonClicked);
        sbU.append(", onEndEventButtonClicked=");
        sbU.append(this.onEndEventButtonClicked);
        sbU.append(", onStartEventButtonClicked=");
        sbU.append(this.onStartEventButtonClicked);
        sbU.append(", onShareButtonClicked=");
        sbU.append(this.onShareButtonClicked);
        sbU.append(", onExtraButtonClicked=");
        sbU.append(this.onExtraButtonClicked);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildButtonConfiguration(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, View$OnClickListener view$OnClickListener, View$OnClickListener view$OnClickListener2, View$OnClickListener view$OnClickListener3, View$OnClickListener view$OnClickListener4, View$OnClickListener view$OnClickListener5, View$OnClickListener view$OnClickListener6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildScheduledEvent, z2, z3, z4, z5, z6, z7, (i & 128) != 0 ? false : z8, (i & 256) != 0 ? null : view$OnClickListener, (i & 512) != 0 ? null : view$OnClickListener2, (i & 1024) != 0 ? null : view$OnClickListener3, (i & 2048) != 0 ? null : view$OnClickListener4, (i & 4096) != 0 ? null : view$OnClickListener5, (i & 8192) != 0 ? null : view$OnClickListener6);
    }
}
