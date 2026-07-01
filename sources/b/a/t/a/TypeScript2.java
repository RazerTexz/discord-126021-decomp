package b.a.t.a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import d0.g0.Regex5;
import d0.z.d.Intrinsics3;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* JADX INFO: renamed from: b.a.t.a.r, reason: use source file name */
/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypeScript2 {
    public static final String[] a = {"import|from|export|default|package", "class|enum", "function|super|extends|implements|arguments", "var|let|const|static|get|set|new", "return|break|continue|yield|void", "if|else|for|while|do|switch|async|await|case|try|catch|finally|delete|throw|NaN|Infinity", "of|in|instanceof|typeof", "debugger|with", "true|false|null|undefined", "type|as|interface|public|private|protected|module|declare|namespace", "abstract|keyof|readonly|is|asserts|infer|override|intrinsic"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f301b = {"String|Boolean|RegExp|Number|Date|Math|JSON|Symbol|BigInt|Atomics|DataView", "Function|Promise|Generator|GeneratorFunction|AsyncFunction|AsyncGenerator|AsyncGeneratorFunction", "Array|Object|Map|Set|WeakMap|WeakSet|Int8Array|Int16Array|Int32Array|Uint8Array|Uint16Array", "Uint32Array|Uint8ClampedArray|Float32Array|Float64Array|BigInt64Array|BigUint64Array|Buffer", "ArrayBuffer|SharedArrayBuffer", "Reflect|Proxy|Intl|WebAssembly", "console|process|require|isNaN|parseInt|parseFloat|encodeURI|decodeURI|encodeURIComponent", "decodeURIComponent|this|global|globalThis|eval|isFinite|module", "setTimeout|setInterval|clearTimeout|clearInterval|setImmediate|clearImmediate", "queueMicrotask|document|window", "Error|SyntaxError|TypeError|RangeError|ReferenceError|EvalError|InternalError|URIError", "AggregateError|escape|unescape|URL|URLSearchParams|TextEncoder|TextDecoder", "AbortController|AbortSignal|EventTarget|Event|MessageChannel", "MessagePort|MessageEvent|FinalizationRegistry|WeakRef", "regeneratorRuntime|performance", "Iterable|Iterator|IterableIterator", "Partial|Required|Readonly|Record|Pick|Omit|Exclude|Extract", "NonNullable|Parameters|ConstructorParameters|ReturnType", "InstanceType|ThisParameterType|OmitThisParameter", "ThisType|Uppercase|Lowercase|Capitalize|Uncapitalize"};
    public static final String[] c = {"string|number|boolean|object|symbol|any|unknown|bigint|never"};
    public static final Pattern d = Pattern.compile("^/.+(?<!\\\\)/[dgimsuy]*");
    public static final Pattern e = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);
    public static final Pattern f = Pattern.compile("^('.*?(?<!\\\\)'|\".*?(?<!\\\\)\"|`[\\s\\S]*?(?<!\\\\)`)(?=\\W|\\s|$)");
    public static final TypeScript2 g = null;

    /* JADX INFO: renamed from: b.a.t.a.r$a */
    /* JADX INFO: compiled from: TypeScript.kt */
    public static final class a<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0021a f302b = new C0021a(null);
        public static final Pattern a = Pattern.compile("^(@)(\\s*[a-zA-Z_$][a-zA-Z0-9_$]*)(<.*>)?", 32);

        /* JADX INFO: renamed from: b.a.t.a.r$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TypeScript.kt */
        public static final class C0021a {
            public C0021a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(String str, String str2, String str3, CodeStyleProviders<RC> codeStyleProviders) {
            Intrinsics3.checkNotNullParameter(str, "prefix");
            Intrinsics3.checkNotNullParameter(str2, "decorator");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.b(str, codeStyleProviders.d);
            nodeArr[1] = new StyleNode.b(str2, codeStyleProviders.g);
            nodeArr[2] = str3 != null ? new StyleNode.b(str3, codeStyleProviders.g) : null;
            super(nodeArr);
        }
    }

    /* JADX INFO: renamed from: b.a.t.a.r$b */
    /* JADX INFO: compiled from: TypeScript.kt */
    public static final class b<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f303b = new a(null);
        public static final Pattern a = Pattern.compile("^(var|let|const)(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*)");

        /* JADX INFO: renamed from: b.a.t.a.r$b$a */
        /* JADX INFO: compiled from: TypeScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, CodeStyleProviders<RC> codeStyleProviders) {
            super(new StyleNode.b(str, codeStyleProviders.d), new StyleNode.b(str2, codeStyleProviders.e));
            Intrinsics3.checkNotNullParameter(str, "definition");
            Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        }
    }

    /* JADX INFO: renamed from: b.a.t.a.r$c */
    /* JADX INFO: compiled from: TypeScript.kt */
    public static final class c<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f304b = new a(null);
        public static final Pattern a = new Regex("^((?:function\\*?|static|get|set|async)\\s)(\\s*[a-zA-Z_$][a-zA-Z0-9_$]*)?(\\s*<.*>)?", Regex5.DOT_MATCHES_ALL).getNativePattern();

        /* JADX INFO: renamed from: b.a.t.a.r$c$a */
        /* JADX INFO: compiled from: TypeScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public c(String str, String str2, String str3, CodeStyleProviders<RC> codeStyleProviders) {
            Intrinsics3.checkNotNullParameter(str, "pre");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.b(str, codeStyleProviders.d);
            nodeArr[1] = str2 != null ? new StyleNode.b(str2, codeStyleProviders.e) : null;
            nodeArr[2] = str3 != null ? new StyleNode.b(str3, codeStyleProviders.g) : null;
            super(nodeArr);
        }
    }

    /* JADX INFO: renamed from: b.a.t.a.r$d */
    /* JADX INFO: compiled from: TypeScript.kt */
    public static final class d<RC> extends Node.a<RC> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f305b = new a(null);
        public static final Pattern a = Pattern.compile("^([{\\[(,;](?:\\s*-)?)(\\s*(?:public|private|protected|readonly))?(\\s*[a-zA-Z0-9_$]+)((?:\\s*\\?)?\\s*:)");

        /* JADX INFO: renamed from: b.a.t.a.r$d$a */
        /* JADX INFO: compiled from: TypeScript.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public d(String str, String str2, String str3, String str4, CodeStyleProviders<RC> codeStyleProviders) {
            Intrinsics3.checkNotNullParameter(str, "prefix");
            Intrinsics3.checkNotNullParameter(str3, "property");
            Intrinsics3.checkNotNullParameter(str4, "suffix");
            Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
            Node[] nodeArr = new Node[4];
            nodeArr[0] = new StyleNode.b(str, codeStyleProviders.a);
            nodeArr[1] = str2 != null ? new StyleNode.b(str2, codeStyleProviders.d) : null;
            nodeArr[2] = new StyleNode.b(str3, codeStyleProviders.e);
            nodeArr[3] = new StyleNode.b(str4, codeStyleProviders.a);
            super(nodeArr);
        }
    }
}
