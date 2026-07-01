package lombok.eclipse.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.core.AST;
import lombok.core.LombokImmutableList;
import lombok.core.SpiLoadUtil;
import lombok.core.TypeLibrary;
import lombok.core.configuration.CheckerFrameworkVersion;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.HandleBuilder;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.AbstractMethodDeclaration;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Argument;
import org.eclipse.jdt.internal.compiler.ast.Block;
import org.eclipse.jdt.internal.compiler.ast.ConditionalExpression;
import org.eclipse.jdt.internal.compiler.ast.EqualExpression;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.FieldReference;
import org.eclipse.jdt.internal.compiler.ast.IfStatement;
import org.eclipse.jdt.internal.compiler.ast.IntLiteral;
import org.eclipse.jdt.internal.compiler.ast.MarkerAnnotation;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.eclipse.jdt.internal.compiler.ast.NullLiteral;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedQualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Reference;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.eclipse.jdt.internal.compiler.ast.SingleNameReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.Statement;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;
import org.eclipse.jdt.internal.compiler.ast.Wildcard;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.eclipse.jdt.internal.compiler.lookup.MethodScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes.SCL.lombok */
public class EclipseSingularsRecipes {
    private static final EclipseSingularsRecipes INSTANCE = new EclipseSingularsRecipes();
    private final Map<String, EclipseSingularizer> singularizers = new HashMap();
    private final TypeLibrary singularizableTypes = new TypeLibrary();

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes$StatementMaker.SCL.lombok */
    public interface StatementMaker {
        /* JADX INFO: renamed from: make */
        Statement mo186make();
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes$TypeReferenceMaker.SCL.lombok */
    public interface TypeReferenceMaker {
        TypeReference make();
    }

    private EclipseSingularsRecipes() {
        try {
            loadAll(this.singularizableTypes, this.singularizers);
            this.singularizableTypes.lock();
        } catch (IOException e) {
            System.err.println("Lombok's @Singularizable feature is broken due to misconfigured SPI files: " + e);
        }
    }

    private static void loadAll(TypeLibrary library, Map<String, EclipseSingularizer> map) throws IOException {
        for (EclipseSingularizer handler : SpiLoadUtil.findServices(EclipseSingularizer.class, EclipseSingularizer.class.getClassLoader())) {
            for (String type : handler.getSupportedTypes()) {
                EclipseSingularizer existingSingularizer = map.get(type);
                if (existingSingularizer != null) {
                    EclipseSingularizer toKeep = existingSingularizer.getClass().getName().compareTo(handler.getClass().getName()) > 0 ? handler : existingSingularizer;
                    System.err.println("Multiple singularizers found for type " + type + "; the alphabetically first class is used: " + toKeep.getClass().getName());
                    map.put(type, toKeep);
                } else {
                    map.put(type, handler);
                    library.addType(type);
                }
            }
        }
    }

    public static EclipseSingularsRecipes get() {
        return INSTANCE;
    }

    public String toQualified(String typeReference) {
        List<String> q = this.singularizableTypes.toQualifieds(typeReference);
        if (q.isEmpty()) {
            return null;
        }
        return q.get(0);
    }

