package androidx.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle {

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public AtomicReference<Object> mInternalScopeRef = new AtomicReference<>();

    /* JADX INFO: renamed from: androidx.lifecycle.Lifecycle$1 */
    public static /* synthetic */ class C04371 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            Event.values();
            int[] iArr = new int[7];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            State.values();
            int[] iArr2 = new int[5];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = iArr2;
            try {
                iArr2[State.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[State.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[State.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[State.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        @Nullable
        public static Event downFrom(@NonNull State state) {
            int iOrdinal = state.ordinal();
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
        public static Event downTo(@NonNull State state) {
            int iOrdinal = state.ordinal();
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
        public static Event upFrom(@NonNull State state) {
            int iOrdinal = state.ordinal();
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
        public static Event upTo(@NonNull State state) {
            int iOrdinal = state.ordinal();
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
        public State getTargetState() {
            int iOrdinal = ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal == 2) {
                        return State.RESUMED;
                    }
                    if (iOrdinal != 3) {
                        if (iOrdinal != 4) {
                            if (iOrdinal == 5) {
                                return State.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return State.STARTED;
            }
            return State.CREATED;
        }
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }

    @MainThread
    public abstract void addObserver(@NonNull LifecycleObserver lifecycleObserver);

    @NonNull
    @MainThread
    public abstract State getCurrentState();

    @MainThread
    public abstract void removeObserver(@NonNull LifecycleObserver lifecycleObserver);
}
