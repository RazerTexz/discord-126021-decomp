package lombok.javac;

import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.util.Context;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.processing.Messager;
import lombok.ConfigurationKeys;
import lombok.core.CleanupRegistry;
import lombok.core.LombokConfiguration;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTransformer.SCL.lombok */
public class JavacTransformer {
    private final HandlerLibrary handlers;
    private final Messager messager;

    static /* synthetic */ HandlerLibrary access$0(JavacTransformer javacTransformer) {
        return javacTransformer.handlers;
    }

    public JavacTransformer(Messager messager, Trees trees) {
        this.messager = messager;
        this.handlers = HandlerLibrary.load(messager, trees);
    }

    public SortedSet<Long> getPriorities() {
        return this.handlers.getPriorities();
    }

    public SortedSet<Long> getPrioritiesRequiringResolutionReset() {
        return this.handlers.getPrioritiesRequiringResolutionReset();
    }

    public void transform(long priority, Context context, List<JCTree$JCCompilationUnit> compilationUnits, CleanupRegistry cleanup) {
        for (JCTree$JCCompilationUnit unit : compilationUnits) {
            if (!Boolean.TRUE.equals(LombokConfiguration.read(ConfigurationKeys.LOMBOK_DISABLE, JavacAST.getAbsoluteFileLocation(unit)))) {
                JavacAST ast = new JavacAST(this.messager, context, unit, cleanup);
                ast.traverse(new JavacTransformer$AnnotationVisitor(this, priority));
                this.handlers.callASTVisitors(ast, priority);
                if (ast.isChanged()) {
                    LombokOptions.markChanged(context, ast.top().get());
                }
            }
        }
    }
}
