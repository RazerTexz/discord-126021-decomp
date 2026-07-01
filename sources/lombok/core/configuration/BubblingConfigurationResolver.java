package lombok.core.configuration;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import lombok.ConfigurationKeys;
import lombok.core.configuration.ConfigurationSource;

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
                    ConfigurationSource.Result resultResolve = dVar.resolve(ConfigurationKeys.STOP_BUBBLING);
                    z2 = z2 || (resultResolve != null && Boolean.TRUE.equals(resultResolve.getValue()));
                    ConfigurationSource.Result resultResolve2 = dVar.resolve(configurationKey);
                    if (resultResolve2 != null) {
                        if (zIsList) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add((List) resultResolve2.getValue());
                        }
                        if (resultResolve2.isAuthoritative()) {
                            if (zIsList) {
                                break loop0;
                            }
                            return (T) resultResolve2.getValue();
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
        for (List<ConfigurationSource.ListModification> list : arrayList) {
            if (list != null) {
                for (ConfigurationSource.ListModification listModification : list) {
                    r0.remove(listModification.getValue());
                    if (listModification.isAdded()) {
                        r0.add(listModification.getValue());
                    }
                }
            }
        }
        return r0;
    }
}
