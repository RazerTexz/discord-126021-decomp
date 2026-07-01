package com.discord.widgets.guildscheduledevent;

import b.d.b.a.a;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded extends WidgetGuildScheduledEventCreateSuccessViewModel$ViewState {
    private final boolean showInviteSettings;
    private final WidgetInviteModel widgetInviteModel;

    public /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded(WidgetInviteModel widgetInviteModel, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetInviteModel, (i & 2) != 0 ? true : z2);
    }

    public static /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded copy$default(WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded, WidgetInviteModel widgetInviteModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetInviteModel = widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded.widgetInviteModel;
        }
        if ((i & 2) != 0) {
            z2 = widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded.showInviteSettings;
        }
        return widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded.copy(widgetInviteModel, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetInviteModel getWidgetInviteModel() {
        return this.widgetInviteModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowInviteSettings() {
        return this.showInviteSettings;
    }

    public final WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded copy(WidgetInviteModel widgetInviteModel, boolean showInviteSettings) {
        m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
        return new WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded(widgetInviteModel, showInviteSettings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded = (WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded) other;
        return m.areEqual(this.widgetInviteModel, widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded.widgetInviteModel) && this.showInviteSettings == widgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded.showInviteSettings;
    }

    public final boolean getShowInviteSettings() {
        return this.showInviteSettings;
    }

    public final WidgetInviteModel getWidgetInviteModel() {
        return this.widgetInviteModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        WidgetInviteModel widgetInviteModel = this.widgetInviteModel;
        int iHashCode = (widgetInviteModel != null ? widgetInviteModel.hashCode() : 0) * 31;
        boolean z2 = this.showInviteSettings;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(widgetInviteModel=");
        sbU.append(this.widgetInviteModel);
        sbU.append(", showInviteSettings=");
        return a.O(sbU, this.showInviteSettings, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded(WidgetInviteModel widgetInviteModel, boolean z2) {
        super(null);
        m.checkNotNullParameter(widgetInviteModel, "widgetInviteModel");
        this.widgetInviteModel = widgetInviteModel;
        this.showInviteSettings = z2;
    }
}
