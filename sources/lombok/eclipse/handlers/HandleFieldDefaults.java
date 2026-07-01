package lombok.eclipse.handlers;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.core.AST$Kind;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.Eclipse;
import lombok.eclipse.EclipseASTAdapter;
import lombok.eclipse.EclipseNode;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;
import org.eclipse.jdt.internal.compiler.ast.ASTNode;
import org.eclipse.jdt.internal.compiler.ast.FieldDeclaration;
import org.eclipse.jdt.internal.compiler.ast.QualifiedTypeReference;
import org.eclipse.jdt.internal.compiler.ast.SingleTypeReference;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;
import org.eclipse.jdt.internal.compiler.ast.TypeReference;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleFieldDefaults.SCL.lombok */
@HandlerPriority(-2048)
public class HandleFieldDefaults extends EclipseASTAdapter {
    private static final char[] FIELD_DEFAULTS = "FieldDefaults".toCharArray();

    public boolean generateFieldDefaultsForType(EclipseNode typeNode, EclipseNode pos, AccessLevel level, boolean makeFinal, boolean checkForTypeLevelFieldDefaults) {
        if (checkForTypeLevelFieldDefaults && EclipseHandlerUtil.hasAnnotation((Class<? extends Annotation>) FieldDefaults.class, typeNode)) {
            return true;
        }
        TypeDeclaration typeDecl = typeNode.get() instanceof TypeDeclaration ? (TypeDeclaration) typeNode.get() : null;
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 8704) != 0;
        if (typeDecl == null || notAClass) {
            pos.addError("@FieldDefaults is only supported on a class or an enum.");
            return false;
        }
        for (EclipseNode field : typeNode.down()) {
            if (field.getKind() == AST$Kind.FIELD) {
                FieldDeclaration fieldDecl = field.get();
                if (EclipseHandlerUtil.filterField(fieldDecl, false)) {
                    Class<?> t = field.get().getClass();
                    if (t == FieldDeclaration.class) {
                        setFieldDefaultsForField(field, pos.get(), level, makeFinal);
                    }
                }
            }
        }
        return true;
    }

    public void setFieldDefaultsForField(EclipseNode fieldNode, ASTNode pos, AccessLevel level, boolean makeFinal) {
        FieldDeclaration field = fieldNode.get();
        if (level != null && level != AccessLevel.NONE && (field.modifiers & 7) == 0 && !EclipseHandlerUtil.hasAnnotation((Class<? extends Annotation>) PackagePrivate.class, fieldNode) && (field.modifiers & 8) == 0) {
            field.modifiers |= EclipseHandlerUtil.toEclipseModifier(level);
        }
        if (makeFinal && (field.modifiers & 16) == 0 && !EclipseHandlerUtil.hasAnnotation((Class<? extends Annotation>) NonFinal.class, fieldNode) && (field.modifiers & 8) == 0) {
            field.modifiers |= 16;
        }
        fieldNode.rebuild();
    }

    /* JADX WARN: Code duplicated, block: B:76:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x00fa A[SYNTHETIC] */
    @Override // lombok.eclipse.EclipseASTAdapter, lombok.eclipse.EclipseASTVisitor
    public void visitType(EclipseNode typeNode, TypeDeclaration type) {
        AnnotationValues<FieldDefaults> fieldDefaults = null;
        EclipseNode source = typeNode;
        boolean levelIsExplicit = false;
        boolean makeFinalIsExplicit = false;
        FieldDefaults fd = null;
        for (EclipseNode jn : typeNode.down()) {
            if (jn.getKind() == AST$Kind.ANNOTATION) {
                org.eclipse.jdt.internal.compiler.ast.Annotation ann = jn.get();
                QualifiedTypeReference qualifiedTypeReference = ann.type;
                if (qualifiedTypeReference == null) {
                    continue;
                } else if (qualifiedTypeReference instanceof SingleTypeReference) {
                    char[] t = ((SingleTypeReference) qualifiedTypeReference).token;
                    if (Arrays.equals(t, FIELD_DEFAULTS)) {
                        if (!EclipseHandlerUtil.typeMatches((Class<?>) FieldDefaults.class, jn, (TypeReference) qualifiedTypeReference)) {
                            source = jn;
                            fieldDefaults = EclipseHandlerUtil.createAnnotation(FieldDefaults.class, jn);
                            levelIsExplicit = fieldDefaults.isExplicit("level");
                            makeFinalIsExplicit = fieldDefaults.isExplicit("makeFinal");
                            HandlerUtil.handleExperimentalFlagUsage(jn, ConfigurationKeys.FIELD_DEFAULTS_FLAG_USAGE, "@FieldDefaults");
                            fd = (FieldDefaults) fieldDefaults.getInstance();
                            if (!levelIsExplicit && !makeFinalIsExplicit) {
                                jn.addError("This does nothing; provide either level or makeFinal or both.");
                            }
                            if (!levelIsExplicit && fd.level() == AccessLevel.NONE) {
                                jn.addError("AccessLevel.NONE doesn't mean anything here. Pick another value.");
                                levelIsExplicit = false;
                                break;
                            } else {
                                break;
                                break;
                            }
                        }
                    } else {
                        continue;
                    }
                } else if (qualifiedTypeReference instanceof QualifiedTypeReference) {
                    char[][] t2 = qualifiedTypeReference.tokens;
                    if (Eclipse.nameEquals(t2, "lombok.experimental.FieldDefaults")) {
                        if (!EclipseHandlerUtil.typeMatches((Class<?>) FieldDefaults.class, jn, (TypeReference) qualifiedTypeReference)) {
                            source = jn;
                            fieldDefaults = EclipseHandlerUtil.createAnnotation(FieldDefaults.class, jn);
                            levelIsExplicit = fieldDefaults.isExplicit("level");
                            makeFinalIsExplicit = fieldDefaults.isExplicit("makeFinal");
                            HandlerUtil.handleExperimentalFlagUsage(jn, ConfigurationKeys.FIELD_DEFAULTS_FLAG_USAGE, "@FieldDefaults");
                            fd = (FieldDefaults) fieldDefaults.getInstance();
                            if (!levelIsExplicit) {
                                jn.addError("This does nothing; provide either level or makeFinal or both.");
                            }
                            if (!levelIsExplicit) {
                                break;
                            }
                            jn.addError("AccessLevel.NONE doesn't mean anything here. Pick another value.");
                            levelIsExplicit = false;
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        if (fd != null || (type.modifiers & 8704) == 0) {
            boolean defaultToPrivate = levelIsExplicit ? false : Boolean.TRUE.equals(typeNode.getAst().readConfiguration(ConfigurationKeys.FIELD_DEFAULTS_PRIVATE_EVERYWHERE));
            boolean defaultToFinal = makeFinalIsExplicit ? false : Boolean.TRUE.equals(typeNode.getAst().readConfiguration(ConfigurationKeys.FIELD_DEFAULTS_FINAL_EVERYWHERE));
            if (defaultToPrivate || defaultToFinal || fieldDefaults != null) {
                AccessLevel fdAccessLevel = (fieldDefaults == null || !levelIsExplicit) ? defaultToPrivate ? AccessLevel.PRIVATE : null : fd.level();
                boolean fdToFinal = (fieldDefaults == null || !makeFinalIsExplicit) ? defaultToFinal : fd.makeFinal();
                generateFieldDefaultsForType(typeNode, source, fdAccessLevel, fdToFinal, false);
            }
        }
    }
}
