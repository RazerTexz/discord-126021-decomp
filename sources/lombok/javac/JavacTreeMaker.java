package lombok.javac;

import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeInfo;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker.SCL.lombok */
public class JavacTreeMaker {
    private final TreeMaker tm;
    private static final ConcurrentHashMap<FieldId<?>, Object> FIELD_CACHE = new ConcurrentHashMap<>();
    private static final Object REFLECTIVE_ITEM_NOT_FOUND = new Object[0];
    private static final Object REFLECTIVE_ITEM_MULTIPLE_FOUND = new Object[0];
    private static final ConcurrentHashMap<MethodId<?>, Object> METHOD_CACHE = new ConcurrentHashMap<>();
    private static final MethodId<JCTree.JCCompilationUnit> TopLevel = MethodId("TopLevel");
    private static final MethodId<JCTree.JCImport> Import = MethodId("Import");
    private static final MethodId<JCTree.JCClassDecl> ClassDef = MethodId("ClassDef");
    private static final MethodId<JCTree.JCMethodDecl> MethodDef = MethodId("MethodDef", JCTree.JCMethodDecl.class, JCTree.JCModifiers.class, Name.class, JCTree.JCExpression.class, List.class, List.class, List.class, JCTree.JCBlock.class, JCTree.JCExpression.class);
    private static final MethodId<JCTree.JCMethodDecl> MethodDefWithRecvParam = MethodId("MethodDef", JCTree.JCMethodDecl.class, JCTree.JCModifiers.class, Name.class, JCTree.JCExpression.class, List.class, JCTree.JCVariableDecl.class, List.class, List.class, JCTree.JCBlock.class, JCTree.JCExpression.class);
    private static final MethodId<JCTree.JCVariableDecl> VarDef = MethodId("VarDef");
    private static final MethodId<JCTree.JCVariableDecl> ReceiverVarDef = MethodId("ReceiverVarDef");
    private static final MethodId<JCTree.JCSkip> Skip = MethodId("Skip");
    private static final MethodId<JCTree.JCBlock> Block = MethodId("Block");
    private static final MethodId<JCTree.JCDoWhileLoop> DoLoop = MethodId("DoLoop");
    private static final MethodId<JCTree.JCWhileLoop> WhileLoop = MethodId("WhileLoop");
    private static final MethodId<JCTree.JCForLoop> ForLoop = MethodId("ForLoop");
    private static final MethodId<JCTree.JCEnhancedForLoop> ForeachLoop = MethodId("ForeachLoop");
    private static final MethodId<JCTree.JCLabeledStatement> Labelled = MethodId("Labelled");
    private static final MethodId<JCTree.JCSwitch> Switch = MethodId("Switch");
    private static final MethodId<JCTree.JCCase> Case11 = MethodId("Case", JCTree.JCCase.class, JCTree.JCExpression.class, List.class);
    private static final MethodId<JCTree.JCSynchronized> Synchronized = MethodId("Synchronized");
    private static final MethodId<JCTree.JCTry> Try = MethodId("Try", JCTree.JCTry.class, JCTree.JCBlock.class, List.class, JCTree.JCBlock.class);
    private static final MethodId<JCTree.JCTry> TryWithResources = MethodId("Try", JCTree.JCTry.class, List.class, JCTree.JCBlock.class, List.class, JCTree.JCBlock.class);
    private static final MethodId<JCTree.JCCatch> Catch = MethodId("Catch");
    private static final MethodId<JCTree.JCConditional> Conditional = MethodId("Conditional");
    private static final MethodId<JCTree.JCIf> If = MethodId("If");
    private static final MethodId<JCTree.JCExpressionStatement> Exec = MethodId("Exec");
    private static final MethodId<JCTree.JCBreak> Break11 = MethodId("Break", JCTree.JCBreak.class, Name.class);
    private static final MethodId<JCTree.JCBreak> Break12 = MethodId("Break", JCTree.JCBreak.class, JCTree.JCExpression.class);
    private static final MethodId<JCTree.JCContinue> Continue = MethodId("Continue");
    private static final MethodId<JCTree.JCReturn> Return = MethodId("Return");
    private static final MethodId<JCTree.JCThrow> Throw = MethodId("Throw");
    private static final MethodId<JCTree.JCAssert> Assert = MethodId("Assert");
    private static final MethodId<JCTree.JCMethodInvocation> Apply = MethodId("Apply");
    private static final MethodId<JCTree.JCNewClass> NewClass = MethodId("NewClass");
    private static final MethodId<JCTree.JCNewArray> NewArray = MethodId("NewArray");
    private static final MethodId<JCTree.JCParens> Parens = MethodId("Parens");
    private static final MethodId<JCTree.JCAssign> Assign = MethodId("Assign");
    private static final MethodId<JCTree.JCAssignOp> Assignop = MethodId("Assignop");
    private static final MethodId<JCTree.JCUnary> Unary = MethodId("Unary");
    private static final MethodId<JCTree.JCBinary> Binary = MethodId("Binary");
    private static final MethodId<JCTree.JCTypeCast> TypeCast = MethodId("TypeCast");
    private static final MethodId<JCTree.JCInstanceOf> TypeTest = MethodId("TypeTest");
    private static final MethodId<JCTree.JCArrayAccess> Indexed = MethodId("Indexed");
    private static final MethodId<JCTree.JCFieldAccess> Select = MethodId("Select");
    private static final MethodId<JCTree.JCIdent> Ident = MethodId("Ident", JCTree.JCIdent.class, Name.class);
    private static final MethodId<JCTree.JCLiteral> Literal = MethodId("Literal", JCTree.JCLiteral.class, TypeTag.class, Object.class);
    private static final MethodId<JCTree.JCPrimitiveTypeTree> TypeIdent = MethodId("TypeIdent");
    private static final MethodId<JCTree.JCArrayTypeTree> TypeArray = MethodId("TypeArray");
    private static final MethodId<JCTree.JCTypeApply> TypeApply = MethodId("TypeApply");
    private static final MethodId<JCTree.JCTypeParameter> TypeParameter = MethodId("TypeParameter", JCTree.JCTypeParameter.class, Name.class, List.class);
    private static final MethodId<JCTree.JCTypeParameter> TypeParameterWithAnnos = MethodId("TypeParameter", JCTree.JCTypeParameter.class, Name.class, List.class, List.class);
    private static final MethodId<JCTree.JCWildcard> Wildcard = MethodId("Wildcard");
    private static final MethodId<JCTree.TypeBoundKind> TypeBoundKind = MethodId("TypeBoundKind");
    private static final MethodId<JCTree.JCAnnotation> Annotation = MethodId("Annotation", JCTree.JCAnnotation.class, JCTree.class, List.class);
    private static final MethodId<JCTree.JCAnnotation> TypeAnnotation = MethodId("TypeAnnotation", JCTree.JCAnnotation.class, JCTree.class, List.class);
    private static final MethodId<JCTree.JCModifiers> ModifiersWithAnnotations = MethodId("Modifiers", JCTree.JCModifiers.class, Long.TYPE, List.class);
    private static final MethodId<JCTree.JCModifiers> Modifiers = MethodId("Modifiers", JCTree.JCModifiers.class, Long.TYPE);
    private static final MethodId<JCTree.JCErroneous> Erroneous = MethodId("Erroneous", JCTree.JCErroneous.class, new Class[0]);
    private static final MethodId<JCTree.JCErroneous> ErroneousWithErrs = MethodId("Erroneous", JCTree.JCErroneous.class, List.class);
    private static final MethodId<JCTree.LetExpr> LetExpr = MethodId("LetExpr", JCTree.LetExpr.class, List.class, JCTree.class);
    private static final MethodId<JCTree.JCClassDecl> AnonymousClassDef = MethodId("AnonymousClassDef");
    private static final MethodId<JCTree.LetExpr> LetExprSingle = MethodId("LetExpr", JCTree.LetExpr.class, JCTree.JCVariableDecl.class, JCTree.class);
    private static final MethodId<JCTree.JCIdent> IdentVarDecl = MethodId("Ident", JCTree.JCIdent.class, JCTree.JCVariableDecl.class);
    private static final MethodId<List<JCTree.JCExpression>> Idents = MethodId("Idents");
    private static final MethodId<JCTree.JCMethodInvocation> App2 = MethodId("App", JCTree.JCMethodInvocation.class, JCTree.JCExpression.class, List.class);
    private static final MethodId<JCTree.JCMethodInvocation> App1 = MethodId("App", JCTree.JCMethodInvocation.class, JCTree.JCExpression.class);
    private static final MethodId<List<JCTree.JCAnnotation>> Annotations = MethodId("Annotations");
    private static final MethodId<JCTree.JCLiteral> LiteralWithValue = MethodId("Literal", JCTree.JCLiteral.class, Object.class);
    private static final MethodId<JCTree.JCAnnotation> AnnotationWithAttributeOnly = MethodId("Annotation", JCTree.JCAnnotation.class, Attribute.class);
    private static final MethodId<JCTree.JCAnnotation> TypeAnnotationWithAttributeOnly = MethodId("TypeAnnotation", JCTree.JCAnnotation.class, Attribute.class);
    private static final MethodId<JCTree.JCExpression> AnnotatedType = MethodId("AnnotatedType", JCTree.JCExpression.class, List.class, JCTree.JCExpression.class);
    private static final MethodId<JCTree.JCStatement> Call = MethodId("Call");
    private static final MethodId<JCTree.JCExpression> Type = MethodId("Type");
    private static final FieldId<JCTree.JCVariableDecl> MethodDecl_recvParam = FieldId(JCTree.JCMethodDecl.class, "recvparam", JCTree.JCVariableDecl.class);

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$Case12.SCL.lombok */
    public static class Case12 {
        private static final Class<?> CASE_KIND_CLASS = JavacTreeMaker.classForName(TreeMaker.class, "com.sun.source.tree.CaseTree$CaseKind");
        static final MethodId<JCTree.JCCase> Case12 = JavacTreeMaker.MethodId("Case", JCTree.JCCase.class, CASE_KIND_CLASS, List.class, List.class, JCTree.class);
        static final Object CASE_KIND_STATEMENT = CASE_KIND_CLASS.getEnumConstants()[0];
    }

