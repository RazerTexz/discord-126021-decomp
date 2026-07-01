package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/LogDeclaration$LogFactoryParameter.SCL.lombok */
public enum LogDeclaration$LogFactoryParameter {
    TYPE,
    NAME,
    TOPIC,
    NULL;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static LogDeclaration$LogFactoryParameter[] valuesCustom() {
        LogDeclaration$LogFactoryParameter[] logDeclaration$LogFactoryParameterArrValuesCustom = values();
        int length = logDeclaration$LogFactoryParameterArrValuesCustom.length;
        LogDeclaration$LogFactoryParameter[] logDeclaration$LogFactoryParameterArr = new LogDeclaration$LogFactoryParameter[length];
        System.arraycopy(logDeclaration$LogFactoryParameterArrValuesCustom, 0, logDeclaration$LogFactoryParameterArr, 0, length);
        return logDeclaration$LogFactoryParameterArr;
    }
}
