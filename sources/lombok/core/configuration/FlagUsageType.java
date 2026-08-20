package lombok.core.configuration;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/FlagUsageType.SCL.lombok */
public enum FlagUsageType {
    WARNING,
    ERROR,
    ALLOW;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static FlagUsageType[] valuesCustom() {
        FlagUsageType[] flagUsageTypeArrValuesCustom = values();
        int length = flagUsageTypeArrValuesCustom.length;
        FlagUsageType[] flagUsageTypeArr = new FlagUsageType[length];
        System.arraycopy(flagUsageTypeArrValuesCustom, 0, flagUsageTypeArr, 0, length);
        return flagUsageTypeArr;
    }
}