    public EclipseSingularizer getSingularizer(String fqn) {
        return this.singularizers.get(fqn);
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes$SingularData.SCL.lombok */
    public static final class SingularData {
        private final EclipseNode annotation;
        private final char[] singularName;
        private final char[] pluralName;
        private final char[] setterPrefix;
        private final List<TypeReference> typeArgs;
        private final String targetFqn;
        private final EclipseSingularizer singularizer;
        private final boolean ignoreNullCollections;
        private final ASTNode source;

        public SingularData(EclipseNode annotation, char[] singularName, char[] pluralName, List<TypeReference> typeArgs, String targetFqn, EclipseSingularizer singularizer, ASTNode source, boolean ignoreNullCollections) {
            this(annotation, singularName, pluralName, typeArgs, targetFqn, singularizer, source, ignoreNullCollections, new char[0]);
        }

        public SingularData(EclipseNode annotation, char[] singularName, char[] pluralName, List<TypeReference> typeArgs, String targetFqn, EclipseSingularizer singularizer, ASTNode source, boolean ignoreNullCollections, char[] setterPrefix) {
            this.annotation = annotation;
            this.singularName = singularName;
            this.pluralName = pluralName;
            this.typeArgs = typeArgs;
            this.targetFqn = targetFqn;
            this.singularizer = singularizer;
            this.source = source;
            this.ignoreNullCollections = ignoreNullCollections;
            this.setterPrefix = setterPrefix;
        }

        public void setGeneratedByRecursive(ASTNode target) {
            SetGeneratedByVisitor visitor = new SetGeneratedByVisitor(this.source);
            if (target instanceof AbstractMethodDeclaration) {
                ((AbstractMethodDeclaration) target).traverse(visitor, (ClassScope) null);
            } else if (target instanceof FieldDeclaration) {
                ((FieldDeclaration) target).traverse(visitor, (MethodScope) null);
            } else {
                target.traverse(visitor, (BlockScope) null);
            }
        }

        public ASTNode getSource() {
            return this.source;
        }

        public EclipseNode getAnnotation() {
            return this.annotation;
        }

        public char[] getSingularName() {
            return this.singularName;
        }

        public char[] getPluralName() {
            return this.pluralName;
        }

        public char[] getSetterPrefix() {
            return this.setterPrefix;
        }

        public List<TypeReference> getTypeArgs() {
            return this.typeArgs;
        }

        public String getTargetFqn() {
            return this.targetFqn;
        }

        public EclipseSingularizer getSingularizer() {
            return this.singularizer;
        }

        public boolean isIgnoreNullCollections() {
            return this.ignoreNullCollections;
        }

        public String getTargetSimpleType() {
            int idx = this.targetFqn.lastIndexOf(".");
            return idx == -1 ? this.targetFqn : this.targetFqn.substring(idx + 1);
        }
    }

    /* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseSingularsRecipes$EclipseSingularizer.SCL.lombok */
    public static abstract class EclipseSingularizer {
        protected static final long[] NULL_POSS = new long[1];
        private static final char[] SIZE_TEXT = {'s', 'i', 'z', 'e'};
        private static /* synthetic */ int[] $SWITCH_TABLE$lombok$core$AST$Kind;

        public abstract LombokImmutableList<String> getSupportedTypes();

        public abstract List<EclipseNode> generateFields(SingularData singularData, EclipseNode eclipseNode);

        public abstract void generateMethods(CheckerFrameworkVersion checkerFrameworkVersion, SingularData singularData, boolean z2, EclipseNode eclipseNode, boolean z3, TypeReferenceMaker typeReferenceMaker, StatementMaker statementMaker, AccessLevel accessLevel);

        public abstract void appendBuildCode(SingularData singularData, EclipseNode eclipseNode, List<Statement> list, char[] cArr, String str);

        protected abstract char[][] getEmptyMakerReceiver(String str);

        protected abstract char[] getEmptyMakerSelector(String str);

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

        public boolean checkForAlreadyExistingNodesAndGenerateError(EclipseNode builderType, SingularData data) {
            for (EclipseNode child : builderType.down()) {
                switch ($SWITCH_TABLE$lombok$core$AST$Kind()[child.getKind().ordinal()]) {
                    case 3:
                        FieldDeclaration fd = child.get();
                        char[] name = fd.name;
                        if (name != null && EclipseHandlerUtil.getGeneratedBy(fd) == null) {
                            for (char[] fieldToBeGenerated : listFieldsToBeGenerated(data, builderType)) {
                                if (Arrays.equals(name, fieldToBeGenerated)) {
                                    child.addError("Manually adding a field that @Singular @Builder would generate is not supported. If you want to manually manage the builder aspect for this field/parameter, don't use @Singular.");
                                    return true;
                                }
                            }
                        }
                        break;
                    case 5:
                        AbstractMethodDeclaration method = child.get();
                        char[] name2 = method.selector;
                        if (name2 != null && EclipseHandlerUtil.getGeneratedBy(method) == null) {
                            for (char[] methodToBeGenerated : listMethodsToBeGenerated(data, builderType)) {
                                if (Arrays.equals(name2, methodToBeGenerated)) {
                                    child.addError("Manually adding a method that @Singular @Builder would generate is not supported. If you want to manually manage the builder aspect for this field/parameter, don't use @Singular.");
                                    return true;
                                }
                            }
                        }
                        break;
                }
            }
            return false;
        }

        public List<char[]> listFieldsToBeGenerated(SingularData data, EclipseNode builderType) {
            return Collections.singletonList(data.pluralName);
        }

        public List<char[]> listMethodsToBeGenerated(SingularData data, EclipseNode builderType) {
            char[] p = data.pluralName;
            char[] s2 = data.singularName;
            return Arrays.equals(p, s2) ? Collections.singletonList(p) : Arrays.asList(p, s2);
        }

        public void generateMethods(final HandleBuilder.BuilderJob job, SingularData data, boolean deprecate) {
            TypeReferenceMaker returnTypeMaker = new TypeReferenceMaker() { // from class: lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer.1
                @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.TypeReferenceMaker
                public TypeReference make() {
                    return job.oldChain ? EclipseHandlerUtil.cloneSelfType(job.builderType) : TypeReference.baseTypeReference(6, 0);
                }
            };
            StatementMaker returnStatementMaker = new StatementMaker() { // from class: lombok.eclipse.handlers.EclipseSingularsRecipes.EclipseSingularizer.2
                @Override // lombok.eclipse.handlers.EclipseSingularsRecipes.StatementMaker
                /* JADX INFO: renamed from: make, reason: merged with bridge method [inline-methods] */
                public ReturnStatement mo186make() {
                    if (job.oldChain) {
                        return new ReturnStatement(new ThisReference(0, 0), 0, 0);
                    }
                    return null;
                }
            };
            generateMethods(job.checkerFramework, data, deprecate, job.builderType, job.oldFluent, returnTypeMaker, returnStatementMaker, job.accessInners);
        }

        public boolean shadowedDuringBuild() {
            return true;
        }

        public boolean requiresCleaning() {
            try {
                return !getClass().getMethod("appendCleaningCode", SingularData.class, EclipseNode.class, List.class).getDeclaringClass().equals(EclipseSingularizer.class);
            } catch (NoSuchMethodException unused) {
                return false;
            }
        }

        public void appendCleaningCode(SingularData data, EclipseNode builderType, List<Statement> statements) {
        }

        protected Annotation[] generateSelfReturnAnnotations(boolean deprecate, CheckerFrameworkVersion cfv, ASTNode source) {
            MarkerAnnotation markerAnnotationGenerateDeprecatedAnnotation = deprecate ? EclipseHandlerUtil.generateDeprecatedAnnotation(source) : null;
            MarkerAnnotation markerAnnotationGenerateNamedAnnotation = cfv.generateReturnsReceiver() ? EclipseHandlerUtil.generateNamedAnnotation(source, CheckerFrameworkVersion.NAME__RETURNS_RECEIVER) : null;
            if (markerAnnotationGenerateDeprecatedAnnotation == null && markerAnnotationGenerateNamedAnnotation == null) {
                return null;
            }
            if (markerAnnotationGenerateDeprecatedAnnotation == null) {
                return new Annotation[]{markerAnnotationGenerateNamedAnnotation};
            }
            return markerAnnotationGenerateNamedAnnotation == null ? new Annotation[]{markerAnnotationGenerateDeprecatedAnnotation} : new Annotation[]{markerAnnotationGenerateDeprecatedAnnotation, markerAnnotationGenerateNamedAnnotation};
        }

        protected TypeReference addTypeArgs(int count, boolean addExtends, EclipseNode node, TypeReference type, List<TypeReference> typeArgs) {
            TypeReference[] clonedAndFixedArgs = createTypeArgs(count, addExtends, node, typeArgs);
            if (type instanceof SingleTypeReference) {
                type = new ParameterizedSingleTypeReference(((SingleTypeReference) type).token, clonedAndFixedArgs, 0, 0L);
            } else if (type instanceof QualifiedTypeReference) {
                QualifiedTypeReference qtr = (QualifiedTypeReference) type;
                TypeReference[][] trs = new TypeReference[qtr.tokens.length][];
                trs[qtr.tokens.length - 1] = clonedAndFixedArgs;
                type = new ParameterizedQualifiedTypeReference(((QualifiedTypeReference) type).tokens, trs, 0, NULL_POSS);
            } else {
                node.addError("Don't know how to clone-and-parameterize type: " + type);
            }
            return type;
        }

        protected TypeReference[] createTypeArgs(int count, boolean addExtends, EclipseNode node, List<TypeReference> typeArgs) {
            if (count < 0) {
                throw new IllegalArgumentException("count is negative");
            }
            if (count == 0) {
                return null;
            }
            List<TypeReference> arguments = new ArrayList<>();
            if (typeArgs != null) {
                Iterator<TypeReference> it = typeArgs.iterator();
                while (it.hasNext()) {
                    Wildcard wildcard = (TypeReference) it.next();
                    Wildcard wildcard2 = wildcard instanceof Wildcard ? wildcard : null;
                    if (!addExtends) {
                        if (wildcard2 != null && (wildcard2.kind == 0 || wildcard2.kind == 2)) {
                            arguments.add(new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, NULL_POSS));
                        } else if (wildcard2 != null && wildcard2.kind == 1) {
                            try {
                                arguments.add(EclipseHandlerUtil.copyType(wildcard2.bound));
                            } catch (Exception unused) {
                                arguments.add(new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, NULL_POSS));
                            }
                        } else {
                            arguments.add(EclipseHandlerUtil.copyType(wildcard));
                        }
                    } else if (wildcard2 != null && (wildcard2.kind == 0 || wildcard2.kind == 2)) {
                        arguments.add(new Wildcard(0));
                    } else if (wildcard2 != null && wildcard2.kind == 1) {
                        arguments.add(EclipseHandlerUtil.copyType(wildcard));
                    } else {
                        Wildcard w = new Wildcard(1);
                        w.bound = EclipseHandlerUtil.copyType(wildcard);
                        arguments.add(w);
                    }
                    count--;
                    if (count == 0) {
                        break;
                    }
                }
            }
            while (true) {
                int i = count;
                count--;
                if (i <= 0) {
                    break;
                }
                if (addExtends) {
                    arguments.add(new Wildcard(0));
                } else {
                    arguments.add(new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, NULL_POSS));
                }
            }
            if (arguments.isEmpty()) {
                return null;
            }
            return (TypeReference[]) arguments.toArray(new TypeReference[0]);
        }

