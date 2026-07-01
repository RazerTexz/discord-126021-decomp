package com.discord.widgets.guildscheduledevent;

import b.a.t.b.b.SimpleMarkdownRules5;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Rules;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventExternalLocationParser$Companion$PARSER$2, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventExternalLocationParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser2 extends Lambda implements Function0<Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState>> {
    public static final GuildScheduledEventExternalLocationParser2 INSTANCE = new GuildScheduledEventExternalLocationParser2();

    public GuildScheduledEventExternalLocationParser2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        parser.addRule(Rules.INSTANCE.createUrlRule());
        parser.addRule(SimpleMarkdownRules5.h.d());
        return parser;
    }
}
