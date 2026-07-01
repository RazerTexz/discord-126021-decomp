package lombok.eclipse.agent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.core.AST$Kind;
import lombok.eclipse.EcjAugments;
import lombok.eclipse.EcjAugments$EclipseAugments;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAST;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.TransformEclipseAST;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.eclipse.handlers.SetGeneratedByVisitor;
import lombok.patcher.Symbols;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.internal.compiler.CompilationResult;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeParameter;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.lookup.AnnotationBinding;
import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.FieldBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.DeltaProcessor;
import org.eclipse.jdt.internal.core.JavaElementDelta;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.core.SourceMethod;
import org.eclipse.jdt.internal.core.SourceType;
import org.eclipse.jdt.internal.core.SourceTypeElementInfo;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate.SCL.lombok */
public class PatchDelegate {
    private static final String LEGALITY_OF_DELEGATE = "@Delegate is legal only on instance fields or no-argument instance methods.";
    private static final String RECURSION_NOT_ALLOWED = "@Delegate does not support recursion (delegating to a type that itself has @Delegate members). Member \"%s\" is @Delegate in type \"%s\"";
    private static ThreadLocal<List<PatchDelegate$ClassScopeEntry>> visited = new PatchDelegate$1();
    private static boolean javaModelManagerAvailable = true;
    private static final char[] STRING_LOMBOK = {'l', 'o', 'm', 'b', 'o', 'k'};
    private static final char[] STRING_EXPERIMENTAL = {'e', 'x', 'p', 'e', 'r', 'i', 'm', 'e', 'n', 't', 'a', 'l'};
    private static final char[] STRING_DELEGATE = {'D', 'e', 'l', 'e', 'g', 'a', 't', 'e'};
    private static final List<String> METHODS_IN_OBJECT = Collections.unmodifiableList(Arrays.asList("hashCode()", "canEqual(java.lang.Object)", "equals(java.lang.Object)", "wait()", "wait(long)", "wait(long, int)", "notify()", "notifyAll()", "toString()", "getClass()", "clone()", "finalize()"));

    private static String nameOfScope(ClassScope scope) {
        TypeDeclaration decl = scope.referenceContext;
        return (decl == null || decl.name == null || decl.name.length == 0) ? "(unknown)" : new String(decl.name);
    }

