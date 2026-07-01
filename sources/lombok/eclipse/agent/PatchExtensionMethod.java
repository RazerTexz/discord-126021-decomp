package lombok.eclipse.agent;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.FieldAugment;
import lombok.eclipse.EclipseAST;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.TransformEclipseAST;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import lombok.experimental.ExtensionMethod;
import lombok.permit.Permit;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ClassLiteralAccess;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.NameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SuperReference;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ProblemMethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.Scope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;
import org.eclipse.jdt.internal.compiler.problem.ProblemReporter;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod.SCL.lombok */
public class PatchExtensionMethod {
    private static final FieldAugment<MessageSend, PostponedError> MessageSend_postponedErrors = FieldAugment.augment(MessageSend.class, PostponedError.class, "lombok$postponedErrors");

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$PostponedError.SCL.lombok */
    private interface PostponedError {
        void fire();
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$Extension.SCL.lombok */
    static class Extension {
        List<MethodBinding> extensionMethods;
        boolean suppressBaseMethods;

        Extension() {
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$PostponedNoMethodError.SCL.lombok */
    private static class PostponedNoMethodError implements PostponedError {
        private final ProblemReporter problemReporter;
        private final WeakReference<MessageSend> messageSendRef;
        private final TypeBinding recType;
        private final TypeBinding[] params;

        PostponedNoMethodError(ProblemReporter problemReporter, MessageSend messageSend, TypeBinding recType, TypeBinding[] params) {
            this.problemReporter = problemReporter;
            this.messageSendRef = new WeakReference<>(messageSend);
            this.recType = recType;
            this.params = params;
        }

        @Override // lombok.eclipse.agent.PatchExtensionMethod.PostponedError
        public void fire() {
            MessageSend messageSend = this.messageSendRef.get();
            if (messageSend != null) {
                this.problemReporter.errorNoMethodFor(messageSend, this.recType, this.params);
            }
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$PostponedInvalidMethodError.SCL.lombok */
    private static class PostponedInvalidMethodError implements PostponedError {
        private final ProblemReporter problemReporter;
        private final WeakReference<MessageSend> messageSendRef;
        private final MethodBinding method;
        private final Scope scope;
        private static final Method shortMethod = getMethod("invalidMethod", MessageSend.class, MethodBinding.class);
        private static final Method longMethod = getMethod("invalidMethod", MessageSend.class, MethodBinding.class, Scope.class);

        private static Method getMethod(String name, Class<?>... clsArr) {
            try {
                Method m = ProblemReporter.class.getMethod(name, clsArr);
                m.setAccessible(true);
                return m;
            } catch (Exception unused) {
                return null;
            }
        }

        PostponedInvalidMethodError(ProblemReporter problemReporter, MessageSend messageSend, MethodBinding method, Scope scope) {
            this.problemReporter = problemReporter;
            this.messageSendRef = new WeakReference<>(messageSend);
            this.method = method;
            this.scope = scope;
        }

        static void invoke(ProblemReporter problemReporter, MessageSend messageSend, MethodBinding method, Scope scope) {
            if (messageSend != null) {
                try {
                    if (shortMethod != null) {
                        shortMethod.invoke(problemReporter, messageSend, method);
                    } else if (longMethod != null) {
                        longMethod.invoke(problemReporter, messageSend, method, scope);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    Throwable t = e2.getCause();
                    if (t instanceof Error) {
                        throw ((Error) t);
                    }
                    if (!(t instanceof RuntimeException)) {
                        throw new RuntimeException(t);
                    }
                    throw ((RuntimeException) t);
                }
            }
        }

        @Override // lombok.eclipse.agent.PatchExtensionMethod.PostponedError
        public void fire() {
            MessageSend messageSend = this.messageSendRef.get();
            invoke(this.problemReporter, messageSend, this.method, this.scope);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$PostponedNonStaticAccessToStaticMethodError.SCL.lombok */
    private static class PostponedNonStaticAccessToStaticMethodError implements PostponedError {
        private final ProblemReporter problemReporter;
        private ASTNode location;
        private MethodBinding method;

        PostponedNonStaticAccessToStaticMethodError(ProblemReporter problemReporter, ASTNode location, MethodBinding method) {
            this.problemReporter = problemReporter;
            this.location = location;
            this.method = method;
        }

        @Override // lombok.eclipse.agent.PatchExtensionMethod.PostponedError
        public void fire() {
            this.problemReporter.nonStaticAccessToStaticMethod(this.location, this.method);
        }
    }

    public static EclipseNode getTypeNode(TypeDeclaration decl) {
        CompilationUnitDeclaration cud = decl.scope.compilationUnitScope().referenceContext;
        EclipseAST astNode = TransformEclipseAST.getAST(cud, false);
        EclipseNode node = astNode.get(decl);
        if (node == null) {
            EclipseAST astNode2 = TransformEclipseAST.getAST(cud, true);
            node = astNode2.get(decl);
        }
        return node;
    }

    public static Annotation getAnnotation(Class<? extends java.lang.annotation.Annotation> expectedType, EclipseNode node) {
        TypeDeclaration decl = node.get();
        if (decl.annotations != null) {
            for (Annotation ann : decl.annotations) {
                if (EclipseHandlerUtil.typeMatches(expectedType, node, ann.type)) {
                    return ann;
                }
            }
            return null;
        }
        return null;
    }

    static EclipseNode upToType(EclipseNode typeNode) {
        EclipseNode node = typeNode;
        do {
            node = node.up();
            if (node == null) {
                break;
            }
        } while (node.getKind() != AST.Kind.TYPE);
        return node;
    }

    static List<Extension> getApplicableExtensionMethods(EclipseNode typeNode, Annotation ann, TypeBinding receiverType) {
        ReferenceBinding referenceBindingResolveType;
        List<Extension> extensions = new ArrayList<>();
        if (typeNode != null && ann != null && receiverType != null) {
            MethodScope methodScope = typeNode.get().initializerScope;
            EclipseNode annotationNode = typeNode.getNodeFor(ann);
            AnnotationValues<ExtensionMethod> annotation = EclipseHandlerUtil.createAnnotation(ExtensionMethod.class, annotationNode);
            boolean suppressBaseMethods = false;
            try {
                suppressBaseMethods = annotation.getInstance().suppressBaseMethods();
            } catch (AnnotationValues.AnnotationValueDecodeFail fail) {
                fail.owner.setError(fail.getMessage(), fail.idx);
            }
            for (Object extensionMethodProvider : annotation.getActualExpressions("value")) {
                if ((extensionMethodProvider instanceof ClassLiteralAccess) && (referenceBindingResolveType = ((ClassLiteralAccess) extensionMethodProvider).type.resolveType(methodScope)) != null && (referenceBindingResolveType.isClass() || referenceBindingResolveType.isEnum())) {
                    Extension e = new Extension();
                    e.extensionMethods = getApplicableExtensionMethodsDefinedInProvider(typeNode, referenceBindingResolveType, receiverType);
                    e.suppressBaseMethods = suppressBaseMethods;
                    extensions.add(e);
                }
            }
        }
        return extensions;
    }

    private static List<MethodBinding> getApplicableExtensionMethodsDefinedInProvider(EclipseNode typeNode, ReferenceBinding extensionMethodProviderBinding, TypeBinding receiverType) {
        List<MethodBinding> extensionMethods = new ArrayList<>();
        for (MethodBinding method : extensionMethodProviderBinding.methods()) {
            if (method.isStatic() && method.isPublic() && method.parameters != null && method.parameters.length != 0) {
                TypeBinding firstArgType = method.parameters[0];
                if (!receiverType.isProvablyDistinct(firstArgType) || receiverType.isCompatibleWith(firstArgType.erasure())) {
                    extensionMethods.add(method);
                }
            }
        }
        return extensionMethods;
    }

    public static void errorNoMethodFor(ProblemReporter problemReporter, MessageSend messageSend, TypeBinding recType, TypeBinding[] params) {
        MessageSend_postponedErrors.set(messageSend, new PostponedNoMethodError(problemReporter, messageSend, recType, params));
    }

    public static void invalidMethod(ProblemReporter problemReporter, MessageSend messageSend, MethodBinding method) {
        MessageSend_postponedErrors.set(messageSend, new PostponedInvalidMethodError(problemReporter, messageSend, method, null));
    }

    public static void invalidMethod(ProblemReporter problemReporter, MessageSend messageSend, MethodBinding method, Scope scope) {
        MessageSend_postponedErrors.set(messageSend, new PostponedInvalidMethodError(problemReporter, messageSend, method, scope));
    }

    public static void nonStaticAccessToStaticMethod(ProblemReporter problemReporter, ASTNode location, MethodBinding method, MessageSend messageSend) {
        MessageSend_postponedErrors.set(messageSend, new PostponedNonStaticAccessToStaticMethodError(problemReporter, location, method));
    }

    public static TypeBinding resolveType(TypeBinding resolvedType, MessageSend methodCall, BlockScope scope) {
        TypeBinding param;
        List<Extension> extensions = new ArrayList<>();
        TypeDeclaration decl = scope.classScope().referenceContext;
        EclipseNode owningType = null;
        EclipseNode typeNode = getTypeNode(decl);
        while (true) {
            EclipseNode typeNode2 = typeNode;
            if (typeNode2 == null) {
                break;
            }
            Annotation ann = getAnnotation(ExtensionMethod.class, typeNode2);
            if (ann != null) {
                extensions.addAll(0, getApplicableExtensionMethods(typeNode2, ann, methodCall.receiver.resolvedType));
                if (owningType == null) {
                    owningType = typeNode2;
                }
            }
            typeNode = upToType(typeNode2);
        }
        boolean skip = false;
        if ((methodCall.receiver instanceof ThisReference) && (methodCall.receiver.bits & 4) != 0) {
            skip = true;
        }
        if (methodCall.receiver instanceof SuperReference) {
            skip = true;
        }
        if (methodCall.receiver instanceof NameReference) {
            Binding binding = methodCall.receiver.binding;
            if (binding instanceof TypeBinding) {
                skip = true;
            }
        }
        if (Reflection.argumentsHaveErrors != null) {
            try {
                if (((Boolean) Reflection.argumentsHaveErrors.get(methodCall)).booleanValue()) {
                    skip = true;
                }
            } catch (IllegalAccessException unused) {
            }
        }
        if (!skip) {
            for (Extension extension : extensions) {
                if (extension.suppressBaseMethods || (methodCall.binding instanceof ProblemMethodBinding)) {
                    for (MethodBinding extensionMethod : extension.extensionMethods) {
                        if (Arrays.equals(methodCall.selector, extensionMethod.selector)) {
                            MessageSend_postponedErrors.clear(methodCall);
                            if (methodCall.receiver instanceof ThisReference) {
                                methodCall.receiver.bits &= -5;
                            }
                            List<Expression> arguments = new ArrayList<>();
                            arguments.add(methodCall.receiver);
                            if (methodCall.arguments != null) {
                                arguments.addAll(Arrays.asList(methodCall.arguments));
                            }
                            Expression[] originalArgs = methodCall.arguments;
                            methodCall.arguments = (Expression[]) arguments.toArray(new Expression[0]);
                            List<TypeBinding> argumentTypes = new ArrayList<>();
                            for (Expression argument : arguments) {
                                TypeBinding argumentType = argument.resolvedType;
                                if (argumentType == null && Reflection.isFunctionalExpression(argument)) {
                                    argumentType = Reflection.getPolyTypeBinding(argument);
                                }
                                if (argumentType == null) {
                                    argumentType = TypeBinding.NULL;
                                }
                                argumentTypes.add(argumentType);
                            }
                            int typeVariables = extensionMethod.typeVariables.length;
                            if (typeVariables > 0 && (methodCall.receiver.resolvedType instanceof ParameterizedTypeBinding)) {
                                ParameterizedTypeBinding parameterizedTypeBinding = methodCall.receiver.resolvedType;
                                if (parameterizedTypeBinding.arguments != null && parameterizedTypeBinding.arguments.length == typeVariables) {
                                    methodCall.genericTypeArguments = parameterizedTypeBinding.arguments;
                                }
                            }
                            MethodBinding fixedBinding = scope.getMethod(extensionMethod.declaringClass, methodCall.selector, (TypeBinding[]) argumentTypes.toArray(new TypeBinding[0]), methodCall);
                            if (fixedBinding instanceof ProblemMethodBinding) {
                                methodCall.arguments = originalArgs;
                                if (fixedBinding.declaringClass != null) {
                                    PostponedInvalidMethodError.invoke(scope.problemReporter(), methodCall, fixedBinding, scope);
                                }
                            } else {
                                boolean isVarargs = fixedBinding.isVarargs();
                                int iend = arguments.size();
                                for (int i = 0; i < iend; i++) {
                                    Expression arg = arguments.get(i);
                                    TypeBinding[] parameters = fixedBinding.parameters;
                                    if (isVarargs && i >= parameters.length - 1) {
                                        param = parameters[parameters.length - 1].leafComponentType();
                                    } else {
                                        param = parameters[i];
                                    }
                                    if (Reflection.isFunctionalExpression(arg)) {
                                        arg.setExpectedType(param);
                                        arg.resolveType(scope);
                                    }
                                    if (arg.resolvedType != null) {
                                        if (!param.isBaseType() && arg.resolvedType.isBaseType()) {
                                            int id2 = arg.resolvedType.id;
                                            arg.implicitConversion = 512 | (id2 + (id2 << 4));
                                        } else if (param.isBaseType() && !arg.resolvedType.isBaseType()) {
                                            int id3 = parameters[i].id;
                                            arg.implicitConversion = 1024 | (id3 + (id3 << 4));
                                        }
                                    }
                                }
                                methodCall.receiver = createNameRef(extensionMethod.declaringClass, methodCall);
                                methodCall.actualReceiverType = extensionMethod.declaringClass;
                                methodCall.binding = fixedBinding;
                                methodCall.resolvedType = methodCall.binding.returnType;
                                methodCall.statementEnd = methodCall.sourceEnd;
                                if (Reflection.argumentTypes != null) {
                                    try {
                                        Reflection.argumentTypes.set(methodCall, argumentTypes.toArray(new TypeBinding[0]));
                                    } catch (IllegalAccessException unused2) {
                                    }
                                }
                            }
                            return methodCall.resolvedType;
                        }
                    }
                }
            }
        }
        PostponedError error = MessageSend_postponedErrors.get(methodCall);
        if (error != null) {
            error.fire();
        }
        MessageSend_postponedErrors.clear(methodCall);
        return resolvedType;
    }

    private static NameReference createNameRef(TypeBinding typeBinding, ASTNode source) {
        long p = (((long) source.sourceStart) << 32) | ((long) source.sourceEnd);
        char[] pkg = typeBinding.qualifiedPackageName();
        char[] basename = typeBinding.qualifiedSourceName();
        StringBuilder sb = new StringBuilder();
        if (pkg != null) {
            sb.append(pkg);
        }
        if (sb.length() > 0) {
            sb.append(".");
        }
        sb.append(basename);
        String tName = sb.toString();
        if (tName.indexOf(46) == -1) {
            return new SingleNameReference(basename, p);
        }
        String[] in = tName.split("\\.");
        char[][] sources = new char[in.length][];
        for (int i = 0; i < in.length; i++) {
            sources[i] = in[i].toCharArray();
        }
        long[] poss = new long[in.length];
        Arrays.fill(poss, p);
        return new QualifiedNameReference(sources, poss, source.sourceStart, source.sourceEnd);
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchExtensionMethod$Reflection.SCL.lombok */
    private static final class Reflection {
        public static final Field argumentTypes = Permit.permissiveGetField(MessageSend.class, "argumentTypes");
        public static final Field argumentsHaveErrors = Permit.permissiveGetField(MessageSend.class, "argumentsHaveErrors");
        private static final Class<?> functionalExpression;
        private static final Constructor<?> polyTypeBindingConstructor;

        private Reflection() {
        }

        static {
            Class<?> a = null;
            Constructor<?> b2 = null;
            try {
                a = Class.forName("org.eclipse.jdt.internal.compiler.ast.FunctionalExpression");
            } catch (Exception unused) {
            }
            try {
                b2 = Permit.getConstructor(Class.forName("org.eclipse.jdt.internal.compiler.lookup.PolyTypeBinding"), Expression.class);
            } catch (Exception unused2) {
            }
            functionalExpression = a;
            polyTypeBindingConstructor = b2;
        }

        public static boolean isFunctionalExpression(Expression expression) {
            if (functionalExpression == null) {
                return false;
            }
            return functionalExpression.isInstance(expression);
        }

        public static TypeBinding getPolyTypeBinding(Expression expression) {
            if (polyTypeBindingConstructor == null) {
                return null;
            }
            try {
                return (TypeBinding) polyTypeBindingConstructor.newInstance(expression);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
