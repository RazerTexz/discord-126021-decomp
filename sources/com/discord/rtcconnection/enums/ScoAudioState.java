package com.discord.rtcconnection.enums;

import android.content.Intent;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ScoAudioState.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ScoAudioState {
    Disconnected(0),
    Connected(1),
    Connecting(2),
    Error(-1);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: renamed from: com.discord.rtcconnection.enums.ScoAudioState$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ScoAudioState.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ScoAudioState a(int i) {
            ScoAudioState[] scoAudioStateArrValues = ScoAudioState.values();
            for (int i2 = 0; i2 < 4; i2++) {
                ScoAudioState scoAudioState = scoAudioStateArrValues[i2];
                if (scoAudioState.getValue() == i) {
                    return scoAudioState;
                }
            }
            return null;
        }

        public final b b(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "intent");
            if (!Intrinsics3.areEqual(intent.getAction(), "android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            ScoAudioState scoAudioStateA = a(intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0));
            Intrinsics3.checkNotNull(scoAudioStateA);
            ScoAudioState scoAudioStateA2 = a(intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", 0));
            Intrinsics3.checkNotNull(scoAudioStateA2);
            return new b(scoAudioStateA, scoAudioStateA2);
        }
    }

    /* JADX INFO: compiled from: ScoAudioState.kt */
    public static final class b {
        public final ScoAudioState a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScoAudioState f2792b;

        public b(ScoAudioState scoAudioState, ScoAudioState scoAudioState2) {
            Intrinsics3.checkNotNullParameter(scoAudioState, "current");
            Intrinsics3.checkNotNullParameter(scoAudioState2, "previous");
            this.a = scoAudioState;
            this.f2792b = scoAudioState2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f2792b, bVar.f2792b);
        }

        public int hashCode() {
            ScoAudioState scoAudioState = this.a;
            int iHashCode = (scoAudioState != null ? scoAudioState.hashCode() : 0) * 31;
            ScoAudioState scoAudioState2 = this.f2792b;
            return iHashCode + (scoAudioState2 != null ? scoAudioState2.hashCode() : 0);
        }

        public String toString() {
            if (this.f2792b == ScoAudioState.Error) {
                return String.valueOf(this.a);
            }
            StringBuilder sbU = outline.U("Update(");
            sbU.append(this.f2792b);
            sbU.append(" -> ");
            sbU.append(this.a);
            sbU.append(')');
            return sbU.toString();
        }
    }

    ScoAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
