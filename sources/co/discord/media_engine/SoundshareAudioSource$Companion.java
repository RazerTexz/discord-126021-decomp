package co.discord.media_engine;

import android.util.Log;
import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SoundshareAudioSource.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SoundshareAudioSource$Companion {
    private SoundshareAudioSource$Companion() {
    }

    public static final /* synthetic */ void access$assertTrue(SoundshareAudioSource$Companion soundshareAudioSource$Companion, boolean z2) {
        soundshareAudioSource$Companion.assertTrue(z2);
    }

    private final void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public final void setMicrophoneMute(boolean mute) {
        Log.w("SoundshareAudioSource", "setMicrophoneMute(" + mute + ')');
        SoundshareAudioSource.access$setMicrophoneMute$cp(mute);
    }

    public /* synthetic */ SoundshareAudioSource$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
