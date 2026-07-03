package p007b.p008a.p050t.p051a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import p507d0.p579g0.EnumC12092i;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.a.k */
/* JADX INFO: compiled from: JavaScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1285k {

    /* JADX INFO: renamed from: a */
    public static final String[] f1927a = {"import|from|export|default|package", "class|enum", "function|super|extends|implements|arguments", "var|let|const|static|get|set|new", "return|break|continue|yield|void", "if|else|for|while|do|switch|async|await|case|try|catch|finally|delete|throw|NaN|Infinity", "of|in|instanceof|typeof", "debugger|with", "true|false|null|undefined"};

    /* JADX INFO: renamed from: b */
    public static final String[] f1928b = {"String|Boolean|RegExp|Number|Date|Math|JSON|Symbol|BigInt|Atomics|DataView", "Function|Promise|Generator|GeneratorFunction|AsyncFunction|AsyncGenerator|AsyncGeneratorFunction", "Array|Object|Map|Set|WeakMap|WeakSet|Int8Array|Int16Array|Int32Array|Uint8Array|Uint16Array", "Uint32Array|Uint8ClampedArray|Float32Array|Float64Array|BigInt64Array|BigUint64Array|Buffer", "ArrayBuffer|SharedArrayBuffer", "Reflect|Proxy|Intl|WebAssembly", "console|process|require|isNaN|parseInt|parseFloat|encodeURI|decodeURI|encodeURIComponent", "decodeURIComponent|this|global|globalThis|eval|isFinite|module", "setTimeout|setInterval|clearTimeout|clearInterval|setImmediate|clearImmediate", "queueMicrotask|document|window", "Error|SyntaxError|TypeError|RangeError|ReferenceError|EvalError|InternalError|URIError", "AggregateError|escape|unescape|URL|URLSearchParams|TextEncoder|TextDecoder", "AbortController|AbortSignal|EventTarget|Event|MessageChannel", "MessagePort|MessageEvent|FinalizationRegistry|WeakRef", "regeneratorRuntime|performance"};

    /* JADX INFO: renamed from: c */
    public static final Pattern f1929c = Pattern.compile("^/.+(?<!\\\\)/[dgimsuy]*");

    /* JADX INFO: renamed from: d */
    public static final Pattern f1930d = Pattern.compile("^<.*(?<!\\\\)>");

    /* JADX INFO: renamed from: e */
    public static final Pattern f1931e = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);

    /* JADX INFO: renamed from: f */
    public static final Pattern f1932f = Pattern.compile("^('.*?(?<!\\\\)'|\".*?(?<!\\\\)\"|`[\\s\\S]*?(?<!\\\\)`)(?=\\W|\\s|$)");

    /* JADX INFO: renamed from: g */
    public static final C1285k f1933g = null;

    /* JADX INFO: renamed from: b.a.t.a.k$a */
    /* JADX INFO: compiled from: JavaScript.kt */
    public static final class a<RC> extends Node.C5655a<RC> {

        /* JADX INFO: renamed from: b */
        public static final C13214a f1935b = new C13214a(null);

        /* JADX INFO: renamed from: a */
        public static final Pattern f1934a = Pattern.compile("^(var|let|const)(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*)");

        /* JADX INFO: renamed from: b.a.t.a.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JavaScript.kt */
        public static final class C13214a {
            public C13214a(DefaultConstructorMarker defaultConstructorMarker) {
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

    /* JADX INFO: renamed from: b.a.t.a.k$b */
    /* JADX INFO: compiled from: JavaScript.kt */
    public static final class b<RC> extends Node.C5655a<RC> {

        /* JADX INFO: renamed from: b */
        public static final a f1937b = new a(null);

        /* JADX INFO: renamed from: a */
        public static final Pattern f1936a = new Regex("^(function\\*?|static|get|set|async)(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*)?(\\s*\\(.*?\\))", EnumC12092i.DOT_MATCHES_ALL).getNativePattern();

        /* JADX INFO: renamed from: b.a.t.a.k$b$a */
        /* JADX INFO: compiled from: JavaScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public b(String str, String str2, String str3, C1280f<RC> c1280f) {
            C12238m.checkNotNullParameter(str, "pre");
            C12238m.checkNotNullParameter(str3, "params");
            C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.C5657b(str, c1280f.f1909d);
            nodeArr[1] = str2 != null ? new StyleNode.C5657b(str2, c1280f.f1910e) : null;
            nodeArr[2] = new StyleNode.C5657b(str3, c1280f.f1913h);
            super(nodeArr);
        }
    }

    /* JADX INFO: renamed from: b.a.t.a.k$c */
    /* JADX INFO: compiled from: JavaScript.kt */
    public static final class c<RC> extends Node.C5655a<RC> {

        /* JADX INFO: renamed from: b */
        public static final a f1939b = new a(null);

        /* JADX INFO: renamed from: a */
        public static final Pattern f1938a = Pattern.compile("^([\\{\\[\\,])(\\s*[a-zA-Z0-9_$]+)(\\s*:)");

        /* JADX INFO: renamed from: b.a.t.a.k$c$a */
        /* JADX INFO: compiled from: JavaScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, String str3, C1280f<RC> c1280f) {
            super(new StyleNode.C5657b(str, c1280f.f1906a), new StyleNode.C5657b(str2, c1280f.f1910e), new StyleNode.C5657b(str3, c1280f.f1906a));
            C12238m.checkNotNullParameter(str, "prefix");
            C12238m.checkNotNullParameter(str2, "property");
            C12238m.checkNotNullParameter(str3, "suffix");
            C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        }
    }
}
