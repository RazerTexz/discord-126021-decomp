package b.a.k;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import b.a.k.g.FormattingParser;
import b.a.k.g.FormattingParserProvider;
import b.a.k.g.ParseState;
import b.a.t.b.b.SimpleRenderer;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.Parser;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: renamed from: b.a.k.b, reason: use source file name */
/* JADX INFO: compiled from: FormatUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FormatUtils {
    public static final Regex a = new Regex("\\{(\\S+?)\\}");

    /* JADX INFO: renamed from: b.a.k.b$a */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class a extends Lambda implements Function1<RenderContext, Unit> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$b */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class b extends Lambda implements Function1<RenderContext, Unit> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$c */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class c extends Lambda implements Function1<RenderContext, Unit> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$d */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class d extends Lambda implements Function1<RenderContext, Unit> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$e */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class e extends Lambda implements Function1<RenderContext, Unit> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$f */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class f extends Lambda implements Function1<MatchResult, CharSequence> {
        public final /* synthetic */ Map $namedArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Map map) {
            super(1);
            this.$namedArgs = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(MatchResult matchResult) {
            MatchResult matchResult2 = matchResult;
            Intrinsics3.checkNotNullParameter(matchResult2, "matchResult");
            String str = (String) this.$namedArgs.get(matchResult2.getGroupValues().get(1));
            return str != null ? str : matchResult2.getValue();
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$g */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class g extends Lambda implements Function1<RenderContext, Unit> {
        public static final g j = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$h */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class h extends Lambda implements Function1<RenderContext, Unit> {
        public static final h j = new h();

        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            return Unit.a;
        }
    }

    public static final void a(TextView textView, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(textView, "$this$bindText");
        textView.setText(charSequence);
        textView.setVisibility((charSequence == null || charSequence.length() == 0) ^ true ? 0 : 8);
    }

    public static final CharSequence b(Context context, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(context, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return c(resources, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence c(Resources resources, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(resources, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        String string = resources.getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "getString(stringResId)");
        return g(string, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence d(View view, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(view, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        return b(context, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence e(Fragment fragment, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return b(contextRequireContext, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence f(CharSequence charSequence, Object[] objArr, RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        Map<String, String> map = renderContext.args;
        List<? extends Object> list = renderContext.orderedArguments;
        boolean z2 = true;
        if (!map.isEmpty()) {
            charSequence = a.replace(charSequence, new f(map));
        } else {
            if (list != null && !list.isEmpty()) {
                z2 = false;
            }
            if (!z2) {
                String strReplace = a.replace(charSequence, "%s");
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                charSequence = outline.P(objArrCopyOf, objArrCopyOf.length, strReplace, "java.lang.String.format(this, *args)");
            }
        }
        Format format = Format.d;
        FormattingParserProvider formattingParserProvider = Format.a;
        if (formattingParserProvider == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("formattingParserProvider");
        }
        FormattingParser formattingParserA = formattingParserProvider.a();
        if (renderContext.uppercase) {
            String string = charSequence.toString();
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            charSequence = string.toUpperCase(locale);
            Intrinsics3.checkNotNullExpressionValue(charSequence, "(this as java.lang.String).toUpperCase(locale)");
        }
        CharSequence charSequence2 = charSequence;
        Objects.requireNonNull(formattingParserA);
        Intrinsics3.checkNotNullParameter(charSequence2, "input");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        List list2 = Parser.parse$default(formattingParserA, charSequence2, new ParseState(false, 0, 3), null, 4, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SimpleRenderer.a(spannableStringBuilder, list2, renderContext);
        return spannableStringBuilder;
    }

    public static final CharSequence g(CharSequence charSequence, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$i18nFormat");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        return f(charSequence, objArr, AnimatableValueParser.R1(function1, Arrays.copyOf(objArr, objArr.length)));
    }

    public static final void m(TextView textView, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "$this$i18nSetText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(function1, "initializer");
        RenderContext renderContextR1 = AnimatableValueParser.R1(function1, Arrays.copyOf(objArr, objArr.length));
        textView.setMovementMethod(renderContextR1.hasClickables ? LinkMovementMethod.getInstance() : null);
        String string = textView.getContext().getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
        textView.setText(f(string, objArr, renderContextR1));
    }

    public static void o(TextView textView, CharSequence charSequence, Object[] objArr, Function1 function1, int i) {
        h hVar = (i & 4) != 0 ? h.j : null;
        Intrinsics3.checkNotNullParameter(textView, "$this$i18nSetText");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        Intrinsics3.checkNotNullParameter(hVar, "initializer");
        if (charSequence == null) {
            textView.setText((CharSequence) null);
            textView.setMovementMethod(null);
        } else {
            RenderContext renderContextR1 = AnimatableValueParser.R1(hVar, Arrays.copyOf(objArr, objArr.length));
            textView.setMovementMethod(renderContextR1.hasClickables ? LinkMovementMethod.getInstance() : null);
            textView.setText(f(charSequence, objArr, renderContextR1));
        }
    }
}
