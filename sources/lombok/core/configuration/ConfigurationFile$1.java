package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationFile$1.SCL.lombok */
class ConfigurationFile$1 extends ThreadLocal<byte[]> {
    @Override // java.lang.ThreadLocal
    protected /* bridge */ /* synthetic */ byte[] initialValue() {
        return initialValue();
    }

    ConfigurationFile$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.ThreadLocal
    protected byte[] initialValue() {
        return new byte[65536];
    }
}
