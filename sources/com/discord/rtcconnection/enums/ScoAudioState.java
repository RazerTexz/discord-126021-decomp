package com.discord.rtcconnection.enums;

import android.content.Intent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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

        /* JADX INFO: renamed from: a */
        public final ScoAudioState m8498a(int i) {
            ScoAudioState[] scoAudioStateArrValues = ScoAudioState.values();
            for (int i2 = 0; i2 < 4; i2++) {
                ScoAudioState scoAudioState = scoAudioStateArrValues[i2];
                if (scoAudioState.getValue() == i) {
                    return scoAudioState;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: b */
        public final C5637b m8499b(Intent intent) {
            C12238m.checkNotNullParameter(intent, "intent");
            if (!C12238m.areEqual(intent.getAction(), "android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            ScoAudioState scoAudioStateM8498a = m8498a(intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0));
            C12238m.checkNotNull(scoAudioStateM8498a);
            ScoAudioState scoAudioStateM8498a2 = m8498a(intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", 0));
            C12238m.checkNotNull(scoAudioStateM8498a2);
            return new C5637b(scoAudioStateM8498a, scoAudioStateM8498a2);
        }
    }

    /* JADX INFO: renamed from: com.discord.rtcconnection.enums.ScoAudioState$b */
    /* JADX INFO: compiled from: ScoAudioState.kt */
    public static final class C5637b {

        /* JADX INFO: renamed from: a */
        public final ScoAudioState f18874a;

        /* JADX INFO: renamed from: b */
        public final ScoAudioState f18875b;

        public C5637b(ScoAudioState scoAudioState, ScoAudioState scoAudioState2) {
            C12238m.checkNotNullParameter(scoAudioState, "current");
            C12238m.checkNotNullParameter(scoAudioState2, "previous");
            this.f18874a = scoAudioState;
            this.f18875b = scoAudioState2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5637b)) {
                return false;
            }
            C5637b c5637b = (C5637b) obj;
            return C12238m.areEqual(this.f18874a, c5637b.f18874a) && C12238m.areEqual(this.f18875b, c5637b.f18875b);
        }

        public int hashCode() {
            ScoAudioState scoAudioState = this.f18874a;
            int iHashCode = (scoAudioState != null ? scoAudioState.hashCode() : 0) * 31;
            ScoAudioState scoAudioState2 = this.f18875b;
            return iHashCode + (scoAudioState2 != null ? scoAudioState2.hashCode() : 0);
        }

        public String toString() {
            if (this.f18875b == ScoAudioState.Error) {
                return String.valueOf(this.f18874a);
            }
            StringBuilder sbM833U = C1643a.m833U("Update(");
            sbM833U.append(this.f18875b);
            sbM833U.append(" -> ");
            sbM833U.append(this.f18874a);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    ScoAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
