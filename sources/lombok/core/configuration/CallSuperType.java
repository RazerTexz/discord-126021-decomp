package lombok.core.configuration;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/CallSuperType.SCL.lombok */
public enum CallSuperType {
    CALL,
    SKIP,
    WARN;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CallSuperType[] valuesCustom() {
        CallSuperType[] callSuperTypeArrValuesCustom = values();
        int length = callSuperTypeArrValuesCustom.length;
        CallSuperType[] callSuperTypeArr = new CallSuperType[length];
        System.arraycopy(callSuperTypeArrValuesCustom, 0, callSuperTypeArr, 0, length);
        return callSuperTypeArr;
    }
}
