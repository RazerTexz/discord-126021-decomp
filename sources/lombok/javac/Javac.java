package lombok.javac;

import com.discord.api.permission.Permission;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.code.Source;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.parser.Tokens;
import com.sun.tools.javac.tree.DocCommentTable;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.JCDiagnostic;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.type.NoType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeVisitor;
import lombok.core.ClassLiteral;
import lombok.core.FieldSelect;
import lombok.core.JavaIdentifiers;
import lombok.javac.JavacTreeMaker;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/Javac.SCL.lombok */
public class Javac {
    private static final Pattern VERSION_PARSER = Pattern.compile("^(\\d{1,6})\\.?(\\d{1,6})?.*$");
    private static final Pattern SOURCE_PARSER = Pattern.compile("^JDK(\\d{1,6})_?(\\d{1,6})?.*$");
    private static final AtomicInteger compilerVersion = new AtomicInteger(-1);
    private static final Class<?> DOCCOMMENTTABLE_CLASS;
    public static final JavacTreeMaker.TypeTag CTC_BOOLEAN;
    public static final JavacTreeMaker.TypeTag CTC_INT;
    public static final JavacTreeMaker.TypeTag CTC_DOUBLE;
    public static final JavacTreeMaker.TypeTag CTC_FLOAT;
    public static final JavacTreeMaker.TypeTag CTC_SHORT;
    public static final JavacTreeMaker.TypeTag CTC_BYTE;
    public static final JavacTreeMaker.TypeTag CTC_LONG;
    public static final JavacTreeMaker.TypeTag CTC_CHAR;
    public static final JavacTreeMaker.TypeTag CTC_VOID;
    public static final JavacTreeMaker.TypeTag CTC_NONE;
    public static final JavacTreeMaker.TypeTag CTC_BOT;
    public static final JavacTreeMaker.TypeTag CTC_ERROR;
    public static final JavacTreeMaker.TypeTag CTC_UNKNOWN;
    public static final JavacTreeMaker.TypeTag CTC_UNDETVAR;
    public static final JavacTreeMaker.TypeTag CTC_CLASS;
    public static final JavacTreeMaker.TreeTag CTC_NOT_EQUAL;
    public static final JavacTreeMaker.TreeTag CTC_LESS_THAN;
    public static final JavacTreeMaker.TreeTag CTC_GREATER_THAN;
    public static final JavacTreeMaker.TreeTag CTC_LESS_OR_EQUAL;
    public static final JavacTreeMaker.TreeTag CTC_GREATER_OR_EQUAL;
    public static final JavacTreeMaker.TreeTag CTC_POS;
    public static final JavacTreeMaker.TreeTag CTC_NEG;
    public static final JavacTreeMaker.TreeTag CTC_NOT;
    public static final JavacTreeMaker.TreeTag CTC_COMPL;
    public static final JavacTreeMaker.TreeTag CTC_BITXOR;
    public static final JavacTreeMaker.TreeTag CTC_UNSIGNED_SHIFT_RIGHT;
    public static final JavacTreeMaker.TreeTag CTC_MUL;
    public static final JavacTreeMaker.TreeTag CTC_DIV;
    public static final JavacTreeMaker.TreeTag CTC_PLUS;
    public static final JavacTreeMaker.TreeTag CTC_MINUS;
    public static final JavacTreeMaker.TreeTag CTC_EQUAL;
    public static final JavacTreeMaker.TreeTag CTC_PREINC;
    public static final JavacTreeMaker.TreeTag CTC_PREDEC;
    public static final JavacTreeMaker.TreeTag CTC_POSTINC;
    public static final JavacTreeMaker.TreeTag CTC_POSTDEC;
    private static final Method getExtendsClause;
    private static final Method getEndPosition;
    private static final Method storeEnd;
    private static final Class<?> JC_VOID_TYPE;
    private static final Class<?> JC_NO_TYPE;
    private static final Field symtabVoidType;
    private static final Field JCCOMPILATIONUNIT_ENDPOSITIONS;
    private static final Field JCCOMPILATIONUNIT_DOCCOMMENTS;

