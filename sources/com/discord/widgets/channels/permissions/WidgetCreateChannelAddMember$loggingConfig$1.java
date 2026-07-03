package com.discord.widgets.channels.permissions;

import com.discord.analytics.generated.events.impression.TrackImpressionChannelAddMembers;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public static final WidgetCreateChannelAddMember$loggingConfig$1 INSTANCE = new WidgetCreateChannelAddMember$loggingConfig$1();

    public WidgetCreateChannelAddMember$loggingConfig$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionChannelAddMembers trackImpressionChannelAddMembers = new TrackImpressionChannelAddMembers();
        trackImpressionChannelAddMembers.m7516e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.CHANNEL_ADD_FLOW, 7));
        return trackImpressionChannelAddMembers;
    }
}
