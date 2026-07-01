package lombok.eclipse.handlers;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import lombok.ConfigurationKeys;
import lombok.NonNull;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.DeferUntilPostDiet;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseAST;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.AssertStatement;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleNonNull.SCL.lombok */
@DeferUntilPostDiet
@HandlerPriority(512)
public class HandleNonNull extends EclipseAnnotationHandler<NonNull> {
    private static final char[] REQUIRE_NON_NULL = "requireNonNull".toCharArray();
    private static final char[] CHECK_NOT_NULL = "checkNotNull".toCharArray();
    public static final HandleNonNull INSTANCE = new HandleNonNull();
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

    static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind() {
        int[] iArr = $SWITCH_TABLE$lombok$core$AST$Kind;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[AST$Kind.valuesCustom().length];
        try {
            iArr2[AST$Kind.ANNOTATION.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[AST$Kind.ARGUMENT.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[AST$Kind.COMPILATION_UNIT.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[AST$Kind.FIELD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[AST$Kind.INITIALIZER.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[AST$Kind.LOCAL.ordinal()] = 8;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[AST$Kind.METHOD.ordinal()] = 5;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[AST$Kind.STATEMENT.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[AST$Kind.TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AST$Kind.TYPE_USE.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$lombok$core$AST$Kind = iArr2;
        return iArr2;
    }

    public void fix(EclipseNode method) {
        for (EclipseNode m : method.down()) {
            if (m.getKind() == AST$Kind.ARGUMENT) {
                for (EclipseNode c : m.down()) {
                    if (c.getKind() == AST$Kind.ANNOTATION && EclipseHandlerUtil.annotationTypeMatches((Class<? extends Annotation>) NonNull.class, c)) {
                        handle0((org.eclipse.jdt.internal.compiler.ast.Annotation) c.get(), c, true);
                    }
                }
            }
        }
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<NonNull> annotation, org.eclipse.jdt.internal.compiler.ast.Annotation ast, EclipseNode annotationNode) {
        handle0(ast, annotationNode, false);
    }

    /* JADX WARN: Code duplicated, block: B:65:0x01de  */
    private void handle0(org.eclipse.jdt.internal.compiler.ast.Annotation ast, EclipseNode annotationNode, boolean force) {
        EclipseNode paramNode;
        int i;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.NON_NULL_FLAG_USAGE, "@NonNull");
        if (annotationNode.up().getKind() == AST$Kind.FIELD) {
            try {
                if (Eclipse.isPrimitive(annotationNode.up().get().type)) {
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
                EclipseNode typeNode = annotationNode.directUp();
                boolean ok = false;
                TypeReference typeReference = (ASTNode) typeNode.get();
                if (typeReference instanceof TypeReference) {
                    org.eclipse.jdt.internal.compiler.ast.Annotation[] anns = EclipseAST.getTopLevelTypeReferenceAnnotations(typeReference);
                    if (anns == null) {
                        return;
                    }
                    for (org.eclipse.jdt.internal.compiler.ast.Annotation ann : anns) {
                        if (ast == ann) {
                            ok = true;
                        }
                    }
                }
                if (!ok) {
                    return;
                } else {
                    paramNode = typeNode.directUp();
                }
                break;
        }
        try {
            Argument param = paramNode.get();
            AbstractMethodDeclaration declaration = paramNode.up().get();
            if ((!force && EclipseHandlerUtil.isGenerated(declaration)) || declaration.isAbstract()) {
                return;
            }
            Statement nullCheck = EclipseHandlerUtil.generateNullCheck(param, annotationNode, null);
            if (nullCheck == null) {
                annotationNode.addWarning("@NonNull is meaningless on a primitive.");
                return;
            }
            if (declaration.statements == null) {
                declaration.statements = new Statement[]{nullCheck};
            } else {
                char[] expectedName = param.name;
                Statement[] stats = declaration.statements;
                int idx = 0;
                while (stats != null && stats.length > idx) {
                    int i2 = idx;
                    idx++;
                    Statement stat = stats[i2];
                    if (stat instanceof TryStatement) {
                        stats = ((TryStatement) stat).tryBlock.statements;
                        idx = 0;
                    } else if (stat instanceof SynchronizedStatement) {
                        stats = ((SynchronizedStatement) stat).block.statements;
                        idx = 0;
                    } else {
                        char[] varNameOfNullCheck = returnVarNameIfNullCheck(stat);
                        if (varNameOfNullCheck != null) {
                            if (Arrays.equals(varNameOfNullCheck, expectedName)) {
                                return;
                            }
                        } else {
                            Statement[] newStatements = new Statement[declaration.statements.length + 1];
                            int skipOver = 0;
                            for (ASTNode aSTNode : declaration.statements) {
                                if (!EclipseHandlerUtil.isGenerated(aSTNode) && isNullCheck(aSTNode)) {
                                    skipOver++;
                                } else {
                                    System.arraycopy(declaration.statements, 0, newStatements, 0, skipOver);
                                    System.arraycopy(declaration.statements, skipOver, newStatements, skipOver + 1, declaration.statements.length - skipOver);
                                    newStatements[skipOver] = nullCheck;
                                    declaration.statements = newStatements;
                                }
                            }
                            System.arraycopy(declaration.statements, 0, newStatements, 0, skipOver);
                            System.arraycopy(declaration.statements, skipOver, newStatements, skipOver + 1, declaration.statements.length - skipOver);
                            newStatements[skipOver] = nullCheck;
                            declaration.statements = newStatements;
                        }
                    }
                }
                Statement[] newStatements2 = new Statement[declaration.statements.length + 1];
                int skipOver2 = 0;
                while (i < r0) {
                    if (!EclipseHandlerUtil.isGenerated(aSTNode)) {
                    }
                    System.arraycopy(declaration.statements, 0, newStatements2, 0, skipOver2);
                    System.arraycopy(declaration.statements, skipOver2, newStatements2, skipOver2 + 1, declaration.statements.length - skipOver2);
                    newStatements2[skipOver2] = nullCheck;
                    declaration.statements = newStatements2;
                }
                System.arraycopy(declaration.statements, 0, newStatements2, 0, skipOver2);
                System.arraycopy(declaration.statements, skipOver2, newStatements2, skipOver2 + 1, declaration.statements.length - skipOver2);
                newStatements2[skipOver2] = nullCheck;
                declaration.statements = newStatements2;
            }
            paramNode.up().rebuild();
        } catch (Exception unused2) {
        }
    }

    public boolean isNullCheck(Statement stat) {
        return returnVarNameIfNullCheck(stat) != null;
    }

    public char[] returnVarNameIfNullCheck(Statement stat) {
        boolean isIf = stat instanceof IfStatement;
        boolean isExpression = stat instanceof Expression;
        if (!isIf && !(stat instanceof AssertStatement) && !isExpression) {
            return null;
        }
        if (isExpression) {
            Expression expression = (Expression) stat;
            if (expression instanceof Assignment) {
                expression = ((Assignment) expression).expression;
            }
            if (!(expression instanceof MessageSend)) {
                return null;
            }
            MessageSend invocation = (MessageSend) expression;
            if ((!Arrays.equals(invocation.selector, CHECK_NOT_NULL) && !Arrays.equals(invocation.selector, REQUIRE_NON_NULL)) || invocation.arguments == null || invocation.arguments.length == 0) {
                return null;
            }
            SingleNameReference singleNameReference = invocation.arguments[0];
            if (singleNameReference instanceof SingleNameReference) {
                return singleNameReference.token;
            }
            return null;
        }
        if (isIf) {
            Statement then = ((IfStatement) stat).thenStatement;
            if (then instanceof Block) {
                Statement[] blockStatements = ((Block) then).statements;
                if (blockStatements == null || blockStatements.length == 0) {
                    return null;
                }
                then = blockStatements[0];
            }
            if (!(then instanceof ThrowStatement)) {
                return null;
            }
        }
        Expression cond = isIf ? ((IfStatement) stat).condition : ((AssertStatement) stat).assertExpression;
        if (!(cond instanceof EqualExpression)) {
            return null;
        }
        EqualExpression bin = (EqualExpression) cond;
        String op = bin.operatorToString();
        if (isIf) {
            if (!"==".equals(op)) {
                return null;
            }
        } else if (!"!=".equals(op)) {
            return null;
        }
        if ((bin.left instanceof SingleNameReference) && (bin.right instanceof NullLiteral)) {
            return bin.left.token;
        }
        return null;
    }
}
