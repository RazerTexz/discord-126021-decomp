package b.a.t.a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import d0.g0.Regex5;
import d0.z.d.Intrinsics3;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* JADX INFO: renamed from: b.a.t.a.k, reason: use source file name */
/* JADX INFO: compiled from: JavaScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class JavaScript2 {
    public static final String[] a = {"import|from|export|default|package", "class|enum", "function|super|extends|implements|arguments", "var|let|const|static|get|set|new", "return|break|continue|yield|void", "if|else|for|while|do|switch|async|await|case|try|catch|finally|delete|throw|NaN|Infinity", "of|in|instanceof|typeof", "debugger|with", "true|false|null|undefined"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f294b = {"String|Boolean|RegExp|Number|Date|Math|JSON|Symbol|BigInt|Atomics|DataView", "Function|Promise|Generator|GeneratorFunction|AsyncFunction|AsyncGenerator|AsyncGeneratorFunction", "Array|Object|Map|Set|WeakMap|WeakSet|Int8Array|Int16Array|Int32Array|Uint8Array|Uint16Array", "Uint32Array|Uint8ClampedArray|Float32Array|Float64Array|BigInt64Array|BigUint64Array|Buffer", "ArrayBuffer|SharedArrayBuffer", "Reflect|Proxy|Intl|WebAssembly", "console|process|require|isNaN|parseInt|parseFloat|encodeURI|decodeURI|encodeURIComponent", "decodeURIComponent|this|global|globalThis|eval|isFinite|module", "setTimeout|setInterval|clearTimeout|clearInterval|setImmediate|clearImmediate", "queueMicrotask|document|window", "Error|SyntaxError|TypeError|RangeError|ReferenceError|EvalError|InternalError|URIError", "AggregateError|escape|unescape|URL|URLSearchParams|TextEncoder|TextDecoder", "AbortController|AbortSignal|EventTarget|Event|MessageChannel", "MessagePort|MessageEvent|FinalizationRegistry|WeakRef", "regeneratorRuntime|performance"};
    public static final Pattern c = Pattern.compile("^/.+(?<!\\\\)/[dgimsuy]*");
    public static final Pattern d = Pattern.compile("^<.*(?<!\\\\)>");
    public static final Pattern e = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);
    public static final Pattern f = Pattern.compile("^('.*?(?<!\\\\)'|\".*?(?<!\\\\)\"|`[\\s\\S]*?(?<!\\\\)`)(?=\\W|\\s|$)");
    public static final JavaScript2 g = null;

    /* JADX INFO: renamed from: b.a.t.a.k$a */
    /* JADX INFO: compiled from: JavaScript.kt */
    public static final class a<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0019a f295b = new C0019a(null);
        public static final Pattern a = Pattern.compile("^(var|let|const)(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*)");

        /* JADX INFO: renamed from: b.a.t.a.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JavaScript.kt */
        public static final class C0019a {
            public C0019a(DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: renamed from: b.a.t.a.k$b */
    /* JADX INFO: compiled from: JavaScript.kt */
    public static final class b<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f296b = new a(null);
        public static final Pattern a = new Regex("^(function\\*?|static|get|set|async)(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*)?(\\s*\\(.*?\\))", Regex5.DOT_MATCHES_ALL).getNativePattern();

        /* JADX INFO: renamed from: b.a.t.a.k$b$a */
        /* JADX INFO: compiled from: JavaScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(String str, String str2, String str3, CodeStyleProviders<RC> codeStyleProviders) {
            Intrinsics3.checkNotNullParameter(str, "pre");
            Intrinsics3.checkNotNullParameter(str3, "params");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.b(str, codeStyleProviders.d);
            nodeArr[1] = str2 != null ? new StyleNode.b(str2, codeStyleProviders.e) : null;
            nodeArr[2] = new StyleNode.b(str3, codeStyleProviders.h);
            super(nodeArr);
        }
    }

    /* JADX INFO: renamed from: b.a.t.a.k$c */
    /* JADX INFO: compiled from: JavaScript.kt */
    public static final class c<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f297b = new a(null);
        public static final Pattern a = Pattern.compile("^([\\{\\[\\,])(\\s*[a-zA-Z0-9_$]+)(\\s*:)");

        /* JADX INFO: renamed from: b.a.t.a.k$c$a */
        /* JADX INFO: compiled from: JavaScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, String str3, CodeStyleProviders<RC> codeStyleProviders) {
            super(new StyleNode.b(str, codeStyleProviders.a), new StyleNode.b(str2, codeStyleProviders.e), new StyleNode.b(str3, codeStyleProviders.a));
            Intrinsics3.checkNotNullParameter(str, "prefix");
            Intrinsics3.checkNotNullParameter(str2, "property");
            Intrinsics3.checkNotNullParameter(str3, "suffix");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        }
    }
}
