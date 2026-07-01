package lombok.core.configuration;

import lombok.core.LombokImmutableList;
import lombok.core.handlers.HandlerUtil;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/NullCheckExceptionType$2.SCL.lombok */
enum NullCheckExceptionType$2 extends NullCheckExceptionType {
    NullCheckExceptionType$2(String str, int i) {
        super(str, i, null);
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public String getExceptionType() {
        return HandlerUtil.DEFAULT_EXCEPTION_FOR_NON_NULL;
    }

    @Override // lombok.core.configuration.NullCheckExceptionType
    public LombokImmutableList<String> getMethod() {
        return null;
    }
}
