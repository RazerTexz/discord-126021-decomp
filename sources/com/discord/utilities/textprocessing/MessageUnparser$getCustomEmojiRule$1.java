package com.discord.utilities.textprocessing;

import b.a.t.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: MessageUnparser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageUnparser$getCustomEmojiRule$1<S, T> extends Rule<T, Node<T>, S> {
    public final /* synthetic */ EmojiSet $emojiSet;
    public final /* synthetic */ MessageUnparser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageUnparser$getCustomEmojiRule$1(MessageUnparser messageUnparser, EmojiSet emojiSet, Pattern pattern) {
        super(pattern);
        this.this$0 = messageUnparser;
        this.$emojiSet = emojiSet;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        Emoji emoji = this.$emojiSet.emojiIndex.get(matcher.group(3));
        a aVar = new a(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + (emoji != null ? emoji.getFirstName() : matcher.group(2)) + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        m.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, state);
    }
}
