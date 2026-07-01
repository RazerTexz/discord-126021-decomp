package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationSource$Result.SCL.lombok */
public final class ConfigurationSource$Result {
    private final Object value;
    private final boolean authoritative;

    public ConfigurationSource$Result(Object value, boolean authoritative) {
        this.value = value;
        this.authoritative = authoritative;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public String toString() {
        return String.valueOf(String.valueOf(this.value)) + (this.authoritative ? " (set)" : " (delta)");
    }
}
