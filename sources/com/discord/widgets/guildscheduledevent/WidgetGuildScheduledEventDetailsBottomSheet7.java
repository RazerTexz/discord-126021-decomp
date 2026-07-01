package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet7 extends Lambda implements Function0<GuildScheduledEventExternalLocationParser> {
    public static final WidgetGuildScheduledEventDetailsBottomSheet7 INSTANCE = new WidgetGuildScheduledEventDetailsBottomSheet7();

    public WidgetGuildScheduledEventDetailsBottomSheet7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventExternalLocationParser invoke() {
        return new GuildScheduledEventExternalLocationParser();
    }
}
