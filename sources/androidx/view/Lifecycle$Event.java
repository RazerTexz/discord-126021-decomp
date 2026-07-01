package androidx.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public enum Lifecycle$Event {
    ON_CREATE,
    ON_START,
    ON_RESUME,
    ON_PAUSE,
    ON_STOP,
    ON_DESTROY,
    ON_ANY;

    @Nullable
    public static Lifecycle$Event downFrom(@NonNull Lifecycle$State lifecycle$State) {
        int iOrdinal = lifecycle$State.ordinal();
        if (iOrdinal == 2) {
            return ON_DESTROY;
        }
        if (iOrdinal == 3) {
            return ON_STOP;
        }
        if (iOrdinal != 4) {
            return null;
        }
        return ON_PAUSE;
    }

    @Nullable
    public static Lifecycle$Event downTo(@NonNull Lifecycle$State lifecycle$State) {
        int iOrdinal = lifecycle$State.ordinal();
        if (iOrdinal == 0) {
            return ON_DESTROY;
        }
        if (iOrdinal == 2) {
            return ON_STOP;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return ON_PAUSE;
    }

    @Nullable
    public static Lifecycle$Event upFrom(@NonNull Lifecycle$State lifecycle$State) {
        int iOrdinal = lifecycle$State.ordinal();
        if (iOrdinal == 1) {
            return ON_CREATE;
        }
        if (iOrdinal == 2) {
            return ON_START;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return ON_RESUME;
    }

    @Nullable
    public static Lifecycle$Event upTo(@NonNull Lifecycle$State lifecycle$State) {
        int iOrdinal = lifecycle$State.ordinal();
        if (iOrdinal == 2) {
            return ON_CREATE;
        }
        if (iOrdinal == 3) {
            return ON_START;
        }
        if (iOrdinal != 4) {
            return null;
        }
        return ON_RESUME;
    }

    @NonNull
    public Lifecycle$State getTargetState() {
        int iOrdinal = ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    return Lifecycle$State.RESUMED;
                }
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            return Lifecycle$State.DESTROYED;
                        }
                        throw new IllegalArgumentException(this + " has no target state");
                    }
                }
            }
            return Lifecycle$State.STARTED;
        }
        return Lifecycle$State.CREATED;
    }
}
