package lombok.javac.handlers;

import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import lombok.ConfigurationKeys;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.JavacASTAdapter;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;
import lombok.javac.ResolutionResetNeeded;
import lombok.val;
import lombok.var;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleVal.SCL.lombok */
@HandlerPriority(65636)
@ResolutionResetNeeded
public class HandleVal extends JavacASTAdapter {
    private static boolean eq(String typeTreeToString, String key) {
        return typeTreeToString.equals(key) || typeTreeToString.equals(new StringBuilder("lombok.").append(key).toString()) || typeTreeToString.equals(new StringBuilder("lombok.experimental.").append(key).toString());
    }

    @Override // lombok.javac.JavacASTAdapter, lombok.javac.JavacASTVisitor
    public void visitLocal(JavacNode localNode, JCTree.JCVariableDecl local) {
        Type type;
        JCTree.JCExpression replacement;
        JCTree.JCExpression jCExpression = local.vartype;
        if (jCExpression == null) {
            return;
        }
        String typeTreeToString = jCExpression.toString();
        if (eq(typeTreeToString, "val") || eq(typeTreeToString, "var")) {
            boolean isVal = JavacHandlerUtil.typeMatches((Class<?>) val.class, localNode, (JCTree) jCExpression);
            boolean isVar = JavacHandlerUtil.typeMatches((Class<?>) var.class, localNode, (JCTree) jCExpression);
            if (isVal || isVar) {
                if (isVal) {
                    HandlerUtil.handleFlagUsage(localNode, ConfigurationKeys.VAL_FLAG_USAGE, "val");
                }
                if (isVar) {
                    HandlerUtil.handleFlagUsage(localNode, ConfigurationKeys.VAR_FLAG_USAGE, "var");
                }
                JCTree.JCForLoop jCForLoop = (JCTree) localNode.directUp().get();
                if (isVal && (jCForLoop instanceof JCTree.JCForLoop)) {
                    localNode.addError("'val' is not allowed in old-style for loops");
                    return;
                }
                if ((jCForLoop instanceof JCTree.JCForLoop) && jCForLoop.getInitializer().size() > 1) {
                    localNode.addError("'var' is not allowed in old-style for loops if there is more than 1 initializer");
                    return;
                }
                JCTree.JCExpression rhsOfEnhancedForLoop = null;
                if (local.init == null && (jCForLoop instanceof JCTree.JCEnhancedForLoop)) {
                    JCTree.JCEnhancedForLoop efl = (JCTree.JCEnhancedForLoop) jCForLoop;
                    if (efl.var == local) {
                        rhsOfEnhancedForLoop = efl.expr;
                    }
                }
                if (rhsOfEnhancedForLoop == null && local.init == null) {
                    localNode.addError("'" + typeTreeToString + "' on a local variable requires an initializer expression");
                    return;
                }
                if ((local.init instanceof JCTree.JCNewArray) && local.init.elemtype == null) {
                    localNode.addError("'" + typeTreeToString + "' is not compatible with array initializer expressions. Use the full form (new int[] { ... } instead of just { ... })");
                    return;
                }
                if (localNode.shouldDeleteLombokAnnotations()) {
                    JavacHandlerUtil.deleteImportFromCompilationUnit(localNode, val.class.getName());
                    JavacHandlerUtil.deleteImportFromCompilationUnit(localNode, lombok.experimental.var.class.getName());
                    JavacHandlerUtil.deleteImportFromCompilationUnit(localNode, var.class.getName());
                }
                if (isVal) {
                    local.mods.flags |= 16;
                }
                if (!localNode.shouldDeleteLombokAnnotations()) {
                    JCTree.JCAnnotation valAnnotation = JavacHandlerUtil.recursiveSetGeneratedBy(localNode.getTreeMaker().Annotation(local.vartype, List.nil()), jCExpression, localNode.getContext());
                    local.mods.annotations = local.mods.annotations == null ? List.of(valAnnotation) : local.mods.annotations.append(valAnnotation);
                }
                if (JavacResolution.platformHasTargetTyping()) {
                    local.vartype = localNode.getAst().getTreeMaker().Ident(localNode.getAst().toName("___Lombok_VAL_Attrib__"));
                } else {
                    local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
                }
                try {
                    try {
                        if (rhsOfEnhancedForLoop == null) {
                            if (local.init.type == null) {
                                if (isVar && (local.init instanceof JCTree.JCLiteral) && local.init.value == null) {
                                    localNode.addError("variable initializer is 'null'");
                                }
                                JavacResolution resolver = new JavacResolution(localNode.getContext());
                                try {
                                    type = resolver.resolveMethodMember(localNode).get(local.init).type;
                                } catch (RuntimeException e) {
                                    System.err.println("Exception while resolving: " + localNode + "(" + localNode.getFileName() + ")");
                                    throw e;
                                }
                            } else {
                                type = local.init.type;
                                if (type.isErroneous()) {
                                    try {
                                        JavacResolution resolver2 = new JavacResolution(localNode.getContext());
                                        local.type = Symtab.instance(localNode.getContext()).unknownType;
                                        type = resolver2.resolveMethodMember(localNode).get(local.init).type;
                                    } catch (RuntimeException e2) {
                                        System.err.println("Exception while resolving: " + localNode + "(" + localNode.getFileName() + ")");
                                        throw e2;
                                    }
                                }
                            }
                        } else if (rhsOfEnhancedForLoop.type == null) {
                            JavacResolution resolver3 = new JavacResolution(localNode.getContext());
                            type = resolver3.resolveMethodMember(localNode.directUp()).get(rhsOfEnhancedForLoop).type;
                        } else {
                            type = rhsOfEnhancedForLoop.type;
                        }
                        try {
                            if (rhsOfEnhancedForLoop != null) {
                                Type componentType = JavacResolution.ifTypeIsIterableToComponent(type, localNode.getAst());
                                replacement = componentType == null ? JavacResolution.createJavaLangObject(localNode.getAst()) : JavacResolution.typeToJCTree(componentType, localNode.getAst(), false);
                            } else {
                                replacement = JavacResolution.typeToJCTree(type, localNode.getAst(), false);
                            }
                            if (replacement != null) {
                                local.vartype = replacement;
                            } else {
                                local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
                            }
                            localNode.getAst().setChanged();
                        } catch (JavacResolution.TypeNotConvertibleException e3) {
                            localNode.addError("Cannot use '" + typeTreeToString + "' here because initializer expression does not have a representable type: " + e3.getMessage());
                            local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
                        }
                        JavacHandlerUtil.recursiveSetGeneratedBy(local.vartype, jCExpression, localNode.getContext());
                    } catch (RuntimeException e4) {
                        local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
                        throw e4;
                    }
                } catch (Throwable th) {
                    JavacHandlerUtil.recursiveSetGeneratedBy(local.vartype, jCExpression, localNode.getContext());
                    throw th;
                }
            }
        }
    }
}