    private Javac() {
    }

    static {
        Method storeEndMethodTemp;
        Class<?> c = null;
        try {
            c = Class.forName("com.sun.tools.javac.tree.DocCommentTable");
        } catch (Throwable unused) {
        }
        DOCCOMMENTTABLE_CLASS = c;
        CTC_BOOLEAN = JavacTreeMaker.TypeTag.typeTag("BOOLEAN");
        CTC_INT = JavacTreeMaker.TypeTag.typeTag("INT");
        CTC_DOUBLE = JavacTreeMaker.TypeTag.typeTag("DOUBLE");
        CTC_FLOAT = JavacTreeMaker.TypeTag.typeTag("FLOAT");
        CTC_SHORT = JavacTreeMaker.TypeTag.typeTag("SHORT");
        CTC_BYTE = JavacTreeMaker.TypeTag.typeTag("BYTE");
        CTC_LONG = JavacTreeMaker.TypeTag.typeTag("LONG");
        CTC_CHAR = JavacTreeMaker.TypeTag.typeTag("CHAR");
        CTC_VOID = JavacTreeMaker.TypeTag.typeTag("VOID");
        CTC_NONE = JavacTreeMaker.TypeTag.typeTag("NONE");
        CTC_BOT = JavacTreeMaker.TypeTag.typeTag("BOT");
        CTC_ERROR = JavacTreeMaker.TypeTag.typeTag("ERROR");
        CTC_UNKNOWN = JavacTreeMaker.TypeTag.typeTag("UNKNOWN");
        CTC_UNDETVAR = JavacTreeMaker.TypeTag.typeTag("UNDETVAR");
        CTC_CLASS = JavacTreeMaker.TypeTag.typeTag("CLASS");
        CTC_NOT_EQUAL = JavacTreeMaker.TreeTag.treeTag("NE");
        CTC_LESS_THAN = JavacTreeMaker.TreeTag.treeTag("LT");
        CTC_GREATER_THAN = JavacTreeMaker.TreeTag.treeTag("GT");
        CTC_LESS_OR_EQUAL = JavacTreeMaker.TreeTag.treeTag("LE");
        CTC_GREATER_OR_EQUAL = JavacTreeMaker.TreeTag.treeTag("GE");
        CTC_POS = JavacTreeMaker.TreeTag.treeTag("POS");
        CTC_NEG = JavacTreeMaker.TreeTag.treeTag("NEG");
        CTC_NOT = JavacTreeMaker.TreeTag.treeTag("NOT");
        CTC_COMPL = JavacTreeMaker.TreeTag.treeTag("COMPL");
        CTC_BITXOR = JavacTreeMaker.TreeTag.treeTag("BITXOR");
        CTC_UNSIGNED_SHIFT_RIGHT = JavacTreeMaker.TreeTag.treeTag("USR");
        CTC_MUL = JavacTreeMaker.TreeTag.treeTag("MUL");
        CTC_DIV = JavacTreeMaker.TreeTag.treeTag("DIV");
        CTC_PLUS = JavacTreeMaker.TreeTag.treeTag("PLUS");
        CTC_MINUS = JavacTreeMaker.TreeTag.treeTag("MINUS");
        CTC_EQUAL = JavacTreeMaker.TreeTag.treeTag("EQ");
        CTC_PREINC = JavacTreeMaker.TreeTag.treeTag("PREINC");
        CTC_PREDEC = JavacTreeMaker.TreeTag.treeTag("PREDEC");
        CTC_POSTINC = JavacTreeMaker.TreeTag.treeTag("POSTINC");
        CTC_POSTDEC = JavacTreeMaker.TreeTag.treeTag("POSTDEC");
        getExtendsClause = getMethod((Class<?>) JCTree.JCClassDecl.class, "getExtendsClause", (Class<?>[]) new Class[0]);
        if (getJavaCompilerVersion() < 8) {
            getEndPosition = getMethod((Class<?>) JCDiagnostic.DiagnosticPosition.class, "getEndPosition", (Class<?>[]) new Class[]{Map.class});
            storeEnd = getMethod((Class<?>) Map.class, "put", (Class<?>[]) new Class[]{Object.class, Object.class});
        } else {
            getEndPosition = getMethod((Class<?>) JCDiagnostic.DiagnosticPosition.class, "getEndPosition", "com.sun.tools.javac.tree.EndPosTable");
            try {
                Class<?> endPosTable = Class.forName("com.sun.tools.javac.tree.EndPosTable");
                try {
                    storeEndMethodTemp = Permit.getMethod(endPosTable, "storeEnd", JCTree.class, Integer.TYPE);
                } catch (NoSuchMethodException unused2) {
                    try {
                        Class<?> endPosTable2 = Class.forName("com.sun.tools.javac.parser.JavacParser$AbstractEndPosTable");
                        storeEndMethodTemp = Permit.getMethod(endPosTable2, "storeEnd", JCTree.class, Integer.TYPE);
                    } catch (ClassNotFoundException ex) {
                        throw sneakyThrow(ex);
                    } catch (NoSuchMethodException ex2) {
                        throw sneakyThrow(ex2);
                    }
                }
                storeEnd = storeEndMethodTemp;
            } catch (ClassNotFoundException ex3) {
                throw sneakyThrow(ex3);
            }
        }
        Permit.setAccessible(getEndPosition);
        Permit.setAccessible(storeEnd);
        Class<?> c2 = null;
        try {
            c2 = Class.forName("com.sun.tools.javac.code.Type$JCVoidType");
        } catch (Throwable unused3) {
        }
        JC_VOID_TYPE = c2;
        Class<?> c3 = null;
        try {
            c3 = Class.forName("com.sun.tools.javac.code.Type$JCNoType");
        } catch (Throwable unused4) {
        }
        JC_NO_TYPE = c3;
        symtabVoidType = getFieldIfExists(Symtab.class, "voidType");
        Field f = null;
        try {
            f = Permit.getField(JCTree.JCCompilationUnit.class, "endPositions");
        } catch (NoSuchFieldException unused5) {
        }
        JCCOMPILATIONUNIT_ENDPOSITIONS = f;
        Field f2 = null;
        try {
            f2 = Permit.getField(JCTree.JCCompilationUnit.class, "docComments");
        } catch (NoSuchFieldException unused6) {
        }
        JCCOMPILATIONUNIT_DOCCOMMENTS = f2;
    }

