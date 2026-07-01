package com.discord.utilities.textprocessing;

import androidx.exifinterface.media.ExifInterface;
import b.a.t.c.a;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule$BlockRule;
import d0.z.d.m;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$MarkdownListItemRule<RC, S> extends Rule$BlockRule<RC, Node<RC>, S> {
    private final Function0<List<Object>> spansProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Rules$MarkdownListItemRule(Function0<? extends List<? extends Object>> function0) {
        super(a.a);
        m.checkNotNullParameter(function0, "spansProvider");
        a aVar = a.e;
        this.spansProvider = function0;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        StyleNode styleNode = new StyleNode(this.spansProvider.invoke());
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        m.checkNotNullParameter(styleNode, "node");
        return new ParseSpec<>(styleNode, state, iStart, iEnd);
    }
}
