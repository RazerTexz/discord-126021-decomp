package lombok.core.configuration;

import lombok.core.LombokImmutableList;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/NullCheckExceptionType$5.SCL.lombok */
enum NullCheckExceptionType$5 extends NullCheckExceptionType {
    NullCheckExceptionType$5(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public String getExceptionType() {
        return null;
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public LombokImmutableList<String> getMethod() {
        return NullCheckExceptionType.access$4();
    }
}
