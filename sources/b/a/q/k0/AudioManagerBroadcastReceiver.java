package b.a.q.k0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import androidx.annotation.MainThread;
import androidx.core.os.EnvironmentCompat;
import b.a.q.l0.WiredHeadsetState;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.enums.AudioManagerBroadcastAction;
import com.discord.rtcconnection.enums.ScoAudioState;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;

/* JADX INFO: renamed from: b.a.q.k0.a, reason: use source file name */
/* JADX INFO: compiled from: AudioManagerBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioManagerBroadcastReceiver extends BroadcastReceiver {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f261b;
    public final OnAudioManagerBroadcastListener c;

    /* JADX INFO: renamed from: b.a.q.k0.a$a */
    /* JADX INFO: compiled from: AudioManagerBroadcastReceiver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AudioManagerBroadcastReceiver(Context context, OnAudioManagerBroadcastListener onAudioManagerBroadcastListener) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onAudioManagerBroadcastListener, "listener");
        this.f261b = context;
        this.c = onAudioManagerBroadcastListener;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        WiredHeadsetState aVar;
        Intrinsics3.checkNotNullParameter(context, "context");
        ThreadUtils.checkIsOnMainThread();
        if (intent == null) {
            return;
        }
        Objects.requireNonNull(AudioManagerBroadcastAction.INSTANCE);
        Intrinsics3.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        AudioManagerBroadcastAction audioManagerBroadcastAction = null;
        if (action != null) {
            Intrinsics3.checkNotNullParameter(action, "action");
            AudioManagerBroadcastAction[] audioManagerBroadcastActionArrValues = AudioManagerBroadcastAction.values();
            for (int i = 0; i < 5; i++) {
                AudioManagerBroadcastAction audioManagerBroadcastAction2 = audioManagerBroadcastActionArrValues[i];
                if (Intrinsics3.areEqual(audioManagerBroadcastAction2.getAction(), action)) {
                    audioManagerBroadcastAction = audioManagerBroadcastAction2;
                    break;
                }
            }
        }
        if (audioManagerBroadcastAction == null) {
            StringBuilder sbU = outline.U("unable to parse AudioManagerBroadcastAction for action: ");
            sbU.append(intent.getAction());
            AnimatableValueParser.f1("AudioManagerBroadcastReceiver", sbU.toString());
            return;
        }
        AnimatableValueParser.e1("AudioManagerBroadcastReceiver", "onReceive: action = " + audioManagerBroadcastAction);
        try {
            OnAudioManagerBroadcastListener onAudioManagerBroadcastListener = this.c;
            int iOrdinal = audioManagerBroadcastAction.ordinal();
            if (iOrdinal == 0) {
                onAudioManagerBroadcastListener.c(context);
                return;
            }
            if (iOrdinal == 1) {
                Intrinsics3.checkNotNullParameter(intent, "intent");
                if (!Intrinsics3.areEqual(intent.getAction(), "android.intent.action.HEADSET_PLUG")) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (intent.getIntExtra("state", 0) == 1) {
                    String stringExtra = intent.getStringExtra(ModelAuditLogEntry.CHANGE_KEY_NAME);
                    if (stringExtra == null) {
                        stringExtra = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    Intrinsics3.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"name\") ?: \"unknown\"");
                    aVar = new WiredHeadsetState.a(stringExtra, intent.getIntExtra("microphone", 0) == 1);
                } else {
                    aVar = WiredHeadsetState.b.a;
                }
                onAudioManagerBroadcastListener.e(context, aVar);
                return;
            }
            if (iOrdinal == 2) {
                onAudioManagerBroadcastListener.b(context, ScoAudioState.INSTANCE.b(intent));
                return;
            }
            if (iOrdinal == 3) {
                Intrinsics3.checkNotNullParameter(context, "$this$isMicrophoneMute");
                Intrinsics3.checkNotNullParameter(context, "$this$getAudioManager");
                Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                onAudioManagerBroadcastListener.a(context, ((AudioManager) systemService).isMicrophoneMute());
                return;
            }
            if (iOrdinal != 4) {
                return;
            }
            Intrinsics3.checkNotNullParameter(context, "$this$isSpeakerphoneOn");
            Intrinsics3.checkNotNullParameter(context, "$this$getAudioManager");
            Object systemService2 = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
            onAudioManagerBroadcastListener.d(context, ((AudioManager) systemService2).isSpeakerphoneOn());
        } catch (Throwable th) {
            AnimatableValueParser.c1("AudioManagerBroadcastReceiver", "error handling " + audioManagerBroadcastAction, th);
        }
    }
}
