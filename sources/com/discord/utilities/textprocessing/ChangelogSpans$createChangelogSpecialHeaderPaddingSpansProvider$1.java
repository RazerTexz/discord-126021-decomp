package com.discord.utilities.textprocessing;

import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.t.m;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans$createChangelogSpecialHeaderPaddingSpansProvider$1 extends o implements Function0<List<? extends VerticalPaddingSpan>> {
    public final /* synthetic */ int $headerBottomPx;
    public final /* synthetic */ int $headerTopPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangelogSpans$createChangelogSpecialHeaderPaddingSpansProvider$1(int i, int i2) {
        super(0);
        this.$headerTopPx = i;
        this.$headerBottomPx = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends VerticalPaddingSpan> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends VerticalPaddingSpan> invoke2() {
        return m.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
    }
}
