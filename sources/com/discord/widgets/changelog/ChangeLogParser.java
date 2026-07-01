package com.discord.widgets.changelog;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.b.SimpleMarkdownRules5;
import b.a.t.c.MarkdownRules;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.ChangelogSpans;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.Rules;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
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
        return Collections2.listOf((Object[]) new Rule.BlockRule[]{new Rules.HeaderLineClassedRule(changelogSpans.createChangelogSpecialHeaderPaddingSpansProvider(context), changelogSpans.createHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules.HeaderLineClassedRule(changelogSpans.createHeaderPaddingSpansProvider(context), changelogSpans.createSpecialHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules.MarkdownListItemRule(changelogSpans.createMarkdownBulletSpansProvider(context))});
    }

    private final <RC, S> List<Rule<RC, Node<RC>, S>> createMarkdownRules(Context context) {
        ChangelogSpans changelogSpans = ChangelogSpans.INSTANCE;
        return Collections2.listOf((Object[]) new Rule.BlockRule[]{new MarkdownRules.c(changelogSpans.createHeaderStyleSpanProvider(context)), new Rules.HeaderLineClassedRule(changelogSpans.createHeaderPaddingSpansProvider(context), changelogSpans.createHeaderStyleSpanProvider(context), changelogSpans.createHeaderClassSpanProvider(context)), new Rules.MarkdownListItemRule(changelogSpans.createMarkdownBulletSpansProvider(context))});
    }

    public static /* synthetic */ DraweeSpanStringBuilder parse$default(ChangeLogParser changeLogParser, Context context, CharSequence charSequence, boolean z2, Function3 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return changeLogParser.parse(context, charSequence, z2, function3);
    }

    public final DraweeSpanStringBuilder parse(Context context, CharSequence input, boolean changeLogRules, Function3<? super Context, ? super String, ? super String, Unit> onClickListener) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(onClickListener, "onClickListener");
        List listB = SimpleMarkdownRules5.b(false, false, 3);
        List listCreateChangelogSpecialMarkdownRules = changeLogRules ? createChangelogSpecialMarkdownRules(context) : createMarkdownRules(context);
        Parser parser = new Parser(false, 1, null);
        Rules rules = Rules.INSTANCE;
        return AstRenderer.render(Parser.parse$default(parser.addRule(rules.createSoftHyphenRule()).addRule(rules.createBlockQuoteRule()).addRule(rules.createMaskedLinkRule()).addRule(rules.createUrlNoEmbedRule()).addRule(rules.createUrlRule()).addRule(rules.createHookedLinkRule()).addRules(listCreateChangelogSpecialMarkdownRules).addRules(listB), input, MessageParseState.INSTANCE.getInitialState(), null, 4, null), new ChangeLogParser2(onClickListener, context));
    }
}
