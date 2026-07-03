package com.discord.widgets.guildscheduledevent;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Rules;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p050t.p052b.p054b.C1303e;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: GuildScheduledEventExternalLocationParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser$Companion$PARSER$2 extends AbstractC12240o implements Function0<Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState>> {
    public static final GuildScheduledEventExternalLocationParser$Companion$PARSER$2 INSTANCE = new GuildScheduledEventExternalLocationParser$Companion$PARSER$2();

    public GuildScheduledEventExternalLocationParser$Companion$PARSER$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        parser.addRule(Rules.INSTANCE.createUrlRule());
        parser.addRule(C1303e.f1988h.m374d());
        return parser;
    }
}
