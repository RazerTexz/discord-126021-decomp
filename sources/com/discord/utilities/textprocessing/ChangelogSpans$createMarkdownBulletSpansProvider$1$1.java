package com.discord.utilities.textprocessing;

import android.text.style.ParagraphStyle;
import com.discord.utilities.spans.BulletSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans$createMarkdownBulletSpansProvider$1$1 extends o implements Function0<List<? extends ParagraphStyle>> {
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
    public /* bridge */ /* synthetic */ List<? extends ParagraphStyle> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ParagraphStyle> invoke2() {
        int i = this.$bulletVerticalPadding;
        return n.listOf((Object[]) new ParagraphStyle[]{new VerticalPaddingSpan(i, i), new BulletSpan(this.$bulletGapWidth, this.$bulletColor, 8, 0.0f, null, 24, null)});
    }
}
