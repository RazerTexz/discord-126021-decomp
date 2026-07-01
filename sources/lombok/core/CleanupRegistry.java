package lombok.core;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: app.apk:lombok/core/CleanupRegistry.SCL.lombok */
public class CleanupRegistry {
    private final ConcurrentMap<CleanupRegistry$CleanupKey, CleanupTask> tasks = new ConcurrentHashMap();

    public void registerTask(String key, Object target, CleanupTask task) {
        CleanupRegistry$CleanupKey ck = new CleanupRegistry$CleanupKey(key, target);
        this.tasks.putIfAbsent(ck, task);
    }

    public void run() {
        for (CleanupTask task : this.tasks.values()) {
            task.cleanup();
        }
        this.tasks.clear();
    }
}
