package com.discord.simpleast.core.parser;

import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Rule.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class Rule<R, T extends Node<R>, S> {
    private final Matcher matcher;

    /* JADX INFO: compiled from: Rule.kt */
    public static abstract class BlockRule<R, T extends Node<R>, S> extends Rule<R, T, S> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BlockRule(Pattern pattern) {
            super(pattern);
            C12238m.checkNotNullParameter(pattern, "pattern");
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
            C12238m.checkNotNullParameter(inspectionSource, "inspectionSource");
            if (lastCapture == null || C12106w.endsWith$default((CharSequence) lastCapture, '\n', false, 2, (Object) null)) {
                return super.match(inspectionSource, lastCapture, state);
            }
            return null;
        }
    }

    public Rule(Matcher matcher) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        this.matcher = matcher;
    }

    public final Matcher getMatcher() {
        return this.matcher;
    }

    public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
        C12238m.checkNotNullParameter(inspectionSource, "inspectionSource");
        this.matcher.reset(inspectionSource);
        if (this.matcher.find()) {
            return this.matcher;
        }
        return null;
    }

    public abstract ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super T, S> parser, S state);

    /* JADX WARN: Illegal instructions before constructor call */
    public Rule(Pattern pattern) {
        C12238m.checkNotNullParameter(pattern, "pattern");
        Matcher matcher = pattern.matcher("");
        C12238m.checkNotNullExpressionValue(matcher, "pattern.matcher(\"\")");
        this(matcher);
    }
}
