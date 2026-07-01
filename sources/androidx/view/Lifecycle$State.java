package androidx.view;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public enum Lifecycle$State {
    DESTROYED,
    INITIALIZED,
    CREATED,
    STARTED,
    RESUMED;

    public boolean isAtLeast(@NonNull Lifecycle$State lifecycle$State) {
        return compareTo(lifecycle$State) >= 0;
    }
}
