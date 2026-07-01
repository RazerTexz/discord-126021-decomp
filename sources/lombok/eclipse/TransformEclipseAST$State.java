package lombok.eclipse;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/TransformEclipseAST$State.SCL.lombok */
enum TransformEclipseAST$State {
    DIET,
    FULL;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static TransformEclipseAST$State[] valuesCustom() {
        TransformEclipseAST$State[] transformEclipseAST$StateArrValuesCustom = values();
        int length = transformEclipseAST$StateArrValuesCustom.length;
        TransformEclipseAST$State[] transformEclipseAST$StateArr = new TransformEclipseAST$State[length];
        System.arraycopy(transformEclipseAST$StateArrValuesCustom, 0, transformEclipseAST$StateArr, 0, length);
        return transformEclipseAST$StateArr;
    }
}
