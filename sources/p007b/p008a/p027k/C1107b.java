package p007b.p008a.p027k;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.Parser;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p008a.p027k.p030g.AbstractC1116b;
import p007b.p008a.p027k.p030g.C1115a;
import p007b.p008a.p027k.p030g.C1117c;
import p007b.p008a.p050t.p052b.p054b.C1306h;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.b */
/* JADX INFO: compiled from: FormatUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1107b {

    /* JADX INFO: renamed from: a */
    public static final Regex f1489a = new Regex("\\{(\\S+?)\\}");

    /* JADX INFO: renamed from: b.a.k.b$a */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class a extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final a f1490j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$b */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class b extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final b f1491j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$c */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class c extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final c f1492j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$d */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class d extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final d f1493j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$e */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class e extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final e f1494j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$f */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class f extends AbstractC12240o implements Function1<MatchResult, CharSequence> {
        public final /* synthetic */ Map $namedArgs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Map map) {
            super(1);
            this.$namedArgs = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(MatchResult matchResult) {
            MatchResult matchResult2 = matchResult;
            C12238m.checkNotNullParameter(matchResult2, "matchResult");
            String str = (String) this.$namedArgs.get(matchResult2.getGroupValues().get(1));
            return str != null ? str : matchResult2.getValue();
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$g */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class g extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final g f1495j = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.k.b$h */
    /* JADX INFO: compiled from: FormatUtils.kt */
    public static final class h extends AbstractC12240o implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: j */
        public static final h f1496j = new h();

        public h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m209a(TextView textView, CharSequence charSequence) {
        C12238m.checkNotNullParameter(textView, "$this$bindText");
        textView.setText(charSequence);
        textView.setVisibility((charSequence == null || charSequence.length() == 0) ^ true ? 0 : 8);
    }

    /* JADX INFO: renamed from: b */
    public static final CharSequence m210b(Context context, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        C12238m.checkNotNullParameter(context, "$this$i18nFormat");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(function1, "initializer");
        Resources resources = context.getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        return m211c(resources, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: c */
    public static final CharSequence m211c(Resources resources, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        C12238m.checkNotNullParameter(resources, "$this$i18nFormat");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(function1, "initializer");
        String string = resources.getString(i);
        C12238m.checkNotNullExpressionValue(string, "getString(stringResId)");
        return m215g(string, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: d */
    public static final CharSequence m212d(View view, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        C12238m.checkNotNullParameter(view, "$this$i18nFormat");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(function1, "initializer");
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        return m210b(context, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: e */
    public static final CharSequence m213e(Fragment fragment, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        C12238m.checkNotNullParameter(fragment, "$this$i18nFormat");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(function1, "initializer");
        Context contextRequireContext = fragment.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return m210b(contextRequireContext, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    /* JADX INFO: renamed from: f */
    public static final CharSequence m214f(CharSequence charSequence, Object[] objArr, RenderContext renderContext) {
        C12238m.checkNotNullParameter(charSequence, "$this$i18nFormat");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        Map<String, String> map = renderContext.args;
        List<? extends Object> list = renderContext.orderedArguments;
        boolean z2 = true;
        if (!map.isEmpty()) {
            charSequence = f1489a.replace(charSequence, new f(map));
        } else {
            if (list != null && !list.isEmpty()) {
                z2 = false;
            }
            if (!z2) {
                String strReplace = f1489a.replace(charSequence, "%s");
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                charSequence = C1643a.m828P(objArrCopyOf, objArrCopyOf.length, strReplace, "java.lang.String.format(this, *args)");
            }
        }
        C1106a c1106a = C1106a.f1486d;
        AbstractC1116b abstractC1116b = C1106a.f1483a;
        if (abstractC1116b == null) {
            C12238m.throwUninitializedPropertyAccessException("formattingParserProvider");
        }
        C1115a c1115aMo224a = abstractC1116b.mo224a();
        if (renderContext.uppercase) {
            String string = charSequence.toString();
            Locale locale = Locale.ROOT;
            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            charSequence = string.toUpperCase(locale);
            C12238m.checkNotNullExpressionValue(charSequence, "(this as java.lang.String).toUpperCase(locale)");
        }
        CharSequence charSequence2 = charSequence;
        Objects.requireNonNull(c1115aMo224a);
        C12238m.checkNotNullParameter(charSequence2, "input");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        List list2 = Parser.parse$default(c1115aMo224a, charSequence2, new C1117c(false, 0, 3), null, 4, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        C1306h.m375a(spannableStringBuilder, list2, renderContext);
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: g */
    public static final CharSequence m215g(CharSequence charSequence, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        C12238m.checkNotNullParameter(charSequence, "$this$i18nFormat");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(function1, "initializer");
        return m214f(charSequence, objArr, C1460d.m470R1(function1, Arrays.copyOf(objArr, objArr.length)));
    }

    /* JADX INFO: renamed from: m */
    public static final void m221m(TextView textView, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        C12238m.checkNotNullParameter(textView, "$this$i18nSetText");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(function1, "initializer");
        RenderContext renderContextM470R1 = C1460d.m470R1(function1, Arrays.copyOf(objArr, objArr.length));
        textView.setMovementMethod(renderContextM470R1.hasClickables ? LinkMovementMethod.getInstance() : null);
        String string = textView.getContext().getString(i);
        C12238m.checkNotNullExpressionValue(string, "context.getString(stringResId)");
        textView.setText(m214f(string, objArr, renderContextM470R1));
    }

    /* JADX INFO: renamed from: o */
    public static void m223o(TextView textView, CharSequence charSequence, Object[] objArr, Function1 function1, int i) {
        h hVar = (i & 4) != 0 ? h.f1496j : null;
        C12238m.checkNotNullParameter(textView, "$this$i18nSetText");
        C12238m.checkNotNullParameter(objArr, "formatArgs");
        C12238m.checkNotNullParameter(hVar, "initializer");
        if (charSequence == null) {
            textView.setText((CharSequence) null);
            textView.setMovementMethod(null);
        } else {
            RenderContext renderContextM470R1 = C1460d.m470R1(hVar, Arrays.copyOf(objArr, objArr.length));
            textView.setMovementMethod(renderContextM470R1.hasClickables ? LinkMovementMethod.getInstance() : null);
            textView.setText(m214f(charSequence, objArr, renderContextM470R1));
        }
    }
}
