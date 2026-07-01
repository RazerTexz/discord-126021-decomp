package com.discord.utilities.media;

import b.d.b.a.a;
import com.discord.R$raw;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AppSound.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AppSound {
    private final int contentType;
    private final int resId;
    private final boolean shouldLoop;
    private final int usage;
    public static final AppSound$Companion Companion = new AppSound$Companion(null);
    private static final AppSound SOUND_DEAFEN = new AppSound(R$raw.deafen, false, 4, 13, 2, null);
    private static final AppSound SOUND_UNDEAFEN = new AppSound(R$raw.undeafen, false, 4, 13, 2, null);
    private static final AppSound SOUND_MUTE = new AppSound(R$raw.mute, false, 4, 13, 2, null);
    private static final AppSound SOUND_UNMUTE = new AppSound(R$raw.unmute, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_ENDED = new AppSound(R$raw.stream_ended, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_STARTED = new AppSound(R$raw.stream_started, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_USER_JOINED = new AppSound(R$raw.stream_user_joined, false, 4, 13, 2, null);
    private static final AppSound SOUND_STREAM_USER_LEFT = new AppSound(R$raw.stream_user_left, false, 4, 13, 2, null);
    private static final AppSound SOUND_CALL_RINGING = new AppSound(R$raw.call_ringing, true, 4, 7);
    private static final AppSound SOUND_CALL_CALLING = new AppSound(R$raw.call_calling, true, 4, 3);
    private static final AppSound SOUND_RECONNECT = new AppSound(R$raw.reconnect, false, 4, 3, 2, null);
    private static final AppSound SOUND_USER_JOINED = new AppSound(R$raw.user_join, false, 4, 13, 2, null);
    private static final AppSound SOUND_USER_LEFT = new AppSound(R$raw.user_leave, false, 4, 13, 2, null);
    private static final AppSound SOUND_USER_MOVED = new AppSound(R$raw.user_moved, false, 4, 13, 2, null);

    public AppSound(int i, boolean z2, int i2, int i3) {
        this.resId = i;
        this.shouldLoop = z2;
        this.contentType = i2;
        this.usage = i3;
    }

    public static final /* synthetic */ AppSound access$getSOUND_CALL_CALLING$cp() {
        return SOUND_CALL_CALLING;
    }

    public static final /* synthetic */ AppSound access$getSOUND_CALL_RINGING$cp() {
        return SOUND_CALL_RINGING;
    }

    public static final /* synthetic */ AppSound access$getSOUND_DEAFEN$cp() {
        return SOUND_DEAFEN;
    }

    public static final /* synthetic */ AppSound access$getSOUND_MUTE$cp() {
        return SOUND_MUTE;
    }

    public static final /* synthetic */ AppSound access$getSOUND_RECONNECT$cp() {
        return SOUND_RECONNECT;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_ENDED$cp() {
        return SOUND_STREAM_ENDED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_STARTED$cp() {
        return SOUND_STREAM_STARTED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_USER_JOINED$cp() {
        return SOUND_STREAM_USER_JOINED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_STREAM_USER_LEFT$cp() {
        return SOUND_STREAM_USER_LEFT;
    }

    public static final /* synthetic */ AppSound access$getSOUND_UNDEAFEN$cp() {
        return SOUND_UNDEAFEN;
    }

    public static final /* synthetic */ AppSound access$getSOUND_UNMUTE$cp() {
        return SOUND_UNMUTE;
    }

    public static final /* synthetic */ AppSound access$getSOUND_USER_JOINED$cp() {
        return SOUND_USER_JOINED;
    }

    public static final /* synthetic */ AppSound access$getSOUND_USER_LEFT$cp() {
        return SOUND_USER_LEFT;
    }

    public static final /* synthetic */ AppSound access$getSOUND_USER_MOVED$cp() {
        return SOUND_USER_MOVED;
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
        StringBuilder sbU = a.U("AppSound(resId=");
        sbU.append(this.resId);
        sbU.append(", shouldLoop=");
        sbU.append(this.shouldLoop);
        sbU.append(", contentType=");
        sbU.append(this.contentType);
        sbU.append(", usage=");
        return a.B(sbU, this.usage, ")");
    }

    public /* synthetic */ AppSound(int i, boolean z2, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? false : z2, i2, i3);
    }
}
