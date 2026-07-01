package lombok.eclipse.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.SneakyThrows;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.DeferUntilPostDiet;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.ArrayInitializer;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.ConstructorDeclaration;
import org.eclipse.jdt.internal.compiler.ast.ExplicitConstructorCall;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.MemberValuePair;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSneakyThrows.SCL.lombok */
@DeferUntilPostDiet
@HandlerPriority(1024)
public class HandleSneakyThrows extends EclipseAnnotationHandler<SneakyThrows> {
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

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<SneakyThrows> annotation, Annotation source, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.SNEAKY_THROWS_FLAG_USAGE, "@SneakyThrows");
        List<String> exceptionNames = annotation.getRawExpressions("value");
        List<HandleSneakyThrows$DeclaredException> exceptions = new ArrayList<>();
        MemberValuePair[] memberValuePairs = source.memberValuePairs();
        if (memberValuePairs == null || memberValuePairs.length == 0) {
            exceptions.add(new HandleSneakyThrows$DeclaredException("java.lang.Throwable", source));
        } else {
            Expression arrayOrSingle = memberValuePairs[0].value;
            Expression[] exceptionNameNodes = arrayOrSingle instanceof ArrayInitializer ? ((ArrayInitializer) arrayOrSingle).expressions : new Expression[]{arrayOrSingle};
            if (exceptionNames.size() != exceptionNameNodes.length) {
                annotationNode.addError("LOMBOK BUG: The number of exception classes in the annotation isn't the same pre- and post- guessing.");
            }
            int idx = 0;
            for (String exceptionName : exceptionNames) {
                if (exceptionName.endsWith(".class")) {
                    exceptionName = exceptionName.substring(0, exceptionName.length() - 6);
                }
                int i = idx;
                idx++;
                exceptions.add(new HandleSneakyThrows$DeclaredException(exceptionName, exceptionNameNodes[i]));
            }
        }
        EclipseNode owner = annotationNode.up();
        switch ($SWITCH_TABLE$lombok$core$AST$Kind()[owner.getKind().ordinal()]) {
            case 5:
                handleMethod(annotationNode, (AbstractMethodDeclaration) owner.get(), exceptions);
                break;
            default:
                annotationNode.addError("@SneakyThrows is legal only on methods and constructors.");
                break;
        }
    }

    public void handleMethod(EclipseNode annotation, AbstractMethodDeclaration method, List<HandleSneakyThrows$DeclaredException> exceptions) {
        if (method.isAbstract()) {
            annotation.addError("@SneakyThrows can only be used on concrete methods.");
            return;
        }
        if (method.statements == null || method.statements.length == 0) {
            boolean hasConstructorCall = false;
            if (method instanceof ConstructorDeclaration) {
                ExplicitConstructorCall constructorCall = ((ConstructorDeclaration) method).constructorCall;
                hasConstructorCall = (constructorCall == null || constructorCall.isImplicitSuper() || constructorCall.isImplicitThis()) ? false : true;
            }
            if (hasConstructorCall) {
                annotation.addWarning("Calls to sibling / super constructors are always excluded from @SneakyThrows; @SneakyThrows has been ignored because there is no other code in this constructor.");
                return;
            } else {
                annotation.addWarning("This method or constructor is empty; @SneakyThrows has been ignored.");
                return;
            }
        }
        Statement[] contents = method.statements;
        for (HandleSneakyThrows$DeclaredException exception : exceptions) {
            contents = new Statement[]{buildTryCatchBlock(contents, exception, exception.node, method)};
        }
        method.statements = contents;
        annotation.up().rebuild();
    }

    public Statement buildTryCatchBlock(Statement[] contents, HandleSneakyThrows$DeclaredException exception, ASTNode source, AbstractMethodDeclaration method) {
        TypeReference typeReference;
        int methodStart = method.bodyStart;
        int methodEnd = method.bodyEnd;
        long methodPosEnd = (((long) methodEnd) << 32) | (((long) methodEnd) & 4294967295L);
        TryStatement tryStatement = new TryStatement();
        EclipseHandlerUtil.setGeneratedBy(tryStatement, source);
        tryStatement.tryBlock = new Block(0);
        tryStatement.tryBlock.sourceStart = methodStart;
        tryStatement.tryBlock.sourceEnd = methodEnd;
        EclipseHandlerUtil.setGeneratedBy(tryStatement.tryBlock, source);
        tryStatement.tryBlock.statements = contents;
        if (exception.exceptionName.indexOf(46) == -1) {
            typeReference = new SingleTypeReference(exception.exceptionName.toCharArray(), methodPosEnd);
            typeReference.statementEnd = methodEnd;
        } else {
            String[] x2 = exception.exceptionName.split("\\.");
            char[][] elems = new char[x2.length][];
            long[] poss = new long[x2.length];
            Arrays.fill(poss, methodPosEnd);
            for (int i = 0; i < x2.length; i++) {
                elems[i] = x2[i].trim().toCharArray();
            }
            typeReference = new QualifiedTypeReference(elems, poss);
        }
        EclipseHandlerUtil.setGeneratedBy(typeReference, source);
        Argument catchArg = new Argument("$ex".toCharArray(), methodPosEnd, typeReference, 16);
        EclipseHandlerUtil.setGeneratedBy(catchArg, source);
        catchArg.sourceEnd = methodEnd;
        catchArg.declarationEnd = methodEnd;
        catchArg.declarationSourceEnd = methodEnd;
        catchArg.sourceStart = methodEnd;
        catchArg.modifiersSourceStart = methodEnd;
        catchArg.declarationSourceStart = methodEnd;
        tryStatement.catchArguments = new Argument[]{catchArg};
        MessageSend sneakyThrowStatement = new MessageSend();
        EclipseHandlerUtil.setGeneratedBy(sneakyThrowStatement, source);
        sneakyThrowStatement.receiver = new QualifiedNameReference(new char[][]{"lombok".toCharArray(), "Lombok".toCharArray()}, new long[2], methodEnd, methodEnd);
        EclipseHandlerUtil.setGeneratedBy(sneakyThrowStatement.receiver, source);
        sneakyThrowStatement.receiver.statementEnd = methodEnd;
        sneakyThrowStatement.selector = "sneakyThrow".toCharArray();
        Expression singleNameReference = new SingleNameReference("$ex".toCharArray(), methodPosEnd);
        EclipseHandlerUtil.setGeneratedBy(singleNameReference, source);
        ((SingleNameReference) singleNameReference).statementEnd = methodEnd;
        sneakyThrowStatement.arguments = new Expression[]{singleNameReference};
        sneakyThrowStatement.nameSourcePosition = -2L;
        sneakyThrowStatement.sourceStart = methodEnd;
        sneakyThrowStatement.statementEnd = methodEnd;
        sneakyThrowStatement.sourceEnd = methodEnd;
        Statement rethrowStatement = new ThrowStatement(sneakyThrowStatement, methodEnd, methodEnd);
        EclipseHandlerUtil.setGeneratedBy(rethrowStatement, source);
        Block block = new Block(0);
        block.sourceStart = methodEnd;
        block.sourceEnd = methodEnd;
        EclipseHandlerUtil.setGeneratedBy(block, source);
        block.statements = new Statement[]{rethrowStatement};
        tryStatement.catchBlocks = new Block[]{block};
        tryStatement.sourceStart = method.bodyStart;
        tryStatement.sourceEnd = method.bodyEnd;
        return tryStatement;
    }
}
