package com.discord.models.botuikit;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.PeerConnectionFactory;

/* JADX INFO: compiled from: ActionInteractionComponentState.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActionInteractionComponentState {

    /* JADX INFO: compiled from: ActionInteractionComponentState.kt */
    public static final class Disabled extends ActionInteractionComponentState {
        public static final Disabled INSTANCE = new Disabled();

        private Disabled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ActionInteractionComponentState.kt */
    public static final class Enabled extends ActionInteractionComponentState {
        public static final Enabled INSTANCE = new Enabled();

        private Enabled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: ActionInteractionComponentState.kt */
    public static final /* data */ class Failed extends ActionInteractionComponentState {
        private final String errorMessage;

        public Failed(String str) {
            super(null);
            this.errorMessage = str;
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.errorMessage;
            }
            return failed.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Failed copy(String errorMessage) {
            return new Failed(errorMessage);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Failed) && Intrinsics3.areEqual(this.errorMessage, ((Failed) other).errorMessage);
            }
            return true;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public int hashCode() {
            String str = this.errorMessage;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("Failed(errorMessage="), this.errorMessage, ")");
        }
    }

    /* JADX INFO: compiled from: ActionInteractionComponentState.kt */
    public static final class Loading extends ActionInteractionComponentState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    private ActionInteractionComponentState() {
    }

    public /* synthetic */ ActionInteractionComponentState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
