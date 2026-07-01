package lombok.core;

/* JADX INFO: loaded from: app.apk:lombok/core/AST$Kind.SCL.lombok */
public enum AST$Kind {
    COMPILATION_UNIT,
    TYPE,
    FIELD,
    INITIALIZER,
    METHOD,
    ANNOTATION,
    ARGUMENT,
    LOCAL,
    STATEMENT,
    TYPE_USE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static AST$Kind[] valuesCustom() {
        AST$Kind[] aST$KindArrValuesCustom = values();
        int length = aST$KindArrValuesCustom.length;
        AST$Kind[] aST$KindArr = new AST$Kind[length];
        System.arraycopy(aST$KindArrValuesCustom, 0, aST$KindArr, 0, length);
        return aST$KindArr;
    }
}
