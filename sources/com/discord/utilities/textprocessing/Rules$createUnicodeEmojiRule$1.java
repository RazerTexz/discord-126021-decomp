package com.discord.utilities.textprocessing;

import b.a.t.b.a.a;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$Companion;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createUnicodeEmojiRule$1<S, T> extends Rule<T, Node<T>, S> {
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createUnicodeEmojiRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group();
        ModelEmojiUnicode modelEmojiUnicode = Rules.access$getEmojiDataProvider$p(Rules.INSTANCE).getUnicodeEmojiSurrogateMap().get(strGroup);
        if (modelEmojiUnicode != null) {
            EmojiNode emojiNodeFrom$default = EmojiNode$Companion.from$default(EmojiNode.Companion, modelEmojiUnicode, 0, 2, (Object) null);
            m.checkNotNullParameter(emojiNodeFrom$default, "node");
            return new ParseSpec<>(emojiNodeFrom$default, state);
        }
        m.checkNotNullExpressionValue(strGroup, "match");
        a aVar = new a(strGroup);
        m.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, state);
    }
}
