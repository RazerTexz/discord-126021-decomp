package p007b.p008a.p050t.p051a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12084a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.a.v */
/* JADX INFO: compiled from: Xml.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1296v {

    /* JADX INFO: renamed from: a */
    public static final Pattern f1973a;

    /* JADX INFO: renamed from: b */
    public static final Pattern f1974b;

    /* JADX INFO: renamed from: c */
    public static final C1296v f1975c = new C1296v();

    /* JADX INFO: renamed from: b.a.t.a.v$a */
    /* JADX INFO: compiled from: Xml.kt */
    public static final class a<RC> extends Node.C5655a<RC> {

        /* JADX INFO: renamed from: a */
        public final String f1976a;

        /* JADX INFO: renamed from: b */
        public final String f1977b;

        /* JADX INFO: renamed from: c */
        public final C1280f<RC> f1978c;

        /* JADX INFO: renamed from: b.a.t.a.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Xml.kt */
        public static final /* synthetic */ class C13217a extends C12236k implements Function1<RC, Iterable<?>> {
            public C13217a(StyleNode.InterfaceC5656a interfaceC5656a) {
                super(1, interfaceC5656a, StyleNode.InterfaceC5656a.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Iterable;", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public Iterable<?> invoke(Object obj) {
                return ((StyleNode.InterfaceC5656a) this.receiver).get(obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, C1280f<RC> c1280f) {
            super(new Node[0]);
            C12238m.checkNotNullParameter(str, "opening");
            C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
            this.f1976a = str;
            this.f1977b = str2;
            this.f1978c = c1280f;
        }

        @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, RC rc) {
            Pair pairM10073to;
            C12238m.checkNotNullParameter(spannableStringBuilder, "builder");
            String str = this.f1976a;
            int length = str.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                }
                char cCharAt = str.charAt(i);
                if (C12084a.isWhitespace(cCharAt) || cCharAt == '/') {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                String str2 = this.f1976a;
                Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = str2.substring(0, i);
                C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String str3 = this.f1976a;
                Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                String strSubstring2 = str3.substring(i);
                C12238m.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                pairM10073to = C12116o.m10073to(strSubstring, strSubstring2);
            } else {
                pairM10073to = C12116o.m10073to(this.f1976a, "");
            }
            String str4 = (String) pairM10073to.component1();
            String str5 = (String) pairM10073to.component2();
            C13217a c13217a = new C13217a(this.f1978c.f1912g);
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) ('<' + str4));
            Iterator<?> it = c13217a.invoke(rc).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length2, spannableStringBuilder.length(), 33);
            }
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) (str5 + '>'));
            Iterator<?> it2 = this.f1978c.f1913h.get(rc).iterator();
            while (it2.hasNext()) {
                spannableStringBuilder.setSpan(it2.next(), length3, spannableStringBuilder.length() - 1, 33);
            }
            Iterator<?> it3 = c13217a.invoke(rc).iterator();
            while (it3.hasNext()) {
                spannableStringBuilder.setSpan(it3.next(), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            }
            super.render(spannableStringBuilder, rc);
            String str6 = this.f1977b;
            if (str6 == null || str6.length() == 0) {
                return;
            }
            int length4 = spannableStringBuilder.length();
            StringBuilder sbM833U = C1643a.m833U("</");
            sbM833U.append(this.f1977b);
            sbM833U.append('>');
            spannableStringBuilder.append((CharSequence) sbM833U.toString());
            Iterator<?> it4 = c13217a.invoke(rc).iterator();
            while (it4.hasNext()) {
                spannableStringBuilder.setSpan(it4.next(), length4 + 1, spannableStringBuilder.length(), 33);
            }
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("^<!--[\\s\\S]*?-->", 32);
        C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^<!--…*?-->\"\"\", Pattern.DOTALL)");
        f1973a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^<([\\s\\S]+?)(?:>(.*?)<\\/([\\s\\S]+?))?>", 32);
        C12238m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\n      \"…?))?>\"\"\", Pattern.DOTALL)");
        f1974b = patternCompile2;
    }
}
