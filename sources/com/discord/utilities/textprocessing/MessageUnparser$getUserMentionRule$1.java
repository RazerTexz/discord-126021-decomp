package com.discord.utilities.textprocessing;

import b.d.b.a.a;
import com.discord.models.user.User;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.s;
import d0.z.d.m;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: MessageUnparser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageUnparser$getUserMentionRule$1<S, T> extends Rule<T, Node<T>, S> {
    public final /* synthetic */ Map $users;
    public final /* synthetic */ MessageUnparser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageUnparser$getUserMentionRule$1(MessageUnparser messageUnparser, Map map, Pattern pattern) {
        super(pattern);
        this.this$0 = messageUnparser;
        this.$users = map;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
        String strGroup;
        Long longOrNull;
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup2 = matcher.group(1);
        User user = (User) this.$users.get(Long.valueOf((strGroup2 == null || (longOrNull = s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue()));
        if (user != null) {
            StringBuilder sbQ = a.Q(MentionUtilsKt.MENTIONS_CHAR);
            sbQ.append(user.getUsername());
            sbQ.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            strGroup = sbQ.toString();
        } else {
            strGroup = matcher.group();
        }
        m.checkNotNullExpressionValue(strGroup, "content");
        b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
        m.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, state);
    }
}
