package lombok.installer;

/* JADX INFO: loaded from: app.apk:lombok/installer/OsUtils$OS.SCL.lombok */
public enum OsUtils$OS {
    MAC_OS_X("\n"),
    WINDOWS("\r\n"),
    UNIX("\n");

    private final String lineEnding;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static OsUtils$OS[] valuesCustom() {
        OsUtils$OS[] osUtils$OSArrValuesCustom = values();
        int length = osUtils$OSArrValuesCustom.length;
        OsUtils$OS[] osUtils$OSArr = new OsUtils$OS[length];
        System.arraycopy(osUtils$OSArrValuesCustom, 0, osUtils$OSArr, 0, length);
        return osUtils$OSArr;
    }

    OsUtils$OS(String lineEnding) {
        this.lineEnding = lineEnding;
    }

    public String getLineEnding() {
        return this.lineEnding;
    }
}
