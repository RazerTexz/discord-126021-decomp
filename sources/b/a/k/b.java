package b.a.k;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import b.a.t.b.b.h;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.Parser;
import d0.z.d.m;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;

/* JADX INFO: compiled from: FormatUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final Regex a = new Regex("\\{(\\S+?)\\}");

    public static final void a(TextView textView, CharSequence charSequence) {
        m.checkNotNullParameter(textView, "$this$bindText");
        textView.setText(charSequence);
        textView.setVisibility((charSequence == null || charSequence.length() == 0) ^ true ? 0 : 8);
    }

    public static final CharSequence b(Context context, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        m.checkNotNullParameter(context, "$this$i18nFormat");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(function1, "initializer");
        Resources resources = context.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        return c(resources, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence c(Resources resources, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        m.checkNotNullParameter(resources, "$this$i18nFormat");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(function1, "initializer");
        String string = resources.getString(i);
        m.checkNotNullExpressionValue(string, "getString(stringResId)");
        return g(string, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence d(View view, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        m.checkNotNullParameter(view, "$this$i18nFormat");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(function1, "initializer");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "context");
        return b(context, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence e(Fragment fragment, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        m.checkNotNullParameter(fragment, "$this$i18nFormat");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(function1, "initializer");
        Context contextRequireContext = fragment.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return b(contextRequireContext, i, Arrays.copyOf(objArr, objArr.length), function1);
    }

    public static final CharSequence f(CharSequence charSequence, Object[] objArr, RenderContext renderContext) {
        m.checkNotNullParameter(charSequence, "$this$i18nFormat");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(renderContext, "renderContext");
        Map<String, String> map = renderContext.args;
        List<? extends Object> list = renderContext.orderedArguments;
        boolean z2 = true;
        if (!map.isEmpty()) {
            charSequence = a.replace(charSequence, new b$f(map));
        } else {
            if (list != null && !list.isEmpty()) {
                z2 = false;
            }
            if (!z2) {
                String strReplace = a.replace(charSequence, "%s");
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                charSequence = b.d.b.a.a.P(objArrCopyOf, objArrCopyOf.length, strReplace, "java.lang.String.format(this, *args)");
            }
        }
        a aVar = a.d;
        b.a.k.g.b bVar = a.a;
        if (bVar == null) {
            m.throwUninitializedPropertyAccessException("formattingParserProvider");
        }
        b.a.k.g.a aVarA = bVar.a();
        if (renderContext.uppercase) {
            String string = charSequence.toString();
            Locale locale = Locale.ROOT;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            charSequence = string.toUpperCase(locale);
            m.checkNotNullExpressionValue(charSequence, "(this as java.lang.String).toUpperCase(locale)");
        }
        CharSequence charSequence2 = charSequence;
        Objects.requireNonNull(aVarA);
        m.checkNotNullParameter(charSequence2, "input");
        m.checkNotNullParameter(renderContext, "renderContext");
        List list2 = Parser.parse$default(aVarA, charSequence2, new b.a.k.g.c(false, 0, 3), null, 4, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        h.a(spannableStringBuilder, list2, renderContext);
        return spannableStringBuilder;
    }

    public static final CharSequence g(CharSequence charSequence, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        m.checkNotNullParameter(charSequence, "$this$i18nFormat");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(function1, "initializer");
        return f(charSequence, objArr, b.c.a.a0.d.R1(function1, Arrays.copyOf(objArr, objArr.length)));
    }

    public static /* synthetic */ CharSequence h(Context context, int i, Object[] objArr, Function1 function1, int i2) {
        return b(context, i, objArr, (i2 & 4) != 0 ? b$b.j : null);
    }

    public static /* synthetic */ CharSequence i(Resources resources, int i, Object[] objArr, Function1 function1, int i2) {
        return c(resources, i, objArr, (i2 & 4) != 0 ? b$d.j : null);
    }

    public static /* synthetic */ CharSequence j(View view, int i, Object[] objArr, Function1 function1, int i2) {
        return d(view, i, objArr, (i2 & 4) != 0 ? b$c.j : null);
    }

    public static /* synthetic */ CharSequence k(Fragment fragment, int i, Object[] objArr, Function1 function1, int i2) {
        return e(fragment, i, objArr, (i2 & 4) != 0 ? b$a.j : null);
    }

    public static /* synthetic */ CharSequence l(CharSequence charSequence, Object[] objArr, Function1 function1, int i) {
        return g(charSequence, objArr, (i & 2) != 0 ? b$e.j : null);
    }

    public static final void m(TextView textView, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        m.checkNotNullParameter(textView, "$this$i18nSetText");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(function1, "initializer");
        RenderContext renderContextR1 = b.c.a.a0.d.R1(function1, Arrays.copyOf(objArr, objArr.length));
        textView.setMovementMethod(renderContextR1.hasClickables ? LinkMovementMethod.getInstance() : null);
        String string = textView.getContext().getString(i);
        m.checkNotNullExpressionValue(string, "context.getString(stringResId)");
        textView.setText(f(string, objArr, renderContextR1));
    }

    public static /* synthetic */ void n(TextView textView, int i, Object[] objArr, Function1 function1, int i2) {
        m(textView, i, objArr, (i2 & 4) != 0 ? b$g.j : null);
    }

    public static void o(TextView textView, CharSequence charSequence, Object[] objArr, Function1 function1, int i) {
        b$h b_h = (i & 4) != 0 ? b$h.j : null;
        m.checkNotNullParameter(textView, "$this$i18nSetText");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(b_h, "initializer");
        if (charSequence == null) {
            textView.setText((CharSequence) null);
            textView.setMovementMethod(null);
        } else {
            RenderContext renderContextR1 = b.c.a.a0.d.R1(b_h, Arrays.copyOf(objArr, objArr.length));
            textView.setMovementMethod(renderContextR1.hasClickables ? LinkMovementMethod.getInstance() : null);
            textView.setText(f(charSequence, objArr, renderContextR1));
        }
    }
}
