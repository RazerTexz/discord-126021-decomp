package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChannelTopic$RenderedTopic {
    public static final WidgetChannelTopic$RenderedTopic$Companion Companion = new WidgetChannelTopic$RenderedTopic$Companion(null);
    public static final int MAX_LINES = 40;
    public static final int MIN_LINES = 2;
    private final int autoLinkMask;
    private final CharSequence channelName;
    private final CharSequence topic;

    public WidgetChannelTopic$RenderedTopic() {
        this(null, null, 0, 7, null);
    }

    public WidgetChannelTopic$RenderedTopic(CharSequence charSequence, CharSequence charSequence2, int i) {
        this.channelName = charSequence;
        this.topic = charSequence2;
        this.autoLinkMask = i;
    }

    public static /* synthetic */ WidgetChannelTopic$RenderedTopic copy$default(WidgetChannelTopic$RenderedTopic widgetChannelTopic$RenderedTopic, CharSequence charSequence, CharSequence charSequence2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = widgetChannelTopic$RenderedTopic.channelName;
        }
        if ((i2 & 2) != 0) {
            charSequence2 = widgetChannelTopic$RenderedTopic.topic;
        }
        if ((i2 & 4) != 0) {
            i = widgetChannelTopic$RenderedTopic.autoLinkMask;
        }
        return widgetChannelTopic$RenderedTopic.copy(charSequence, charSequence2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getChannelName() {
        return this.channelName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAutoLinkMask() {
        return this.autoLinkMask;
    }

    public final WidgetChannelTopic$RenderedTopic copy(CharSequence channelName, CharSequence topic, int autoLinkMask) {
        return new WidgetChannelTopic$RenderedTopic(channelName, topic, autoLinkMask);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChannelTopic$RenderedTopic)) {
            return false;
        }
        WidgetChannelTopic$RenderedTopic widgetChannelTopic$RenderedTopic = (WidgetChannelTopic$RenderedTopic) other;
        return m.areEqual(this.channelName, widgetChannelTopic$RenderedTopic.channelName) && m.areEqual(this.topic, widgetChannelTopic$RenderedTopic.topic) && this.autoLinkMask == widgetChannelTopic$RenderedTopic.autoLinkMask;
    }

    public final int getAutoLinkMask() {
        return this.autoLinkMask;
    }

    public final CharSequence getChannelName() {
        return this.channelName;
    }

    public final CharSequence getTopic() {
        return this.topic;
    }

    public int hashCode() {
        CharSequence charSequence = this.channelName;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.topic;
        return ((iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31) + this.autoLinkMask;
    }

    public String toString() {
        StringBuilder sbU = a.U("RenderedTopic(channelName=");
        sbU.append(this.channelName);
        sbU.append(", topic=");
        sbU.append(this.topic);
        sbU.append(", autoLinkMask=");
        return a.B(sbU, this.autoLinkMask, ")");
    }

    public /* synthetic */ WidgetChannelTopic$RenderedTopic(String str, CharSequence charSequence, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : charSequence, (i2 & 4) != 0 ? 0 : i);
    }
}
