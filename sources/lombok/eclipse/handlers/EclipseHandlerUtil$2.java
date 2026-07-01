package lombok.eclipse.handlers;

import java.util.List;
import lombok.core.AnnotationValues$AnnotationValue;
import lombok.core.LombokNode;
import lombok.eclipse.EclipseNode;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$2.SCL.lombok */
class EclipseHandlerUtil$2 extends AnnotationValues$AnnotationValue {
    private final /* synthetic */ EclipseNode val$annotationNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EclipseHandlerUtil$2(LombokNode lombokNode, List list, List list2, List list3, boolean $anonymous4, EclipseNode eclipseNode) {
        super(lombokNode, list, list2, list3, $anonymous4);
        this.val$annotationNode = eclipseNode;
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setError(String message, int valueIdx) {
        this.val$annotationNode.addError(message);
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setWarning(String message, int valueIdx) {
        this.val$annotationNode.addWarning(message);
    }
}
