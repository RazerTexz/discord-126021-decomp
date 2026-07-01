package lombok.eclipse.handlers;

import java.util.Collections;
import lombok.AccessLevel;
import lombok.ConfigurationKeys;
import lombok.Data;
import lombok.core.AnnotationValues;
import lombok.core.handlers.HandlerUtil;
import lombok.eclipse.EclipseAnnotationHandler;
import lombok.eclipse.EclipseNode;
import lombok.eclipse.handlers.HandleConstructor;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.TypeDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleData.SCL.lombok */
public class HandleData extends EclipseAnnotationHandler<Data> {
    private HandleGetter handleGetter = new HandleGetter();
    private HandleSetter handleSetter = new HandleSetter();
    private HandleEqualsAndHashCode handleEqualsAndHashCode = new HandleEqualsAndHashCode();
    private HandleToString handleToString = new HandleToString();
    private HandleConstructor handleConstructor = new HandleConstructor();

    @Override // lombok.eclipse.EclipseAnnotationHandler
    public void handle(AnnotationValues<Data> annotation, Annotation ast, EclipseNode annotationNode) {
        HandlerUtil.handleFlagUsage(annotationNode, ConfigurationKeys.DATA_FLAG_USAGE, "@Data");
        Data ann = annotation.getInstance();
        EclipseNode typeNode = annotationNode.up();
        TypeDeclaration typeDecl = null;
        if (typeNode.get() instanceof TypeDeclaration) {
            typeDecl = (TypeDeclaration) typeNode.get();
        }
        int modifiers = typeDecl == null ? 0 : typeDecl.modifiers;
        boolean notAClass = (modifiers & 25088) != 0;
        if (typeDecl == null || notAClass) {
            annotationNode.addError("@Data is only supported on a class.");
            return;
        }
        this.handleGetter.generateGetterForType(typeNode, annotationNode, AccessLevel.PUBLIC, true, Collections.emptyList());
        this.handleSetter.generateSetterForType(typeNode, annotationNode, AccessLevel.PUBLIC, true, Collections.emptyList(), Collections.emptyList());
        this.handleEqualsAndHashCode.generateEqualsAndHashCodeForType(typeNode, annotationNode);
        this.handleToString.generateToStringForType(typeNode, annotationNode);
        this.handleConstructor.generateRequiredArgsConstructor(typeNode, AccessLevel.PUBLIC, ann.staticConstructor(), HandleConstructor.SkipIfConstructorExists.YES, Collections.emptyList(), annotationNode);
        this.handleConstructor.generateExtraNoArgsConstructor(typeNode, annotationNode);
    }
}
