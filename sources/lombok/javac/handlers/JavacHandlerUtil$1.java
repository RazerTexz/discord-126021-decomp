package lombok.javac.handlers;

import com.sun.tools.javac.util.JCDiagnostic$DiagnosticPosition;
import java.util.List;
import lombok.core.AnnotationValues$AnnotationValue;
import lombok.core.LombokNode;
import lombok.javac.JavacNode;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$1.SCL.lombok */
class JavacHandlerUtil$1 extends AnnotationValues$AnnotationValue {
    private final /* synthetic */ JavacNode val$node;
    private final /* synthetic */ List val$positions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JavacHandlerUtil$1(LombokNode lombokNode, List list, List list2, List list3, boolean $anonymous4, JavacNode javacNode, List list4) {
        super(lombokNode, list, list2, list3, $anonymous4);
        this.val$node = javacNode;
        this.val$positions = list4;
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setError(String message, int valueIdx) {
        if (valueIdx >= 0) {
            this.val$node.addError(message, (JCDiagnostic$DiagnosticPosition) this.val$positions.get(valueIdx));
        } else {
            this.val$node.addError(message);
        }
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setWarning(String message, int valueIdx) {
        if (valueIdx >= 0) {
            this.val$node.addWarning(message, (JCDiagnostic$DiagnosticPosition) this.val$positions.get(valueIdx));
        } else {
            this.val$node.addWarning(message);
        }
    }
}
