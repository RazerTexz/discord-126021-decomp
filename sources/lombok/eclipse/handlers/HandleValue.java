package lombok.eclipse.handlers;

import java.util.Collections;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Value;
import lombok.core.AnnotationValues;
import lombok.core.HandlerPriority;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.experimental.NonFinal;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleValue.SCL.lombok */
@HandlerPriority(-512)
public class HandleValue extends EclipseAnnotationHandler<Value> {
    private HandleFieldDefaults handleFieldDefaults = new HandleFieldDefaults();
    private HandleGetter handleGetter = new HandleGetter();
    private HandleEqualsAndHashCode handleEqualsAndHashCode = new HandleEqualsAndHashCode();
    private HandleToString handleToString = new HandleToString();
    private HandleConstructor handleConstructor = new HandleConstructor();

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Value> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.VALUE_FLAG_USAGE, "@Value");
        Value ann = annotation.getInstance();
        EclipseNode typeNode = annotationNode.up();
        TypeDeclaration typeDecl = null;
        if (typeNode.get() instanceof TypeDeclaration) {
            typeDecl = (TypeDeclaration) typeNode.get();
        }
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            annotationNode.addError("@Value is only supported on a class.");
            return;
        }
        if (!EclipseHandlerUtil.hasAnnotation((Class<? extends java.lang.annotation.Annotation>) NonFinal.class, typeNode) && (typeDecl.modifiers & 16) == 0) {
            typeDecl.modifiers |= 16;
            typeNode.rebuild();
        }
        this.handleFieldDefaults.generateFieldDefaultsForType(typeNode, annotationNode, AccessLevel.PRIVATE, true, true);
        this.handleGetter.generateGetterForType(typeNode, annotationNode, AccessLevel.PUBLIC, true, Collections.emptyList());
        this.handleEqualsAndHashCode.generateEqualsAndHashCodeForType(typeNode, annotationNode);
        this.handleToString.generateToStringForType(typeNode, annotationNode);
        this.handleConstructor.generateAllArgsConstructor(typeNode, AccessLevel.PUBLIC, ann.staticConstructor(), HandleConstructor$SkipIfConstructorExists.YES, Collections.emptyList(), annotationNode);
        this.handleConstructor.generateExtraNoArgsConstructor(typeNode, annotationNode);
    }
}
