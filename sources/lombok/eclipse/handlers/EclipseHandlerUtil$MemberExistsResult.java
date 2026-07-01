package lombok.eclipse.handlers;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/handlers/EclipseHandlerUtil$MemberExistsResult.SCL.lombok */
public enum EclipseHandlerUtil$MemberExistsResult {
    NOT_EXISTS,
    EXISTS_BY_LOMBOK,
    EXISTS_BY_USER;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EclipseHandlerUtil$MemberExistsResult[] valuesCustom() {
        EclipseHandlerUtil$MemberExistsResult[] eclipseHandlerUtil$MemberExistsResultArrValuesCustom = values();
        int length = eclipseHandlerUtil$MemberExistsResultArrValuesCustom.length;
        EclipseHandlerUtil$MemberExistsResult[] eclipseHandlerUtil$MemberExistsResultArr = new EclipseHandlerUtil$MemberExistsResult[length];
        System.arraycopy(eclipseHandlerUtil$MemberExistsResultArrValuesCustom, 0, eclipseHandlerUtil$MemberExistsResultArr, 0, length);
        return eclipseHandlerUtil$MemberExistsResultArr;
    }
}
