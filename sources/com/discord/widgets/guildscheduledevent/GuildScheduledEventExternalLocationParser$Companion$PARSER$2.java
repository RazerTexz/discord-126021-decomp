package com.discord.widgets.guildscheduledevent;

import b.a.t.b.b.e;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Rules;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildScheduledEventExternalLocationParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser$Companion$PARSER$2 extends o implements Function0<Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState>> {
    public static final GuildScheduledEventExternalLocationParser$Companion$PARSER$2 INSTANCE = new GuildScheduledEventExternalLocationParser$Companion$PARSER$2();

    public GuildScheduledEventExternalLocationParser$Companion$PARSER$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        parser.addRule(Rules.INSTANCE.createUrlRule());
        parser.addRule(e.h.d());
        return parser;
    }
}
