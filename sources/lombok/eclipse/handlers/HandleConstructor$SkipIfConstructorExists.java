package lombok.eclipse.handlers;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/HandleConstructor$SkipIfConstructorExists.SCL.lombok */
public enum HandleConstructor$SkipIfConstructorExists {
    YES,
    NO,
    I_AM_BUILDER;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static HandleConstructor$SkipIfConstructorExists[] valuesCustom() {
        HandleConstructor$SkipIfConstructorExists[] handleConstructor$SkipIfConstructorExistsArrValuesCustom = values();
        int length = handleConstructor$SkipIfConstructorExistsArrValuesCustom.length;
        HandleConstructor$SkipIfConstructorExists[] handleConstructor$SkipIfConstructorExistsArr = new HandleConstructor$SkipIfConstructorExists[length];
        System.arraycopy(handleConstructor$SkipIfConstructorExistsArrValuesCustom, 0, handleConstructor$SkipIfConstructorExistsArr, 0, length);
        return handleConstructor$SkipIfConstructorExistsArr;
    }
}
