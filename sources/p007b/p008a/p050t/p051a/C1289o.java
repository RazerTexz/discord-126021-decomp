package p007b.p008a.p050t.p051a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import p507d0.p579g0.EnumC12092i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.a.o */
/* JADX INFO: compiled from: Kotlin.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1289o {

    /* JADX INFO: renamed from: a */
    public static final String[] f1943a = {"public|private|internal|inline|lateinit|abstract|open|reified", "import|package", "class|interface|data|enum|sealed|object|typealias", "fun|override|this|super|where|constructor|init|param|delegate", "const|val|var|get|final|vararg|it", "return|break|continue|suspend", "for|while|do|if|else|when|try|catch|finally|throw", "in|out|is|as|typeof", "shr|ushr|shl|ushl", "true|false|null"};

    /* JADX INFO: renamed from: b */
    public static final String[] f1944b = {"true|false|Boolean|String|Char", "Int|UInt|Long|ULong|Float|Double|Byte|UByte|Short|UShort", "Self|Set|Map|MutableMap|List|MutableList|Array|Runnable|Unit", "arrayOf|listOf|mapOf|setOf|let|also|apply|run"};

    /* JADX INFO: renamed from: c */
    public static final Pattern f1945c = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);

    /* JADX INFO: renamed from: d */
    public static final Pattern f1946d = Pattern.compile("^@(\\w+)");

    /* JADX INFO: renamed from: e */
    public static final Pattern f1947e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");

    /* JADX INFO: renamed from: f */
    public static final C1289o f1948f = null;

    /* JADX INFO: renamed from: b.a.t.a.o$a */
    /* JADX INFO: compiled from: Kotlin.kt */
    public static final class a<RC> extends Node.C5655a<RC> {

        /* JADX INFO: renamed from: b */
        public static final C13215a f1950b = new C13215a(null);

        /* JADX INFO: renamed from: a */
        public static final Pattern f1949a = Pattern.compile("^(val|var)(\\s+\\w+)", 32);

        /* JADX INFO: renamed from: b.a.t.a.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Kotlin.kt */
        public static final class C13215a {
            public C13215a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, C1280f<RC> c1280f) {
            super(new StyleNode.C5657b(str, c1280f.f1909d), new StyleNode.C5657b(str2, c1280f.f1910e));
            C12238m.checkNotNullParameter(str, "definition");
            C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        }
    }

    /* JADX INFO: renamed from: b.a.t.a.o$b */
    /* JADX INFO: compiled from: Kotlin.kt */
    public static final class b<RC> extends Node.C5655a<RC> {

        /* JADX INFO: renamed from: b */
        public static final a f1952b = new a(null);

        /* JADX INFO: renamed from: a */
        public static final Pattern f1951a = new Regex("^(fun)( *<.*>)?( \\w+)( *\\(.*?\\))", EnumC12092i.DOT_MATCHES_ALL).getNativePattern();

        /* JADX INFO: renamed from: b.a.t.a.o$b$a */
        /* JADX INFO: compiled from: Kotlin.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(String str, String str2, String str3, String str4, C1280f<RC> c1280f) {
            C12238m.checkNotNullParameter(str, "pre");
            C12238m.checkNotNullParameter(str3, "signature");
            C12238m.checkNotNullParameter(str4, "params");
            C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
            Node[] nodeArr = new Node[4];
            nodeArr[0] = new StyleNode.C5657b(str, c1280f.f1909d);
            nodeArr[1] = str2 != null ? new StyleNode.C5657b(str2, c1280f.f1912g) : null;
            nodeArr[2] = new StyleNode.C5657b(str3, c1280f.f1910e);
            nodeArr[3] = new StyleNode.C5657b(str4, c1280f.f1913h);
            super(nodeArr);
        }
    }
}
