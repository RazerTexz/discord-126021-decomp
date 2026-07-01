package lombok.eclipse.handlers;

import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$CopyJavadoc.SCL.lombok */
public abstract class EclipseHandlerUtil$CopyJavadoc {
    public static final EclipseHandlerUtil$CopyJavadoc VERBATIM = new EclipseHandlerUtil$CopyJavadoc$1("VERBATIM", 0);
    public static final EclipseHandlerUtil$CopyJavadoc GETTER = new EclipseHandlerUtil$CopyJavadoc$2("GETTER", 1);
    public static final EclipseHandlerUtil$CopyJavadoc SETTER = new EclipseHandlerUtil$CopyJavadoc$3("SETTER", 2);
    public static final EclipseHandlerUtil$CopyJavadoc WITH = new EclipseHandlerUtil$CopyJavadoc$4("WITH", 3);
    public static final EclipseHandlerUtil$CopyJavadoc WITH_BY = new EclipseHandlerUtil$CopyJavadoc$5("WITH_BY", 4);
    private static final /* synthetic */ EclipseHandlerUtil$CopyJavadoc[] ENUM$VALUES = {VERBATIM, GETTER, SETTER, WITH, WITH_BY};

    public abstract String apply(CompilationUnitDeclaration compilationUnitDeclaration, EclipseNode eclipseNode);

    public static EclipseHandlerUtil$CopyJavadoc[] values() {
        EclipseHandlerUtil$CopyJavadoc[] eclipseHandlerUtil$CopyJavadocArr = ENUM$VALUES;
        int length = eclipseHandlerUtil$CopyJavadocArr.length;
        EclipseHandlerUtil$CopyJavadoc[] eclipseHandlerUtil$CopyJavadocArr2 = new EclipseHandlerUtil$CopyJavadoc[length];
        System.arraycopy(eclipseHandlerUtil$CopyJavadocArr, 0, eclipseHandlerUtil$CopyJavadocArr2, 0, length);
        return eclipseHandlerUtil$CopyJavadocArr2;
    }

    public static EclipseHandlerUtil$CopyJavadoc valueOf(String str) {
        return (EclipseHandlerUtil$CopyJavadoc) Enum.valueOf(EclipseHandlerUtil$CopyJavadoc.class, str);
    }

    private EclipseHandlerUtil$CopyJavadoc(String str, int i) {
        super(str, i);
    }

    /* synthetic */ EclipseHandlerUtil$CopyJavadoc(String str, int i, EclipseHandlerUtil$CopyJavadoc eclipseHandlerUtil$CopyJavadoc) {
        this(str, i);
    }

    static /* synthetic */ String access$3(CompilationUnitDeclaration compilationUnitDeclaration, EclipseNode eclipseNode, String str) {
        return applySetter(compilationUnitDeclaration, eclipseNode, str);
    }

    private static String applySetter(CompilationUnitDeclaration cu, EclipseNode node, String sectionName) {
        ASTNode n = node.get();
        String javadoc = EclipseHandlerUtil.getDocComment(cu, n);
        String out = HandlerUtil.getJavadocSection(javadoc, sectionName);
        boolean sectionBased = out != null;
        if (!sectionBased) {
            out = HandlerUtil.stripLinesWithTagFromJavadoc(HandlerUtil.stripSectionsFromJavadoc(javadoc), "@returns?\\s+.*");
        }
        return EclipseHandlerUtil.shouldReturnThis(node) ? HandlerUtil.addReturnsThisIfNeeded(out) : out;
    }
}
