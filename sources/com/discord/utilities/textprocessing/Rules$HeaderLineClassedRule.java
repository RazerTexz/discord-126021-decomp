package com.discord.utilities.textprocessing;

import android.text.style.CharacterStyle;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.c.a$a;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import d0.z.d.m;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$HeaderLineClassedRule<RC, T, S> extends a$a<RC, Object, S> {
    private final Function0<List<Object>> headerPaddingSpanProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Rules$HeaderLineClassedRule(Function0<? extends List<? extends Object>> function0, Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2) {
        super(function1, function2);
        m.checkNotNullParameter(function0, "headerPaddingSpanProvider");
        m.checkNotNullParameter(function1, "styleSpanProvider");
        m.checkNotNullParameter(function2, "classSpanProvider");
        this.headerPaddingSpanProvider = function0;
    }

    @Override // b.a.t.c.a$a, b.a.t.c.a$b, b.a.t.c.a$c, com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        Node<RC> node = super.parse(matcher, parser, state).root;
        StyleNode styleNode = new StyleNode(this.headerPaddingSpanProvider.invoke());
        styleNode.addChild(node);
        m.checkNotNullParameter(styleNode, "node");
        return new ParseSpec<>(styleNode, state);
    }
}
