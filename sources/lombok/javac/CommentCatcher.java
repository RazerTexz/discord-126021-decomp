package lombok.javac;

import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import lombok.core.FieldAugment;
import lombok.permit.Permit;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/CommentCatcher.SCL.lombok */
public class CommentCatcher {
    private final JavaCompiler compiler;
    public static final FieldAugment<JCTree.JCCompilationUnit, List<CommentInfo>> JCCompilationUnit_comments = FieldAugment.augment(JCTree.JCCompilationUnit.class, List.class, "lombok$comments");
    public static final FieldAugment<JCTree.JCCompilationUnit, List<Integer>> JCCompilationUnit_textBlockStarts = FieldAugment.augment(JCTree.JCCompilationUnit.class, List.class, "lombok$textBlockStarts");

    public static CommentCatcher create(Context context, boolean findTextBlocks) {
        registerCommentsCollectingScannerFactory(context, findTextBlocks);
        JavaCompiler compiler = new JavaCompiler(context);
        setInCompiler(compiler, context);
        compiler.keepComments = true;
        compiler.genEndPos = true;
        return new CommentCatcher(compiler);
    }

    private CommentCatcher(JavaCompiler compiler) {
        this.compiler = compiler;
    }

    public JavaCompiler getCompiler() {
        return this.compiler;
    }

    public void setComments(JCTree.JCCompilationUnit ast, List<CommentInfo> comments) {
        if (comments != null) {
            JCCompilationUnit_comments.set(ast, comments);
        } else {
            JCCompilationUnit_comments.clear(ast);
        }
    }

    public List<CommentInfo> getComments(JCTree.JCCompilationUnit ast) {
        List<CommentInfo> list = JCCompilationUnit_comments.get(ast);
        return list == null ? Collections.emptyList() : list;
    }

    public List<Integer> getTextBlockStarts(JCTree.JCCompilationUnit ast) {
        List<Integer> list = JCCompilationUnit_textBlockStarts.get(ast);
        return list == null ? Collections.emptyList() : list;
    }

    private static void registerCommentsCollectingScannerFactory(Context context, boolean findTextBlocks) {
        Class<?> scannerFactory;
        try {
            int javaCompilerVersion = Javac.getJavaCompilerVersion();
            if (javaCompilerVersion <= 6) {
                scannerFactory = Class.forName("lombok.javac.java6.CommentCollectingScannerFactory");
            } else if (javaCompilerVersion == 7) {
                scannerFactory = Class.forName("lombok.javac.java7.CommentCollectingScannerFactory");
            } else {
                scannerFactory = Class.forName("lombok.javac.java8.CommentCollectingScannerFactory");
                if (findTextBlocks) {
                    Permit.getField(scannerFactory, "findTextBlocks").set(null, true);
                }
            }
            Permit.getMethod(scannerFactory, "preRegister", Context.class).invoke(null, context);
        } catch (InvocationTargetException e) {
            throw Javac.sneakyThrow(e.getCause());
        } catch (Exception e2) {
            throw Javac.sneakyThrow(e2);
        }
    }

    private static void setInCompiler(JavaCompiler compiler, Context context) {
        Class<?> parserFactory;
        try {
            int javaCompilerVersion = Javac.getJavaCompilerVersion();
            if (javaCompilerVersion <= 6) {
                parserFactory = Class.forName("lombok.javac.java6.CommentCollectingParserFactory");
            } else if (javaCompilerVersion == 7) {
                parserFactory = Class.forName("lombok.javac.java7.CommentCollectingParserFactory");
            } else if (javaCompilerVersion == 8) {
                parserFactory = Class.forName("lombok.javac.java8.CommentCollectingParserFactory");
            } else {
                parserFactory = Class.forName("lombok.javac.java9.CommentCollectingParserFactory");
            }
            Permit.getMethod(parserFactory, "setInCompiler", JavaCompiler.class, Context.class).invoke(null, compiler, context);
        } catch (InvocationTargetException e) {
            throw Javac.sneakyThrow(e.getCause());
        } catch (Exception e2) {
            throw Javac.sneakyThrow(e2);
        }
    }
}
