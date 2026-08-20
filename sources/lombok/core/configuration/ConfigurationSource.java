package lombok.core.configuration;

import java.util.List;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/ConfigurationSource.SCL.lombok */
public interface ConfigurationSource {
    Result resolve(ConfigurationKey<?> configurationKey);

    List<ConfigurationFile> imports();

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/ConfigurationSource$Result.SCL.lombok */
    public static final class Result {
        private final Object value;
        private final boolean authoritative;

        public Result(Object value, boolean authoritative) {
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

    /* JADX INFO: loaded from: discord-126021.apk:lombok/core/configuration/ConfigurationSource$ListModification.SCL.lombok */
    public static final class ListModification {
        private final Object value;
        private final boolean added;

        public ListModification(Object value, boolean added) {
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
}
