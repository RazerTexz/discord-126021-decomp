package com.discord.widgets.changelog;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.b.e;
import b.a.t.c.a$c;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.simpleast.core.parser.Rule$BlockRule;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.ChangelogSpans;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.Rules;
import com.discord.utilities.textprocessing.Rules$HeaderLineClassedRule;
import com.discord.utilities.textprocessing.Rules$MarkdownListItemRule;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ChangeLogParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangeLogParser {
    public static final ChangeLogParser INSTANCE = new ChangeLogParser();

    private ChangeLogParser() {
    }

    private final <RC, S> List<Rule<RC, Node<RC>, S>> createChangelogSpecialMarkdownRules(Context context) {
        ChangelogSpans changelogSpans = ChangelogSpans.INSTANCE;
        return n.listOf((Object[]) new Rule$BlockRule[]{new Rules$HeaderLineClassedRule(changelogSpans.createChangelogSpecialHeaderPaddingSpansProvider(context), changelogSpans.createHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules$HeaderLineClassedRule(changelogSpans.createHeaderPaddingSpansProvider(context), changelogSpans.createSpecialHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules$MarkdownListItemRule(changelogSpans.createMarkdownBulletSpansProvider(context))});
    }

    private final <RC, S> List<Rule<RC, Node<RC>, S>> createMarkdownRules(Context context) {
        ChangelogSpans changelogSpans = ChangelogSpans.INSTANCE;
        return n.listOf((Object[]) new Rule$BlockRule[]{new a$c(changelogSpans.createHeaderStyleSpanProvider(context)), new Rules$HeaderLineClassedRule(changelogSpans.createHeaderPaddingSpansProvider(context), changelogSpans.createHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules$MarkdownListItemRule(changelogSpans.createMarkdownBulletSpansProvider(context))});
    }

    public static /* synthetic */ DraweeSpanStringBuilder parse$default(ChangeLogParser changeLogParser, Context context, CharSequence charSequence, boolean z2, Function3 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return changeLogParser.parse(context, charSequence, z2, function3);
    }

    public final DraweeSpanStringBuilder parse(Context context, CharSequence input, boolean changeLogRules, Function3<? super Context, ? super String, ? super String, Unit> onClickListener) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(onClickListener, "onClickListener");
        List listB = e.b(false, false, 3);
        List listCreateChangelogSpecialMarkdownRules = changeLogRules ? createChangelogSpecialMarkdownRules(context) : createMarkdownRules(context);
        Parser parser = new Parser(false, 1, null);
        Rules rules = Rules.INSTANCE;
        return AstRenderer.render(Parser.parse$default(parser.addRule(rules.createSoftHyphenRule()).addRule(rules.createBlockQuoteRule()).addRule(rules.createMaskedLinkRule()).addRule(rules.createUrlNoEmbedRule()).addRule(rules.createUrlRule()).addRule(rules.createHookedLinkRule()).addRules(listCreateChangelogSpecialMarkdownRules).addRules(listB), input, MessageParseState.Companion.getInitialState(), null, 4, null), new ChangeLogParser$parse$renderContext$1(onClickListener, context));
    }
}
