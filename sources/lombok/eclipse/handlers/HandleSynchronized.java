package lombok.eclipse.handlers;

import java.util.Arrays;
import lombok.ConfigurationKeys;
import lombok.Synchronized;
import lombok.core.AST;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.DeferUntilPostDiet;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.QualifiedNameReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleSynchronized.SCL.lombok */
@DeferUntilPostDiet
@HandlerPriority(1024)
public class HandleSynchronized extends EclipseAnnotationHandler<Synchronized> {
    private static final char[] INSTANCE_LOCK_NAME = "$lock".toCharArray();
    private static final char[] STATIC_LOCK_NAME = "$LOCK".toCharArray();

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void preHandle(AnnotationValues<Synchronized> annotation, Annotation source, EclipseNode annotationNode) {
        EclipseNode methodNode = annotationNode.up();
        if (methodNode != null && methodNode.getKind() == AST.Kind.METHOD && (methodNode.get() instanceof MethodDeclaration)) {
            MethodDeclaration method = methodNode.get();
            if (method.isAbstract()) {
                return;
            }
            createLockField(annotation, annotationNode, new boolean[]{method.isStatic()}, false);
        }
    }

    public char[] createLockField(AnnotationValues<Synchronized> annotation, EclipseNode annotationNode, boolean[] isStatic, boolean reportErrors) {
        char[] lockName = annotation.getInstance().value().toCharArray();
        Annotation source = annotationNode.get();
        boolean autoMake = false;
        if (lockName.length == 0) {
            autoMake = true;
            lockName = isStatic[0] ? STATIC_LOCK_NAME : INSTANCE_LOCK_NAME;
        }
        EclipseNode typeNode = EclipseHandlerUtil.upToTypeNode(annotationNode);
        EclipseHandlerUtil.MemberExistsResult exists = EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS;
        if (typeNode != null && (typeNode.get() instanceof TypeDeclaration)) {
            TypeDeclaration typeDecl = typeNode.get();
            if (typeDecl.fields != null) {
                for (FieldDeclaration def : typeDecl.fields) {
                    char[] fName = def.name;
                    if (fName != null && Arrays.equals(fName, lockName)) {
                        exists = EclipseHandlerUtil.getGeneratedBy(def) == null ? EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_USER : EclipseHandlerUtil.MemberExistsResult.EXISTS_BY_LOMBOK;
                        boolean st = def.isStatic();
                        if (!st && isStatic[0]) {
                            if (reportErrors) {
                                annotationNode.addError(String.format("The field %s is non-static and thus cannot be used on this static method", new String(lockName)));
                                return null;
                            }
                            return null;
                        }
                        isStatic[0] = st;
                        break;
                    }
                }
            }
        }
        if (exists == EclipseHandlerUtil.MemberExistsResult.NOT_EXISTS) {
            if (!autoMake) {
                if (reportErrors) {
                    annotationNode.addError(String.format("The field %s does not exist", new String(lockName)));
                    return null;
                }
                return null;
            }
            FieldDeclaration fieldDecl = new FieldDeclaration(lockName, 0, -1);
            EclipseHandlerUtil.setGeneratedBy(fieldDecl, source);
            fieldDecl.declarationSourceEnd = -1;
            fieldDecl.modifiers = (isStatic[0] ? 8 : 0) | 16 | 2;
            ArrayAllocationExpression arrayAlloc = new ArrayAllocationExpression();
            EclipseHandlerUtil.setGeneratedBy(arrayAlloc, source);
            arrayAlloc.dimensions = new Expression[]{EclipseHandlerUtil.makeIntLiteral("0".toCharArray(), source)};
            arrayAlloc.type = new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, new long[3]);
            EclipseHandlerUtil.setGeneratedBy(arrayAlloc.type, source);
            fieldDecl.type = new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, new long[3]);
            EclipseHandlerUtil.setGeneratedBy(fieldDecl.type, source);
            fieldDecl.initialization = arrayAlloc;
            EclipseHandlerUtil.injectField(annotationNode.up().up(), fieldDecl);
        }
        return lockName;
    }

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Synchronized> annotation, Annotation source, EclipseNode annotationNode) {
        QualifiedNameReference fieldReference;
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.SYNCHRONIZED_FLAG_USAGE, "@Synchronized");
        int p1 = source.sourceStart - 1;
        int p2 = source.sourceStart - 2;
        long pos = (((long) p1) << 32) | ((long) p2);
        EclipseNode methodNode = annotationNode.up();
        if (methodNode == null || methodNode.getKind() != AST.Kind.METHOD || !(methodNode.get() instanceof MethodDeclaration)) {
            annotationNode.addError("@Synchronized is legal only on methods.");
            return;
        }
        MethodDeclaration method = methodNode.get();
        if (method.isAbstract()) {
            annotationNode.addError("@Synchronized is legal only on concrete methods.");
            return;
        }
        boolean[] isStatic = {method.isStatic()};
        char[] lockName = createLockField(annotation, annotationNode, isStatic, true);
        if (lockName == null || method.statements == null) {
            return;
        }
        Block block = new Block(0);
        EclipseHandlerUtil.setGeneratedBy(block, source);
        block.statements = method.statements;
        block.sourceEnd = method.bodyEnd;
        block.sourceStart = method.bodyStart;
        if (isStatic[0]) {
            EclipseNode typeNode = EclipseHandlerUtil.upToTypeNode(annotationNode);
            char[][] n = EclipseHandlerUtil.getQualifiedInnerName(typeNode, lockName);
            long[] ps = new long[n.length];
            Arrays.fill(ps, pos);
            fieldReference = new QualifiedNameReference(n, ps, p1, p2);
        } else {
            fieldReference = new FieldReference(lockName, pos);
            ThisReference thisReference = new ThisReference(p1, p2);
            EclipseHandlerUtil.setGeneratedBy(thisReference, source);
            ((FieldReference) fieldReference).receiver = thisReference;
        }
        EclipseHandlerUtil.setGeneratedBy(fieldReference, source);
        method.statements = new Statement[]{new SynchronizedStatement(fieldReference, block, 0, 0)};
        method.statements[0].sourceEnd = method.bodyEnd;
        method.statements[0].sourceStart = method.bodyStart;
        EclipseHandlerUtil.setGeneratedBy(method.statements[0], source);
        methodNode.rebuild();
    }
}
