package b.a.t.a;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: Kotlin.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static final String[] a = {"public|private|internal|inline|lateinit|abstract|open|reified", "import|package", "class|interface|data|enum|sealed|object|typealias", "fun|override|this|super|where|constructor|init|param|delegate", "const|val|var|get|final|vararg|it", "return|break|continue|suspend", "for|while|do|if|else|when|try|catch|finally|throw", "in|out|is|as|typeof", "shr|ushr|shl|ushl", "true|false|null"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f298b = {"true|false|Boolean|String|Char", "Int|UInt|Long|ULong|Float|Double|Byte|UByte|Short|UShort", "Self|Set|Map|MutableMap|List|MutableList|Array|Runnable|Unit", "arrayOf|listOf|mapOf|setOf|let|also|apply|run"};
    public static final Pattern c = Pattern.compile("^(?:(?://.*?(?=\\n|$))|(/\\*.*?\\*/))", 32);
    public static final Pattern d = Pattern.compile("^@(\\w+)");
    public static final Pattern e = Pattern.compile("^\"[\\s\\S]*?(?<!\\\\)\"(?=\\W|\\s|$)");
    public static final o f = null;
}
