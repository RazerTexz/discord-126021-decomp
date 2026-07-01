package lombok.core.configuration;

import java.net.URI;
import java.util.Comparator;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/ConfigurationApp$4.SCL.lombok */
class ConfigurationApp$4 implements Comparator<URI> {
    final /* synthetic */ ConfigurationApp this$0;

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(URI uri, URI uri2) {
        return compare2(uri, uri2);
    }

    ConfigurationApp$4(ConfigurationApp configurationApp) {
        this.this$0 = configurationApp;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(URI o1, URI o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
