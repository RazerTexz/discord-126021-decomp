package com.discord.utilities.textprocessing;

import android.text.style.ParagraphStyle;
import com.discord.utilities.spans.BulletSpan;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createMarkdownBulletSpansProvider$1$1, reason: use source file name */
/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans2 extends Lambda implements Function0<List<? extends ParagraphStyle>> {
    public final /* synthetic */ int $bulletColor;
    public final /* synthetic */ int $bulletGapWidth;
    public final /* synthetic */ int $bulletVerticalPadding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangelogSpans2(int i, int i2, int i3) {
        super(0);
        this.$bulletVerticalPadding = i;
        this.$bulletGapWidth = i2;
        this.$bulletColor = i3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends ParagraphStyle> invoke() {
        int i = this.$bulletVerticalPadding;
        return Collections2.listOf((Object[]) new ParagraphStyle[]{new VerticalPaddingSpan(i, i), new BulletSpan(this.$bulletGapWidth, this.$bulletColor, 8, 0.0f, null, 24, null)});
    }
}
