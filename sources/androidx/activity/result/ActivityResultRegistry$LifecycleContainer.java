package androidx.activity.result;

import androidx.annotation.NonNull;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ActivityResultRegistry$LifecycleContainer {
    public final Lifecycle mLifecycle;
    private final ArrayList<LifecycleEventObserver> mObservers = new ArrayList<>();

    public ActivityResultRegistry$LifecycleContainer(@NonNull Lifecycle lifecycle) {
        this.mLifecycle = lifecycle;
    }

    public void addObserver(@NonNull LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle.addObserver(lifecycleEventObserver);
        this.mObservers.add(lifecycleEventObserver);
    }

    public void clearObservers() {
        Iterator<LifecycleEventObserver> it = this.mObservers.iterator();
        while (it.hasNext()) {
            this.mLifecycle.removeObserver(it.next());
        }
        this.mObservers.clear();
    }
}
