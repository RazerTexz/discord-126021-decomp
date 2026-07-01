package com.discord.utilities.textprocessing;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import com.discord.R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.VerticalPaddingSpan;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChangelogSpans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChangelogSpans {
    public static final ChangelogSpans INSTANCE = new ChangelogSpans();
    private static final int MARKDOWN_BULLET_RADIUS = 8;

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createChangelogSpecialHeaderPaddingSpansProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends VerticalPaddingSpan> invoke() {
            return CollectionsJVM.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderClassSpanProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ int $marginTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, int i) {
            super(1);
            this.$context = context;
            this.$marginTopPx = i;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "className");
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

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderPaddingSpansProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends VerticalPaddingSpan>> {
        public final /* synthetic */ int $headerBottomPx;
        public final /* synthetic */ int $headerTopPx;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, int i2) {
            super(0);
            this.$headerTopPx = i;
            this.$headerBottomPx = i2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends VerticalPaddingSpan> invoke() {
            return CollectionsJVM.listOf(new VerticalPaddingSpan(this.$headerTopPx, this.$headerBottomPx));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createHeaderStyleSpanProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
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

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.ChangelogSpans$createSpecialHeaderStyleSpanProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChangelogSpans.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, CharacterStyle> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
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
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_changelog_special_top_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<String, Object> createHeaderClassSpanProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context, context.getResources().getDimensionPixelSize(R.dimen.markdown_header_class_marginTop));
    }

    public final Function0<List<VerticalPaddingSpan>> createHeaderPaddingSpansProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_top_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_header_1_bottom_padding));
    }

    public final Function1<Integer, CharacterStyle> createHeaderStyleSpanProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context);
    }

    public final Function0<List<ParagraphStyle>> createMarkdownBulletSpansProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new ChangelogSpans2(context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_vertical_padding), context.getResources().getDimensionPixelSize(R.dimen.markdown_bullet_gap), ColorCompat.getThemedColor(context, R.attr.color_brand_500));
    }

    public final Function1<Integer, CharacterStyle> createSpecialHeaderStyleSpanProvider(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return new AnonymousClass1(context);
    }
}
