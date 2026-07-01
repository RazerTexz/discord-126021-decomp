package lombok.core.handlers;

/* JADX INFO: loaded from: app.apk:lombok/core/handlers/HandlerUtil$FieldAccess.SCL.lombok */
public enum HandlerUtil$FieldAccess {
    GETTER,
    PREFER_FIELD,
    ALWAYS_FIELD;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static HandlerUtil$FieldAccess[] valuesCustom() {
        HandlerUtil$FieldAccess[] handlerUtil$FieldAccessArrValuesCustom = values();
        int length = handlerUtil$FieldAccessArrValuesCustom.length;
        HandlerUtil$FieldAccess[] handlerUtil$FieldAccessArr = new HandlerUtil$FieldAccess[length];
        System.arraycopy(handlerUtil$FieldAccessArrValuesCustom, 0, handlerUtil$FieldAccessArr, 0, length);
        return handlerUtil$FieldAccessArr;
    }
}
