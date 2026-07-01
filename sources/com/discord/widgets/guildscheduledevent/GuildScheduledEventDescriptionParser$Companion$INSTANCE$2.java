package com.discord.widgets.guildscheduledevent;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildScheduledEventDescriptionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDescriptionParser$Companion$INSTANCE$2 extends o implements Function0<Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState>> {
    public static final GuildScheduledEventDescriptionParser$Companion$INSTANCE$2 INSTANCE = new GuildScheduledEventDescriptionParser$Companion$INSTANCE$2();

    public GuildScheduledEventDescriptionParser$Companion$INSTANCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        return DiscordParser.createParser$default(false, true, false, false, false, 24, null);
    }
}
