package lombok.javac.handlers;

import java.util.List;
import lombok.core.AnnotationValues$AnnotationValue;
import lombok.core.LombokNode;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$2.SCL.lombok */
class JavacHandlerUtil$2 extends AnnotationValues$AnnotationValue {
    private final /* synthetic */ JavacNode val$node;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JavacHandlerUtil$2(LombokNode lombokNode, List list, List list2, List list3, boolean $anonymous4, JavacNode javacNode) {
        super(lombokNode, list, list2, list3, $anonymous4);
        this.val$node = javacNode;
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setError(String message, int valueIdx) {
        this.val$node.addError(message);
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setWarning(String message, int valueIdx) {
        this.val$node.addWarning(message);
    }
}
