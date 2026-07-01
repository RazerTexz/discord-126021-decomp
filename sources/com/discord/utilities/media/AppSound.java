package com.discord.utilities.media;

import b.d.b.a.outline;
import com.discord.R;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppSound.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppSound {
    private static final AppSound SOUND_MUTE;
    private static final AppSound SOUND_STREAM_ENDED;
    private static final AppSound SOUND_STREAM_STARTED;
    private static final AppSound SOUND_STREAM_USER_JOINED;
    private static final AppSound SOUND_STREAM_USER_LEFT;
    private static final AppSound SOUND_UNMUTE;
    private final int contentType;
    private final int resId;
    private final boolean shouldLoop;
    private final int usage;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AppSound SOUND_DEAFEN = new AppSound(R.raw.deafen, false, 4, 13, 2, null);
    private static final AppSound SOUND_UNDEAFEN = new AppSound(R.raw.undeafen, false, 4, 13, 2, null);
    private static final AppSound SOUND_CALL_RINGING = new AppSound(R.raw.call_ringing, true, 4, 7);
    private static final AppSound SOUND_CALL_CALLING = new AppSound(R.raw.call_calling, true, 4, 3);
    private static final AppSound SOUND_RECONNECT = new AppSound(R.raw.reconnect, false, 4, 3, 2, null);
    private static final AppSound SOUND_USER_JOINED = new AppSound(R.raw.user_join, false, 4, 13, 2, null);
    private static final AppSound SOUND_USER_LEFT = new AppSound(R.raw.user_leave, false, 4, 13, 2, null);
    private static final AppSound SOUND_USER_MOVED = new AppSound(R.raw.user_moved, false, 4, 13, 2, null);

    /* JADX INFO: compiled from: AppSound.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AppSound getSOUND_CALL_CALLING() {
            return AppSound.SOUND_CALL_CALLING;
        }

        public final AppSound getSOUND_CALL_RINGING() {
            return AppSound.SOUND_CALL_RINGING;
        }

        public final AppSound getSOUND_DEAFEN() {
            return AppSound.SOUND_DEAFEN;
        }

        public final AppSound getSOUND_MUTE() {
            return AppSound.SOUND_MUTE;
        }

        public final AppSound getSOUND_RECONNECT() {
            return AppSound.SOUND_RECONNECT;
        }

        public final AppSound getSOUND_STREAM_ENDED() {
            return AppSound.SOUND_STREAM_ENDED;
        }

        public final AppSound getSOUND_STREAM_STARTED() {
            return AppSound.SOUND_STREAM_STARTED;
        }

        public final AppSound getSOUND_STREAM_USER_JOINED() {
            return AppSound.SOUND_STREAM_USER_JOINED;
        }

        public final AppSound getSOUND_STREAM_USER_LEFT() {
            return AppSound.SOUND_STREAM_USER_LEFT;
        }

        public final AppSound getSOUND_UNDEAFEN() {
            return AppSound.SOUND_UNDEAFEN;
        }

        public final AppSound getSOUND_UNMUTE() {
            return AppSound.SOUND_UNMUTE;
        }

        public final AppSound getSOUND_USER_JOINED() {
            return AppSound.SOUND_USER_JOINED;
        }

        public final AppSound getSOUND_USER_LEFT() {
            return AppSound.SOUND_USER_LEFT;
        }

        public final AppSound getSOUND_USER_MOVED() {
            return AppSound.SOUND_USER_MOVED;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        boolean z2 = false;
        int i = 4;
        int i2 = 13;
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        SOUND_MUTE = new AppSound(R.raw.mute, z2, i, i2, i3, defaultConstructorMarker);
        boolean z3 = false;
        int i4 = 4;
        int i5 = 13;
        int i6 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        SOUND_UNMUTE = new AppSound(R.raw.unmute, z3, i4, i5, i6, defaultConstructorMarker2);
        SOUND_STREAM_ENDED = new AppSound(R.raw.stream_ended, z2, i, i2, i3, defaultConstructorMarker);
        SOUND_STREAM_STARTED = new AppSound(R.raw.stream_started, z3, i4, i5, i6, defaultConstructorMarker2);
        SOUND_STREAM_USER_JOINED = new AppSound(R.raw.stream_user_joined, z2, i, i2, i3, defaultConstructorMarker);
        SOUND_STREAM_USER_LEFT = new AppSound(R.raw.stream_user_left, z3, i4, i5, i6, defaultConstructorMarker2);
    }

    public AppSound(int i, boolean z2, int i2, int i3) {
        this.resId = i;
        this.shouldLoop = z2;
        this.contentType = i2;
        this.usage = i3;
    }

    public static /* synthetic */ AppSound copy$default(AppSound appSound, int i, boolean z2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = appSound.resId;
        }
        if ((i4 & 2) != 0) {
            z2 = appSound.shouldLoop;
        }
        if ((i4 & 4) != 0) {
            i2 = appSound.contentType;
        }
        if ((i4 & 8) != 0) {
            i3 = appSound.usage;
        }
        return appSound.copy(i, z2, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShouldLoop() {
        return this.shouldLoop;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getUsage() {
        return this.usage;
    }

    public final AppSound copy(int resId, boolean shouldLoop, int contentType, int usage) {
        return new AppSound(resId, shouldLoop, contentType, usage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppSound)) {
            return false;
        }
        AppSound appSound = (AppSound) other;
        return this.resId == appSound.resId && this.shouldLoop == appSound.shouldLoop && this.contentType == appSound.contentType && this.usage == appSound.usage;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final int getResId() {
        return this.resId;
    }

    public final boolean getShouldLoop() {
        return this.shouldLoop;
    }

    public final int getUsage() {
        return this.usage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int i = this.resId * 31;
        boolean z2 = this.shouldLoop;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return ((((i + r1) * 31) + this.contentType) * 31) + this.usage;
    }

    public String toString() {
        StringBuilder sbU = outline.U("AppSound(resId=");
        sbU.append(this.resId);
        sbU.append(", shouldLoop=");
        sbU.append(this.shouldLoop);
        sbU.append(", contentType=");
        sbU.append(this.contentType);
        sbU.append(", usage=");
        return outline.B(sbU, this.usage, ")");
    }

    public /* synthetic */ AppSound(int i, boolean z2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? false : z2, i2, i3);
    }
}
