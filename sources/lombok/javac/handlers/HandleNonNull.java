package lombok.javac.handlers;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import java.util.Iterator;
import lombok.ConfigurationKeys;
import lombok.NonNull;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.javac.Javac;
import lombok.javac.JavacAnnotationHandler;
import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/HandleNonNull.SCL.lombok */
@HandlerPriority(512)
public class HandleNonNull extends JavacAnnotationHandler<NonNull> {
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST.Kind.valuesCustom().length];
        try {
            iArr2[AST.Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST.Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST.Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST.Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST.Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST.Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST.Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST.Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST.Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST.Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x017b  */
    /* JADX WARN: Code duplicated, block: B:56:0x01cd A[LOOP:2: B:57:0x01e2->B:56:0x01cd, LOOP_END] */
    @Override // lombok.javac.JavacAnnotationHandler
    public void handle(AnnotationValues<NonNull> annotation, JCTree.JCAnnotation ast, JavacNode annotationNode) {
        JavacNode paramNode;
        List<JCTree.JCStatement> tail;
        List<JCTree.JCStatement> head;
        List<JCTree.JCStatement> newList;
        Iterator it;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.NON_NULL_FLAG_USAGE, "@NonNull");
        if (annotationNode.up().getKind() == AST.Kind.FIELD) {
            try {
                if (Javac.isPrimitive(annotationNode.up().get().vartype)) {
                    annotationNode.addWarning("@NonNull is meaningless on a primitive.");
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[annotationNode.up().getKind().ordinal()]) {
            case 7:
                paramNode = annotationNode.up();
                break;
            case 8:
            case 9:
            default:
                return;
            case 10:
                JavacNode typeNode = annotationNode.directUp();
                paramNode = typeNode.directUp();
                break;
        }
        if (paramNode.getKind() != AST.Kind.ARGUMENT) {
            return;
        }
        try {
            JCTree.JCMethodDecl declaration = paramNode.up().get();
            if (declaration.body == null) {
                return;
            }
            JCTree.JCStatement nullCheck = JavacHandlerUtil.recursiveSetGeneratedBy(JavacHandlerUtil.generateNullCheck(annotationNode.getTreeMaker(), paramNode, annotationNode), ast, annotationNode.getContext());
            if (nullCheck == null) {
                annotationNode.addWarning("@NonNull is meaningless on a primitive.");
                return;
            }
            List<JCTree.JCStatement> statements = declaration.body.stats;
            String expectedName = paramNode.getName();
            List<JCTree.JCStatement> stats = statements;
            int idx = 0;
            while (stats.size() > idx) {
                int i = idx;
                idx++;
                JCTree.JCSynchronized jCSynchronized = (JCTree.JCStatement) stats.get(i);
                if (!JavacHandlerUtil.isConstructorCall(jCSynchronized)) {
                    if (jCSynchronized instanceof JCTree.JCTry) {
                        stats = ((JCTree.JCTry) jCSynchronized).body.stats;
                        idx = 0;
                    } else if (jCSynchronized instanceof JCTree.JCSynchronized) {
                        stats = jCSynchronized.body.stats;
                        idx = 0;
                    } else {
                        String varNameOfNullCheck = returnVarNameIfNullCheck(jCSynchronized);
                        if (varNameOfNullCheck != null) {
                            if (varNameOfNullCheck.equals(expectedName)) {
                                return;
                            }
                        } else {
                            tail = statements;
                            head = List.nil();
                            for (JCTree.JCStatement stat : statements) {
                                if (!JavacHandlerUtil.isConstructorCall(stat) || (JavacHandlerUtil.isGenerated(stat) && isNullCheck(stat))) {
                                    tail = tail.tail;
                                    head = head.prepend(stat);
                                } else {
                                    newList = tail.prepend(nullCheck);
                                    it = head.iterator();
                                    while (it.hasNext()) {
                                        newList = newList.prepend((JCTree.JCStatement) it.next());
                                    }
                                    declaration.body.stats = newList;
                                    annotationNode.getAst().setChanged();
                                }
                            }
                            newList = tail.prepend(nullCheck);
                            it = head.iterator();
                            while (it.hasNext()) {
                                newList = newList.prepend((JCTree.JCStatement) it.next());
                            }
                            declaration.body.stats = newList;
                            annotationNode.getAst().setChanged();
                        }
                    }
                }
            }
            tail = statements;
            head = List.nil();
            while (r0.hasNext()) {
                if (!JavacHandlerUtil.isConstructorCall(stat)) {
                }
                tail = tail.tail;
                head = head.prepend(stat);
            }
            newList = tail.prepend(nullCheck);
            it = head.iterator();
            while (it.hasNext()) {
                newList = newList.prepend((JCTree.JCStatement) it.next());
            }
            declaration.body.stats = newList;
            annotationNode.getAst().setChanged();
        } catch (Exception unused2) {
        }
    }

    public boolean isNullCheck(JCTree.JCStatement stat) {
        return returnVarNameIfNullCheck(stat) != null;
    }

    public String returnVarNameIfNullCheck(JCTree.JCStatement stat) {
        JCTree.JCExpression cond;
        boolean isIf = stat instanceof JCTree.JCIf;
        boolean isExpression = stat instanceof JCTree.JCExpressionStatement;
        if (!isIf && !(stat instanceof JCTree.JCAssert) && !isExpression) {
            return null;
        }
        if (isExpression) {
            JCTree.JCExpression expression = ((JCTree.JCExpressionStatement) stat).expr;
            if (expression instanceof JCTree.JCAssign) {
                expression = ((JCTree.JCAssign) expression).rhs;
            }
            if (!(expression instanceof JCTree.JCMethodInvocation)) {
                return null;
            }
            JCTree.JCMethodInvocation invocation = (JCTree.JCMethodInvocation) expression;
            JCTree.JCFieldAccess jCFieldAccess = invocation.meth;
            Name name = null;
            if (jCFieldAccess instanceof JCTree.JCFieldAccess) {
                name = jCFieldAccess.name;
            } else if (jCFieldAccess instanceof JCTree.JCIdent) {
                name = ((JCTree.JCIdent) jCFieldAccess).name;
            }
            if (name == null) {
                return null;
            }
            if ((!name.contentEquals("checkNotNull") && !name.contentEquals("requireNonNull")) || invocation.args.isEmpty()) {
                return null;
            }
            JCTree.JCIdent jCIdent = (JCTree.JCExpression) invocation.args.head;
            if (jCIdent instanceof JCTree.JCIdent) {
                return jCIdent.toString();
            }
            return null;
        }
        if (isIf) {
            JCTree.JCStatement then = ((JCTree.JCIf) stat).thenpart;
            if (then instanceof JCTree.JCBlock) {
                List<JCTree.JCStatement> stats = ((JCTree.JCBlock) then).stats;
                if (stats.length() == 0) {
                    return null;
                }
                then = (JCTree.JCStatement) stats.get(0);
            }
            if (!(then instanceof JCTree.JCThrow)) {
                return null;
            }
        }
        JCTree.JCExpression jCExpression = isIf ? ((JCTree.JCIf) stat).cond : ((JCTree.JCAssert) stat).cond;
        while (true) {
            cond = jCExpression;
            if (!(cond instanceof JCTree.JCParens)) {
                break;
            }
            jCExpression = ((JCTree.JCParens) cond).expr;
        }
        if (!(cond instanceof JCTree.JCBinary)) {
            return null;
        }
        JCTree.JCBinary bin = (JCTree.JCBinary) cond;
        if (isIf) {
            if (!Javac.CTC_EQUAL.equals(JavacTreeMaker.TreeTag.treeTag((JCTree) bin))) {
                return null;
            }
        } else if (!Javac.CTC_NOT_EQUAL.equals(JavacTreeMaker.TreeTag.treeTag((JCTree) bin))) {
            return null;
        }
        if ((bin.lhs instanceof JCTree.JCIdent) && (bin.rhs instanceof JCTree.JCLiteral) && Javac.CTC_BOT.equals(JavacTreeMaker.TypeTag.typeTag((JCTree) bin.rhs))) {
            return bin.lhs.name.toString();
        }
        return null;
    }
}
