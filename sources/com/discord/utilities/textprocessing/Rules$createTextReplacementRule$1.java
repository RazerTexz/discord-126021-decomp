package com.discord.utilities.textprocessing;

import b.a.t.b.b.e;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createTextReplacementRule$1<S, T> extends Rule<T, Node<T>, S> {
    private final List<Rule<T, Node<T>, S>> innerRules;
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createTextReplacementRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
        this.innerRules = n.listOf((Object[]) new Rule[]{Rules.INSTANCE.createNamedEmojiRule(), e.h.d()});
    }

    public final List<Rule<T, Node<T>, S>> getInnerRules() {
        return this.innerRules;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
        Node node;
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        Rules rules = Rules.INSTANCE;
        String strGroup = matcher.group();
        m.checkNotNullExpressionValue(strGroup, "matcher.group()");
        List<T> list = parser.parse(Rules.access$replaceEmojiSurrogates(rules, strGroup), state, this.innerRules);
        if (list.size() == 1) {
            Object objFirst = u.first((List<? extends Object>) list);
            Objects.requireNonNull(objFirst, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
            node = (Node) objFirst;
        } else {
            StyleNode styleNode = new StyleNode(n.emptyList());
            for (Object obj : list) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<T>");
                styleNode.addChild((Node) obj);
            }
            node = styleNode;
        }
        m.checkNotNullParameter(node, "node");
        return new ParseSpec<>(node, state);
    }
}
