package lombok.eclipse.handlers;

import java.util.List;
import lombok.core.AnnotationValues$AnnotationValue;
import lombok.core.LombokNode;
import lombok.eclipse.EclipseNode;
import org.eclipse.jdt.internal.compiler.ast.Annotation;
import org.eclipse.jdt.internal.compiler.ast.Expression;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$1.SCL.lombok */
class EclipseHandlerUtil$1 extends AnnotationValues$AnnotationValue {
    private final /* synthetic */ Expression val$rhs;
    private final /* synthetic */ Expression[] val$exprs;
    private final /* synthetic */ Annotation val$annotation;
    private final /* synthetic */ EclipseNode val$annotationNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EclipseHandlerUtil$1(LombokNode lombokNode, List list, List list2, List list3, boolean $anonymous4, Expression expression, Expression[] expressionArr, Annotation annotation, EclipseNode eclipseNode) {
        super(lombokNode, list, list2, list3, $anonymous4);
        this.val$rhs = expression;
        this.val$exprs = expressionArr;
        this.val$annotation = annotation;
        this.val$annotationNode = eclipseNode;
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setError(String message, int valueIdx) {
        Expression ex;
        if (valueIdx == -1) {
            ex = this.val$rhs;
        } else {
            ex = this.val$exprs != null ? this.val$exprs[valueIdx] : null;
        }
        if (ex == null) {
            ex = this.val$annotation;
        }
        int sourceStart = ex.sourceStart;
        int sourceEnd = ex.sourceEnd;
        this.val$annotationNode.addError(message, sourceStart, sourceEnd);
    }

    @Override // lombok.core.AnnotationValues$AnnotationValue
    public void setWarning(String message, int valueIdx) {
        Expression ex;
        if (valueIdx == -1) {
            ex = this.val$rhs;
        } else {
            ex = this.val$exprs != null ? this.val$exprs[valueIdx] : null;
        }
        if (ex == null) {
            ex = this.val$annotation;
        }
        int sourceStart = ex.sourceStart;
        int sourceEnd = ex.sourceEnd;
        this.val$annotationNode.addWarning(message, sourceStart, sourceEnd);
    }
}
