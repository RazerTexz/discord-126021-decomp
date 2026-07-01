package com.discord.utilities.textprocessing;

import android.text.TextUtils;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createCustomEmojiRule$1<S, T> extends Rule<T, EmojiNode<T>, S> {
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createCustomEmojiRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super EmojiNode<T>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        boolean zIsEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(2);
        m.checkNotNull(strGroup);
        long longOrDefault$default = Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(3), 0L, 1, null);
        EmojiNode emojiNode = new EmojiNode(strGroup, new Rules$createCustomEmojiRule$1$parse$emojiNode$1(longOrDefault$default, zIsEmpty), new EmojiNode$EmojiIdAndType$Custom(longOrDefault$default, zIsEmpty, strGroup), 0, 0, 24, null);
        m.checkNotNullParameter(emojiNode, "node");
        return new ParseSpec<>(emojiNode, state);
    }
}
