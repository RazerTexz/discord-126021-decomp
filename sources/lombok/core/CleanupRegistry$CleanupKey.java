package lombok.core;

/* JADX INFO: loaded from: app.apk:lombok/core/CleanupRegistry$CleanupKey.SCL.lombok */
final class CleanupRegistry$CleanupKey {
    private final String key;
    private final Object target;

    CleanupRegistry$CleanupKey(String key, Object target) {
        this.key = key;
        this.target = target;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof CleanupRegistry$CleanupKey)) {
            return false;
        }
        CleanupRegistry$CleanupKey o = (CleanupRegistry$CleanupKey) other;
        return this.key.equals(o.key) && this.target == o.target;
    }

    public int hashCode() {
        return (109 * System.identityHashCode(this.target)) + this.key.hashCode();
    }
}
