package b.a.t.a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import d0.g0.Regex5;
import d0.z.d.Intrinsics3;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* JADX INFO: renamed from: b.a.t.a.o, reason: use source file name */
/* JADX INFO: compiled from: Kotlin.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Kotlin2 {
    public static final String[] a = {"public|private|internal|inline|lateinit|abstract|open|reified", "import|package", "class|interface|data|enum|sealed|object|typealias", "fun|override|this|super|where|constructor|init|param|delegate", "const|val|var|get|final|vararg|it", "return|break|continue|suspend", "for|while|do|if|else|when|try|catch|finally|throw", "in|out|is|as|typeof", "shr|ushr|shl|ushl", "true|false|null"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f298b = {"true|false|Boolean|String|Char", "Int|UInt|Long|ULong|Float|Double|Byte|UByte|Short|UShort", "Self|Set|Map|MutableMap|List|MutableList|Array|Runnable|Unit", "arrayOf|listOf|mapOf|setOf|let|also|apply|run"};
    public static final Pattern c = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);
    public static final Pattern d = Pattern.compile("^@(\\w+)");
    public static final Pattern e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
    public static final Kotlin2 f = null;

    /* JADX INFO: renamed from: b.a.t.a.o$a */
    /* JADX INFO: compiled from: Kotlin.kt */
    public static final class a<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0020a f299b = new C0020a(null);
        public static final Pattern a = Pattern.compile("^(val|var)(\\s+\\w+)", 32);

        /* JADX INFO: renamed from: b.a.t.a.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Kotlin.kt */
        public static final class C0020a {
            public C0020a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, CodeStyleProviders<RC> codeStyleProviders) {
            super(new StyleNode.b(str, codeStyleProviders.d), new StyleNode.b(str2, codeStyleProviders.e));
            Intrinsics3.checkNotNullParameter(str, "definition");
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        }
    }

    /* JADX INFO: renamed from: b.a.t.a.o$b */
    /* JADX INFO: compiled from: Kotlin.kt */
    public static final class b<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f300b = new a(null);
        public static final Pattern a = new Regex("^(fun)( *<.*>)?( \\w+)( *\\(.*?\\))", Regex5.DOT_MATCHES_ALL).getNativePattern();

        /* JADX INFO: renamed from: b.a.t.a.o$b$a */
        /* JADX INFO: compiled from: Kotlin.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(String str, String str2, String str3, String str4, CodeStyleProviders<RC> codeStyleProviders) {
            Intrinsics3.checkNotNullParameter(str, "pre");
            Intrinsics3.checkNotNullParameter(str3, "signature");
            Intrinsics3.checkNotNullParameter(str4, "params");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            Node[] nodeArr = new Node[4];
            nodeArr[0] = new StyleNode.b(str, codeStyleProviders.d);
            nodeArr[1] = str2 != null ? new StyleNode.b(str2, codeStyleProviders.g) : null;
            nodeArr[2] = new StyleNode.b(str3, codeStyleProviders.e);
            nodeArr[3] = new StyleNode.b(str4, codeStyleProviders.h);
            super(nodeArr);
        }
    }
}
