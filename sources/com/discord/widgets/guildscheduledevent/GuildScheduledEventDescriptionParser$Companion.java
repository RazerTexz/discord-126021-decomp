package com.discord.widgets.guildscheduledevent;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser$Companion {
    private GuildScheduledEventDescriptionParser$Companion() {
    }

    public static final /* synthetic */ Parser access$getINSTANCE$p(GuildScheduledEventDescriptionParser$Companion guildScheduledEventDescriptionParser$Companion) {
        return guildScheduledEventDescriptionParser$Companion.getINSTANCE();
    }

    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> getINSTANCE() {
        Lazy lazyAccess$getINSTANCE$cp = GuildScheduledEventDescriptionParser.access$getINSTANCE$cp();
        GuildScheduledEventDescriptionParser$Companion guildScheduledEventDescriptionParser$Companion = GuildScheduledEventDescriptionParser.Companion;
        return (Parser) lazyAccess$getINSTANCE$cp.getValue();
    }

    public /* synthetic */ GuildScheduledEventDescriptionParser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
