package com.discord.utilities.textprocessing;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import com.discord.R$attr;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans {
    public static final ChangelogSpans INSTANCE = new ChangelogSpans();
    private static final int MARKDOWN_BULLET_RADIUS = 8;

    private ChangelogSpans() {
    }

    public final Function0<List<VerticalPaddingSpan>> createChangelogSpecialHeaderPaddingSpansProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createChangelogSpecialHeaderPaddingSpansProvider$1(context.getResources().getDimensionPixelSize(2131165475), context.getResources().getDimensionPixelSize(2131165474));
    }

    public final Function1<String, Object> createHeaderClassSpanProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createHeaderClassSpanProvider$1(context, context.getResources().getDimensionPixelSize(2131165477));
    }

    public final Function0<List<VerticalPaddingSpan>> createHeaderPaddingSpansProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createHeaderPaddingSpansProvider$1(context.getResources().getDimensionPixelSize(2131165476), context.getResources().getDimensionPixelSize(2131165474));
    }

    public final Function1<Integer, CharacterStyle> createHeaderStyleSpanProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createHeaderStyleSpanProvider$1(context);
    }

    public final Function0<List<ParagraphStyle>> createMarkdownBulletSpansProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createMarkdownBulletSpansProvider$1$1(context.getResources().getDimensionPixelSize(2131165471), context.getResources().getDimensionPixelSize(2131165470), ColorCompat.getThemedColor(context, R$attr.color_brand_500));
    }

    public final Function1<Integer, CharacterStyle> createSpecialHeaderStyleSpanProvider(Context context) {
        m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createSpecialHeaderStyleSpanProvider$1(context);
    }
}
