package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.a.i */
/* JADX INFO: compiled from: Crystal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1283i {

    /* JADX INFO: renamed from: a */
    public static final String[] f1916a = {"true|false|nil", "module|require|include|extend|lib", "abstract|private|protected", "annotation|class|finalize|new|initialize|allocate|self|super", "union|typeof|forall|is_a?|nil?|as?|as|responds_to?|alias|type", "property|getter|setter|struct|of", "previous_def|method|fun|enum|macro", "rescue|raise|begin|end|ensure", "if|else|elsif|then|unless|until", "for|in|of|do|when|select|with", "while|break|next|yield|case", "print|puts|return"};

    /* JADX INFO: renamed from: b */
    public static final String[] f1917b = {"Nil|Bool|true|false|Void|NoReturn", "Number|BigDecimal|BigRational|BigFloat|BigInt", "Int|Int8|Int16|Int32|Int64|UInt8|UInt16|UInt32|UInt64|Float|Float32|Float64", "Char|String|Symbol|Regex", "StaticArray|Array|Set|Hash|Range|Tuple|NamedTuple|Union|BitArray", "Proc|Command|Enum|Class", "Reference|Value|Struct|Object|Pointer", "Exception|ArgumentError|KeyError|TypeCastError|IndexError|RuntimeError|NilAssertionError|InvalidBigDecimalException|NotImplementedError|OverflowError", "pointerof|sizeof|instance_sizeof|offsetof|uninitialized"};

    /* JADX INFO: renamed from: c */
    public static final Pattern f1918c = Pattern.compile("^(#.*)");

    /* JADX INFO: renamed from: d */
    public static final Pattern f1919d = Pattern.compile("^@\\[(\\w+)(?:\\(.+\\))?]");

    /* JADX INFO: renamed from: e */
    public static final Pattern f1920e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");

    /* JADX INFO: renamed from: f */
    public static final Pattern f1921f = Pattern.compile("^/.*?/[imx]?");

    /* JADX INFO: renamed from: g */
    public static final Pattern f1922g = Pattern.compile("^(:\"?(?:[+-/%&^|]|\\*\\*?|\\w+|(?:<(?=[<=\\s])[<=]?(?:(?<==)>)?|>(?=[>=\\s])[>=]?(?:(?<==)>)?)|\\[][?=]?|(?:!(?=[=~\\s])[=~]?|=?(?:~|==?)))(?:(?<!\\\\)\"(?=\\s|$))?)");

    /* JADX INFO: renamed from: h */
    public static final C1283i f1923h = null;

    /* JADX INFO: renamed from: b.a.t.a.i$a */
    /* JADX INFO: compiled from: Crystal.kt */
    public static final class a<RC> extends Node.C5655a<RC> {

        /* JADX INFO: renamed from: b */
        public static final C13213a f1925b = new C13213a(null);

        /* JADX INFO: renamed from: a */
        public static final Pattern f1924a = Pattern.compile("^(def)( +\\w+)( *\\( *(?:@\\w+ +: +\\w*)?\\w+(?: +[:=] +.*)? *\\))?(?!.+)");

        /* JADX INFO: renamed from: b.a.t.a.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Crystal.kt */
        public static final class C13213a {
            public C13213a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public a(String str, String str2, String str3, C1280f<RC> c1280f) {
            C12238m.checkNotNullParameter(str, "pre");
            C12238m.checkNotNullParameter(str2, "signature");
            C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
            Node[] nodeArr = new Node[3];
            nodeArr[0] = new StyleNode.C5657b(str, c1280f.f1909d);
            nodeArr[1] = new StyleNode.C5657b(str2, c1280f.f1910e);
            nodeArr[2] = str3 != null ? new StyleNode.C5657b(str3, c1280f.f1913h) : null;
            super(nodeArr);
        }
    }
}
