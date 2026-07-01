package lombok.core.configuration;

import lombok.core.LombokImmutableList;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/NullCheckExceptionType$1.SCL.lombok */
enum NullCheckExceptionType$1 extends NullCheckExceptionType {
    NullCheckExceptionType$1(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public String getExceptionType() {
        return "java.lang.IllegalArgumentException";
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public LombokImmutableList<String> getMethod() {
        return null;
    }
}
