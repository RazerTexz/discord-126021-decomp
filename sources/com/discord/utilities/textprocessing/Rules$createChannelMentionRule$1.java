package com.discord.utilities.textprocessing;

import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.node.ChannelMentionNode;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createChannelMentionRule$1<S, T> extends Rule<T, ChannelMentionNode<T>, S> {
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createChannelMentionRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super ChannelMentionNode<T>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        ChannelMentionNode channelMentionNode = new ChannelMentionNode(Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
        m.checkNotNullParameter(channelMentionNode, "node");
        return new ParseSpec<>(channelMentionNode, state);
    }
}
