package lombok.core;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationValues$AnnotationValueDecodeFail.SCL.lombok */
public class AnnotationValues$AnnotationValueDecodeFail extends RuntimeException {
    private static final long serialVersionUID = 1;
    public final int idx;
    public final AnnotationValues$AnnotationValue owner;

    public AnnotationValues$AnnotationValueDecodeFail(AnnotationValues$AnnotationValue owner, String msg, int idx) {
        super(msg);
        this.idx = idx;
        this.owner = owner;
    }
}