        protected Expression getSize(EclipseNode builderType, char[] name, boolean nullGuard, String builderVariable) {
            MessageSend invoke = new MessageSend();
            Reference thisRef = getBuilderReference(builderVariable);
            FieldReference thisDotName = new FieldReference(name, 0L);
            thisDotName.receiver = thisRef;
            invoke.receiver = thisDotName;
            invoke.selector = SIZE_TEXT;
            if (!nullGuard) {
                return invoke;
            }
            Reference cdnThisRef = getBuilderReference(builderVariable);
            FieldReference cdnThisDotName = new FieldReference(name, 0L);
            cdnThisDotName.receiver = cdnThisRef;
            NullLiteral nullLiteral = new NullLiteral(0, 0);
            EqualExpression isNull = new EqualExpression(cdnThisDotName, nullLiteral, 18);
            IntLiteral zeroLiteral = EclipseHandlerUtil.makeIntLiteral(new char[]{'0'}, null);
            ConditionalExpression conditional = new ConditionalExpression(isNull, zeroLiteral, invoke);
            return conditional;
        }

        protected TypeReference cloneParamType(int index, List<TypeReference> typeArgs, EclipseNode builderType) {
            if (typeArgs != null && typeArgs.size() > index) {
                Wildcard wildcard = (TypeReference) typeArgs.get(index);
                if (wildcard instanceof Wildcard) {
                    Wildcard wOriginalType = wildcard;
                    if (wOriginalType.kind == 1) {
                        try {
                            return EclipseHandlerUtil.copyType(wOriginalType.bound);
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    return EclipseHandlerUtil.copyType(wildcard);
                }
            }
            return new QualifiedTypeReference(TypeConstants.JAVA_LANG_OBJECT, NULL_POSS);
        }

        protected static Reference getBuilderReference(String builderVariable) {
            if ("this".equals(builderVariable)) {
                return new ThisReference(0, 0);
            }
            return new SingleNameReference(builderVariable.toCharArray(), 0L);
        }

        protected void nullBehaviorize(EclipseNode typeNode, SingularData data, List<Statement> statements, Argument arg) {
            boolean ignoreNullCollections = data.isIgnoreNullCollections();
            if (ignoreNullCollections) {
                EqualExpression equalExpression = new EqualExpression(new SingleNameReference(data.getPluralName(), 0L), new NullLiteral(0, 0), 29);
                Block b2 = new Block(0);
                b2.statements = (Statement[]) statements.toArray(new Statement[statements.size()]);
                statements.clear();
                statements.add(new IfStatement(equalExpression, b2, 0, 0));
                EclipseHandlerUtil.createRelevantNullableAnnotation(typeNode, arg);
                return;
            }
            EclipseHandlerUtil.createRelevantNonNullAnnotation(typeNode, arg);
            Statement nullCheck = EclipseHandlerUtil.generateNullCheck(null, data.getPluralName(), typeNode, "%s cannot be null");
            statements.add(0, nullCheck);
        }
    }
}
