package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;
import lombok.javac.JavacNode;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$CopyJavadoc.SCL.lombok */
public abstract class JavacHandlerUtil$CopyJavadoc {
    public static final JavacHandlerUtil$CopyJavadoc VERBATIM = new JavacHandlerUtil$CopyJavadoc$1("VERBATIM", 0);
    public static final JavacHandlerUtil$CopyJavadoc GETTER = new JavacHandlerUtil$CopyJavadoc$2("GETTER", 1);
    public static final JavacHandlerUtil$CopyJavadoc SETTER = new JavacHandlerUtil$CopyJavadoc$3("SETTER", 2);
    public static final JavacHandlerUtil$CopyJavadoc WITH = new JavacHandlerUtil$CopyJavadoc$4("WITH", 3);
    public static final JavacHandlerUtil$CopyJavadoc WITH_BY = new JavacHandlerUtil$CopyJavadoc$5("WITH_BY", 4);
    private static final /* synthetic */ JavacHandlerUtil$CopyJavadoc[] ENUM$VALUES = {VERBATIM, GETTER, SETTER, WITH, WITH_BY};

    public abstract String apply(JCTree$JCCompilationUnit jCTree$JCCompilationUnit, JavacNode javacNode);

    public static JavacHandlerUtil$CopyJavadoc[] values() {
        JavacHandlerUtil$CopyJavadoc[] javacHandlerUtil$CopyJavadocArr = ENUM$VALUES;
        int length = javacHandlerUtil$CopyJavadocArr.length;
        JavacHandlerUtil$CopyJavadoc[] javacHandlerUtil$CopyJavadocArr2 = new JavacHandlerUtil$CopyJavadoc[length];
        System.arraycopy(javacHandlerUtil$CopyJavadocArr, 0, javacHandlerUtil$CopyJavadocArr2, 0, length);
        return javacHandlerUtil$CopyJavadocArr2;
    }

    public static JavacHandlerUtil$CopyJavadoc valueOf(String str) {
        return (JavacHandlerUtil$CopyJavadoc) Enum.valueOf(JavacHandlerUtil$CopyJavadoc.class, str);
    }

    private JavacHandlerUtil$CopyJavadoc(String str, int i) {
        super(str, i);
    }

    /* synthetic */ JavacHandlerUtil$CopyJavadoc(String str, int i, JavacHandlerUtil$CopyJavadoc javacHandlerUtil$CopyJavadoc) {
        this(str, i);
    }

    static /* synthetic */ String access$3(JCTree$JCCompilationUnit jCTree$JCCompilationUnit, JavacNode javacNode, String str) {
        return applySetter(jCTree$JCCompilationUnit, javacNode, str);
    }

    private static String applySetter(JCTree$JCCompilationUnit cu, JavacNode node, String sectionName) {
        JCTree n = node.get();
        String javadoc = Javac.getDocComment(cu, n);
        String out = HandlerUtil.getJavadocSection(javadoc, sectionName);
        boolean sectionBased = out != null;
        if (!sectionBased) {
            out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@returns?\\s+.*");
        }
        node.getAst().cleanupTask("javadocfilter-setter", n, new JavacHandlerUtil$CopyJavadoc$6(cu, n, sectionBased));
        return JavacHandlerUtil.shouldReturnThis(node) ? HandlerUtil.addReturnsThisIfNeeded(out) : out;
    }
}
