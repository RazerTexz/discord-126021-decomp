package com.discord.stores;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class LoadState {

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class JustLoadedAll extends LoadState {
        public static final JustLoadedAll INSTANCE = new JustLoadedAll();

        private JustLoadedAll() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class JustLoadedDown extends LoadState {
        public static final JustLoadedDown INSTANCE = new JustLoadedDown();

        private JustLoadedDown() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class JustLoadedUp extends LoadState {
        public static final JustLoadedUp INSTANCE = new JustLoadedUp();

        private JustLoadedUp() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class Loading extends LoadState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class LoadingDown extends LoadState {
        public static final LoadingDown INSTANCE = new LoadingDown();

        private LoadingDown() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class LoadingUp extends LoadState {
        public static final LoadingUp INSTANCE = new LoadingUp();

        private LoadingUp() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: StoreApplicationCommands.kt */
    public static final class None extends LoadState {
        public static final None INSTANCE = new None();

        private None() {
            super(null);
        }
    }

    private LoadState() {
    }

    public final boolean isLoading() {
        return (this instanceof Loading) || (this instanceof LoadingUp) || (this instanceof LoadingDown);
    }

    public /* synthetic */ LoadState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