    public static int getJavaCompilerVersion() {
        int cv = compilerVersion.get();
        if (cv != -1) {
            return cv;
        }
        Matcher m = VERSION_PARSER.matcher(JavaCompiler.version());
        if (m.matches()) {
            int major = Integer.parseInt(m.group(1));
            if (major == 1) {
                int minor = Integer.parseInt(m.group(2));
                return setVersion(minor);
            }
            if (major >= 9) {
                return setVersion(major);
            }
        }
        String name = Source.values()[Source.values().length - 1].name();
        Matcher m2 = SOURCE_PARSER.matcher(name);
        if (m2.matches()) {
            int major2 = Integer.parseInt(m2.group(1));
            if (major2 == 1) {
                int minor2 = Integer.parseInt(m2.group(2));
                return setVersion(minor2);
            }
            if (major2 >= 9) {
                return setVersion(major2);
            }
        }
        return setVersion(6);
    }

    private static int setVersion(int version) {
        compilerVersion.set(version);
        return version;
    }

    public static boolean instanceOfDocCommentTable(Object o) {
        return DOCCOMMENTTABLE_CLASS != null && DOCCOMMENTTABLE_CLASS.isInstance(o);
    }

    public static boolean isPrimitive(JCTree.JCExpression ref) {
        return JavaIdentifiers.isPrimitive(ref.toString());
    }

