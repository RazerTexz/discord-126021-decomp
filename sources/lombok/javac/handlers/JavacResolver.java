package lombok.javac.handlers;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import lombok.javac.JavacNode;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacResolver.SCL.lombok */
public abstract class JavacResolver {
    public static final JavacResolver CLASS = new JavacResolver$1("CLASS", 0);
    public static final JavacResolver METHOD = new JavacResolver$2("METHOD", 1);
    public static final JavacResolver CLASS_AND_METHOD = new JavacResolver$3("CLASS_AND_METHOD", 2);
    private static final /* synthetic */ JavacResolver[] ENUM$VALUES = {CLASS, METHOD, CLASS_AND_METHOD};

    public abstract Type resolveMember(JavacNode javacNode, JCTree$JCExpression jCTree$JCExpression);

    public static JavacResolver[] values() {
        JavacResolver[] javacResolverArr = ENUM$VALUES;
        int length = javacResolverArr.length;
        JavacResolver[] javacResolverArr2 = new JavacResolver[length];
        System.arraycopy(javacResolverArr, 0, javacResolverArr2, 0, length);
        return javacResolverArr2;
    }

    public static JavacResolver valueOf(String str) {
        return (JavacResolver) Enum.valueOf(JavacResolver.class, str);
    }

    private JavacResolver(String str, int i) {
        super(str, i);
    }

    /* synthetic */ JavacResolver(String str, int i, JavacResolver javacResolver) {
        this(str, i);
    }
}
