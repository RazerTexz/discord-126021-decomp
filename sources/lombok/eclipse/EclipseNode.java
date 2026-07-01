package lombok.eclipse;

import java.util.List;
import lombok.core.AST;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.LombokNode;
import lombok.eclipse.handlers.EclipseHandlerUtil;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Clinit;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Initializer;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.ast.MethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/EclipseNode.SCL.lombok */
public class EclipseNode extends LombokNode<EclipseAST, EclipseNode, ASTNode> {
    private EclipseAST ast;
    private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

    @Override // lombok.core.LombokNode
    protected /* bridge */ /* synthetic */ boolean calculateIsStructurallySignificant(ASTNode aSTNode) {
        return calculateIsStructurallySignificant2(aSTNode);
    }

    @Override // lombok.core.LombokNode
    public /* bridge */ /* synthetic */ AST getAst() {
        return getAst();
    }

    @Override // lombok.core.LombokNode
    protected /* bridge */ /* synthetic */ boolean fieldContainsAnnotation(ASTNode aSTNode, ASTNode aSTNode2) {
        return fieldContainsAnnotation2(aSTNode, aSTNode2);
    }

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

    EclipseNode(EclipseAST ast, ASTNode node, List<EclipseNode> children, AST$Kind kind) {
        super(node, children, kind);
        this.ast = ast;
    }

    @Override // lombok.core.LombokNode
    public EclipseAST getAst() {
        return this.ast;
    }