    public static Object calculateGuess(JCTree.JCExpression expr) {
        if (expr instanceof JCTree.JCLiteral) {
            JCTree.JCLiteral lit = (JCTree.JCLiteral) expr;
            if (lit.getKind() == Tree.Kind.BOOLEAN_LITERAL) {
                return Boolean.valueOf(((Number) lit.value).intValue() != 0);
            }
            return lit.value;
        }
        if ((expr instanceof JCTree.JCIdent) || (expr instanceof JCTree.JCFieldAccess)) {
            String x2 = expr.toString();
            if (x2.endsWith(".class")) {
                return new ClassLiteral(x2.substring(0, x2.length() - 6));
            }
            int idx = x2.lastIndexOf(46);
            if (idx > -1) {
                x2 = x2.substring(idx + 1);
            }
            return new FieldSelect(x2);
        }
        return null;
    }

    private static Method getMethod(Class<?> clazz, String name, Class<?>... clsArr) {
        try {
            return Permit.getMethod(clazz, name, clsArr);
        } catch (NoSuchMethodException e) {
            throw sneakyThrow(e);
        }
    }

    private static Method getMethod(Class<?> clazz, String name, String... paramTypes) {
        try {
            Class[] c = new Class[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                c[i] = Class.forName(paramTypes[i]);
            }
            return Permit.getMethod(clazz, name, c);
        } catch (ClassNotFoundException e) {
            throw sneakyThrow(e);
        } catch (NoSuchMethodException e2) {
            throw sneakyThrow(e2);
        }
    }

    public static JCTree getExtendsClause(JCTree.JCClassDecl decl) {
        try {
            return (JCTree) getExtendsClause.invoke(decl, new Object[0]);
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        } catch (InvocationTargetException e2) {
            throw sneakyThrow(e2.getCause());
        }
    }

    public static Object getDocComments(JCTree.JCCompilationUnit cu) {
        try {
            return JCCOMPILATIONUNIT_DOCCOMMENTS.get(cu);
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        }
    }

    public static String getDocComment(JCTree.JCCompilationUnit cu, JCTree node) {
        Object dc = getDocComments(cu);
        if (dc instanceof Map) {
            return (String) ((Map) dc).get(node);
        }
        if (instanceOfDocCommentTable(dc)) {
            return JavadocOps_8.getJavadoc(dc, node);
        }
        return null;
    }

