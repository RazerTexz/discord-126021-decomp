package com.discord.widgets.channels.list;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelListUnreads$Model {
    public static final WidgetChannelListUnreads$Model$Companion Companion = new WidgetChannelListUnreads$Model$Companion(null);
    public static final int INVALID_INDEX = -1;
    public static final int TYPE_MENTION = 0;
    public static final int TYPE_UNREAD = 1;
    private final WidgetChannelListUnreads$Model$Indicator bottomIndicator;
    private final WidgetChannelListUnreads$Model$Indicator topIndicator;

    public WidgetChannelListUnreads$Model() {
        this(null, null, 3, null);
    }

    public WidgetChannelListUnreads$Model(WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator, WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator2) {
        this.topIndicator = widgetChannelListUnreads$Model$Indicator;
        this.bottomIndicator = widgetChannelListUnreads$Model$Indicator2;
    }

    public static /* synthetic */ WidgetChannelListUnreads$Model copy$default(WidgetChannelListUnreads$Model widgetChannelListUnreads$Model, WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator, WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator2, int i, Object obj) {
        if ((i & 1) != 0) {
            widgetChannelListUnreads$Model$Indicator = widgetChannelListUnreads$Model.topIndicator;
        }
        if ((i & 2) != 0) {
            widgetChannelListUnreads$Model$Indicator2 = widgetChannelListUnreads$Model.bottomIndicator;
        }
        return widgetChannelListUnreads$Model.copy(widgetChannelListUnreads$Model$Indicator, widgetChannelListUnreads$Model$Indicator2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final WidgetChannelListUnreads$Model$Indicator getTopIndicator() {
        return this.topIndicator;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetChannelListUnreads$Model$Indicator getBottomIndicator() {
        return this.bottomIndicator;
    }

    public final WidgetChannelListUnreads$Model copy(WidgetChannelListUnreads$Model$Indicator topIndicator, WidgetChannelListUnreads$Model$Indicator bottomIndicator) {
        return new WidgetChannelListUnreads$Model(topIndicator, bottomIndicator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelListUnreads$Model)) {
            return false;
        }
        WidgetChannelListUnreads$Model widgetChannelListUnreads$Model = (WidgetChannelListUnreads$Model) other;
        return m.areEqual(this.topIndicator, widgetChannelListUnreads$Model.topIndicator) && m.areEqual(this.bottomIndicator, widgetChannelListUnreads$Model.bottomIndicator);
    }

    public final WidgetChannelListUnreads$Model$Indicator getBottomIndicator() {
        return this.bottomIndicator;
    }

    public final WidgetChannelListUnreads$Model$Indicator getTopIndicator() {
        return this.topIndicator;
    }

    public int hashCode() {
        WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator = this.topIndicator;
        int iHashCode = (widgetChannelListUnreads$Model$Indicator != null ? widgetChannelListUnreads$Model$Indicator.hashCode() : 0) * 31;
        WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator2 = this.bottomIndicator;
        return iHashCode + (widgetChannelListUnreads$Model$Indicator2 != null ? widgetChannelListUnreads$Model$Indicator2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(topIndicator=");
        sbU.append(this.topIndicator);
        sbU.append(", bottomIndicator=");
        sbU.append(this.bottomIndicator);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetChannelListUnreads$Model(WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator, WidgetChannelListUnreads$Model$Indicator widgetChannelListUnreads$Model$Indicator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : widgetChannelListUnreads$Model$Indicator, (i & 2) != 0 ? null : widgetChannelListUnreads$Model$Indicator2);
    }
}