    public void traverse(EclipseASTVisitor visitor) {
        if (!visitor.isDeferUntilPostDiet() || isCompleteParse()) {
            switch ($SWITCH_TABLE$lombok$core$AST$Kind()[getKind().ordinal()]) {
                case 1:
                    visitor.visitCompilationUnit(this, (CompilationUnitDeclaration) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitCompilationUnit(this, (CompilationUnitDeclaration) get());
                    return;
                case 2:
                    visitor.visitType(this, (TypeDeclaration) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitType(this, (TypeDeclaration) get());
                    return;
                case 3:
                    visitor.visitField(this, (FieldDeclaration) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitField(this, (FieldDeclaration) get());
                    return;
                case 4:
                    visitor.visitInitializer(this, (Initializer) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitInitializer(this, (Initializer) get());
                    return;
                case 5:
                    if (get() instanceof Clinit) {
                        return;
                    }
                    visitor.visitMethod(this, (AbstractMethodDeclaration) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitMethod(this, (AbstractMethodDeclaration) get());
                    return;
                case 6:
                    switch ($SWITCH_TABLE$lombok$core$AST$Kind()[up().getKind().ordinal()]) {
                        case 2:
                            visitor.visitAnnotationOnType((TypeDeclaration) up().get(), this, (Annotation) get());
                            return;
                        case 3:
                            visitor.visitAnnotationOnField((FieldDeclaration) up().get(), this, (Annotation) get());
                            return;
                        case 4:
                        case 6:
                        case 9:
                        default:
                            throw new AssertionError("Annotation not expected as child of a " + up().getKind());
                        case 5:
                            visitor.visitAnnotationOnMethod((AbstractMethodDeclaration) up().get(), this, (Annotation) get());
                            return;
                        case 7:
                            visitor.visitAnnotationOnMethodArgument((Argument) ((EclipseNode) this.parent).get(), (AbstractMethodDeclaration) ((EclipseNode) this.parent).directUp().get(), this, (Annotation) get());
                            return;
                        case 8:
                            visitor.visitAnnotationOnLocal((LocalDeclaration) ((EclipseNode) this.parent).get(), this, (Annotation) get());
                            return;
                        case 10:
                            visitor.visitAnnotationOnTypeUse((TypeReference) ((EclipseNode) this.parent).get(), this, (Annotation) get());
                            return;
                    }
                case 7:
                    AbstractMethodDeclaration method = (AbstractMethodDeclaration) up().get();
                    visitor.visitMethodArgument(this, (Argument) get(), method);
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitMethodArgument(this, (Argument) get(), method);
                    return;
                case 8:
                    visitor.visitLocal(this, (LocalDeclaration) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitLocal(this, (LocalDeclaration) get());
                    return;
                case 9:
                    visitor.visitStatement(this, (Statement) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitStatement(this, (Statement) get());
                    return;
                case 10:
                    visitor.visitTypeUse(this, (TypeReference) get());
                    this.ast.traverseChildren(visitor, this);
                    visitor.endVisitTypeUse(this, (TypeReference) get());
                    return;
                default:
                    throw new AssertionError("Unexpected kind during node traversal: " + getKind());
            }
        }
    }

    /* JADX INFO: renamed from: fieldContainsAnnotation, reason: avoid collision after fix types in other method */
    protected boolean fieldContainsAnnotation2(ASTNode field, ASTNode annotation) {
        if (!(field instanceof FieldDeclaration)) {
            return false;
        }
        FieldDeclaration f = (FieldDeclaration) field;
        if (f.annotations == null) {
            return false;
        }
        for (Annotation childAnnotation : f.annotations) {
            if (childAnnotation == annotation) {
                return true;
            }
        }
        return false;
    }

    @Override // lombok.core.LombokNode
    public String getName() {
        char[] n;
        if (this.node instanceof TypeDeclaration) {
            n = ((TypeDeclaration) this.node).name;
        } else if (this.node instanceof FieldDeclaration) {
            n = ((FieldDeclaration) this.node).name;
        } else if (this.node instanceof AbstractMethodDeclaration) {
            n = ((AbstractMethodDeclaration) this.node).selector;
        } else {
            n = this.node instanceof LocalDeclaration ? ((LocalDeclaration) this.node).name : null;
        }
        if (n == null) {
            return null;
        }
        return new String(n);
    }

    @Override // lombok.core.DiagnosticsReceiver
    public void addError(String message) {
        addError(message, get().sourceStart, get().sourceEnd);
    }

    public void addError(String message, int sourceStart, int sourceEnd) {
        EclipseAST eclipseAST = this.ast;
        EclipseAST eclipseAST2 = this.ast;
        eclipseAST2.getClass();
        eclipseAST.addProblem(new EclipseAST$ParseProblem(eclipseAST2, false, message, sourceStart, sourceEnd));
    }

    @Override // lombok.core.DiagnosticsReceiver
    public void addWarning(String message) {
        addWarning(message, get().sourceStart, get().sourceEnd);
    }

    public void addWarning(String message, int sourceStart, int sourceEnd) {
        EclipseAST eclipseAST = this.ast;
        EclipseAST eclipseAST2 = this.ast;
        eclipseAST2.getClass();
        eclipseAST.addProblem(new EclipseAST$ParseProblem(eclipseAST2, true, message, sourceStart, sourceEnd));
    }

    /* JADX INFO: renamed from: calculateIsStructurallySignificant, reason: avoid collision after fix types in other method */
    protected boolean calculateIsStructurallySignificant2(ASTNode parent) {
        return (this.node instanceof TypeDeclaration) || (this.node instanceof AbstractMethodDeclaration) || (this.node instanceof FieldDeclaration) || (this.node instanceof LocalDeclaration) || (this.node instanceof CompilationUnitDeclaration);
    }

    public boolean isCompleteParse() {
        return this.ast.isCompleteParse();
    }

    @Override // lombok.core.LombokNode
    public boolean hasAnnotation(Class<? extends java.lang.annotation.Annotation> type) {
        return EclipseHandlerUtil.hasAnnotation(type, this);
    }

    @Override // lombok.core.LombokNode
    public <Z extends java.lang.annotation.Annotation> AnnotationValues<Z> findAnnotation(Class<Z> type) {
        EclipseNode annotation = EclipseHandlerUtil.findAnnotation(type, this);
        if (annotation == null) {
            return null;
        }
        return EclipseHandlerUtil.createAnnotation(type, annotation);
    }

    private Integer getModifiers() {
        if (this.node instanceof TypeDeclaration) {
            return Integer.valueOf(((TypeDeclaration) this.node).modifiers);
        }
        if (this.node instanceof FieldDeclaration) {
            return Integer.valueOf(((FieldDeclaration) this.node).modifiers);
        }
        if (this.node instanceof LocalDeclaration) {
            return Integer.valueOf(((LocalDeclaration) this.node).modifiers);
        }
        if (this.node instanceof AbstractMethodDeclaration) {
            return Integer.valueOf(((AbstractMethodDeclaration) this.node).modifiers);
        }
        return null;
    }

    @Override // lombok.core.LombokNode
    public boolean isStatic() {
        EclipseNode directUp;
        if (this.node instanceof TypeDeclaration) {
            EclipseNode directUp2 = directUp();
            if (directUp2 == null || directUp2.getKind() == AST$Kind.COMPILATION_UNIT) {
                return true;
            }
            if (!(directUp2.get() instanceof TypeDeclaration)) {
                return false;
            }
            TypeDeclaration p = directUp2.get();
            int f = p.modifiers;
            if ((512 & f) != 0 || (16384 & f) != 0) {
                return true;
            }
        }
        if ((this.node instanceof FieldDeclaration) && (directUp = directUp()) != null && (directUp.get() instanceof TypeDeclaration)) {
            TypeDeclaration p2 = directUp.get();
            int f2 = p2.modifiers;
            if ((512 & f2) != 0) {
                return true;
            }
        }
        Integer i = getModifiers();
        if (i == null) {
            return false;
        }
        int f3 = i.intValue();
        return (8 & f3) != 0;
    }

    @Override // lombok.core.LombokNode
    public boolean isFinal() {
        EclipseNode directUp;
        if ((this.node instanceof FieldDeclaration) && (directUp = directUp()) != null && (directUp.get() instanceof TypeDeclaration)) {
            TypeDeclaration p = directUp.get();
            int f = p.modifiers;
            if ((16896 & f) != 0) {
                return true;
            }
        }
        Integer i = getModifiers();
        if (i == null) {
            return false;
        }
        int f2 = i.intValue();
        return (16 & f2) != 0;
    }

    @Override // lombok.core.LombokNode
    public boolean isPrimitive() {
        if ((this.node instanceof FieldDeclaration) && !isEnumMember()) {
            return Eclipse.isPrimitive(((FieldDeclaration) this.node).type);
        }
        if (this.node instanceof MethodDeclaration) {
            return Eclipse.isPrimitive(((MethodDeclaration) this.node).returnType);
        }
        return false;
    }

    @Override // lombok.core.LombokNode
    public String fieldOrMethodBaseType() {
        TypeReference typeReference = null;
        if ((this.node instanceof FieldDeclaration) && !isEnumMember()) {
            typeReference = ((FieldDeclaration) this.node).type;
        }
        if (this.node instanceof MethodDeclaration) {
            typeReference = ((MethodDeclaration) this.node).returnType;
        }
        if (typeReference == null) {
            return null;
        }
        String fqn = Eclipse.toQualifiedName(typeReference.getTypeName());
        if (typeReference.dimensions() == 0) {
            return fqn;
        }
        StringBuilder result = new StringBuilder(fqn.length() + (2 * typeReference.dimensions()));
        result.append(fqn);
        for (int i = 0; i < typeReference.dimensions(); i++) {
            result.append("[]");
        }
        return result.toString();
    }

    @Override // lombok.core.LombokNode
    public boolean isTransient() {
        Integer i;
        return (getKind() != AST$Kind.FIELD || (i = getModifiers()) == null || (i.intValue() & 128) == 0) ? false : true;
    }

    @Override // lombok.core.LombokNode
    public boolean isEnumMember() {
        return getKind() == AST$Kind.FIELD && ((FieldDeclaration) this.node).getKind() == 3;
    }

    @Override // lombok.core.LombokNode
    public boolean isEnumType() {
        return getKind() == AST$Kind.TYPE && (((TypeDeclaration) this.node).modifiers & 16384) != 0;
    }

    @Override // lombok.core.LombokNode
    public int countMethodParameters() {
        Argument[] a;
        if (getKind() == AST$Kind.METHOD && (a = ((AbstractMethodDeclaration) this.node).arguments) != null) {
            return a.length;
        }
        return 0;
    }

    @Override // lombok.core.LombokNode
    public int getStartPos() {
        return ((ASTNode) this.node).sourceStart;
    }
}