    public static void setDocComment(JCTree.JCCompilationUnit cu, JCTree node, String javadoc) {
        Object dc = getDocComments(cu);
        if (dc instanceof Map) {
            ((Map) dc).put(node, javadoc);
        } else if (instanceOfDocCommentTable(dc)) {
            JavadocOps_8.setJavadoc(dc, node, javadoc);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/Javac$JavadocOps_8.SCL.lombok */
    private static class JavadocOps_8 {
        private JavadocOps_8() {
        }

        static String getJavadoc(Object dc, JCTree node) {
            DocCommentTable dct = (DocCommentTable) dc;
            Tokens.Comment javadoc = dct.getComment(node);
            if (javadoc == null) {
                return null;
            }
            return javadoc.getText();
        }

        static void setJavadoc(Object dc, JCTree node, String javadoc) {
            DocCommentTable dct = (DocCommentTable) dc;
            Tokens.Comment newCmt = createJavadocComment(javadoc, node);
            dct.putComment(node, newCmt);
        }

        private static Tokens.Comment createJavadocComment(final String text, final JCTree field) {
            return new Tokens.Comment() { // from class: lombok.javac.Javac.JavadocOps_8.1
                public String getText() {
                    return text;
                }

                public int getSourcePos(int index) {
                    return -1;
                }

                public Tokens.Comment.CommentStyle getStyle() {
                    return Tokens.Comment.CommentStyle.JAVADOC;
                }

                public boolean isDeprecated() {
                    return text.contains("@deprecated") && (field instanceof JCTree.JCVariableDecl) && Javac.isFieldDeprecated(field);
                }
            };
        }
    }

    public static boolean isFieldDeprecated(JCTree field) {
        if (!(field instanceof JCTree.JCVariableDecl)) {
            return false;
        }
        JCTree.JCVariableDecl fieldNode = (JCTree.JCVariableDecl) field;
        if ((fieldNode.mods.flags & Permission.MENTION_EVERYONE) != 0) {
            return true;
        }
        if (fieldNode.mods.annotations == null) {
            return false;
        }
        Iterator it = fieldNode.mods.annotations.iterator();
        if (it.hasNext()) {
            JCTree.JCAnnotation ann = (JCTree.JCAnnotation) it.next();
            String at = ann.getAnnotationType().toString();
            return at.equals("Deprecated") || at.endsWith(".Deprecated");
        }
        return false;
    }

    public static void initDocComments(JCTree.JCCompilationUnit cu) {
        try {
            JCCOMPILATIONUNIT_DOCCOMMENTS.set(cu, new HashMap());
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        } catch (IllegalArgumentException unused) {
        }
    }

    public static int getEndPosition(JCDiagnostic.DiagnosticPosition pos, JCTree.JCCompilationUnit top) {
        try {
            Object endPositions = JCCOMPILATIONUNIT_ENDPOSITIONS.get(top);
            return ((Integer) getEndPosition.invoke(pos, endPositions)).intValue();
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        } catch (InvocationTargetException e2) {
            throw sneakyThrow(e2.getCause());
        }
    }

    public static void storeEnd(JCTree tree, int pos, JCTree.JCCompilationUnit top) {
        try {
            Object endPositions = JCCOMPILATIONUNIT_ENDPOSITIONS.get(top);
            storeEnd.invoke(endPositions, tree, Integer.valueOf(pos));
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        } catch (InvocationTargetException e2) {
            throw sneakyThrow(e2.getCause());
        }
    }

    private static Field getFieldIfExists(Class<?> c, String fieldName) {
        try {
            return Permit.getField(c, "voidType");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Type createVoidType(Symtab symbolTable, JavacTreeMaker.TypeTag tag) {
        if (symtabVoidType != null) {
            try {
                return (Type) symtabVoidType.get(symbolTable);
            } catch (IllegalAccessException unused) {
            }
        }
        if (getJavaCompilerVersion() < 8) {
            return new JCNoType(((Integer) tag.value).intValue());
        }
        try {
            if (CTC_VOID.equals(tag)) {
                return (Type) JC_VOID_TYPE.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            return (Type) JC_NO_TYPE.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw sneakyThrow(e);
        } catch (InstantiationException e2) {
            throw sneakyThrow(e2);
        } catch (NoSuchMethodException e3) {
            throw sneakyThrow(e3);
        } catch (InvocationTargetException e4) {
            throw sneakyThrow(e4.getCause());
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/Javac$JCNoType.SCL.lombok */
    private static class JCNoType extends Type implements NoType {
        public JCNoType(int tag) {
            super(tag, (Symbol.TypeSymbol) null);
        }

        public TypeKind getKind() {
            if (this.tag == ((Integer) Javac.CTC_VOID.value).intValue()) {
                return TypeKind.VOID;
            }
            if (this.tag == ((Integer) Javac.CTC_NONE.value).intValue()) {
                return TypeKind.NONE;
            }
            throw new AssertionError("Unexpected tag: " + this.tag);
        }

        public <R, P> R accept(TypeVisitor<R, P> typeVisitor, P p) {
            return (R) typeVisitor.visitNoType(this, p);
        }
    }

    static RuntimeException sneakyThrow(Throwable t) throws Throwable {
        if (t == null) {
            throw new NullPointerException("t");
        }
        sneakyThrow0(t);
        return null;
    }

    private static <T extends Throwable> void sneakyThrow0(Throwable t) throws Throwable {
        throw t;
    }
}
