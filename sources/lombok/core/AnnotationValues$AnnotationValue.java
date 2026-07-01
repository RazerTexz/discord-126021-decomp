package lombok.core;

import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/core/AnnotationValues$AnnotationValue.SCL.lombok */
public class AnnotationValues$AnnotationValue {
    public final List<String> raws;
    public final List<Object> valueGuesses;
    public final List<Object> expressions;
    private final LombokNode<?, ?, ?> node;
    private final boolean isExplicit;

    public AnnotationValues$AnnotationValue(LombokNode<?, ?, ?> node, List<String> raws, List<Object> expressions, List<Object> valueGuesses, boolean isExplicit) {
        this.node = node;
        this.raws = raws;
        this.expressions = expressions;
        this.valueGuesses = valueGuesses;
        this.isExplicit = isExplicit;
    }

    public void setError(String message, int valueIdx) {
        this.node.addError(message);
    }

    public void setWarning(String message, int valueIdx) {
        this.node.addError(message);
    }

    public String toString() {
        return "raws: " + this.raws + " valueGuesses: " + this.valueGuesses;
    }

    public boolean isExplicit() {
        return this.isExplicit;
    }
}
