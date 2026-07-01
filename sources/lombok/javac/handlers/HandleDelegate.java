package lombok.javac.handlers;

import com.discord.api.permission.Permission;
import com.sun.tools.javac.code.Attribute$Compound;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symbol$MethodSymbol;
import com.sun.tools.javac.code.Symbol$TypeSymbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.code.Type$ClassType;
import com.sun.tools.javac.code.Type$TypeVar;
import com.sun.tools.javac.code.Types;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree$JCAnnotation;
import com.sun.tools.javac.tree.JCTree$JCBlock;
import com.sun.tools.javac.tree.JCTree$JCExpression;
import com.sun.tools.javac.tree.JCTree$JCFieldAccess;
import com.sun.tools.javac.tree.JCTree$JCMethodDecl;
import com.sun.tools.javac.tree.JCTree$JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree$JCModifiers;
import com.sun.tools.javac.tree.JCTree$JCTypeParameter;
import com.sun.tools.javac.tree.JCTree$JCVariableDecl;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import lombok.ConfigurationKeys;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.experimental.Delegate;
import lombok.javac.FindTypeVarScanner;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;
import lombok.javac.JavacResolution$TypeNotConvertibleException;
import lombok.javac.JavacTreeMaker;
import lombok.javac.ResolutionResetNeeded;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleDelegate.SCL.lombok */
@HandlerPriority(65536)
@ResolutionResetNeeded
public class HandleDelegate extends JavacAnnotationHandler<Delegate> {
    private static final List<String> METHODS_IN_OBJECT = Collections.unmodifiableList(Arrays.asList("hashCode()", "canEqual(java.lang.Object)", "equals(java.lang.Object)", "wait()", "wait(long)", "wait(long, int)", "notify()", "notifyAll()", "toString()", "getClass()", "clone()", "finalize()"));
    private static final String LEGALITY_OF_DELEGATE = "@Delegate is legal only on instance fields or no-argument instance methods.";
    private static final String RECURSION_NOT_ALLOWED = "@Delegate does not support recursion (delegating to a type that itself has @Delegate members). Member \"%s\" is @Delegate in type \"%s\"";
    public static final int HANDLE_DELEGATE_PRIORITY = 65536;

    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<Delegate> annotation, JCTree$JCAnnotation ast, JavacNode annotationNode) {
        HandleDelegate$DelegateReceiver delegateReceiver;
        Type delegateType;
        HandlerUtil.handleExperimentalFlagUsage(annotationNode, ConfigurationKeys.DELEGATE_FLAG_USAGE, "@Delegate");
        JavacHandlerUtil.deleteAnnotationIfNeccessary(annotationNode, (Class<? extends Annotation>) Delegate.class, (Class<? extends Annotation>) lombok.Delegate.class);
        Name delegateName = annotationNode.toName(annotationNode.up().getName());
        JavacResolution reso = new JavacResolution(annotationNode.getContext());
        JCTree$JCVariableDecl jCTree$JCVariableDecl = (JCTree) annotationNode.up().get();
        if (annotationNode.up().getKind() == AST$Kind.FIELD) {
            if ((jCTree$JCVariableDecl.mods.flags & 8) != 0) {
                annotationNode.addError(LEGALITY_OF_DELEGATE);
                return;
            }
            delegateReceiver = HandleDelegate$DelegateReceiver.FIELD;
            Type delegateType2 = ((JCTree) jCTree$JCVariableDecl).type;
            if (delegateType2 == null) {
                reso.resolveClassMember(annotationNode.up());
            }
            delegateType = ((JCTree) jCTree$JCVariableDecl).type;
        } else if (annotationNode.up().getKind() == AST$Kind.METHOD) {
            if (!(jCTree$JCVariableDecl instanceof JCTree$JCMethodDecl)) {
                annotationNode.addError(LEGALITY_OF_DELEGATE);
                return;
            }
            JCTree$JCMethodDecl methodDecl = (JCTree$JCMethodDecl) jCTree$JCVariableDecl;
            if (!methodDecl.params.isEmpty() || (methodDecl.mods.flags & 8) != 0) {
                annotationNode.addError(LEGALITY_OF_DELEGATE);
                return;
            }
            delegateReceiver = HandleDelegate$DelegateReceiver.METHOD;
            Type delegateType3 = methodDecl.restype.type;
            if (delegateType3 == null) {
                reso.resolveClassMember(annotationNode.up());
            }
            delegateType = methodDecl.restype.type;
        } else {
            return;
        }
        List<Object> delegateTypes = annotation.getActualExpressions("types");
        List<Object> excludeTypes = annotation.getActualExpressions("excludes");
        List<Type> toDelegate = new ArrayList<>();
        List<Type> toExclude = new ArrayList<>();
        if (delegateTypes.isEmpty()) {
            if (delegateType != null) {
                toDelegate.add(delegateType);
            }
        } else {
            for (Object dt : delegateTypes) {
                if ((dt instanceof JCTree$JCFieldAccess) && ((JCTree$JCFieldAccess) dt).name.toString().equals("class")) {
                    if (((JCTree$JCFieldAccess) dt).selected.type == null) {
                        reso.resolveClassMember(annotationNode);
                    }
                    Type type = ((JCTree$JCFieldAccess) dt).selected.type;
                    if (type != null) {
                        toDelegate.add(type);
                    }
                }
            }
        }
        for (Object et : excludeTypes) {
            if ((et instanceof JCTree$JCFieldAccess) && ((JCTree$JCFieldAccess) et).name.toString().equals("class")) {
                if (((JCTree$JCFieldAccess) et).selected.type == null) {
                    reso.resolveClassMember(annotationNode);
                }
                Type type2 = ((JCTree$JCFieldAccess) et).selected.type;
                if (type2 != null) {
                    toExclude.add(type2);
                }
            }
        }
        List<HandleDelegate$MethodSig> signaturesToDelegate = new ArrayList<>();
        List<HandleDelegate$MethodSig> signaturesToExclude = new ArrayList<>();
        Set<String> banList = new HashSet<>();
        banList.addAll(METHODS_IN_OBJECT);
        JavacNode typeNode = JavacHandlerUtil.upToTypeNode(annotationNode);
        for (Symbol m : typeNode.get().sym.getEnclosedElements()) {
            if (m instanceof Symbol$MethodSymbol) {
                banList.add(printSig(m.asType(), m.name, annotationNode.getTypesUtil()));
            }
        }
        try {
            for (Type t : toExclude) {
                if (t instanceof Type$ClassType) {
                    Type$ClassType ct = (Type$ClassType) t;
                    addMethodBindings(signaturesToExclude, ct, annotationNode.getTypesUtil(), banList);
                } else {
                    annotationNode.addError("@Delegate can only use concrete class types, not wildcards, arrays, type variables, or primitives.");
                    return;
                }
            }
            for (HandleDelegate$MethodSig sig : signaturesToExclude) {
                banList.add(printSig(sig.type, sig.name, annotationNode.getTypesUtil()));
            }
            Iterator<Type> it = toDelegate.iterator();
            while (it.hasNext()) {
                Type unannotatedType = HandleDelegate$Unannotated.unannotatedType(it.next());
                if (unannotatedType instanceof Type$ClassType) {
                    Type$ClassType ct2 = (Type$ClassType) unannotatedType;
                    addMethodBindings(signaturesToDelegate, ct2, annotationNode.getTypesUtil(), banList);
                } else {
                    annotationNode.addError("@Delegate can only use concrete class types, not wildcards, arrays, type variables, or primitives.");
                    return;
                }
            }
            Iterator<HandleDelegate$MethodSig> it2 = signaturesToDelegate.iterator();
            while (it2.hasNext()) {
                generateAndAdd(it2.next(), annotationNode, delegateName, delegateReceiver);
            }
        } catch (HandleDelegate$DelegateRecursion e) {
            annotationNode.addError(String.format(RECURSION_NOT_ALLOWED, e.member, e.type));
        }
    }

    public void generateAndAdd(HandleDelegate$MethodSig sig, JavacNode annotation, Name delegateName, HandleDelegate$DelegateReceiver delegateReceiver) {
        List<JCTree$JCMethodDecl> toAdd = new ArrayList<>();
        try {
            toAdd.add(createDelegateMethod(sig, annotation, delegateName, delegateReceiver));
            for (JCTree$JCMethodDecl method : toAdd) {
                JavacHandlerUtil.injectMethod(annotation.up().up(), method);
            }
        } catch (JavacResolution$TypeNotConvertibleException e) {
            annotation.addError("Can't create delegate method for " + sig.name + ": " + e.getMessage());
        } catch (HandleDelegate$CantMakeDelegates e2) {
            annotation.addError("There's a conflict in the names of type parameters. Fix it by renaming the following type parameters of your class: " + e2.conflicted);
        }
    }

    public void checkConflictOfTypeVarNames(HandleDelegate$MethodSig sig, JavacNode annotation) throws HandleDelegate$CantMakeDelegates {
        com.sun.tools.javac.util.List<JCTree$JCTypeParameter> list;
        if (sig.elem.getTypeParameters().isEmpty()) {
            return;
        }
        Set<String> usedInOurType = new HashSet<>();
        JavacNode javacNodeUp = annotation;
        while (true) {
            JavacNode enclosingType = javacNodeUp;
            if (enclosingType == null) {
                break;
            }
            if (enclosingType.getKind() == AST$Kind.TYPE && (list = enclosingType.get().typarams) != null) {
                for (JCTree$JCTypeParameter param : list) {
                    if (param.name != null) {
                        usedInOurType.add(param.name.toString());
                    }
                }
            }
            javacNodeUp = enclosingType.up();
        }
        Set<String> usedInMethodSig = new HashSet<>();
        Iterator it = sig.elem.getTypeParameters().iterator();
        while (it.hasNext()) {
            usedInMethodSig.add(((TypeParameterElement) it.next()).getSimpleName().toString());
        }
        usedInMethodSig.retainAll(usedInOurType);
        if (usedInMethodSig.isEmpty()) {
            return;
        }
        FindTypeVarScanner scanner = new FindTypeVarScanner();
        sig.elem.asType().accept(scanner, (Object) null);
        Set<String> names = new HashSet<>(scanner.getTypeVariables());
        names.removeAll(usedInMethodSig);
        if (!names.isEmpty()) {
            HandleDelegate$CantMakeDelegates cmd = new HandleDelegate$CantMakeDelegates();
            cmd.conflicted = usedInMethodSig;
            throw cmd;
        }
    }

    public JCTree$JCMethodDecl createDelegateMethod(HandleDelegate$MethodSig sig, JavacNode annotation, Name delegateName, HandleDelegate$DelegateReceiver delegateReceiver) throws HandleDelegate$CantMakeDelegates, JavacResolution$TypeNotConvertibleException {
        com.sun.tools.javac.util.List<JCTree$JCAnnotation> annotations;
        checkConflictOfTypeVarNames(sig, annotation);
        JavacTreeMaker maker = annotation.getTreeMaker();
        if (sig.isDeprecated) {
            annotations = com.sun.tools.javac.util.List.of(maker.Annotation(JavacHandlerUtil.genJavaLangTypeRef(annotation, "Deprecated"), com.sun.tools.javac.util.List.nil()));
        } else {
            annotations = com.sun.tools.javac.util.List.nil();
        }
        JCTree$JCModifiers mods = maker.Modifiers(1L, annotations);
        JCTree$JCExpression returnType = JavacResolution.typeToJCTree(sig.type.getReturnType(), annotation.getAst(), true);
        boolean useReturn = sig.type.getReturnType().getKind() != TypeKind.VOID;
        ListBuffer<JCTree$JCVariableDecl> params = sig.type.getParameterTypes().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree$JCExpression> args = sig.type.getParameterTypes().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree$JCExpression> thrown = sig.type.getThrownTypes().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree$JCTypeParameter> typeParams = sig.type.getTypeVariables().isEmpty() ? null : new ListBuffer<>();
        ListBuffer<JCTree$JCExpression> typeArgs = sig.type.getTypeVariables().isEmpty() ? null : new ListBuffer<>();
        Types types = Types.instance(annotation.getContext());
        for (Type$TypeVar type$TypeVar : sig.type.getTypeVariables()) {
            Name name = type$TypeVar.tsym.name;
            ListBuffer<JCTree$JCExpression> bounds = new ListBuffer<>();
            for (Type type : types.getBounds(type$TypeVar)) {
                bounds.append(JavacResolution.typeToJCTree(type, annotation.getAst(), true));
            }
            typeParams.append(maker.TypeParameter(name, bounds.toList()));
            typeArgs.append(maker.Ident(name));
        }
        Iterator it = sig.type.getThrownTypes().iterator();
        while (it.hasNext()) {
            thrown.append(JavacResolution.typeToJCTree((TypeMirror) it.next(), annotation.getAst(), true));
        }
        int idx = 0;
        String[] paramNames = sig.getParameterNames();
        boolean varargs = sig.elem.isVarArgs();
        for (Type type2 : sig.type.getParameterTypes()) {
            long flags = JavacHandlerUtil.addFinalIfNeeded(Permission.MANAGE_EVENTS, annotation.getContext());
            JCTree$JCModifiers paramMods = maker.Modifiers(flags);
            int i = idx;
            idx++;
            Name name2 = annotation.toName(paramNames[i]);
            if (varargs && idx == paramNames.length) {
                paramMods.flags |= Permission.MANAGE_THREADS;
            }
            params.append(maker.VarDef(paramMods, name2, JavacResolution.typeToJCTree(type2, annotation.getAst(), true), null));
            args.append(maker.Ident(name2));
        }
        JCTree$JCMethodInvocation jCTree$JCMethodInvocationApply = maker.Apply(toList(typeArgs), maker.Select(delegateReceiver.get(annotation, delegateName), sig.name), toList(args));
        JCTree$JCBlock bodyBlock = maker.Block(0L, com.sun.tools.javac.util.List.of(useReturn ? maker.Return(jCTree$JCMethodInvocationApply) : maker.Exec(jCTree$JCMethodInvocationApply)));
        return JavacHandlerUtil.recursiveSetGeneratedBy(maker.MethodDef(mods, sig.name, returnType, toList(typeParams), toList(params), toList(thrown), bodyBlock, null), annotation.get(), annotation.getContext());
    }

    public static <T> com.sun.tools.javac.util.List<T> toList(ListBuffer<T> collection) {
        return collection == null ? com.sun.tools.javac.util.List.nil() : collection.toList();
    }

    public void addMethodBindings(List<HandleDelegate$MethodSig> signatures, Type$ClassType ct, JavacTypes types, Set<String> banList) throws HandleDelegate$DelegateRecursion {
        Symbol$TypeSymbol tsym = ct.asElement();
        if (tsym == null) {
            return;
        }
        for (ExecutableElement executableElement : tsym.getEnclosedElements()) {
            for (Attribute$Compound am : executableElement.getAnnotationMirrors()) {
                String name = null;
                try {
                    name = am.type.tsym.flatName().toString();
                } catch (Exception unused) {
                }
                if ("lombok.Delegate".equals(name) || "lombok.experimental.Delegate".equals(name)) {
                    throw new HandleDelegate$DelegateRecursion(ct.tsym.name.toString(), ((Symbol) executableElement).name.toString());
                }
            }
            if (executableElement.getKind() == ElementKind.METHOD && !executableElement.isStatic() && !executableElement.isConstructor()) {
                ExecutableElement exElem = executableElement;
                if (exElem.getModifiers().contains(Modifier.PUBLIC)) {
                    ExecutableType methodType = types.asMemberOf(ct, executableElement);
                    String sig = printSig(methodType, ((Symbol) executableElement).name, types);
                    if (banList.add(sig)) {
                        boolean isDeprecated = (executableElement.flags() & Permission.MENTION_EVERYONE) != 0;
                        signatures.add(new HandleDelegate$MethodSig(((Symbol) executableElement).name, methodType, isDeprecated, exElem));
                    }
                }
            }
        }
        for (Type type : types.directSupertypes(ct)) {
            if (type instanceof Type$ClassType) {
                addMethodBindings(signatures, (Type$ClassType) type, types, banList);
            }
        }
    }

    public static String printSig(ExecutableType method, Name name, JavacTypes types) {
        StringBuilder sb = new StringBuilder();
        sb.append(name.toString()).append("(");
        boolean first = true;
        for (TypeMirror param : method.getParameterTypes()) {
            if (!first) {
                sb.append(", ");
            }
            first = false;
            sb.append(typeBindingToSignature(param, types));
        }
        return sb.append(")").toString();
    }

    public static String typeBindingToSignature(TypeMirror binding, JavacTypes types) {
        return types.erasure(binding).toString();
    }
}
