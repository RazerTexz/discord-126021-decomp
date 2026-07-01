package lombok.javac;

/* JADX INFO: loaded from: app.apk:lombok/javac/CompilerMessageSuppressor$Writers.SCL.lombok */
enum CompilerMessageSuppressor$Writers {
    ERROR("errWriter", "ERROR"),
    WARNING("warnWriter", "WARNING"),
    NOTICE("noticeWriter", "NOTICE");

    final String fieldName;
    final String keyName;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static CompilerMessageSuppressor$Writers[] valuesCustom() {
        CompilerMessageSuppressor$Writers[] compilerMessageSuppressor$WritersArrValuesCustom = values();
        int length = compilerMessageSuppressor$WritersArrValuesCustom.length;
        CompilerMessageSuppressor$Writers[] compilerMessageSuppressor$WritersArr = new CompilerMessageSuppressor$Writers[length];
        System.arraycopy(compilerMessageSuppressor$WritersArrValuesCustom, 0, compilerMessageSuppressor$WritersArr, 0, length);
        return compilerMessageSuppressor$WritersArr;
    }

    CompilerMessageSuppressor$Writers(String fieldName, String keyName) {
        this.fieldName = fieldName;
        this.keyName = keyName;
    }
}
