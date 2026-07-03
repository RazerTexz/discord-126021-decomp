package com.discord.utilities.textprocessing;

import android.text.style.ParagraphStyle;
import com.discord.utilities.spans.BulletSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans$createMarkdownBulletSpansProvider$1$1 extends AbstractC12240o implements Function0<List<? extends ParagraphStyle>> {
    public final /* synthetic */ int $bulletColor;
    public final /* synthetic */ int $bulletGapWidth;
    public final /* synthetic */ int $bulletVerticalPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangelogSpans$createMarkdownBulletSpansProvider$1$1(int i, int i2, int i3) {
        super(0);
        this.$bulletVerticalPadding = i;
        this.$bulletGapWidth = i2;
        this.$bulletColor = i3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends ParagraphStyle> invoke() {
        int i = this.$bulletVerticalPadding;
        return C12147n.listOf((Object[]) new ParagraphStyle[]{new VerticalPaddingSpan(i, i), new BulletSpan(this.$bulletGapWidth, this.$bulletColor, 8, 0.0f, null, 24, null)});
    }
}
