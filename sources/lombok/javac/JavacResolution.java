package lombok.javac;

import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.Types;
import com.sun.tools.javac.comp.Attr;
import com.sun.tools.javac.comp.AttrContext;
import com.sun.tools.javac.comp.Enter;
import com.sun.tools.javac.comp.Env;
import com.sun.tools.javac.comp.MemberEnter;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Log;
import com.sun.tools.javac.util.Name;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.lang.model.type.TypeKind;
import javax.tools.JavaFileObject;
import lombok.Lombok;
import lombok.core.debug.AssertionLogger;
import lombok.javac.JavacTreeMaker;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution.SCL.lombok */
public class JavacResolution {
    private final Attr attr;
    private final CompilerMessageSuppressor messageSuppressor;
    private static Field memberEnterDotEnv;
    private static /* synthetic */ int[] $SWITCH_TABLE$javax$lang$model$type$TypeKind;

    static /* synthetic */ int[] $SWITCH_TABLE$javax$lang$model$type$TypeKind() {
        int[] iArr = $SWITCH_TABLE$javax$lang$model$type$TypeKind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[TypeKind.values().length];
        try {
            iArr2[TypeKind.ARRAY.ordinal()] = 12;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[TypeKind.BOOLEAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[TypeKind.BYTE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[TypeKind.CHAR.ordinal()] = 6;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[TypeKind.DECLARED.ordinal()] = 13;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[TypeKind.DOUBLE.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[TypeKind.ERROR.ordinal()] = 14;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[TypeKind.EXECUTABLE.ordinal()] = 18;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[TypeKind.FLOAT.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[TypeKind.INT.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[TypeKind.LONG.ordinal()] = 5;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[TypeKind.NONE.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[TypeKind.NULL.ordinal()] = 11;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[TypeKind.OTHER.ordinal()] = 19;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[TypeKind.PACKAGE.ordinal()] = 17;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[TypeKind.SHORT.ordinal()] = 3;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[TypeKind.TYPEVAR.ordinal()] = 15;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr2[TypeKind.VOID.ordinal()] = 9;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr2[TypeKind.WILDCARD.ordinal()] = 16;
        } catch (NoSuchFieldError unused19) {
        }
        $SWITCH_TABLE$javax$lang$model$type$TypeKind = iArr2;
        return iArr2;
    }

    public JavacResolution(Context context) {
        this.attr = Attr.instance(context);
        this.messageSuppressor = new CompilerMessageSuppressor(context);
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution$EnvFinder.SCL.lombok */
    private static final class EnvFinder extends JCTree.Visitor {
        private Enter enter;
        private MemberEnter memberEnter;
        private Env<AttrContext> env = null;
        private JCTree copyAt = null;

        EnvFinder(Context context) {
            this.enter = Enter.instance(context);
            this.memberEnter = MemberEnter.instance(context);
        }

        Env<AttrContext> get() {
            return this.env;
        }

        JCTree copyAt() {
            return this.copyAt;
        }

        public void visitTopLevel(JCTree.JCCompilationUnit tree) {
            if (this.copyAt != null) {
                return;
            }
            this.env = this.enter.getTopLevelEnv(tree);
        }

        public void visitClassDef(JCTree.JCClassDecl tree) {
            if (this.copyAt == null && tree.sym != null) {
                this.env = this.enter.getClassEnv(tree.sym);
            }
        }

        public void visitMethodDef(JCTree.JCMethodDecl tree) {
            if (this.copyAt != null) {
                return;
            }
            this.env = this.memberEnter.getMethodEnv(tree, this.env);
            this.copyAt = tree;
        }

        public void visitVarDef(JCTree.JCVariableDecl tree) {
            if (this.copyAt != null) {
                return;
            }
            this.env = this.memberEnter.getInitEnv(tree, this.env);
            this.copyAt = tree;
        }

        public void visitBlock(JCTree.JCBlock tree) {
            if (this.copyAt != null) {
                return;
            }
            this.copyAt = tree;
        }

        public void visitTree(JCTree that) {
        }
    }

    public Map<JCTree, JCTree> resolveMethodMember(JavacNode node) {
        ArrayDeque<JCTree> stack = new ArrayDeque<>();
        JavacNode javacNodeUp = node;
        while (true) {
            JavacNode n = javacNodeUp;
            if (n == null) {
                break;
            }
            stack.push(n.get());
            javacNodeUp = n.up();
        }
        this.messageSuppressor.disableLoggers();
        try {
            EnvFinder finder = new EnvFinder(node.getContext());
            while (!stack.isEmpty()) {
                stack.pop().accept(finder);
            }
            TreeMirrorMaker mirrorMaker = new TreeMirrorMaker(node.getTreeMaker(), node.getContext());
            JCTree copy = mirrorMaker.copy(finder.copyAt());
            Log log = Log.instance(node.getContext());
            JavaFileObject oldFileObject = log.useSource(node.top().get().getSourceFile());
            try {
                memberEnterAndAttribute(copy, finder.get(), node.getContext());
                Map<JCTree, JCTree> originalToCopyMap = mirrorMaker.getOriginalToCopyMap();
                log.useSource(oldFileObject);
                this.messageSuppressor.enableLoggers();
                return originalToCopyMap;
            } catch (Throwable th) {
                log.useSource(oldFileObject);
                throw th;
            }
        } catch (Throwable th2) {
            this.messageSuppressor.enableLoggers();
            throw th2;
        }
    }

    private static Field getMemberEnterDotEnv() {
        if (memberEnterDotEnv != null) {
            return memberEnterDotEnv;
        }
        try {
            Field field = Permit.getField(MemberEnter.class, "env");
            memberEnterDotEnv = field;
            return field;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Env<AttrContext> getEnvOfMemberEnter(MemberEnter memberEnter) {
        Field f = getMemberEnterDotEnv();
        try {
            return (Env) f.get(memberEnter);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void setEnvOfMemberEnter(MemberEnter memberEnter, Env<AttrContext> env) {
        Field f = getMemberEnterDotEnv();
        try {
            f.set(memberEnter, env);
        } catch (Exception unused) {
        }
    }

    private void memberEnterAndAttribute(JCTree copy, Env<AttrContext> env, Context context) {
        MemberEnter memberEnter = MemberEnter.instance(context);
        Env<AttrContext> oldEnv = getEnvOfMemberEnter(memberEnter);
        setEnvOfMemberEnter(memberEnter, env);
        try {
            copy.accept(memberEnter);
        } catch (Exception ignore) {
            AssertionLogger.assertLog("member enter failed.", ignore);
        } finally {
            setEnvOfMemberEnter(memberEnter, oldEnv);
        }
        attrib(copy, env);
    }

    public void resolveClassMember(JavacNode node) {
        ArrayDeque<JCTree> stack = new ArrayDeque<>();
        JavacNode javacNodeUp = node;
        while (true) {
            JavacNode n = javacNodeUp;
            if (n == null) {
                break;
            }
            stack.push(n.get());
            javacNodeUp = n.up();
        }
        this.messageSuppressor.disableLoggers();
        try {
            EnvFinder finder = new EnvFinder(node.getContext());
            while (!stack.isEmpty()) {
                stack.pop().accept(finder);
            }
            attrib(node.get(), finder.get());
        } finally {
            this.messageSuppressor.enableLoggers();
        }
    }

    private void attrib(JCTree tree, Env<AttrContext> env) {
        if (env.enclClass.type == null) {
            try {
                env.enclClass.type = Type.noType;
            } catch (Throwable unused) {
            }
        }
        if (!(tree instanceof JCTree.JCBlock)) {
            if (!(tree instanceof JCTree.JCMethodDecl)) {
                if (!(tree instanceof JCTree.JCVariableDecl)) {
                    throw new IllegalStateException("Called with something that isn't a block, method decl, or variable decl");
                }
                this.attr.attribStat(tree, env);
                return;
            }
            this.attr.attribStat(((JCTree.JCMethodDecl) tree).body, env);
            return;
        }
        this.attr.attribStat(tree, env);
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution$TypeNotConvertibleException.SCL.lombok */
    public static class TypeNotConvertibleException extends Exception {
        public TypeNotConvertibleException(String msg) {
            super(msg);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacResolution$ReflectiveAccess.SCL.lombok */
    private static class ReflectiveAccess {
        private static Method UPPER_BOUND;

        private ReflectiveAccess() {
        }

        static {
            Method upperBound = null;
            try {
                upperBound = Permit.getMethod(Types.class, "upperBound", Type.class);
            } catch (Throwable unused) {
            }
            if (upperBound == null) {
                try {
                    upperBound = Permit.getMethod(Types.class, "wildUpperBound", Type.class);
                } catch (Throwable unused2) {
                }
            }
            UPPER_BOUND = upperBound;
        }

        public static Type Types_upperBound(Types types, Type type) {
            try {
                return (Type) UPPER_BOUND.invoke(types, type);
            } catch (InvocationTargetException e) {
                throw Lombok.sneakyThrow(e.getCause());
            } catch (Exception e2) {
                throw Lombok.sneakyThrow(e2);
            }
        }
    }

    public static Type ifTypeIsIterableToComponent(Type type, JavacAST ast) {
        if (type == null) {
            return null;
        }
        Types types = Types.instance(ast.getContext());
        Symtab syms = Symtab.instance(ast.getContext());
        Type boundType = ReflectiveAccess.Types_upperBound(types, type);
        Type elemTypeIfArray = types.elemtype(boundType);
        if (elemTypeIfArray != null) {
            return elemTypeIfArray;
        }
        Type base = types.asSuper(boundType, syms.iterableType.tsym);
        if (base == null) {
            return syms.objectType;
        }
        List<Type> iterableParams = base.allparams();
        return iterableParams.isEmpty() ? syms.objectType : ReflectiveAccess.Types_upperBound(types, (Type) iterableParams.head);
    }

    public static JCTree.JCExpression typeToJCTree(Type type, JavacAST ast, boolean allowVoid) throws TypeNotConvertibleException {
        return typeToJCTree(type, ast, false, allowVoid, false);
    }

    public static JCTree.JCExpression createJavaLangObject(JavacAST ast) {
        JavacTreeMaker maker = ast.getTreeMaker();
        return maker.Select(maker.Select(maker.Ident(ast.toName("java")), ast.toName("lang")), ast.toName("Object"));
    }

    private static JCTree.JCExpression typeToJCTree(Type type, JavacAST ast, boolean allowCompound, boolean allowVoid, boolean allowCapture) throws TypeNotConvertibleException {
        Type type0;
        int dims = 0;
        Type type2 = type;
        while (true) {
            type0 = type2;
            if (!(type0 instanceof Type.ArrayType)) {
                break;
            }
            dims++;
            type2 = ((Type.ArrayType) type0).elemtype;
        }
        JCTree.JCArrayTypeTree jCArrayTypeTreeTypeToJCTree0 = typeToJCTree0(type0, ast, allowCompound, allowVoid, allowCapture);
        while (dims > 0) {
            jCArrayTypeTreeTypeToJCTree0 = ast.getTreeMaker().TypeArray(jCArrayTypeTreeTypeToJCTree0);
            dims--;
        }
        return jCArrayTypeTreeTypeToJCTree0;
    }

    private static Iterable<? extends Type> concat(final Type t, final Collection<? extends Type> ts) {
        return t == null ? ts : new Iterable<Type>() { // from class: lombok.javac.JavacResolution.1
            @Override // java.lang.Iterable
            public Iterator<Type> iterator() {
                return new Iterator<Type>(ts, t) { // from class: lombok.javac.JavacResolution.1.1
                    private boolean first = true;
                    private Iterator<? extends Type> wrap;
                    private final /* synthetic */ Type val$t;

                    {
                        this.val$t = type;
                        this.wrap = collection == null ? null : collection.iterator();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        if (this.first) {
                            return true;
                        }
                        if (this.wrap == null) {
                            return false;
                        }
                        return this.wrap.hasNext();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.Iterator
                    public Type next() {
                        if (this.first) {
                            this.first = false;
                            return this.val$t;
                        }
                        if (this.wrap == null) {
                            throw new NoSuchElementException();
                        }
                        return this.wrap.next();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    private static int compare(Name a, Name b2) {
        return a.compareTo(b2);
    }

    private static JCTree.JCExpression typeToJCTree0(Type type, JavacAST ast, boolean allowCompound, boolean allowVoid, boolean allowCapture) throws TypeNotConvertibleException {
        Type lower;
        Type upper;
        String qName;
        int level;
        JavacTreeMaker maker = ast.getTreeMaker();
        if (Javac.CTC_BOT.equals(JavacTreeMaker.TypeTag.typeTag(type))) {
            return createJavaLangObject(ast);
        }
        if (Javac.CTC_VOID.equals(JavacTreeMaker.TypeTag.typeTag(type))) {
            return allowVoid ? primitiveToJCTree(type.getKind(), maker) : createJavaLangObject(ast);
        }
        if (type.isPrimitive()) {
            return primitiveToJCTree(type.getKind(), maker);
        }
        if (type.isErroneous()) {
            throw new TypeNotConvertibleException("Type cannot be resolved");
        }
        Symbol.TypeSymbol symbol = type.asElement();
        List<Type> generics = type.getTypeArguments();
        JCTree.JCIdent jCIdentTypeToJCTree0 = null;
        if (symbol == null) {
            throw new TypeNotConvertibleException("Null or compound type");
        }
        if (symbol.name.length() == 0) {
            if (type instanceof Type.ClassType) {
                Type winner = null;
                int winLevel = 0;
                Type supertype = ((Type.ClassType) type).supertype_field;
                List<Type> ifaces = ((Type.ClassType) type).interfaces_field;
                for (Type t : concat(supertype, ifaces)) {
                    if (t instanceof Type.ArrayType) {
                        level = 100;
                    } else if (t instanceof Type.TypeVar) {
                        level = 20;
                    } else if (t instanceof Type.WildcardType) {
                        level = 15;
                    } else if (t.isInterface()) {
                        level = 10;
                    } else if (isObject(t)) {
                        level = 1;
                    } else {
                        level = t instanceof Type.ClassType ? 50 : 5;
                    }
                    if (winLevel <= level) {
                        if (winLevel < level) {
                            winner = t;
                            winLevel = level;
                        } else if (compare(winner.tsym.getQualifiedName(), t.tsym.getQualifiedName()) < 0) {
                            winner = t;
                        }
                    }
                }
                return winner == null ? createJavaLangObject(ast) : typeToJCTree(winner, ast, allowCompound, allowVoid, allowCapture);
            }
            throw new TypeNotConvertibleException("Anonymous inner class");
        }
        if ((type instanceof Type.WildcardType) || (type instanceof Type.CapturedType)) {
            if (type instanceof Type.WildcardType) {
                upper = ((Type.WildcardType) type).getExtendsBound();
                lower = ((Type.WildcardType) type).getSuperBound();
            } else {
                lower = type.getLowerBound();
                upper = type.getUpperBound();
                if (allowCapture) {
                    BoundKind bk = ((Type.CapturedType) type).wildcard.kind;
                    if (bk == BoundKind.UNBOUND) {
                        return maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
                    }
                    if (bk == BoundKind.EXTENDS) {
                        lower = null;
                        upper = ((Type.CapturedType) type).wildcard.type;
                    } else if (bk == BoundKind.SUPER) {
                        lower = ((Type.CapturedType) type).wildcard.type;
                        upper = null;
                    }
                }
            }
            if (allowCompound) {
                if (lower == null || Javac.CTC_BOT.equals(JavacTreeMaker.TypeTag.typeTag(lower))) {
                    if (upper == null || upper.toString().equals("java.lang.Object")) {
                        return maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
                    }
                    if (upper.getTypeArguments().contains(type)) {
                        return maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
                    }
                    JCTree.JCExpression bound = typeToJCTree(upper, ast, false, false, true);
                    return bound instanceof JCTree.JCWildcard ? maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null) : maker.Wildcard(maker.TypeBoundKind(BoundKind.EXTENDS), bound);
                }
                JCTree.JCExpression bound2 = typeToJCTree(lower, ast, false, false, true);
                return bound2 instanceof JCTree.JCWildcard ? maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null) : maker.Wildcard(maker.TypeBoundKind(BoundKind.SUPER), bound2);
            }
            if (upper != null) {
                if (upper.getTypeArguments().contains(type)) {
                    return maker.Wildcard(maker.TypeBoundKind(BoundKind.UNBOUND), null);
                }
                return typeToJCTree(upper, ast, allowCompound, allowVoid, true);
            }
            return createJavaLangObject(ast);
        }
        if (symbol.isLocal()) {
            qName = symbol.getSimpleName().toString();
        } else if (symbol.type != null && symbol.type.getEnclosingType() != null && JavacTreeMaker.TypeTag.typeTag(symbol.type.getEnclosingType()).equals(JavacTreeMaker.TypeTag.typeTag("CLASS"))) {
            jCIdentTypeToJCTree0 = typeToJCTree0(type.getEnclosingType(), ast, false, false, false);
            qName = symbol.getSimpleName().toString();
        } else {
            qName = symbol.getQualifiedName().toString();
        }
        if (qName.isEmpty()) {
            throw new TypeNotConvertibleException("unknown type");
        }
        if (qName.startsWith("<")) {
            throw new TypeNotConvertibleException(qName);
        }
        String[] baseNames = qName.split("\\.");
        int i = 0;
        if (jCIdentTypeToJCTree0 == null) {
            jCIdentTypeToJCTree0 = maker.Ident(ast.toName(baseNames[0]));
            i = 1;
        }
        while (i < baseNames.length) {
            jCIdentTypeToJCTree0 = maker.Select(jCIdentTypeToJCTree0, ast.toName(baseNames[i]));
            i++;
        }
        return genericsToJCTreeNodes(generics, ast, jCIdentTypeToJCTree0);
    }

    private static boolean isObject(Type supertype) {
        return supertype.tsym.toString().equals("java.lang.Object");
    }

    private static JCTree.JCExpression genericsToJCTreeNodes(List<Type> generics, JavacAST ast, JCTree.JCExpression rawTypeNode) throws TypeNotConvertibleException {
        if (generics != null && !generics.isEmpty()) {
            ListBuffer<JCTree.JCExpression> args = new ListBuffer<>();
            for (Type t : generics) {
                args.append(typeToJCTree(t, ast, true, false, true));
            }
            return ast.getTreeMaker().TypeApply(rawTypeNode, args.toList());
        }
        return rawTypeNode;
    }

    private static JCTree.JCExpression primitiveToJCTree(TypeKind kind, JavacTreeMaker maker) throws TypeNotConvertibleException {
        switch ($SWITCH_TABLE$javax$lang$model$type$TypeKind()[kind.ordinal()]) {
            case 1:
                return maker.TypeIdent(Javac.CTC_BOOLEAN);
            case 2:
                return maker.TypeIdent(Javac.CTC_BYTE);
            case 3:
                return maker.TypeIdent(Javac.CTC_SHORT);
            case 4:
                return maker.TypeIdent(Javac.CTC_INT);
            case 5:
                return maker.TypeIdent(Javac.CTC_LONG);
            case 6:
                return maker.TypeIdent(Javac.CTC_CHAR);
            case 7:
                return maker.TypeIdent(Javac.CTC_FLOAT);
            case 8:
                return maker.TypeIdent(Javac.CTC_DOUBLE);
            case 9:
                return maker.TypeIdent(Javac.CTC_VOID);
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            default:
                throw new TypeNotConvertibleException("Nulltype");
        }
    }

    public static boolean platformHasTargetTyping() {
        return Javac.getJavaCompilerVersion() >= 8;
    }
}