    private static boolean hasDelegateMarkedFieldsOrMethods(TypeDeclaration decl) {
        if (decl.fields != null) {
            for (FieldDeclaration field : decl.fields) {
                if (field.annotations != null) {
                    for (Annotation ann : field.annotations) {
                        if (isDelegate(ann, decl)) {
                            return true;
                        }
                    }
                }
            }
        }
        if (decl.methods != null) {
            for (AbstractMethodDeclaration method : decl.methods) {
                if (method.annotations != null) {
                    for (Annotation ann2 : method.annotations) {
                        if (isDelegate(ann2, decl)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static boolean handleDelegateForType(ClassScope scope) {
        if (TransformEclipseAST.disableLombok) {
            return false;
        }
        CompilationUnitDeclaration cud = scope.compilationUnitScope().referenceContext;
        if (scope == scope.compilationUnitScope().topLevelTypes[0].scope) {
            cleanupDelegateMethods(cud);
        }
        if (!hasDelegateMarkedFieldsOrMethods(scope.referenceContext)) {
            return false;
        }
        List<PatchDelegate$ClassScopeEntry> stack = visited.get();
        StringBuilder corrupted = null;
        for (PatchDelegate$ClassScopeEntry entry : stack) {
            if (corrupted != null) {
                corrupted.append(" -> ").append(nameOfScope(entry.scope));
            } else if (entry.scope == scope) {
                corrupted = new StringBuilder().append(nameOfScope(scope));
            }
        }
        if (corrupted != null) {
            boolean found = false;
            String path = corrupted.toString();
            for (PatchDelegate$ClassScopeEntry entry2 : stack) {
                if (!found && entry2.scope == scope) {
                    found = true;
                }
                if (found) {
                    entry2.corruptedPath = path;
                }
            }
            return false;
        }
        PatchDelegate$ClassScopeEntry entry3 = new PatchDelegate$ClassScopeEntry(scope);
        stack.add(entry3);
        try {
            TypeDeclaration decl = scope.referenceContext;
            if (decl != null) {
                EclipseAST eclipseAst = TransformEclipseAST.getAST(cud, true);
                List<PatchDelegate$BindingTuple> methodsToDelegate = new ArrayList<>();
                fillMethodBindingsForFields(cud, scope, methodsToDelegate);
                if (entry3.corruptedPath != null) {
                    eclipseAst.get(scope.referenceContext).addError("No @Delegate methods created because there's a loop: " + entry3.corruptedPath);
                } else {
                    generateDelegateMethods(eclipseAst.get(decl), methodsToDelegate, PatchDelegate$DelegateReceiver.FIELD);
                }
                methodsToDelegate.clear();
                fillMethodBindingsForMethods(cud, scope, methodsToDelegate);
                if (entry3.corruptedPath != null) {
                    eclipseAst.get(scope.referenceContext).addError("No @Delegate methods created because there's a loop: " + entry3.corruptedPath);
                } else {
                    generateDelegateMethods(eclipseAst.get(decl), methodsToDelegate, PatchDelegate$DelegateReceiver.METHOD);
                }
            }
        } finally {
            stack.remove(stack.size() - 1);
            if (stack.isEmpty()) {
                notifyDelegateMethodsAdded(cud);
            }
        }
    }

    public static IJavaElement[] getChildren(IJavaElement[] returnValue, SourceTypeElementInfo javaElement) {
        if (Symbols.hasSymbol("lombok.skipdelegates")) {
            return returnValue;
        }
        List<SourceMethod> delegateMethods = getDelegateMethods(javaElement.getHandle());
        if (delegateMethods != null) {
            return (IJavaElement[]) EclipseHandlerUtil.concat(returnValue, (IJavaElement[]) delegateMethods.toArray(new IJavaElement[0]), IJavaElement.class);
        }
        return returnValue;
    }

    private static String containsDuplicates(List<PatchDelegate$BindingTuple> tuples) {
        Set<String> sigs = new HashSet<>();
        for (PatchDelegate$BindingTuple tuple : tuples) {
            if (!sigs.add(printSig(tuple.parameterized))) {
                return printSig(tuple.parameterized);
            }
        }
        return null;
    }

    public static void markHandled(Annotation annotation) {
        EcjAugments.Annotation_applied.set(annotation, true);
    }

    private static void fillMethodBindingsForFields(CompilationUnitDeclaration cud, ClassScope scope, List<PatchDelegate$BindingTuple> methodsToDelegate) {
        TypeDeclaration decl = scope.referenceContext;
        if (decl != null && decl.fields != null) {
            for (FieldDeclaration field : decl.fields) {
                if (field.annotations != null) {
                    for (Annotation ann : field.annotations) {
                        if (isDelegate(ann, decl) && !EcjAugments.Annotation_applied.getAndSet(ann, true).booleanValue()) {
                            if ((field.modifiers & 8) != 0) {
                                EclipseAST eclipseAst = TransformEclipseAST.getAST(cud, true);
                                eclipseAst.get(ann).addError(LEGALITY_OF_DELEGATE);
                                break;
                            }
                            List<ClassLiteralAccess> rawTypes = rawTypes(ann, "types");
                            List<ClassLiteralAccess> excludedRawTypes = rawTypes(ann, "excludes");
                            List<PatchDelegate$BindingTuple> methodsToExclude = new ArrayList<>();
                            List<PatchDelegate$BindingTuple> methodsToDelegateForThisAnn = new ArrayList<>();
                            try {
                                for (ClassLiteralAccess cla : excludedRawTypes) {
                                    addAllMethodBindings(methodsToExclude, cla.type.resolveType(decl.initializerScope), new HashSet(), field.name, ann);
                                }
                                Set<String> banList = findAlreadyImplementedMethods(decl);
                                for (PatchDelegate$BindingTuple excluded : methodsToExclude) {
                                    banList.add(printSig(excluded.parameterized));
                                }
                                if (rawTypes.isEmpty()) {
                                    addAllMethodBindings(methodsToDelegateForThisAnn, field.type.resolveType(decl.initializerScope), banList, field.name, ann);
                                } else {
                                    for (ClassLiteralAccess cla2 : rawTypes) {
                                        addAllMethodBindings(methodsToDelegateForThisAnn, cla2.type.resolveType(decl.initializerScope), banList, field.name, ann);
                                    }
                                }
                                String dupe = containsDuplicates(methodsToDelegateForThisAnn);
                                if (dupe != null) {
                                    EclipseAST eclipseAst2 = TransformEclipseAST.getAST(cud, true);
                                    eclipseAst2.get(ann).addError("The method '" + dupe + "' is being delegated by more than one specified type.");
                                } else {
                                    methodsToDelegate.addAll(methodsToDelegateForThisAnn);
                                }
                            } catch (PatchDelegate$DelegateRecursion e) {
                                EclipseAST eclipseAst3 = TransformEclipseAST.getAST(cud, true);
                                eclipseAst3.get(ann).addError(String.format(RECURSION_NOT_ALLOWED, new String(e.member), new String(e.type)));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void fillMethodBindingsForMethods(CompilationUnitDeclaration cud, ClassScope scope, List<PatchDelegate$BindingTuple> methodsToDelegate) {
        TypeDeclaration decl = scope.referenceContext;
        if (decl != null && decl.methods != null) {
            for (MethodDeclaration methodDeclaration : decl.methods) {
                if (((AbstractMethodDeclaration) methodDeclaration).annotations != null) {
                    for (Annotation ann : ((AbstractMethodDeclaration) methodDeclaration).annotations) {
                        if (isDelegate(ann, decl) && !EcjAugments.Annotation_applied.getAndSet(ann, true).booleanValue()) {
                            if (!(methodDeclaration instanceof MethodDeclaration)) {
                                EclipseAST eclipseAst = TransformEclipseAST.getAST(cud, true);
                                eclipseAst.get(ann).addError(LEGALITY_OF_DELEGATE);
                                break;
                            }
                            if (((AbstractMethodDeclaration) methodDeclaration).arguments != null) {
                                EclipseAST eclipseAst2 = TransformEclipseAST.getAST(cud, true);
                                eclipseAst2.get(ann).addError(LEGALITY_OF_DELEGATE);
                                break;
                            }
                            if ((((AbstractMethodDeclaration) methodDeclaration).modifiers & 8) != 0) {
                                EclipseAST eclipseAst3 = TransformEclipseAST.getAST(cud, true);
                                eclipseAst3.get(ann).addError(LEGALITY_OF_DELEGATE);
                                break;
                            }
                            MethodDeclaration method = methodDeclaration;
                            List<ClassLiteralAccess> rawTypes = rawTypes(ann, "types");
                            List<ClassLiteralAccess> excludedRawTypes = rawTypes(ann, "excludes");
                            List<PatchDelegate$BindingTuple> methodsToExclude = new ArrayList<>();
                            List<PatchDelegate$BindingTuple> methodsToDelegateForThisAnn = new ArrayList<>();
                            try {
                                for (ClassLiteralAccess cla : excludedRawTypes) {
                                    addAllMethodBindings(methodsToExclude, cla.type.resolveType(decl.initializerScope), new HashSet(), method.selector, ann);
                                }
                                Set<String> banList = findAlreadyImplementedMethods(decl);
                                for (PatchDelegate$BindingTuple excluded : methodsToExclude) {
                                    banList.add(printSig(excluded.parameterized));
                                }
                                if (rawTypes.isEmpty()) {
                                    if (method.returnType != null) {
                                        addAllMethodBindings(methodsToDelegateForThisAnn, method.returnType.resolveType(decl.initializerScope), banList, method.selector, ann);
                                    }
                                } else {
                                    for (ClassLiteralAccess cla2 : rawTypes) {
                                        addAllMethodBindings(methodsToDelegateForThisAnn, cla2.type.resolveType(decl.initializerScope), banList, method.selector, ann);
                                    }
                                }
                                String dupe = containsDuplicates(methodsToDelegateForThisAnn);
                                if (dupe != null) {
                                    EclipseAST eclipseAst4 = TransformEclipseAST.getAST(cud, true);
                                    eclipseAst4.get(ann).addError("The method '" + dupe + "' is being delegated by more than one specified type.");
                                } else {
                                    methodsToDelegate.addAll(methodsToDelegateForThisAnn);
                                }
                            } catch (PatchDelegate$DelegateRecursion e) {
                                EclipseAST eclipseAst5 = TransformEclipseAST.getAST(cud, true);
                                eclipseAst5.get(ann).addError(String.format(RECURSION_NOT_ALLOWED, new String(e.member), new String(e.type)));
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean isDelegate(Annotation ann, TypeDeclaration decl) {
        TypeBinding tb;
        if (ann.type == null || !charArrayEquals("Delegate", ann.type.getLastToken()) || (tb = ann.type.resolveType(decl.initializerScope)) == null) {
            return false;
        }
        return (charArrayEquals("lombok", tb.qualifiedPackageName()) || charArrayEquals("lombok.experimental", tb.qualifiedPackageName())) && charArrayEquals("Delegate", tb.qualifiedSourceName());
    }

    private static List<ClassLiteralAccess> rawTypes(Annotation ann, String name) {
        List<ClassLiteralAccess> rawTypes = new ArrayList<>();
        for (MemberValuePair pair : ann.memberValuePairs()) {
            if (charArrayEquals(name, pair.name)) {
                if (pair.value instanceof ArrayInitializer) {
                    for (ClassLiteralAccess classLiteralAccess : pair.value.expressions) {
                        if (classLiteralAccess instanceof ClassLiteralAccess) {
                            rawTypes.add(classLiteralAccess);
                        }
                    }
                }
                if (pair.value instanceof ClassLiteralAccess) {
                    rawTypes.add(pair.value);
                }
            }
        }
        return rawTypes;
    }

    private static void generateDelegateMethods(EclipseNode typeNode, List<PatchDelegate$BindingTuple> methods, PatchDelegate$DelegateReceiver delegateReceiver) {
        CompilationUnitDeclaration top = typeNode.top().get();
        String qualifiedName = new String(CharOperation.concatWith(EclipseHandlerUtil.getQualifiedInnerName(typeNode.up(), typeNode.getName().toCharArray()), '$'));
        SourceType sourceType = getSourceType(top, qualifiedName);
        List<SourceMethod> delegateSourceMethods = getDelegateMethods(sourceType);
        for (PatchDelegate$BindingTuple pair : methods) {
            EclipseNode annNode = typeNode.getAst().get(pair.responsible);
            MethodDeclaration method = createDelegateMethod(pair.fieldName, typeNode, pair, top.compilationResult, annNode, delegateReceiver);
            if (method != null) {
                SetGeneratedByVisitor visitor = new SetGeneratedByVisitor(annNode.get());
                method.traverse(visitor, typeNode.get().scope);
                EclipseHandlerUtil.injectMethod(typeNode, method);
                if (delegateSourceMethods != null) {
                    delegateSourceMethods.add(PatchDelegate$DelegateSourceMethod.access$0(sourceType, method));
                }
            }
        }
    }

    public static void checkConflictOfTypeVarNames(PatchDelegate$BindingTuple binding, EclipseNode typeNode) throws PatchDelegate$CantMakeDelegates {
        TypeParameter[] typeParameters;
        TypeVariableBinding[] typeVars = binding.parameterized.typeVariables();
        if (typeVars == null || typeVars.length == 0) {
            return;
        }
        Set<String> usedInOurType = new HashSet<>();
        EclipseNode eclipseNodeUp = typeNode;
        while (true) {
            EclipseNode enclosingType = eclipseNodeUp;
            if (enclosingType == null) {
                break;
            }
            if (enclosingType.getKind() == AST$Kind.TYPE && (typeParameters = enclosingType.get().typeParameters) != null) {
                for (TypeParameter param : typeParameters) {
                    if (param.name != null) {
                        usedInOurType.add(new String(param.name));
                    }
                }
            }
            eclipseNodeUp = enclosingType.up();
        }
        Set<String> usedInMethodSig = new HashSet<>();
        for (TypeVariableBinding var : typeVars) {
            char[] sourceName = var.sourceName();
            if (sourceName != null) {
                usedInMethodSig.add(new String(sourceName));
            }
        }
        usedInMethodSig.retainAll(usedInOurType);
        if (usedInMethodSig.isEmpty()) {
            return;
        }
        PatchDelegate$TypeVarFinder finder = new PatchDelegate$TypeVarFinder();
        finder.visitRaw(binding.base);
        Set<String> names = new HashSet<>(finder.getTypeVariables());
        names.removeAll(usedInMethodSig);
        if (!names.isEmpty()) {
            PatchDelegate$CantMakeDelegates cmd = new PatchDelegate$CantMakeDelegates();
            cmd.conflicted = usedInMethodSig;
            throw cmd;
        }
    }

    private static MethodDeclaration createDelegateMethod(char[] name, EclipseNode typeNode, PatchDelegate$BindingTuple pair, CompilationResult compilationResult, EclipseNode annNode, PatchDelegate$DelegateReceiver delegateReceiver) {
        ASTNode returnStatement;
        AbstractMethodDeclaration sourceElem;
        boolean isVarargs = (pair.base.modifiers & 128) != 0;
        try {
            checkConflictOfTypeVarNames(pair, typeNode);
            ASTNode source = annNode.get();
            int pS = source.sourceStart;
            int pE = source.sourceEnd;
            MethodBinding binding = pair.parameterized;
            MethodDeclaration method = new MethodDeclaration(compilationResult);
            EclipseHandlerUtil.setGeneratedBy(method, source);
            method.sourceStart = pS;
            method.sourceEnd = pE;
            method.modifiers = 1;
            method.returnType = EclipseHandlerUtil.makeType(binding.returnType, source, false);
            boolean isDeprecated = binding.isDeprecated();
            method.selector = binding.selector;
            if (binding.thrownExceptions != null && binding.thrownExceptions.length > 0) {
                method.thrownExceptions = new TypeReference[binding.thrownExceptions.length];
                for (int i = 0; i < method.thrownExceptions.length; i++) {
                    method.thrownExceptions[i] = EclipseHandlerUtil.makeType(binding.thrownExceptions[i], source, false);
                }
            }
            ASTNode messageSend = new MessageSend();
            ((MessageSend) messageSend).sourceStart = pS;
            ((MessageSend) messageSend).sourceEnd = pE;
            ((MessageSend) messageSend).nameSourcePosition = Eclipse.pos(source);
            EclipseHandlerUtil.setGeneratedBy(messageSend, source);
            ((MessageSend) messageSend).receiver = delegateReceiver.get(source, name);
            ((MessageSend) messageSend).selector = binding.selector;
            if (binding.typeVariables != null && binding.typeVariables.length > 0) {
                method.typeParameters = new TypeParameter[binding.typeVariables.length];
                ((MessageSend) messageSend).typeArguments = new TypeReference[binding.typeVariables.length];
                for (int i2 = 0; i2 < method.typeParameters.length; i2++) {
                    method.typeParameters[i2] = new TypeParameter();
                    method.typeParameters[i2].sourceStart = pS;
                    method.typeParameters[i2].sourceEnd = pE;
                    EclipseHandlerUtil.setGeneratedBy(method.typeParameters[i2], source);
                    method.typeParameters[i2].name = binding.typeVariables[i2].sourceName;
                    ((MessageSend) messageSend).typeArguments[i2] = new SingleTypeReference(binding.typeVariables[i2].sourceName, Eclipse.pos(source));
                    EclipseHandlerUtil.setGeneratedBy(((MessageSend) messageSend).typeArguments[i2], source);
                    ReferenceBinding super1 = binding.typeVariables[i2].superclass;
                    ReferenceBinding[] super2 = binding.typeVariables[i2].superInterfaces;
                    if (super2 == null) {
                        super2 = new ReferenceBinding[0];
                    }
                    if (super1 != null || super2.length > 0) {
                        int offset = super1 == null ? 0 : 1;
                        method.typeParameters[i2].bounds = new TypeReference[(super2.length + offset) - 1];
                        if (super1 != null) {
                            method.typeParameters[i2].type = EclipseHandlerUtil.makeType(super1, source, false);
                        } else {
                            method.typeParameters[i2].type = EclipseHandlerUtil.makeType(super2[0], source, false);
                        }
                        int ctr = 0;
                        for (int j = super1 == null ? 1 : 0; j < super2.length; j++) {
                            method.typeParameters[i2].bounds[ctr] = EclipseHandlerUtil.makeType(super2[j], source, false);
                            int i3 = ctr;
                            ctr++;
                            method.typeParameters[i2].bounds[i3].bits |= 16;
                        }
                    }
                }
            }
            if (isDeprecated) {
                method.annotations = new Annotation[]{EclipseHandlerUtil.generateDeprecatedAnnotation(source)};
            }
            method.bits |= 8388608;
            if (binding.parameters != null && binding.parameters.length > 0) {
                method.arguments = new Argument[binding.parameters.length];
                ((MessageSend) messageSend).arguments = new Expression[method.arguments.length];
                for (int i4 = 0; i4 < method.arguments.length; i4++) {
                    try {
                        sourceElem = pair.base.sourceMethod();
                    } catch (Exception unused) {
                        sourceElem = null;
                    }
                    char[] argName = sourceElem == null ? ("arg" + i4).toCharArray() : sourceElem.arguments[i4].name;
                    method.arguments[i4] = new Argument(argName, Eclipse.pos(source), EclipseHandlerUtil.makeType(binding.parameters[i4], source, false), 16);
                    EclipseHandlerUtil.setGeneratedBy(method.arguments[i4], source);
                    ((MessageSend) messageSend).arguments[i4] = new SingleNameReference(argName, Eclipse.pos(source));
                    EclipseHandlerUtil.setGeneratedBy(((MessageSend) messageSend).arguments[i4], source);
                }
                if (isVarargs) {
                    method.arguments[method.arguments.length - 1].type.bits |= 16384;
                }
            }
            if ((method.returnType instanceof SingleTypeReference) && method.returnType.token == TypeConstants.VOID) {
                returnStatement = messageSend;
            } else {
                returnStatement = new ReturnStatement(messageSend, source.sourceStart, source.sourceEnd);
                EclipseHandlerUtil.setGeneratedBy(returnStatement, source);
            }
            method.statements = new Statement[]{returnStatement};
            return method;
        } catch (PatchDelegate$CantMakeDelegates e) {
            annNode.addError("There's a conflict in the names of type parameters. Fix it by renaming the following type parameters of your class: " + e.conflicted);
            return null;
        }
    }

    private static void cleanupDelegateMethods(CompilationUnitDeclaration cud) {
        CompilationUnit compilationUnit = getCompilationUnit(cud);
        if (compilationUnit != null) {
            EcjAugments$EclipseAugments.CompilationUnit_delegateMethods.clear(compilationUnit);
        }
    }

    private static void notifyDelegateMethodsAdded(CompilationUnitDeclaration cud) {
        CompilationUnit compilationUnit = getCompilationUnit(cud);
        if (compilationUnit != null && javaModelManagerAvailable) {
            try {
                DeltaProcessor deltaProcessor = JavaModelManager.getJavaModelManager().getDeltaProcessor();
                deltaProcessor.fire(new JavaElementDelta(compilationUnit), 1);
            } catch (NoClassDefFoundError unused) {
                javaModelManagerAvailable = false;
            }
        }
    }

    private static CompilationUnit getCompilationUnit(Object iCompilationUnit) {
        if (iCompilationUnit instanceof CompilationUnit) {
            CompilationUnit compilationUnit = (CompilationUnit) iCompilationUnit;
            return compilationUnit.originalFromClone();
        }
        return null;
    }

    private static CompilationUnit getCompilationUnit(CompilationUnitDeclaration cud) {
        return getCompilationUnit(cud.compilationResult.compilationUnit);
    }

    private static List<SourceMethod> getDelegateMethods(SourceType sourceType) {
        CompilationUnit compilationUnit;
        if (sourceType != null && (compilationUnit = getCompilationUnit(sourceType.getCompilationUnit())) != null) {
            ConcurrentMap<String, List<SourceMethod>> map = EcjAugments$EclipseAugments.CompilationUnit_delegateMethods.setIfAbsent(compilationUnit, new ConcurrentHashMap());
            List<SourceMethod> newList = new ArrayList<>();
            List<SourceMethod> oldList = map.putIfAbsent(sourceType.getTypeQualifiedName(), newList);
            return oldList != null ? oldList : newList;
        }
        return null;
    }

    private static SourceType getSourceType(CompilationUnitDeclaration cud, String typeName) {
        CompilationUnit compilationUnit = getCompilationUnit(cud);
        if (compilationUnit != null) {
            try {
                for (SourceType sourceType : compilationUnit.getAllTypes()) {
                    if ((sourceType instanceof SourceType) && sourceType.getTypeQualifiedName().equals(typeName)) {
                        return sourceType;
                    }
                }
                return null;
            } catch (JavaModelException unused) {
                return null;
            }
        }
        return null;
    }

    private static void addAllMethodBindings(List<PatchDelegate$BindingTuple> list, TypeBinding binding, Set<String> banList, char[] fieldName, ASTNode responsible) throws PatchDelegate$DelegateRecursion {
        banList.addAll(METHODS_IN_OBJECT);
        addAllMethodBindings0(list, binding, banList, fieldName, responsible);
    }

    private static void addAllMethodBindings0(List<PatchDelegate$BindingTuple> list, TypeBinding binding, Set<String> banList, char[] fieldName, ASTNode responsible) throws PatchDelegate$DelegateRecursion {
        TypeBinding inner;
        ClassScope cs;
        ClassScope scope;
        if ((binding instanceof SourceTypeBinding) && (scope = ((SourceTypeBinding) binding).scope) != null) {
            scope.environment().globalOptions.storeAnnotations = true;
        }
        if (binding == null) {
            return;
        }
        if (binding instanceof ParameterizedTypeBinding) {
            inner = ((ParameterizedTypeBinding) binding).genericType();
        } else {
            inner = binding;
        }
        if ((inner instanceof SourceTypeBinding) && (cs = ((SourceTypeBinding) inner).scope) != null) {
            try {
                PatchDelegate$Reflection.classScopeBuildFieldsAndMethodsMethod.invoke(cs, new Object[0]);
            } catch (Exception unused) {
            }
        }
        if (!(binding instanceof ReferenceBinding)) {
            return;
        }
        ReferenceBinding rb = (ReferenceBinding) binding;
        MethodBinding[] availableMethods = rb.availableMethods();
        FieldBinding[] availableFields = rb.availableFields();
        failIfContainsAnnotation(binding, availableMethods);
        failIfContainsAnnotation(binding, availableFields);
        MethodBinding[] baseSigs = availableMethods;
        if (binding instanceof ParameterizedTypeBinding) {
            baseSigs = ((ParameterizedTypeBinding) binding).genericType().availableMethods();
            if (baseSigs.length != availableMethods.length) {
                baseSigs = availableMethods;
            }
        }
        for (int i = 0; i < availableMethods.length; i++) {
            MethodBinding mb = availableMethods[i];
            String sig = printSig(mb);
            if (!mb.isStatic() && !mb.isBridge() && !mb.isConstructor() && !mb.isDefaultAbstract() && mb.isPublic() && !mb.isSynthetic() && banList.add(sig)) {
                PatchDelegate$BindingTuple pair = new PatchDelegate$BindingTuple(mb, baseSigs[i], fieldName, responsible);
                list.add(pair);
            }
        }
        addAllMethodBindings0(list, rb.superclass(), banList, fieldName, responsible);
        TypeBinding[] typeBindingArrSuperInterfaces = rb.superInterfaces();
        if (typeBindingArrSuperInterfaces != null) {
            for (TypeBinding typeBinding : typeBindingArrSuperInterfaces) {
                addAllMethodBindings0(list, typeBinding, banList, fieldName, responsible);
            }
        }
    }

    private static Set<String> findAlreadyImplementedMethods(TypeDeclaration decl) {
        Set<String> sigs = new HashSet<>();
        for (AbstractMethodDeclaration md : decl.methods) {
            if (!md.isStatic() && (md.modifiers & 64) == 0 && !md.isConstructor() && (md.modifiers & 524288) == 0 && (md.modifiers & 1) != 0 && (md.modifiers & 4096) == 0) {
                sigs.add(printSig(md, decl.scope));
            }
        }
        return sigs;
    }

    private static void failIfContainsAnnotation(TypeBinding parent, Binding[] bindings) throws PatchDelegate$DelegateRecursion {
        if (bindings == null) {
            return;
        }
        for (Binding b2 : bindings) {
            AnnotationBinding[] anns = b2 instanceof MethodBinding ? ((MethodBinding) b2).getAnnotations() : null;
            if (b2 instanceof FieldBinding) {
                anns = ((FieldBinding) b2).getAnnotations();
            }
            if (anns != null) {
                for (AnnotationBinding ann : anns) {
                    char[][] name = null;
                    try {
                        name = ann.getAnnotationType().compoundName;
                    } catch (Exception unused) {
                    }
                    if (name != null && name.length >= 2 && name.length <= 3 && Arrays.equals(STRING_LOMBOK, name[0]) && Arrays.equals(STRING_DELEGATE, name[name.length - 1]) && (name.length != 3 || Arrays.equals(STRING_EXPERIMENTAL, name[1]))) {
                        throw new PatchDelegate$DelegateRecursion(parent.readableName(), b2.readableName());
                    }
                }
            }
        }
    }

    static /* synthetic */ String access$0(MethodBinding methodBinding) {
        return printSig(methodBinding);
    }

    private static String printSig(MethodBinding binding) {
        StringBuilder signature = new StringBuilder();
        signature.append(binding.selector);
        signature.append("(");
        boolean first = true;
        if (binding.parameters != null) {
            for (TypeBinding param : binding.parameters) {
                if (!first) {
                    signature.append(", ");
                }
                first = false;
                signature.append(typeBindingToSignature(param));
            }
        }
        signature.append(")");
        return signature.toString();
    }

    private static String printSig(AbstractMethodDeclaration md, ClassScope scope) {
        StringBuilder signature = new StringBuilder();
        signature.append(md.selector);
        signature.append("(");
        boolean first = true;
        if (md.arguments != null) {
            TypeParameter[] typeParameters = md.typeParameters();
            Map<String, TypeParameter> typeParametersMap = new HashMap<>();
            if (typeParameters != null) {
                for (TypeParameter typeParameter : typeParameters) {
                    typeParametersMap.put(new String(typeParameter.name), typeParameter);
                }
            }
            for (Argument argument : md.arguments) {
                TypeBinding typeBinding = makeTypeBinding(argument.type, typeParametersMap, scope);
                if (!first) {
                    signature.append(", ");
                }
                first = false;
                signature.append(typeBindingToSignature(typeBinding));
            }
        }
        signature.append(")");
        return signature.toString();
    }

    private static TypeBinding makeTypeBinding(TypeReference typeReference, Map<String, TypeParameter> typeParametersMap, ClassScope scope) {
        char[][] typeName = typeReference.getTypeName();
        String typeNameString = Eclipse.toQualifiedName(typeName);
        TypeParameter typeParameter = typeParametersMap.get(typeNameString);
        if (typeParameter != null) {
            if (typeParameter.type != null) {
                typeName = typeParameter.type.getTypeName();
            } else {
                typeName = TypeConstants.JAVA_LANG_OBJECT;
            }
        }
        TypeBinding typeBinding = scope.getType(typeName, typeName.length);
        if (typeReference.dimensions() > 0) {
            typeBinding = scope.createArrayType(typeBinding, typeReference.dimensions());
        }
        return typeBinding;
    }

    private static String typeBindingToSignature(TypeBinding binding) {
        TypeBinding binding2 = binding.erasure();
        if (binding2 != null && binding2.isBaseType()) {
            return new String(binding2.sourceName());
        }
        if (binding2 instanceof ReferenceBinding) {
            String pkg = binding2.qualifiedPackageName() == null ? "" : new String(binding2.qualifiedPackageName());
            String qsn = binding2.qualifiedSourceName() == null ? "" : new String(binding2.qualifiedSourceName());
            return pkg.isEmpty() ? qsn : String.valueOf(pkg) + "." + qsn;
        }
        if (binding2 instanceof ArrayBinding) {
            StringBuilder out = new StringBuilder();
            out.append(typeBindingToSignature(binding2.leafComponentType()));
            for (int i = 0; i < binding2.dimensions(); i++) {
                out.append("[]");
            }
            return out.toString();
        }
        return "";
    }

    private static boolean charArrayEquals(String s2, char[] c) {
        if (s2 == null) {
            return c == null;
        }
        if (c == null || s2.length() != c.length) {
            return false;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != c[i]) {
                return false;
            }
        }
        return true;
    }
}
