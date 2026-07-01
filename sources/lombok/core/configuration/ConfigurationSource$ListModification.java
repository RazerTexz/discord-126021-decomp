package lombok.core.configuration;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationSource$ListModification.SCL.lombok */
public final class ConfigurationSource$ListModification {
    private final Object value;
    private final boolean added;

    public ConfigurationSource$ListModification(Object value, boolean added) {
        this.value = value;
        this.added = added;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isAdded() {
        return this.added;
    }
}
