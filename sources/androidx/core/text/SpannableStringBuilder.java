package androidx.core.text;

import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: androidx.core.text.SpannableStringBuilderKt, reason: use source file name */
/* JADX INFO: compiled from: SpannableStringBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableStringBuilder {
    public static final android.text.SpannableStringBuilder backgroundColor(android.text.SpannableStringBuilder spannableStringBuilder, @ColorInt int i, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder bold(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final SpannedString buildSpannedString(Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        function1.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    public static final android.text.SpannableStringBuilder color(android.text.SpannableStringBuilder spannableStringBuilder, @ColorInt int i, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder inSpans(android.text.SpannableStringBuilder spannableStringBuilder, Object[] objArr, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(objArr, "spans");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        int length2 = objArr.length;
        int i = 0;
        while (i < length2) {
            Object obj = objArr[i];
            i++;
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder italic(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder scale(android.text.SpannableStringBuilder spannableStringBuilder, float f, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f);
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder strikeThrough(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder subscript(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder superscript(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder underline(android.text.SpannableStringBuilder spannableStringBuilder, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static final android.text.SpannableStringBuilder inSpans(android.text.SpannableStringBuilder spannableStringBuilder, Object obj, Function1<? super android.text.SpannableStringBuilder, Unit> function1) {
        Intrinsics3.checkNotNullParameter(spannableStringBuilder, "<this>");
        Intrinsics3.checkNotNullParameter(obj, "span");
        Intrinsics3.checkNotNullParameter(function1, "builderAction");
        int length = spannableStringBuilder.length();
        function1.invoke(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
