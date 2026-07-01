package com.discord.utilities.textprocessing;

import android.text.TextUtils;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.node.UserMentionNode;
import com.discord.utilities.textprocessing.node.UserMentionNode$Type;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S, T] */
/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createUserMentionRule$1<S, T> extends Rule<T, Node<T>, S> {
    public final /* synthetic */ Rules this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rules$createUserMentionRule$1(Rules rules, Pattern pattern) {
        super(pattern);
        this.this$0 = rules;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<T, S> parse(Matcher matcher, Parser<T, ? super Node<T>, S> parser, S state) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        if (!TextUtils.isEmpty(matcher.group(1))) {
            UserMentionNode userMentionNode = new UserMentionNode(UserMentionNode$Type.USER, Rules.toLongOrDefault$default(Rules.INSTANCE, matcher.group(1), 0L, 1, null));
            m.checkNotNullParameter(userMentionNode, "node");
            return new ParseSpec<>(userMentionNode, state);
        }
        String strGroup = matcher.group(2);
        m.checkNotNull(strGroup);
        UserMentionNode userMentionNode2 = new UserMentionNode(strGroup.charAt(0) != 'e' ? UserMentionNode$Type.HERE : UserMentionNode$Type.EVERYONE, 0L, 2, null);
        m.checkNotNullParameter(userMentionNode2, "node");
        return new ParseSpec<>(userMentionNode2, state);
    }
}
