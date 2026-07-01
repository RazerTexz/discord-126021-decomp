package lombok.javac;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$TreeTag.SCL.lombok */
public class JavacTreeMaker$TreeTag extends JavacTreeMaker$SchroedingerType {
    private static final Field TAG_FIELD;
    private static final Method TAG_METHOD;
    private static final ConcurrentMap<String, Object> TREE_TAG_CACHE = new ConcurrentHashMap();
    private static final JavacTreeMaker$MethodId<Integer> OP_PREC = JavacTreeMaker.MethodId(TreeInfo.class, "opPrec", Integer.TYPE, JavacTreeMaker$TreeTag.class);

    @Override // lombok.javac.JavacTreeMaker$SchroedingerType
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // lombok.javac.JavacTreeMaker$SchroedingerType
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    static {
        Method m = null;
        try {
            m = Permit.getMethod(JCTree.class, "getTag", new Class[0]);
        } catch (NoSuchMethodException unused) {
        }
        if (m != null) {
            TAG_FIELD = null;
            TAG_METHOD = m;
        } else {
            Field f = null;
            try {
                f = Permit.getField(JCTree.class, "tag");
            } catch (NoSuchFieldException unused2) {
            }
            TAG_FIELD = f;
            TAG_METHOD = null;
        }
    }

    private JavacTreeMaker$TreeTag(Object value) {
        super(value, null);
    }

    public static JavacTreeMaker$TreeTag treeTag(JCTree o) {
        try {
            return TAG_METHOD != null ? new JavacTreeMaker$TreeTag(TAG_METHOD.invoke(o, new Object[0])) : new JavacTreeMaker$TreeTag(TAG_FIELD.get(o));
        } catch (IllegalAccessException e) {
            throw Javac.sneakyThrow(e);
        } catch (InvocationTargetException e2) {
            throw Javac.sneakyThrow(e2.getCause());
        }
    }

    public static JavacTreeMaker$TreeTag treeTag(String identifier) {
        return new JavacTreeMaker$TreeTag(getFieldCached(TREE_TAG_CACHE, Javac.getJavaCompilerVersion() < 8 ? "com.sun.tools.javac.tree.JCTree" : "com.sun.tools.javac.tree.JCTree$Tag", identifier));
    }

    public int getOperatorPrecedenceLevel() {
        return ((Integer) JavacTreeMaker.access$0(null, OP_PREC, new Object[]{this.value})).intValue();
    }

    public boolean isPrefixUnaryOp() {
        return Javac.CTC_NEG.equals(this) || Javac.CTC_POS.equals(this) || Javac.CTC_NOT.equals(this) || Javac.CTC_COMPL.equals(this) || Javac.CTC_PREDEC.equals(this) || Javac.CTC_PREINC.equals(this);
    }
}
