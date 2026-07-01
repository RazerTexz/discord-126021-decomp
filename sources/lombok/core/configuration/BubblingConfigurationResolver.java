package lombok.core.configuration;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import lombok.ConfigurationKeys;

/* JADX INFO: loaded from: app.apk:lombok/core/configuration/BubblingConfigurationResolver.SCL.lombok */
public class BubblingConfigurationResolver implements ConfigurationResolver {
    private final ConfigurationFile start;
    private final ConfigurationFileToSource fileMapper;

    public BubblingConfigurationResolver(ConfigurationFile start, ConfigurationFileToSource fileMapper) {
        this.start = start;
        this.fileMapper = fileMapper;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.util.ArrayList, java.util.List] */
    @Override // lombok.core.configuration.ConfigurationResolver
    public <T> T resolve(ConfigurationKey<T> configurationKey) {
        ConfigurationSource dVar;
        boolean zIsList = configurationKey.getType().isList();
        ArrayList<List> arrayList = null;
        boolean z2 = false;
        HashSet hashSet = new HashSet();
        loop0: for (ConfigurationFile configurationFileParent = this.start; !z2 && configurationFileParent != null; configurationFileParent = configurationFileParent.parent()) {
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.push(configurationFileParent);
            while (!arrayDeque.isEmpty()) {
                ConfigurationFile configurationFile = (ConfigurationFile) arrayDeque.pop();
                if (configurationFile != null && hashSet.add(configurationFile) && (dVar = this.fileMapper.parsed(configurationFile)) != null) {
                    Iterator<ConfigurationFile> it = dVar.imports().iterator();
                    while (it.hasNext()) {
                        arrayDeque.push(it.next());
                    }
                    ConfigurationSource$Result configurationSource$ResultResolve = dVar.resolve(ConfigurationKeys.STOP_BUBBLING);
                    z2 = z2 || (configurationSource$ResultResolve != null && Boolean.TRUE.equals(configurationSource$ResultResolve.getValue()));
                    ConfigurationSource$Result configurationSource$ResultResolve2 = dVar.resolve(configurationKey);
                    if (configurationSource$ResultResolve2 != null) {
                        if (zIsList) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add((List) configurationSource$ResultResolve2.getValue());
                        }
                        if (configurationSource$ResultResolve2.isAuthoritative()) {
                            if (zIsList) {
                                break loop0;
                            }
                            return (T) configurationSource$ResultResolve2.getValue();
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (!zIsList) {
            return null;
        }
        if (arrayList == null) {
            return (T) Collections.emptyList();
        }
        ?? r0 = (T) new ArrayList();
        Collections.reverse(arrayList);
        for (List<ConfigurationSource$ListModification> list : arrayList) {
            if (list != null) {
                for (ConfigurationSource$ListModification configurationSource$ListModification : list) {
                    r0.remove(configurationSource$ListModification.getValue());
                    if (configurationSource$ListModification.isAdded()) {
                        r0.add(configurationSource$ListModification.getValue());
                    }
                }
            }
        }
        return r0;
    }
}
