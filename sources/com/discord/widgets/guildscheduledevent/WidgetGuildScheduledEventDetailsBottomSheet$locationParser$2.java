package com.discord.widgets.guildscheduledevent;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2 extends AbstractC12240o implements Function0<GuildScheduledEventExternalLocationParser> {
    public static final WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2 INSTANCE = new WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2();

    public WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventExternalLocationParser invoke() {
        return new GuildScheduledEventExternalLocationParser();
    }
}
