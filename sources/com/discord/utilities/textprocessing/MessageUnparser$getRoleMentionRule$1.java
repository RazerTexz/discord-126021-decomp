package com.discord.utilities.textprocessing;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.s;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: MessageUnparser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageUnparser$getRoleMentionRule$1<S, T> extends Rule<T, Node<T>, S> {
    public final /* synthetic */ List $guildRoles;
    public final /* synthetic */ MessageUnparser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageUnparser$getRoleMentionRule$1(MessageUnparser messageUnparser, List list, Pattern pattern) {
        super(pattern);
        this.this$0 = messageUnparser;
        this.$guildRoles = list;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
        T next;
        String strGroup;
        Long longOrNull;
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup2 = matcher.group(1);
        long jLongValue = (strGroup2 == null || (longOrNull = s.toLongOrNull(strGroup2)) == null) ? -1L : longOrNull.longValue();
        Iterator<T> it = this.$guildRoles.iterator();
        do {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
        } while (!(((GuildRole) next).getId() == jLongValue));
        GuildRole guildRole = next;
        if (guildRole != null) {
            StringBuilder sbQ = a.Q(MentionUtilsKt.MENTIONS_CHAR);
            sbQ.append(guildRole.getName());
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
