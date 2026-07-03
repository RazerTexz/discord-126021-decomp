package com.discord.utilities.textprocessing;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.VerticalPaddingSpan;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans {
    public static final ChangelogSpans INSTANCE = new ChangelogSpans();
    private static final int MARKDOWN_BULLET_RADIUS = 8;

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createChangelogSpecialHeaderPaddingSpansProvider$1 */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class C69391 extends AbstractC12240o implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69391(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends VerticalPaddingSpan> invoke() {
            return C12145m.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderClassSpanProvider$1 */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class C69401 extends AbstractC12240o implements Function1<String, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ int $marginTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69401(Context context, int i) {
            super(1);
            this.$context = context;
            this.$marginTopPx = i;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(String str) {
            C12238m.checkNotNullParameter(str, "className");
            switch (str.hashCode()) {
                case -1269237627:
                    if (str.equals("changelogSpecial")) {
                        return new TextAppearanceSpan(this.$context, 2131952041);
                    }
                    return null;
                case -1044792121:
                    if (str.equals("marginTop")) {
                        return new VerticalPaddingSpan(0, this.$marginTopPx);
                    }
                    return null;
                case -1001078227:
                    if (str.equals("progress")) {
                        return new TextAppearanceSpan(this.$context, 2131952039);
                    }
                    return null;
                case -419685396:
                    if (str.equals("improved")) {
                        return new TextAppearanceSpan(this.$context, 2131952038);
                    }
                    return null;
                case 92659968:
                    if (str.equals("added")) {
                        return new TextAppearanceSpan(this.$context, 2131952036);
                    }
                    return null;
                case 97445748:
                    if (str.equals("fixed")) {
                        return new TextAppearanceSpan(this.$context, 2131952037);
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderPaddingSpansProvider$1 */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class C69411 extends AbstractC12240o implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69411(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends VerticalPaddingSpan> invoke() {
            return C12145m.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderStyleSpanProvider$1 */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class C69421 extends AbstractC12240o implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69421(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharacterStyle invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharacterStyle invoke(int i) {
            if (i != 1) {
                return i != 4 ? new StyleSpan(3) : new TextAppearanceSpan(this.$context, 2131952040);
            }
            return new TextAppearanceSpan(this.$context, 2131952035);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createSpecialHeaderStyleSpanProvider$1 */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class C69431 extends AbstractC12240o implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69431(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharacterStyle invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharacterStyle invoke(int i) {
            if (i != 1) {
                return i != 4 ? new StyleSpan(3) : new TextAppearanceSpan(this.$context, 2131952040);
            }
            return new TextAppearanceSpan(this.$context, 2131952041);
        }
    }

    private ChangelogSpans() {
    }

    public final Function0<List<VerticalPaddingSpan>> createChangelogSpecialHeaderPaddingSpansProvider(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        return new C69391(context.getResources().getDimensionPixelSize(C5419R.dimen.markdown_header_1_changelog_special_top_padding), context.getResources().getDimensionPixelSize(C5419R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<String, Object> createHeaderClassSpanProvider(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        return new C69401(context, context.getResources().getDimensionPixelSize(C5419R.dimen.markdown_header_class_marginTop));
    }

    public final Function0<List<VerticalPaddingSpan>> createHeaderPaddingSpansProvider(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        return new C69411(context.getResources().getDimensionPixelSize(C5419R.dimen.markdown_header_1_top_padding), context.getResources().getDimensionPixelSize(C5419R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<Integer, CharacterStyle> createHeaderStyleSpanProvider(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        return new C69421(context);
    }

    public final Function0<List<ParagraphStyle>> createMarkdownBulletSpansProvider(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        return new ChangelogSpans$createMarkdownBulletSpansProvider$1$1(context.getResources().getDimensionPixelSize(C5419R.dimen.markdown_bullet_vertical_padding), context.getResources().getDimensionPixelSize(C5419R.dimen.markdown_bullet_gap), ColorCompat.getThemedColor(context, C5419R.attr.color_brand_500));
    }

    public final Function1<Integer, CharacterStyle> createSpecialHeaderStyleSpanProvider(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        return new C69431(context);
    }
}
