package lombok.core.configuration;

import lombok.core.LombokImmutableList;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/NullCheckExceptionType$4.SCL.lombok */
enum NullCheckExceptionType$4 extends NullCheckExceptionType {
    NullCheckExceptionType$4(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public String getExceptionType() {
        return null;
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public LombokImmutableList<String> getMethod() {
        return NullCheckExceptionType.access$3();
    }
}
