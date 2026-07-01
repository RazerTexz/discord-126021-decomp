package com.discord.simpleast.core.parser;

import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import d0.g0.w;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Rule.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class Rule$BlockRule<R, T extends Node<R>, S> extends Rule<R, T, S> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Rule$BlockRule(Pattern pattern) {
        super(pattern);
        m.checkNotNullParameter(pattern, "pattern");
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public Matcher match(CharSequence inspectionSource, String lastCapture, S state) {
        m.checkNotNullParameter(inspectionSource, "inspectionSource");
        if (lastCapture == null || w.endsWith$default((CharSequence) lastCapture, '\n', false, 2, (Object) null)) {
            return super.match(inspectionSource, lastCapture, state);
        }
        return null;
    }
}