    public JavacTreeMaker(TreeMaker tm) {
        this.tm = tm;
    }

    public TreeMaker getUnderlyingTreeMaker() {
        return this.tm;
    }

    public JavacTreeMaker at(int pos) {
        this.tm.at(pos);
        return this;
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$FieldId.SCL.lombok */
    private static final class FieldId<J> {
        private final Class<?> owner;
        private final String name;
        private final Class<J> fieldType;

        FieldId(Class<?> owner, String name, Class<J> fieldType) {
            this.owner = owner;
            this.name = name;
            this.fieldType = fieldType;
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$MethodId.SCL.lombok */
    private static final class MethodId<J> {
        private final Class<?> owner;
        private final String name;
        private final Class<J> returnType;
        private final Class<?>[] paramTypes;

        MethodId(Class<?> owner, String name, Class<J> returnType, Class<?>... clsArr) {
            this.owner = owner;
            this.name = name;
            this.paramTypes = clsArr;
            this.returnType = returnType;
        }

        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append(this.returnType.getName()).append(" ").append(this.owner.getName()).append(".").append(this.name).append("(");
            boolean f = true;
            for (Class<?> p : this.paramTypes) {
                if (f) {
                    f = false;
                } else {
                    out.append(", ");
                }
                out.append(p.getName());
            }
            return out.append(")").toString();
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$SchroedingerType.SCL.lombok */
    private static class SchroedingerType {
        final Object value;
        private static Field NOSUCHFIELDEX_MARKER;

        private SchroedingerType(Object value) {
            this.value = value;
        }

        /* synthetic */ SchroedingerType(Object obj, SchroedingerType schroedingerType) {
            this(obj);
        }

        public int hashCode() {
            if (this.value == null) {
                return -1;
            }
            return this.value.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof SchroedingerType) {
                Object other = ((SchroedingerType) obj).value;
                if (this.value == null) {
                    return other == null;
                }
                return this.value.equals(other);
            }
            return false;
        }

        static Object getFieldCached(ConcurrentMap<String, Object> cache, String className, String fieldName) {
            Object value = cache.get(fieldName);
            if (value != null) {
                return value;
            }
            try {
                Object value2 = Permit.getField(Class.forName(className), fieldName).get(null);
                cache.putIfAbsent(fieldName, value2);
                return value2;
            } catch (ClassNotFoundException e) {
                throw Javac.sneakyThrow(e);
            } catch (IllegalAccessException e2) {
                throw Javac.sneakyThrow(e2);
            } catch (NoSuchFieldException e3) {
                throw Javac.sneakyThrow(e3);
            }
        }

        static {
            try {
                NOSUCHFIELDEX_MARKER = Permit.getField(SchroedingerType.class, "NOSUCHFIELDEX_MARKER");
            } catch (NoSuchFieldException e) {
                throw Javac.sneakyThrow(e);
            }
        }

        static Object getFieldCached(ConcurrentMap<Class<?>, Field> cache, Object ref, String fieldName) throws NoSuchFieldException {
            Class<?> c = ref.getClass();
            Field field = cache.get(c);
            if (field == null) {
                try {
                    field = Permit.getField(c, fieldName);
                    Permit.setAccessible(field);
                    Field old = cache.putIfAbsent(c, field);
                    if (old != null) {
                        field = old;
                    }
                } catch (NoSuchFieldException e) {
                    cache.putIfAbsent(c, NOSUCHFIELDEX_MARKER);
                    throw Javac.sneakyThrow(e);
                }
            }
            if (field == NOSUCHFIELDEX_MARKER) {
                throw new NoSuchFieldException(fieldName);
            }
            try {
                return field.get(ref);
            } catch (IllegalAccessException e2) {
                throw Javac.sneakyThrow(e2);
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$TypeTag.SCL.lombok */
    public static class TypeTag extends SchroedingerType {
        private static final ConcurrentMap<String, Object> TYPE_TAG_CACHE = new ConcurrentHashMap();
        private static final ConcurrentMap<Class<?>, Field> FIELD_CACHE = new ConcurrentHashMap();
        private static final Method TYPE_TYPETAG_METHOD;

        @Override // lombok.javac.JavacTreeMaker.SchroedingerType
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // lombok.javac.JavacTreeMaker.SchroedingerType
        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return super.equals(obj);
        }

        static {
            Method m = null;
            try {
                m = Permit.getMethod(Type.class, "getTag", new Class[0]);
            } catch (NoSuchMethodException unused) {
            }
            TYPE_TYPETAG_METHOD = m;
        }

        private TypeTag(Object value) {
            super(value, null);
        }

        public static TypeTag typeTag(JCTree o) {
            try {
                return new TypeTag(getFieldCached(FIELD_CACHE, o, "typetag"));
            } catch (NoSuchFieldException e) {
                throw Javac.sneakyThrow(e);
            }
        }

        public static TypeTag typeTag(Type t) {
            if (t == null) {
                return Javac.CTC_VOID;
            }
            try {
                return new TypeTag(getFieldCached(FIELD_CACHE, t, "tag"));
            } catch (NoSuchFieldException unused) {
                if (TYPE_TYPETAG_METHOD == null) {
                    throw new IllegalStateException("Type " + t.getClass() + " has neither 'tag' nor getTag()");
                }
                try {
                    return new TypeTag(TYPE_TYPETAG_METHOD.invoke(t, new Object[0]));
                } catch (IllegalAccessException ex) {
                    throw Javac.sneakyThrow(ex);
                } catch (InvocationTargetException ex2) {
                    throw Javac.sneakyThrow(ex2.getCause());
                }
            }
        }

        public static TypeTag typeTag(String identifier) {
            return new TypeTag(getFieldCached(TYPE_TAG_CACHE, Javac.getJavaCompilerVersion() < 8 ? "com.sun.tools.javac.code.TypeTags" : "com.sun.tools.javac.code.TypeTag", identifier));
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$TreeTag.SCL.lombok */
    public static class TreeTag extends SchroedingerType {
        private static final Field TAG_FIELD;
        private static final Method TAG_METHOD;
        private static final ConcurrentMap<String, Object> TREE_TAG_CACHE = new ConcurrentHashMap();
        private static final MethodId<Integer> OP_PREC = JavacTreeMaker.MethodId(TreeInfo.class, "opPrec", Integer.TYPE, TreeTag.class);

        @Override // lombok.javac.JavacTreeMaker.SchroedingerType
        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }

        @Override // lombok.javac.JavacTreeMaker.SchroedingerType
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

        private TreeTag(Object value) {
            super(value, null);
        }

        public static TreeTag treeTag(JCTree o) {
            try {
                return TAG_METHOD != null ? new TreeTag(TAG_METHOD.invoke(o, new Object[0])) : new TreeTag(TAG_FIELD.get(o));
            } catch (IllegalAccessException e) {
                throw Javac.sneakyThrow(e);
            } catch (InvocationTargetException e2) {
                throw Javac.sneakyThrow(e2.getCause());
            }
        }

        public static TreeTag treeTag(String identifier) {
            return new TreeTag(getFieldCached(TREE_TAG_CACHE, Javac.getJavaCompilerVersion() < 8 ? "com.sun.tools.javac.tree.JCTree" : "com.sun.tools.javac.tree.JCTree$Tag", identifier));
        }

        public int getOperatorPrecedenceLevel() {
            return ((Integer) JavacTreeMaker.invokeAny(null, OP_PREC, this.value)).intValue();
        }

        public boolean isPrefixUnaryOp() {
            return Javac.CTC_NEG.equals(this) || Javac.CTC_POS.equals(this) || Javac.CTC_NOT.equals(this) || Javac.CTC_COMPL.equals(this) || Javac.CTC_PREDEC.equals(this) || Javac.CTC_PREINC.equals(this);
        }
    }

    static <J> MethodId<J> MethodId(Class<?> owner, String name, Class<J> returnType, Class<?>... clsArr) {
        return new MethodId<>(owner, name, returnType, clsArr);
    }

    static <J> MethodId<J> MethodId(String name, Class<J> returnType, Class<?>... clsArr) {
        return new MethodId<>(TreeMaker.class, name, returnType, clsArr);
    }

    static <J> MethodId<J> MethodId(String name) {
        for (Method m : JavacTreeMaker.class.getDeclaredMethods()) {
            if (m.getName().equals(name)) {
                return new MethodId<>(TreeMaker.class, name, m.getReturnType(), m.getParameterTypes());
            }
        }
        throw new InternalError("Not found: " + name);
    }

    static <J> FieldId<J> FieldId(Class<?> owner, String name, Class<J> fieldType) {
        return new FieldId<>(owner, name, fieldType);
    }

    private static boolean has(FieldId<?> f) {
        Object field = FIELD_CACHE.get(f);
        if (field == REFLECTIVE_ITEM_NOT_FOUND) {
            return false;
        }
        if (field instanceof Field) {
            return true;
        }
        try {
            return getFromCache(f) != REFLECTIVE_ITEM_NOT_FOUND;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private static <J> J get(Object obj, FieldId<J> fieldId) {
        try {
            return (J) ((FieldId) fieldId).fieldType.cast(getFromCache((FieldId<?>) fieldId).get(obj));
        } catch (IllegalAccessException e) {
            throw Javac.sneakyThrow(e);
        }
    }

    private static <J> void set(Object owner, FieldId<J> f, J val) {
        Field field = getFromCache((FieldId<?>) f);
        try {
            field.set(owner, val);
        } catch (IllegalAccessException e) {
            throw Javac.sneakyThrow(e);
        } catch (IllegalArgumentException e2) {
            System.err.println("Type mismatch for: " + field);
            throw e2;
        }
    }

    private static Field getFromCache(FieldId<?> f) {
        Object s2 = FIELD_CACHE.get(f);
        if (s2 == null) {
            s2 = addToCache(f);
        }
        if (s2 == REFLECTIVE_ITEM_NOT_FOUND) {
            throw new IllegalStateException("Lombok TreeMaker frontend issue: no match when looking for field: " + f);
        }
        return (Field) s2;
    }

    private static Object addToCache(FieldId<?> f) {
        for (Field field : ((FieldId) f).owner.getDeclaredFields()) {
            if (((FieldId) f).name.equals(field.getName())) {
                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }
                return FIELD_CACHE.putIfAbsent(f, field);
            }
        }
        return FIELD_CACHE.putIfAbsent(f, REFLECTIVE_ITEM_NOT_FOUND);
    }

    private boolean has(MethodId<?> m) {
        Object method = METHOD_CACHE.get(m);
        if (method == REFLECTIVE_ITEM_NOT_FOUND) {
            return false;
        }
        if (method instanceof Method) {
            return true;
        }
        try {
            return getFromCache(m) != REFLECTIVE_ITEM_NOT_FOUND;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private <J> J invoke(MethodId<J> methodId, Object... objArr) {
        return (J) invokeAny(this.tm, methodId, objArr);
    }

    private static <J> J invokeAny(Object obj, MethodId<J> methodId, Object... objArr) {
        Method fromCache = getFromCache((MethodId<?>) methodId);
        try {
            if (!((MethodId) methodId).returnType.isPrimitive()) {
                return (J) ((MethodId) methodId).returnType.cast(fromCache.invoke(obj, objArr));
            }
            return (J) fromCache.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw Javac.sneakyThrow(e);
        } catch (IllegalArgumentException e2) {
            System.err.println("Type mismatch for: " + fromCache);
            throw e2;
        } catch (InvocationTargetException e3) {
            throw Javac.sneakyThrow(e3.getCause());
        }
    }

    private static boolean tryResolve(MethodId<?> m) {
        Object s2 = METHOD_CACHE.get(m);
        if (s2 == null) {
            s2 = addToCache(m);
        }
        return s2 instanceof Method;
    }

    private static Method getFromCache(MethodId<?> m) {
        Object s2 = METHOD_CACHE.get(m);
        if (s2 == null) {
            s2 = addToCache(m);
        }
        if (s2 == REFLECTIVE_ITEM_MULTIPLE_FOUND) {
            throw new IllegalStateException("Lombok TreeMaker frontend issue: multiple matches when looking for method: " + m);
        }
        if (s2 == REFLECTIVE_ITEM_NOT_FOUND) {
            throw new IllegalStateException("Lombok TreeMaker frontend issue: no match when looking for method: " + m);
        }
        return (Method) s2;
    }

    private static Object addToCache(MethodId<?> m) {
        Method found = null;
        for (Method method : ((MethodId) m).owner.getDeclaredMethods()) {
            if (((MethodId) m).name.equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == ((MethodId) m).paramTypes.length) {
                    int i = 0;
                    while (true) {
                        if (i < parameterTypes.length) {
                            if (Symbol.class.isAssignableFrom(parameterTypes[i])) {
                                break;
                            }
                            if (!SchroedingerType.class.isAssignableFrom(((MethodId) m).paramTypes[i])) {
                                if (parameterTypes[i].isPrimitive()) {
                                    if (parameterTypes[i] != ((MethodId) m).paramTypes[i]) {
                                        break;
                                    }
                                } else if (!parameterTypes[i].isAssignableFrom(((MethodId) m).paramTypes[i])) {
                                    break;
                                }
                            }
                            i++;
                        } else {
                            if (found == null) {
                                found = method;
                                break;
                            }
                            METHOD_CACHE.putIfAbsent(m, REFLECTIVE_ITEM_MULTIPLE_FOUND);
                            return REFLECTIVE_ITEM_MULTIPLE_FOUND;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        if (found == null) {
            METHOD_CACHE.putIfAbsent(m, REFLECTIVE_ITEM_NOT_FOUND);
            return REFLECTIVE_ITEM_NOT_FOUND;
        }
        Permit.setAccessible(found);
        Object marker = METHOD_CACHE.putIfAbsent(m, found);
        return marker == null ? found : marker;
    }

    public JCTree.JCCompilationUnit TopLevel(List<JCTree.JCAnnotation> packageAnnotations, JCTree.JCExpression pid, List<JCTree> defs) {
        return (JCTree.JCCompilationUnit) invoke(TopLevel, packageAnnotations, pid, defs);
    }

    public JCTree.JCImport Import(JCTree qualid, boolean staticImport) {
        return (JCTree.JCImport) invoke(Import, qualid, Boolean.valueOf(staticImport));
    }

    public JCTree.JCClassDecl ClassDef(JCTree.JCModifiers mods, Name name, List<JCTree.JCTypeParameter> typarams, JCTree.JCExpression extending, List<JCTree.JCExpression> implementing, List<JCTree> defs) {
        return (JCTree.JCClassDecl) invoke(ClassDef, mods, name, typarams, extending, implementing, defs);
    }

    public JCTree.JCMethodDecl MethodDef(JCTree.JCModifiers mods, Name name, JCTree.JCExpression resType, List<JCTree.JCTypeParameter> typarams, List<JCTree.JCVariableDecl> params, List<JCTree.JCExpression> thrown, JCTree.JCBlock body, JCTree.JCExpression defaultValue) {
        return (JCTree.JCMethodDecl) invoke(MethodDef, mods, name, resType, typarams, params, thrown, body, defaultValue);
    }

    public boolean hasMethodDefWithRecvParam() {
        return has((MethodId<?>) MethodDefWithRecvParam);
    }

    public JCTree.JCMethodDecl MethodDefWithRecvParam(JCTree.JCModifiers mods, Name name, JCTree.JCExpression resType, List<JCTree.JCTypeParameter> typarams, JCTree.JCVariableDecl recvparam, List<JCTree.JCVariableDecl> params, List<JCTree.JCExpression> thrown, JCTree.JCBlock body, JCTree.JCExpression defaultValue) {
        return (JCTree.JCMethodDecl) invoke(MethodDefWithRecvParam, mods, name, resType, typarams, recvparam, params, thrown, body, defaultValue);
    }

    public JCTree.JCVariableDecl VarDef(JCTree.JCModifiers mods, Name name, JCTree.JCExpression vartype, JCTree.JCExpression init) {
        JCTree.JCVariableDecl varDef = (JCTree.JCVariableDecl) invoke(VarDef, mods, name, vartype, init);
        if (varDef.vartype != null && varDef.vartype.pos == -1) {
            varDef.vartype.pos = 0;
        }
        return varDef;
    }

    public JCTree.JCVariableDecl ReceiverVarDef(JCTree.JCModifiers mods, JCTree.JCExpression name, JCTree.JCExpression vartype) {
        return (JCTree.JCVariableDecl) invoke(ReceiverVarDef, mods, name, vartype);
    }

    public JCTree.JCSkip Skip() {
        return (JCTree.JCSkip) invoke(Skip, new Object[0]);
    }

    public JCTree.JCBlock Block(long flags, List<JCTree.JCStatement> stats) {
        return (JCTree.JCBlock) invoke(Block, Long.valueOf(flags), stats);
    }

    public JCTree.JCDoWhileLoop DoLoop(JCTree.JCStatement body, JCTree.JCExpression cond) {
        return (JCTree.JCDoWhileLoop) invoke(DoLoop, body, cond);
    }

    public JCTree.JCWhileLoop WhileLoop(JCTree.JCExpression cond, JCTree.JCStatement body) {
        return (JCTree.JCWhileLoop) invoke(WhileLoop, cond, body);
    }

    public JCTree.JCForLoop ForLoop(List<JCTree.JCStatement> init, JCTree.JCExpression cond, List<JCTree.JCExpressionStatement> step, JCTree.JCStatement body) {
        return (JCTree.JCForLoop) invoke(ForLoop, init, cond, step, body);
    }

    public JCTree.JCEnhancedForLoop ForeachLoop(JCTree.JCVariableDecl var, JCTree.JCExpression expr, JCTree.JCStatement body) {
        return (JCTree.JCEnhancedForLoop) invoke(ForeachLoop, var, expr, body);
    }

    public JCTree.JCLabeledStatement Labelled(Name label, JCTree.JCStatement body) {
        return (JCTree.JCLabeledStatement) invoke(Labelled, label, body);
    }

    public JCTree.JCSwitch Switch(JCTree.JCExpression selector, List<JCTree.JCCase> cases) {
        return (JCTree.JCSwitch) invoke(Switch, selector, cases);
    }

    static Class<?> classForName(Class<?> context, String name) {
        try {
            return context.getClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {
            Error x2 = new NoClassDefFoundError(e.getMessage());
            x2.setStackTrace(e.getStackTrace());
            throw x2;
        }
    }

    public JCTree.JCCase Case(JCTree.JCExpression pat, List<JCTree.JCStatement> stats) {
        if (tryResolve(Case11)) {
            return (JCTree.JCCase) invoke(Case11, pat, stats);
        }
        MethodId<JCTree.JCCase> methodId = Case12.Case12;
        Object[] objArr = new Object[4];
        objArr[0] = Case12.CASE_KIND_STATEMENT;
        objArr[1] = pat == null ? List.nil() : List.of(pat);
        objArr[2] = stats;
        objArr[3] = null;
        return (JCTree.JCCase) invoke(methodId, objArr);
    }

    public JCTree.JCSynchronized Synchronized(JCTree.JCExpression lock, JCTree.JCBlock body) {
        return (JCTree.JCSynchronized) invoke(Synchronized, lock, body);
    }

    public JCTree.JCTry Try(JCTree.JCBlock body, List<JCTree.JCCatch> catchers, JCTree.JCBlock finalizer) {
        return (JCTree.JCTry) invoke(Try, body, catchers, finalizer);
    }

    public JCTree.JCTry Try(List<JCTree> resources, JCTree.JCBlock body, List<JCTree.JCCatch> catchers, JCTree.JCBlock finalizer) {
        return (JCTree.JCTry) invoke(TryWithResources, resources, body, catchers, finalizer);
    }

    public JCTree.JCCatch Catch(JCTree.JCVariableDecl param, JCTree.JCBlock body) {
        return (JCTree.JCCatch) invoke(Catch, param, body);
    }

    public JCTree.JCConditional Conditional(JCTree.JCExpression cond, JCTree.JCExpression thenpart, JCTree.JCExpression elsepart) {
        return (JCTree.JCConditional) invoke(Conditional, cond, thenpart, elsepart);
    }

    public JCTree.JCIf If(JCTree.JCExpression cond, JCTree.JCStatement thenpart, JCTree.JCStatement elsepart) {
        return (JCTree.JCIf) invoke(If, cond, thenpart, elsepart);
    }

    public JCTree.JCExpressionStatement Exec(JCTree.JCExpression expr) {
        return (JCTree.JCExpressionStatement) invoke(Exec, expr);
    }

    public JCTree.JCBreak Break(Name label) {
        if (tryResolve(Break11)) {
            return (JCTree.JCBreak) invoke(Break11, label);
        }
        MethodId<JCTree.JCBreak> methodId = Break12;
        Object[] objArr = new Object[1];
        objArr[0] = label != null ? Ident(label) : null;
        return (JCTree.JCBreak) invoke(methodId, objArr);
    }

    public JCTree.JCContinue Continue(Name label) {
        return (JCTree.JCContinue) invoke(Continue, label);
    }

    public JCTree.JCReturn Return(JCTree.JCExpression expr) {
        return (JCTree.JCReturn) invoke(Return, expr);
    }

    public JCTree.JCThrow Throw(JCTree.JCExpression expr) {
        return (JCTree.JCThrow) invoke(Throw, expr);
    }

    public JCTree.JCAssert Assert(JCTree.JCExpression cond, JCTree.JCExpression detail) {
        return (JCTree.JCAssert) invoke(Assert, cond, detail);
    }

    public JCTree.JCMethodInvocation Apply(List<JCTree.JCExpression> typeargs, JCTree.JCExpression fn, List<JCTree.JCExpression> args) {
        return (JCTree.JCMethodInvocation) invoke(Apply, typeargs, fn, args);
    }

    public JCTree.JCNewClass NewClass(JCTree.JCExpression encl, List<JCTree.JCExpression> typeargs, JCTree.JCExpression clazz, List<JCTree.JCExpression> args, JCTree.JCClassDecl def) {
        return (JCTree.JCNewClass) invoke(NewClass, encl, typeargs, clazz, args, def);
    }

    public JCTree.JCNewArray NewArray(JCTree.JCExpression elemtype, List<JCTree.JCExpression> dims, List<JCTree.JCExpression> elems) {
        return (JCTree.JCNewArray) invoke(NewArray, elemtype, dims, elems);
    }

    public JCTree.JCParens Parens(JCTree.JCExpression expr) {
        return (JCTree.JCParens) invoke(Parens, expr);
    }

    public JCTree.JCAssign Assign(JCTree.JCExpression lhs, JCTree.JCExpression rhs) {
        return (JCTree.JCAssign) invoke(Assign, lhs, rhs);
    }

    public JCTree.JCAssignOp Assignop(TreeTag opcode, JCTree lhs, JCTree rhs) {
        return (JCTree.JCAssignOp) invoke(Assignop, opcode.value, lhs, rhs);
    }

    public JCTree.JCUnary Unary(TreeTag opcode, JCTree.JCExpression arg) {
        return (JCTree.JCUnary) invoke(Unary, opcode.value, arg);
    }

    public JCTree.JCBinary Binary(TreeTag opcode, JCTree.JCExpression lhs, JCTree.JCExpression rhs) {
        return (JCTree.JCBinary) invoke(Binary, opcode.value, lhs, rhs);
    }

    public JCTree.JCTypeCast TypeCast(JCTree expr, JCTree.JCExpression type) {
        return (JCTree.JCTypeCast) invoke(TypeCast, expr, type);
    }

    public JCTree.JCInstanceOf TypeTest(JCTree.JCExpression expr, JCTree clazz) {
        return (JCTree.JCInstanceOf) invoke(TypeTest, expr, clazz);
    }

    public JCTree.JCArrayAccess Indexed(JCTree.JCExpression indexed, JCTree.JCExpression index) {
        return (JCTree.JCArrayAccess) invoke(Indexed, indexed, index);
    }

    public JCTree.JCFieldAccess Select(JCTree.JCExpression selected, Name selector) {
        return (JCTree.JCFieldAccess) invoke(Select, selected, selector);
    }

    public JCTree.JCIdent Ident(Name idname) {
        return (JCTree.JCIdent) invoke(Ident, idname);
    }

    public JCTree.JCLiteral Literal(TypeTag tag, Object value) {
        return (JCTree.JCLiteral) invoke(Literal, tag.value, value);
    }

    public JCTree.JCPrimitiveTypeTree TypeIdent(TypeTag typetag) {
        return (JCTree.JCPrimitiveTypeTree) invoke(TypeIdent, typetag.value);
    }

    public JCTree.JCArrayTypeTree TypeArray(JCTree.JCExpression elemtype) {
        return (JCTree.JCArrayTypeTree) invoke(TypeArray, elemtype);
    }

    public JCTree.JCTypeApply TypeApply(JCTree.JCExpression clazz, List<JCTree.JCExpression> arguments) {
        return (JCTree.JCTypeApply) invoke(TypeApply, clazz, arguments);
    }

    public JCTree.JCTypeParameter TypeParameter(Name name, List<JCTree.JCExpression> bounds) {
        return (JCTree.JCTypeParameter) invoke(TypeParameter, name, bounds);
    }

    public JCTree.JCTypeParameter TypeParameter(Name name, List<JCTree.JCExpression> bounds, List<JCTree.JCAnnotation> annos) {
        return (JCTree.JCTypeParameter) invoke(TypeParameterWithAnnos, name, bounds, annos);
    }

    public JCTree.JCWildcard Wildcard(JCTree.TypeBoundKind kind, JCTree type) {
        return (JCTree.JCWildcard) invoke(Wildcard, kind, type);
    }

    public JCTree.TypeBoundKind TypeBoundKind(BoundKind kind) {
        return (JCTree.TypeBoundKind) invoke(TypeBoundKind, kind);
    }

    public JCTree.JCAnnotation Annotation(JCTree annotationType, List<JCTree.JCExpression> args) {
        return (JCTree.JCAnnotation) invoke(Annotation, annotationType, args);
    }

    public JCTree.JCAnnotation TypeAnnotation(JCTree annotationType, List<JCTree.JCExpression> args) {
        return (JCTree.JCAnnotation) invoke(TypeAnnotation, annotationType, args);
    }

    public JCTree.JCModifiers Modifiers(long flags, List<JCTree.JCAnnotation> annotations) {
        return (JCTree.JCModifiers) invoke(ModifiersWithAnnotations, Long.valueOf(flags), annotations);
    }

    public JCTree.JCModifiers Modifiers(long flags) {
        return (JCTree.JCModifiers) invoke(Modifiers, Long.valueOf(flags));
    }

    public JCTree.JCErroneous Erroneous() {
        return (JCTree.JCErroneous) invoke(Erroneous, new Object[0]);
    }

    public JCTree.JCErroneous Erroneous(List<? extends JCTree> errs) {
        return (JCTree.JCErroneous) invoke(ErroneousWithErrs, errs);
    }

    public JCTree.LetExpr LetExpr(List<JCTree.JCVariableDecl> defs, JCTree expr) {
        return (JCTree.LetExpr) invoke(LetExpr, defs, expr);
    }

    public JCTree.JCClassDecl AnonymousClassDef(JCTree.JCModifiers mods, List<JCTree> defs) {
        return (JCTree.JCClassDecl) invoke(AnonymousClassDef, mods, defs);
    }

    public JCTree.LetExpr LetExpr(JCTree.JCVariableDecl def, JCTree expr) {
        return (JCTree.LetExpr) invoke(LetExprSingle, def, expr);
    }

    public JCTree.JCExpression Ident(JCTree.JCVariableDecl param) {
        return (JCTree.JCExpression) invoke(IdentVarDecl, param);
    }

    public List<JCTree.JCExpression> Idents(List<JCTree.JCVariableDecl> params) {
        return (List) invoke(Idents, params);
    }

    public JCTree.JCMethodInvocation App(JCTree.JCExpression meth, List<JCTree.JCExpression> args) {
        return (JCTree.JCMethodInvocation) invoke(App2, meth, args);
    }

    public JCTree.JCMethodInvocation App(JCTree.JCExpression meth) {
        return (JCTree.JCMethodInvocation) invoke(App1, meth);
    }

    public List<JCTree.JCAnnotation> Annotations(List<Attribute.Compound> attributes) {
        return (List) invoke(Annotations, attributes);
    }

    public JCTree.JCLiteral Literal(Object value) {
        return (JCTree.JCLiteral) invoke(LiteralWithValue, value);
    }

    public JCTree.JCAnnotation Annotation(Attribute a) {
        return (JCTree.JCAnnotation) invoke(AnnotationWithAttributeOnly, a);
    }

    public JCTree.JCAnnotation TypeAnnotation(Attribute a) {
        return (JCTree.JCAnnotation) invoke(TypeAnnotationWithAttributeOnly, a);
    }

    public JCTree.JCExpression AnnotatedType(List<JCTree.JCAnnotation> annotations, JCTree.JCExpression underlyingType) {
        return (JCTree.JCExpression) invoke(AnnotatedType, annotations, underlyingType);
    }

    public JCTree.JCStatement Call(JCTree.JCExpression apply) {
        return (JCTree.JCStatement) invoke(Call, apply);
    }

    public JCTree.JCExpression Type(Type type) {
        return (JCTree.JCExpression) invoke(Type, type);
    }

    public boolean hasReceiverParameter() {
        return has((FieldId<?>) MethodDecl_recvParam);
    }

    public JCTree.JCVariableDecl getReceiverParameter(JCTree.JCMethodDecl method) {
        return (JCTree.JCVariableDecl) get(method, MethodDecl_recvParam);
    }

    public void setReceiverParameter(JCTree.JCMethodDecl method, JCTree.JCVariableDecl param) {
        set(method, MethodDecl_recvParam, param);
    }
}
