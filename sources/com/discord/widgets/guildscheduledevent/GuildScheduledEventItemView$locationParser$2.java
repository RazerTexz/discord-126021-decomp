package com.discord.widgets.guildscheduledevent;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: GuildScheduledEventItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventItemView$locationParser$2 extends AbstractC12240o implements Function0<GuildScheduledEventExternalLocationParser> {
    public static final GuildScheduledEventItemView$locationParser$2 INSTANCE = new GuildScheduledEventItemView$locationParser$2();

    public GuildScheduledEventItemView$locationParser$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventExternalLocationParser invoke() {
        return new GuildScheduledEventExternalLocationParser();
    }
}
