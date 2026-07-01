package lombok.javac;

import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Attribute$Compound;
import com.sun.tools.javac.code.BoundKind;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCArrayAccess;
import com.sun.tools.javac.tree.JCTree$JCArrayTypeTree;
import com.sun.tools.javac.tree.JCTree$JCAssert;
import com.sun.tools.javac.tree.JCTree$JCAssign;
import com.sun.tools.javac.tree.JCTree$JCAssignOp;
import com.sun.tools.javac.tree.JCTree$JCBinary;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCBreak;
import com.sun.tools.javac.tree.JCTree$JCCase;
import com.sun.tools.javac.tree.JCTree$JCCatch;
import com.sun.tools.javac.tree.JCTree$JCClassDecl;
import com.sun.tools.javac.tree.JCTree$JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree$JCConditional;
import com.sun.tools.javac.tree.JCTree$JCContinue;
import com.sun.tools.javac.tree.JCTree$JCDoWhileLoop;
import com.sun.tools.javac.tree.JCTree$JCEnhancedForLoop;
import com.sun.tools.javac.tree.JCTree$JCErroneous;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCExpressionStatement;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import com.sun.tools.javac.tree.JCTree$JCForLoop;
import com.sun.tools.javac.tree.JCTree$JCIdent;
import com.sun.tools.javac.tree.JCTree$JCIf;
import com.sun.tools.javac.tree.JCTree$JCImport;
import com.sun.tools.javac.tree.JCTree$JCInstanceOf;
import com.sun.tools.javac.tree.JCTree$JCLabeledStatement;
import com.sun.tools.javac.tree.JCTree$JCLiteral;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree$JCModifiers;
import com.sun.tools.javac.tree.JCTree$JCNewArray;
import com.sun.tools.javac.tree.JCTree$JCNewClass;
import com.sun.tools.javac.tree.JCTree$JCParens;
import com.sun.tools.javac.tree.JCTree$JCPrimitiveTypeTree;
import com.sun.tools.javac.tree.JCTree$JCReturn;
import com.sun.tools.javac.tree.JCTree$JCSkip;
import com.sun.tools.javac.tree.JCTree$JCStatement;
import com.sun.tools.javac.tree.JCTree$JCSwitch;
import com.sun.tools.javac.tree.JCTree$JCSynchronized;
import com.sun.tools.javac.tree.JCTree$JCThrow;
import com.sun.tools.javac.tree.JCTree$JCTry;
import com.sun.tools.javac.tree.JCTree$JCTypeApply;
import com.sun.tools.javac.tree.JCTree$JCTypeCast;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.tree.JCTree$JCUnary;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.tree.JCTree$JCWhileLoop;
import com.sun.tools.javac.tree.JCTree$JCWildcard;
import com.sun.tools.javac.tree.JCTree$LetExpr;
import com.sun.tools.javac.tree.JCTree$TypeBoundKind;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker.SCL.lombok */
public class JavacTreeMaker {
    private final TreeMaker tm;
    private static final ConcurrentHashMap<JavacTreeMaker$FieldId<?>, Object> FIELD_CACHE = new ConcurrentHashMap<>();
    private static final Object REFLECTIVE_ITEM_NOT_FOUND = new Object[0];
    private static final Object REFLECTIVE_ITEM_MULTIPLE_FOUND = new Object[0];
    private static final ConcurrentHashMap<JavacTreeMaker$MethodId<?>, Object> METHOD_CACHE = new ConcurrentHashMap<>();
    private static final JavacTreeMaker$MethodId<JCTree$JCCompilationUnit> TopLevel = MethodId("TopLevel");
    private static final JavacTreeMaker$MethodId<JCTree$JCImport> Import = MethodId("Import");
    private static final JavacTreeMaker$MethodId<JCTree$JCClassDecl> ClassDef = MethodId("ClassDef");
    private static final JavacTreeMaker$MethodId<JCTree$JCMethodDecl> MethodDef = MethodId("MethodDef", JCTree$JCMethodDecl.class, JCTree$JCModifiers.class, Name.class, JCTree$JCExpression.class, List.class, List.class, List.class, JCTree$JCBlock.class, JCTree$JCExpression.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCMethodDecl> MethodDefWithRecvParam = MethodId("MethodDef", JCTree$JCMethodDecl.class, JCTree$JCModifiers.class, Name.class, JCTree$JCExpression.class, List.class, JCTree$JCVariableDecl.class, List.class, List.class, JCTree$JCBlock.class, JCTree$JCExpression.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCVariableDecl> VarDef = MethodId("VarDef");
    private static final JavacTreeMaker$MethodId<JCTree$JCVariableDecl> ReceiverVarDef = MethodId("ReceiverVarDef");
    private static final JavacTreeMaker$MethodId<JCTree$JCSkip> Skip = MethodId("Skip");
    private static final JavacTreeMaker$MethodId<JCTree$JCBlock> Block = MethodId("Block");
    private static final JavacTreeMaker$MethodId<JCTree$JCDoWhileLoop> DoLoop = MethodId("DoLoop");
    private static final JavacTreeMaker$MethodId<JCTree$JCWhileLoop> WhileLoop = MethodId("WhileLoop");
    private static final JavacTreeMaker$MethodId<JCTree$JCForLoop> ForLoop = MethodId("ForLoop");
    private static final JavacTreeMaker$MethodId<JCTree$JCEnhancedForLoop> ForeachLoop = MethodId("ForeachLoop");
    private static final JavacTreeMaker$MethodId<JCTree$JCLabeledStatement> Labelled = MethodId("Labelled");
    private static final JavacTreeMaker$MethodId<JCTree$JCSwitch> Switch = MethodId("Switch");
    private static final JavacTreeMaker$MethodId<JCTree$JCCase> Case11 = MethodId("Case", JCTree$JCCase.class, JCTree$JCExpression.class, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCSynchronized> Synchronized = MethodId("Synchronized");
    private static final JavacTreeMaker$MethodId<JCTree$JCTry> Try = MethodId("Try", JCTree$JCTry.class, JCTree$JCBlock.class, List.class, JCTree$JCBlock.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCTry> TryWithResources = MethodId("Try", JCTree$JCTry.class, List.class, JCTree$JCBlock.class, List.class, JCTree$JCBlock.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCCatch> Catch = MethodId("Catch");
    private static final JavacTreeMaker$MethodId<JCTree$JCConditional> Conditional = MethodId("Conditional");
    private static final JavacTreeMaker$MethodId<JCTree$JCIf> If = MethodId("If");
    private static final JavacTreeMaker$MethodId<JCTree$JCExpressionStatement> Exec = MethodId("Exec");
    private static final JavacTreeMaker$MethodId<JCTree$JCBreak> Break11 = MethodId("Break", JCTree$JCBreak.class, Name.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCBreak> Break12 = MethodId("Break", JCTree$JCBreak.class, JCTree$JCExpression.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCContinue> Continue = MethodId("Continue");
    private static final JavacTreeMaker$MethodId<JCTree$JCReturn> Return = MethodId("Return");
    private static final JavacTreeMaker$MethodId<JCTree$JCThrow> Throw = MethodId("Throw");
    private static final JavacTreeMaker$MethodId<JCTree$JCAssert> Assert = MethodId("Assert");
    private static final JavacTreeMaker$MethodId<JCTree$JCMethodInvocation> Apply = MethodId("Apply");
    private static final JavacTreeMaker$MethodId<JCTree$JCNewClass> NewClass = MethodId("NewClass");
    private static final JavacTreeMaker$MethodId<JCTree$JCNewArray> NewArray = MethodId("NewArray");
    private static final JavacTreeMaker$MethodId<JCTree$JCParens> Parens = MethodId("Parens");
    private static final JavacTreeMaker$MethodId<JCTree$JCAssign> Assign = MethodId("Assign");
    private static final JavacTreeMaker$MethodId<JCTree$JCAssignOp> Assignop = MethodId("Assignop");
    private static final JavacTreeMaker$MethodId<JCTree$JCUnary> Unary = MethodId("Unary");
    private static final JavacTreeMaker$MethodId<JCTree$JCBinary> Binary = MethodId("Binary");
    private static final JavacTreeMaker$MethodId<JCTree$JCTypeCast> TypeCast = MethodId("TypeCast");
    private static final JavacTreeMaker$MethodId<JCTree$JCInstanceOf> TypeTest = MethodId("TypeTest");
    private static final JavacTreeMaker$MethodId<JCTree$JCArrayAccess> Indexed = MethodId("Indexed");
    private static final JavacTreeMaker$MethodId<JCTree$JCFieldAccess> Select = MethodId("Select");
    private static final JavacTreeMaker$MethodId<JCTree$JCIdent> Ident = MethodId("Ident", JCTree$JCIdent.class, Name.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCLiteral> Literal = MethodId("Literal", JCTree$JCLiteral.class, JavacTreeMaker$TypeTag.class, Object.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCPrimitiveTypeTree> TypeIdent = MethodId("TypeIdent");
    private static final JavacTreeMaker$MethodId<JCTree$JCArrayTypeTree> TypeArray = MethodId("TypeArray");
    private static final JavacTreeMaker$MethodId<JCTree$JCTypeApply> TypeApply = MethodId("TypeApply");
    private static final JavacTreeMaker$MethodId<JCTree$JCTypeParameter> TypeParameter = MethodId("TypeParameter", JCTree$JCTypeParameter.class, Name.class, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCTypeParameter> TypeParameterWithAnnos = MethodId("TypeParameter", JCTree$JCTypeParameter.class, Name.class, List.class, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCWildcard> Wildcard = MethodId("Wildcard");
    private static final JavacTreeMaker$MethodId<JCTree$TypeBoundKind> TypeBoundKind = MethodId("TypeBoundKind");
    private static final JavacTreeMaker$MethodId<JCTree$JCAnnotation> Annotation = MethodId("Annotation", JCTree$JCAnnotation.class, JCTree.class, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCAnnotation> TypeAnnotation = MethodId("TypeAnnotation", JCTree$JCAnnotation.class, JCTree.class, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCModifiers> ModifiersWithAnnotations = MethodId("Modifiers", JCTree$JCModifiers.class, Long.TYPE, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCModifiers> Modifiers = MethodId("Modifiers", JCTree$JCModifiers.class, Long.TYPE);
    private static final JavacTreeMaker$MethodId<JCTree$JCErroneous> Erroneous = MethodId("Erroneous", JCTree$JCErroneous.class, new Class[0]);
    private static final JavacTreeMaker$MethodId<JCTree$JCErroneous> ErroneousWithErrs = MethodId("Erroneous", JCTree$JCErroneous.class, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$LetExpr> LetExpr = MethodId("LetExpr", JCTree$LetExpr.class, List.class, JCTree.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCClassDecl> AnonymousClassDef = MethodId("AnonymousClassDef");
    private static final JavacTreeMaker$MethodId<JCTree$LetExpr> LetExprSingle = MethodId("LetExpr", JCTree$LetExpr.class, JCTree$JCVariableDecl.class, JCTree.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCIdent> IdentVarDecl = MethodId("Ident", JCTree$JCIdent.class, JCTree$JCVariableDecl.class);
    private static final JavacTreeMaker$MethodId<List<JCTree$JCExpression>> Idents = MethodId("Idents");
    private static final JavacTreeMaker$MethodId<JCTree$JCMethodInvocation> App2 = MethodId("App", JCTree$JCMethodInvocation.class, JCTree$JCExpression.class, List.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCMethodInvocation> App1 = MethodId("App", JCTree$JCMethodInvocation.class, JCTree$JCExpression.class);
    private static final JavacTreeMaker$MethodId<List<JCTree$JCAnnotation>> Annotations = MethodId("Annotations");
    private static final JavacTreeMaker$MethodId<JCTree$JCLiteral> LiteralWithValue = MethodId("Literal", JCTree$JCLiteral.class, Object.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCAnnotation> AnnotationWithAttributeOnly = MethodId("Annotation", JCTree$JCAnnotation.class, Attribute.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCAnnotation> TypeAnnotationWithAttributeOnly = MethodId("TypeAnnotation", JCTree$JCAnnotation.class, Attribute.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCExpression> AnnotatedType = MethodId("AnnotatedType", JCTree$JCExpression.class, List.class, JCTree$JCExpression.class);
    private static final JavacTreeMaker$MethodId<JCTree$JCStatement> Call = MethodId("Call");
    private static final JavacTreeMaker$MethodId<JCTree$JCExpression> Type = MethodId("Type");
    private static final JavacTreeMaker$FieldId<JCTree$JCVariableDecl> MethodDecl_recvParam = FieldId(JCTree$JCMethodDecl.class, "recvparam", JCTree$JCVariableDecl.class);

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

    static <J> JavacTreeMaker$MethodId<J> MethodId(Class<?> owner, String name, Class<J> returnType, Class<?>... clsArr) {
        return new JavacTreeMaker$MethodId<>(owner, name, returnType, clsArr);
    }

    static <J> JavacTreeMaker$MethodId<J> MethodId(String name, Class<J> returnType, Class<?>... clsArr) {
        return new JavacTreeMaker$MethodId<>(TreeMaker.class, name, returnType, clsArr);
    }

    static <J> JavacTreeMaker$MethodId<J> MethodId(String name) {
        for (Method m : JavacTreeMaker.class.getDeclaredMethods()) {
            if (m.getName().equals(name)) {
                return new JavacTreeMaker$MethodId<>(TreeMaker.class, name, m.getReturnType(), m.getParameterTypes());
            }
        }
        throw new InternalError("Not found: " + name);
    }

    static <J> JavacTreeMaker$FieldId<J> FieldId(Class<?> owner, String name, Class<J> fieldType) {
        return new JavacTreeMaker$FieldId<>(owner, name, fieldType);
    }

    private static boolean has(JavacTreeMaker$FieldId<?> f) {
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

    private static <J> J get(Object obj, JavacTreeMaker$FieldId<J> javacTreeMaker$FieldId) {
        try {
            return (J) JavacTreeMaker$FieldId.access$0(javacTreeMaker$FieldId).cast(getFromCache((JavacTreeMaker$FieldId<?>) javacTreeMaker$FieldId).get(obj));
        } catch (IllegalAccessException e) {
            throw Javac.sneakyThrow(e);
        }
    }

    private static <J> void set(Object owner, JavacTreeMaker$FieldId<J> f, J val) {
        Field field = getFromCache((JavacTreeMaker$FieldId<?>) f);
        try {
            field.set(owner, val);
        } catch (IllegalAccessException e) {
            throw Javac.sneakyThrow(e);
        } catch (IllegalArgumentException e2) {
            System.err.println("Type mismatch for: " + field);
            throw e2;
        }
    }

    private static Field getFromCache(JavacTreeMaker$FieldId<?> f) {
        Object s2 = FIELD_CACHE.get(f);
        if (s2 == null) {
            s2 = addToCache(f);
        }
        if (s2 == REFLECTIVE_ITEM_NOT_FOUND) {
            throw new IllegalStateException("Lombok TreeMaker frontend issue: no match when looking for field: " + f);
        }
        return (Field) s2;
    }

    private static Object addToCache(JavacTreeMaker$FieldId<?> f) {
        for (Field field : JavacTreeMaker$FieldId.access$1(f).getDeclaredFields()) {
            if (JavacTreeMaker$FieldId.access$2(f).equals(field.getName())) {
                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }
                return FIELD_CACHE.putIfAbsent(f, field);
            }
        }
        return FIELD_CACHE.putIfAbsent(f, REFLECTIVE_ITEM_NOT_FOUND);
    }

    private boolean has(JavacTreeMaker$MethodId<?> m) {
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

    private <J> J invoke(JavacTreeMaker$MethodId<J> javacTreeMaker$MethodId, Object... objArr) {
        return (J) invokeAny(this.tm, javacTreeMaker$MethodId, objArr);
    }

    static /* synthetic */ Object access$0(Object obj, JavacTreeMaker$MethodId javacTreeMaker$MethodId, Object[] objArr) {
        return invokeAny(obj, javacTreeMaker$MethodId, objArr);
    }

    private static <J> J invokeAny(Object obj, JavacTreeMaker$MethodId<J> javacTreeMaker$MethodId, Object... objArr) {
        Method fromCache = getFromCache((JavacTreeMaker$MethodId<?>) javacTreeMaker$MethodId);
        try {
            if (JavacTreeMaker$MethodId.access$0(javacTreeMaker$MethodId).isPrimitive()) {
                return (J) fromCache.invoke(obj, objArr);
            }
            return (J) JavacTreeMaker$MethodId.access$0(javacTreeMaker$MethodId).cast(fromCache.invoke(obj, objArr));
        } catch (IllegalAccessException e) {
            throw Javac.sneakyThrow(e);
        } catch (IllegalArgumentException e2) {
            System.err.println("Type mismatch for: " + fromCache);
            throw e2;
        } catch (InvocationTargetException e3) {
            throw Javac.sneakyThrow(e3.getCause());
        }
    }

    private static boolean tryResolve(JavacTreeMaker$MethodId<?> m) {
        Object s2 = METHOD_CACHE.get(m);
        if (s2 == null) {
            s2 = addToCache(m);
        }
        return s2 instanceof Method;
    }

    private static Method getFromCache(JavacTreeMaker$MethodId<?> m) {
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

    private static Object addToCache(JavacTreeMaker$MethodId<?> m) {
        Method found = null;
        for (Method method : JavacTreeMaker$MethodId.access$1(m).getDeclaredMethods()) {
            if (JavacTreeMaker$MethodId.access$2(m).equals(method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == JavacTreeMaker$MethodId.access$3(m).length) {
                    int i = 0;
                    while (true) {
                        if (i < parameterTypes.length) {
                            if (Symbol.class.isAssignableFrom(parameterTypes[i])) {
                                break;
                            }
                            if (!JavacTreeMaker$SchroedingerType.class.isAssignableFrom(JavacTreeMaker$MethodId.access$3(m)[i])) {
                                if (parameterTypes[i].isPrimitive()) {
                                    if (parameterTypes[i] != JavacTreeMaker$MethodId.access$3(m)[i]) {
                                        break;
                                    }
                                } else if (!parameterTypes[i].isAssignableFrom(JavacTreeMaker$MethodId.access$3(m)[i])) {
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

    public JCTree$JCCompilationUnit TopLevel(List<JCTree$JCAnnotation> packageAnnotations, JCTree$JCExpression pid, List<JCTree> defs) {
        return (JCTree$JCCompilationUnit) invoke(TopLevel, packageAnnotations, pid, defs);
    }

    public JCTree$JCImport Import(JCTree qualid, boolean staticImport) {
        return (JCTree$JCImport) invoke(Import, qualid, Boolean.valueOf(staticImport));
    }

    public JCTree$JCClassDecl ClassDef(JCTree$JCModifiers mods, Name name, List<JCTree$JCTypeParameter> typarams, JCTree$JCExpression extending, List<JCTree$JCExpression> implementing, List<JCTree> defs) {
        return (JCTree$JCClassDecl) invoke(ClassDef, mods, name, typarams, extending, implementing, defs);
    }

    public JCTree$JCMethodDecl MethodDef(JCTree$JCModifiers mods, Name name, JCTree$JCExpression resType, List<JCTree$JCTypeParameter> typarams, List<JCTree$JCVariableDecl> params, List<JCTree$JCExpression> thrown, JCTree$JCBlock body, JCTree$JCExpression defaultValue) {
        return (JCTree$JCMethodDecl) invoke(MethodDef, mods, name, resType, typarams, params, thrown, body, defaultValue);
    }

    public boolean hasMethodDefWithRecvParam() {
        return has((JavacTreeMaker$MethodId<?>) MethodDefWithRecvParam);
    }

    public JCTree$JCMethodDecl MethodDefWithRecvParam(JCTree$JCModifiers mods, Name name, JCTree$JCExpression resType, List<JCTree$JCTypeParameter> typarams, JCTree$JCVariableDecl recvparam, List<JCTree$JCVariableDecl> params, List<JCTree$JCExpression> thrown, JCTree$JCBlock body, JCTree$JCExpression defaultValue) {
        return (JCTree$JCMethodDecl) invoke(MethodDefWithRecvParam, mods, name, resType, typarams, recvparam, params, thrown, body, defaultValue);
    }

    public JCTree$JCVariableDecl VarDef(JCTree$JCModifiers mods, Name name, JCTree$JCExpression vartype, JCTree$JCExpression init) {
        JCTree$JCVariableDecl varDef = (JCTree$JCVariableDecl) invoke(VarDef, mods, name, vartype, init);
        if (varDef.vartype != null && varDef.vartype.pos == -1) {
            varDef.vartype.pos = 0;
        }
        return varDef;
    }

    public JCTree$JCVariableDecl ReceiverVarDef(JCTree$JCModifiers mods, JCTree$JCExpression name, JCTree$JCExpression vartype) {
        return (JCTree$JCVariableDecl) invoke(ReceiverVarDef, mods, name, vartype);
    }

    public JCTree$JCSkip Skip() {
        return (JCTree$JCSkip) invoke(Skip, new Object[0]);
    }

    public JCTree$JCBlock Block(long flags, List<JCTree$JCStatement> stats) {
        return (JCTree$JCBlock) invoke(Block, Long.valueOf(flags), stats);
    }

    public JCTree$JCDoWhileLoop DoLoop(JCTree$JCStatement body, JCTree$JCExpression cond) {
        return (JCTree$JCDoWhileLoop) invoke(DoLoop, body, cond);
    }

    public JCTree$JCWhileLoop WhileLoop(JCTree$JCExpression cond, JCTree$JCStatement body) {
        return (JCTree$JCWhileLoop) invoke(WhileLoop, cond, body);
    }

    public JCTree$JCForLoop ForLoop(List<JCTree$JCStatement> init, JCTree$JCExpression cond, List<JCTree$JCExpressionStatement> step, JCTree$JCStatement body) {
        return (JCTree$JCForLoop) invoke(ForLoop, init, cond, step, body);
    }

    public JCTree$JCEnhancedForLoop ForeachLoop(JCTree$JCVariableDecl var, JCTree$JCExpression expr, JCTree$JCStatement body) {
        return (JCTree$JCEnhancedForLoop) invoke(ForeachLoop, var, expr, body);
    }

    public JCTree$JCLabeledStatement Labelled(Name label, JCTree$JCStatement body) {
        return (JCTree$JCLabeledStatement) invoke(Labelled, label, body);
    }

    public JCTree$JCSwitch Switch(JCTree$JCExpression selector, List<JCTree$JCCase> cases) {
        return (JCTree$JCSwitch) invoke(Switch, selector, cases);
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

    public JCTree$JCCase Case(JCTree$JCExpression pat, List<JCTree$JCStatement> stats) {
        if (tryResolve(Case11)) {
            return (JCTree$JCCase) invoke(Case11, pat, stats);
        }
        JavacTreeMaker$MethodId<JCTree$JCCase> javacTreeMaker$MethodId = JavacTreeMaker$Case12.Case12;
        Object[] objArr = new Object[4];
        objArr[0] = JavacTreeMaker$Case12.CASE_KIND_STATEMENT;
        objArr[1] = pat == null ? List.nil() : List.of(pat);
        objArr[2] = stats;
        objArr[3] = null;
        return (JCTree$JCCase) invoke(javacTreeMaker$MethodId, objArr);
    }

    public JCTree$JCSynchronized Synchronized(JCTree$JCExpression lock, JCTree$JCBlock body) {
        return (JCTree$JCSynchronized) invoke(Synchronized, lock, body);
    }

    public JCTree$JCTry Try(JCTree$JCBlock body, List<JCTree$JCCatch> catchers, JCTree$JCBlock finalizer) {
        return (JCTree$JCTry) invoke(Try, body, catchers, finalizer);
    }

    public JCTree$JCTry Try(List<JCTree> resources, JCTree$JCBlock body, List<JCTree$JCCatch> catchers, JCTree$JCBlock finalizer) {
        return (JCTree$JCTry) invoke(TryWithResources, resources, body, catchers, finalizer);
    }

    public JCTree$JCCatch Catch(JCTree$JCVariableDecl param, JCTree$JCBlock body) {
        return (JCTree$JCCatch) invoke(Catch, param, body);
    }

    public JCTree$JCConditional Conditional(JCTree$JCExpression cond, JCTree$JCExpression thenpart, JCTree$JCExpression elsepart) {
        return (JCTree$JCConditional) invoke(Conditional, cond, thenpart, elsepart);
    }

    public JCTree$JCIf If(JCTree$JCExpression cond, JCTree$JCStatement thenpart, JCTree$JCStatement elsepart) {
        return (JCTree$JCIf) invoke(If, cond, thenpart, elsepart);
    }

    public JCTree$JCExpressionStatement Exec(JCTree$JCExpression expr) {
        return (JCTree$JCExpressionStatement) invoke(Exec, expr);
    }

    public JCTree$JCBreak Break(Name label) {
        if (tryResolve(Break11)) {
            return (JCTree$JCBreak) invoke(Break11, label);
        }
        JavacTreeMaker$MethodId<JCTree$JCBreak> javacTreeMaker$MethodId = Break12;
        Object[] objArr = new Object[1];
        objArr[0] = label != null ? Ident(label) : null;
        return (JCTree$JCBreak) invoke(javacTreeMaker$MethodId, objArr);
    }

    public JCTree$JCContinue Continue(Name label) {
        return (JCTree$JCContinue) invoke(Continue, label);
    }

    public JCTree$JCReturn Return(JCTree$JCExpression expr) {
        return (JCTree$JCReturn) invoke(Return, expr);
    }

    public JCTree$JCThrow Throw(JCTree$JCExpression expr) {
        return (JCTree$JCThrow) invoke(Throw, expr);
    }

    public JCTree$JCAssert Assert(JCTree$JCExpression cond, JCTree$JCExpression detail) {
        return (JCTree$JCAssert) invoke(Assert, cond, detail);
    }

    public JCTree$JCMethodInvocation Apply(List<JCTree$JCExpression> typeargs, JCTree$JCExpression fn, List<JCTree$JCExpression> args) {
        return (JCTree$JCMethodInvocation) invoke(Apply, typeargs, fn, args);
    }

    public JCTree$JCNewClass NewClass(JCTree$JCExpression encl, List<JCTree$JCExpression> typeargs, JCTree$JCExpression clazz, List<JCTree$JCExpression> args, JCTree$JCClassDecl def) {
        return (JCTree$JCNewClass) invoke(NewClass, encl, typeargs, clazz, args, def);
    }

    public JCTree$JCNewArray NewArray(JCTree$JCExpression elemtype, List<JCTree$JCExpression> dims, List<JCTree$JCExpression> elems) {
        return (JCTree$JCNewArray) invoke(NewArray, elemtype, dims, elems);
    }

    public JCTree$JCParens Parens(JCTree$JCExpression expr) {
        return (JCTree$JCParens) invoke(Parens, expr);
    }

    public JCTree$JCAssign Assign(JCTree$JCExpression lhs, JCTree$JCExpression rhs) {
        return (JCTree$JCAssign) invoke(Assign, lhs, rhs);
    }

    public JCTree$JCAssignOp Assignop(JavacTreeMaker$TreeTag opcode, JCTree lhs, JCTree rhs) {
        return (JCTree$JCAssignOp) invoke(Assignop, opcode.value, lhs, rhs);
    }

    public JCTree$JCUnary Unary(JavacTreeMaker$TreeTag opcode, JCTree$JCExpression arg) {
        return (JCTree$JCUnary) invoke(Unary, opcode.value, arg);
    }

    public JCTree$JCBinary Binary(JavacTreeMaker$TreeTag opcode, JCTree$JCExpression lhs, JCTree$JCExpression rhs) {
        return (JCTree$JCBinary) invoke(Binary, opcode.value, lhs, rhs);
    }

    public JCTree$JCTypeCast TypeCast(JCTree expr, JCTree$JCExpression type) {
        return (JCTree$JCTypeCast) invoke(TypeCast, expr, type);
    }

    public JCTree$JCInstanceOf TypeTest(JCTree$JCExpression expr, JCTree clazz) {
        return (JCTree$JCInstanceOf) invoke(TypeTest, expr, clazz);
    }

    public JCTree$JCArrayAccess Indexed(JCTree$JCExpression indexed, JCTree$JCExpression index) {
        return (JCTree$JCArrayAccess) invoke(Indexed, indexed, index);
    }

    public JCTree$JCFieldAccess Select(JCTree$JCExpression selected, Name selector) {
        return (JCTree$JCFieldAccess) invoke(Select, selected, selector);
    }

    public JCTree$JCIdent Ident(Name idname) {
        return (JCTree$JCIdent) invoke(Ident, idname);
    }

    public JCTree$JCLiteral Literal(JavacTreeMaker$TypeTag tag, Object value) {
        return (JCTree$JCLiteral) invoke(Literal, tag.value, value);
    }

    public JCTree$JCPrimitiveTypeTree TypeIdent(JavacTreeMaker$TypeTag typetag) {
        return (JCTree$JCPrimitiveTypeTree) invoke(TypeIdent, typetag.value);
    }

    public JCTree$JCArrayTypeTree TypeArray(JCTree$JCExpression elemtype) {
        return (JCTree$JCArrayTypeTree) invoke(TypeArray, elemtype);
    }

    public JCTree$JCTypeApply TypeApply(JCTree$JCExpression clazz, List<JCTree$JCExpression> arguments) {
        return (JCTree$JCTypeApply) invoke(TypeApply, clazz, arguments);
    }

    public JCTree$JCTypeParameter TypeParameter(Name name, List<JCTree$JCExpression> bounds) {
        return (JCTree$JCTypeParameter) invoke(TypeParameter, name, bounds);
    }

    public JCTree$JCTypeParameter TypeParameter(Name name, List<JCTree$JCExpression> bounds, List<JCTree$JCAnnotation> annos) {
        return (JCTree$JCTypeParameter) invoke(TypeParameterWithAnnos, name, bounds, annos);
    }

    public JCTree$JCWildcard Wildcard(JCTree$TypeBoundKind kind, JCTree type) {
        return (JCTree$JCWildcard) invoke(Wildcard, kind, type);
    }

    public JCTree$TypeBoundKind TypeBoundKind(BoundKind kind) {
        return (JCTree$TypeBoundKind) invoke(TypeBoundKind, kind);
    }

    public JCTree$JCAnnotation Annotation(JCTree annotationType, List<JCTree$JCExpression> args) {
        return (JCTree$JCAnnotation) invoke(Annotation, annotationType, args);
    }

    public JCTree$JCAnnotation TypeAnnotation(JCTree annotationType, List<JCTree$JCExpression> args) {
        return (JCTree$JCAnnotation) invoke(TypeAnnotation, annotationType, args);
    }

    public JCTree$JCModifiers Modifiers(long flags, List<JCTree$JCAnnotation> annotations) {
        return (JCTree$JCModifiers) invoke(ModifiersWithAnnotations, Long.valueOf(flags), annotations);
    }

    public JCTree$JCModifiers Modifiers(long flags) {
        return (JCTree$JCModifiers) invoke(Modifiers, Long.valueOf(flags));
    }

    public JCTree$JCErroneous Erroneous() {
        return (JCTree$JCErroneous) invoke(Erroneous, new Object[0]);
    }

    public JCTree$JCErroneous Erroneous(List<? extends JCTree> errs) {
        return (JCTree$JCErroneous) invoke(ErroneousWithErrs, errs);
    }

    public JCTree$LetExpr LetExpr(List<JCTree$JCVariableDecl> defs, JCTree expr) {
        return (JCTree$LetExpr) invoke(LetExpr, defs, expr);
    }

    public JCTree$JCClassDecl AnonymousClassDef(JCTree$JCModifiers mods, List<JCTree> defs) {
        return (JCTree$JCClassDecl) invoke(AnonymousClassDef, mods, defs);
    }

    public JCTree$LetExpr LetExpr(JCTree$JCVariableDecl def, JCTree expr) {
        return (JCTree$LetExpr) invoke(LetExprSingle, def, expr);
    }

    public JCTree$JCExpression Ident(JCTree$JCVariableDecl param) {
        return (JCTree$JCExpression) invoke(IdentVarDecl, param);
    }

    public List<JCTree$JCExpression> Idents(List<JCTree$JCVariableDecl> params) {
        return (List) invoke(Idents, params);
    }

    public JCTree$JCMethodInvocation App(JCTree$JCExpression meth, List<JCTree$JCExpression> args) {
        return (JCTree$JCMethodInvocation) invoke(App2, meth, args);
    }

    public JCTree$JCMethodInvocation App(JCTree$JCExpression meth) {
        return (JCTree$JCMethodInvocation) invoke(App1, meth);
    }

    public List<JCTree$JCAnnotation> Annotations(List<Attribute$Compound> attributes) {
        return (List) invoke(Annotations, attributes);
    }

    public JCTree$JCLiteral Literal(Object value) {
        return (JCTree$JCLiteral) invoke(LiteralWithValue, value);
    }

    public JCTree$JCAnnotation Annotation(Attribute a) {
        return (JCTree$JCAnnotation) invoke(AnnotationWithAttributeOnly, a);
    }

    public JCTree$JCAnnotation TypeAnnotation(Attribute a) {
        return (JCTree$JCAnnotation) invoke(TypeAnnotationWithAttributeOnly, a);
    }

    public JCTree$JCExpression AnnotatedType(List<JCTree$JCAnnotation> annotations, JCTree$JCExpression underlyingType) {
        return (JCTree$JCExpression) invoke(AnnotatedType, annotations, underlyingType);
    }

    public JCTree$JCStatement Call(JCTree$JCExpression apply) {
        return (JCTree$JCStatement) invoke(Call, apply);
    }

    public JCTree$JCExpression Type(Type type) {
        return (JCTree$JCExpression) invoke(Type, type);
    }

    public boolean hasReceiverParameter() {
        return has((JavacTreeMaker$FieldId<?>) MethodDecl_recvParam);
    }

    public JCTree$JCVariableDecl getReceiverParameter(JCTree$JCMethodDecl method) {
        return (JCTree$JCVariableDecl) get(method, MethodDecl_recvParam);
    }

    public void setReceiverParameter(JCTree$JCMethodDecl method, JCTree$JCVariableDecl param) {
        set(method, MethodDecl_recvParam, param);
    }
}
