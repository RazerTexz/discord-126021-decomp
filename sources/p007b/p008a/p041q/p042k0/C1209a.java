package p007b.p008a.p041q.p042k0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import androidx.annotation.MainThread;
import androidx.core.os.EnvironmentCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.enums.AudioManagerBroadcastAction;
import com.discord.rtcconnection.enums.ScoAudioState;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;
import org.webrtc.ThreadUtils;
import p007b.p008a.p041q.p043l0.AbstractC1219a;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.k0.a */
/* JADX INFO: compiled from: AudioManagerBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1209a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public static final a f1640a = new a(null);

    /* JADX INFO: renamed from: b */
    public final Context f1641b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1216h f1642c;

    /* JADX INFO: renamed from: b.a.q.k0.a$a */
    /* JADX INFO: compiled from: AudioManagerBroadcastReceiver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public C1209a(Context context, InterfaceC1216h interfaceC1216h) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(interfaceC1216h, "listener");
        this.f1641b = context;
        this.f1642c = interfaceC1216h;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        AbstractC1219a aVar;
        C12238m.checkNotNullParameter(context, "context");
        ThreadUtils.checkIsOnMainThread();
        if (intent == null) {
            return;
        }
        Objects.requireNonNull(AudioManagerBroadcastAction.INSTANCE);
        C12238m.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        AudioManagerBroadcastAction audioManagerBroadcastAction = null;
        if (action != null) {
            C12238m.checkNotNullParameter(action, "action");
            AudioManagerBroadcastAction[] audioManagerBroadcastActionArrValues = AudioManagerBroadcastAction.values();
            for (int i = 0; i < 5; i++) {
                AudioManagerBroadcastAction audioManagerBroadcastAction2 = audioManagerBroadcastActionArrValues[i];
                if (C12238m.areEqual(audioManagerBroadcastAction2.getAction(), action)) {
                    audioManagerBroadcastAction = audioManagerBroadcastAction2;
                    break;
                }
            }
        }
        if (audioManagerBroadcastAction == null) {
            StringBuilder sbM833U = C1643a.m833U("unable to parse AudioManagerBroadcastAction for action: ");
            sbM833U.append(intent.getAction());
            C1460d.m517f1("AudioManagerBroadcastReceiver", sbM833U.toString());
            return;
        }
        C1460d.m513e1("AudioManagerBroadcastReceiver", "onReceive: action = " + audioManagerBroadcastAction);
        try {
            InterfaceC1216h interfaceC1216h = this.f1642c;
            int iOrdinal = audioManagerBroadcastAction.ordinal();
            if (iOrdinal == 0) {
                interfaceC1216h.mo283c(context);
                return;
            }
            if (iOrdinal == 1) {
                C12238m.checkNotNullParameter(intent, "intent");
                if (!C12238m.areEqual(intent.getAction(), "android.intent.action.HEADSET_PLUG")) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (intent.getIntExtra("state", 0) == 1) {
                    String stringExtra = intent.getStringExtra(ModelAuditLogEntry.CHANGE_KEY_NAME);
                    if (stringExtra == null) {
                        stringExtra = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    C12238m.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(\"name\") ?: \"unknown\"");
                    aVar = new AbstractC1219a.a(stringExtra, intent.getIntExtra("microphone", 0) == 1);
                } else {
                    aVar = AbstractC1219a.b.f1669a;
                }
                interfaceC1216h.mo285e(context, aVar);
                return;
            }
            if (iOrdinal == 2) {
                interfaceC1216h.mo282b(context, ScoAudioState.INSTANCE.m8499b(intent));
                return;
            }
            if (iOrdinal == 3) {
                C12238m.checkNotNullParameter(context, "$this$isMicrophoneMute");
                C12238m.checkNotNullParameter(context, "$this$getAudioManager");
                Object systemService = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                interfaceC1216h.mo281a(context, ((AudioManager) systemService).isMicrophoneMute());
                return;
            }
            if (iOrdinal != 4) {
                return;
            }
            C12238m.checkNotNullParameter(context, "$this$isSpeakerphoneOn");
            C12238m.checkNotNullParameter(context, "$this$getAudioManager");
            Object systemService2 = context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.media.AudioManager");
            interfaceC1216h.mo284d(context, ((AudioManager) systemService2).isSpeakerphoneOn());
        } catch (Throwable th) {
            C1460d.m505c1("AudioManagerBroadcastReceiver", "error handling " + audioManagerBroadcastAction, th);
        }
    }
}
