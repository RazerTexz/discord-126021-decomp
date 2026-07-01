package com.discord.widgets.guildscheduledevent;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventExternalLocationParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser$Companion {
    private GuildScheduledEventExternalLocationParser$Companion() {
    }

    public static final /* synthetic */ Parser access$getPARSER$p(GuildScheduledEventExternalLocationParser$Companion guildScheduledEventExternalLocationParser$Companion) {
        return guildScheduledEventExternalLocationParser$Companion.getPARSER();
    }

    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getPARSER() {
        Lazy lazyAccess$getPARSER$cp = GuildScheduledEventExternalLocationParser.access$getPARSER$cp();
        GuildScheduledEventExternalLocationParser$Companion guildScheduledEventExternalLocationParser$Companion = GuildScheduledEventExternalLocationParser.Companion;
        return (Parser) lazyAccess$getPARSER$cp.getValue();
    }

    public /* synthetic */ GuildScheduledEventExternalLocationParser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
