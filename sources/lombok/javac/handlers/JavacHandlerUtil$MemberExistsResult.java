package lombok.javac.handlers;

/* JADX INFO: loaded from: app.apk:lombok/javac/handlers/JavacHandlerUtil$MemberExistsResult.SCL.lombok */
public enum JavacHandlerUtil$MemberExistsResult {
    NOT_EXISTS,
    EXISTS_BY_LOMBOK,
    EXISTS_BY_USER;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static JavacHandlerUtil$MemberExistsResult[] valuesCustom() {
        JavacHandlerUtil$MemberExistsResult[] javacHandlerUtil$MemberExistsResultArrValuesCustom = values();
        int length = javacHandlerUtil$MemberExistsResultArrValuesCustom.length;
        JavacHandlerUtil$MemberExistsResult[] javacHandlerUtil$MemberExistsResultArr = new JavacHandlerUtil$MemberExistsResult[length];
        System.arraycopy(javacHandlerUtil$MemberExistsResultArrValuesCustom, 0, javacHandlerUtil$MemberExistsResultArr, 0, length);
        return javacHandlerUtil$MemberExistsResultArr;
    }
}
