package defpackage;

import android.content.Context;
import android.view.View;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.views.OverlayMenuView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public i(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2 = this.j;
        if (i2 == 0) {
            DiscordOverlayService.Companion companion = DiscordOverlayService.INSTANCE;
            Context context = ((OverlayMenuView) this.k).getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            companion.launchForVoiceChannelSelect(context);
            ((OverlayMenuView) this.k).getOnDismissRequested$app_productionGoogleRelease().invoke();
            return;
        }
        if (i2 == 1) {
            List<DiscordAudioManager.AudioDevice> audioDevices = ((OverlayMenuView.a) this.k).c.getAudioManagerState().getAudioDevices();
            if ((audioDevices instanceof Collection) && audioDevices.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = audioDevices.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((DiscordAudioManager.AudioDevice) it.next()).isAvailable && (i = i + 1) < 0) {
                        Collections2.throwCountOverflow();
                    }
                }
            }
            if (i > 1) {
                StoreStream.INSTANCE.getAudioManagerV2().toggleSpeakerOutput();
                return;
            } else {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                AppToast.g(view.getContext(), R.string.audio_devices_toggle_unavailable, 0, null, 12);
                return;
            }
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw null;
            }
            ((OverlayMenuView) this.k).getOnDismissRequested$app_productionGoogleRelease().invoke();
            StoreStream.INSTANCE.getVoiceChannelSelected().clear();
            return;
        }
        if (((OverlayMenuView.a) this.k).c.isSuppressed()) {
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            AppToast.g(view.getContext(), R.string.suppressed_permission_body, 0, null, 12);
        } else {
            if (((OverlayMenuView.a) this.k).c.isMuted()) {
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                AppToast.g(view.getContext(), R.string.server_muted_dialog_body, 0, null, 12);
                return;
            }
            StoreMediaSettings.SelfMuteFailure selfMuteFailure = StoreStream.INSTANCE.getMediaSettings().toggleSelfMuted();
            if (selfMuteFailure == null || selfMuteFailure.ordinal() != 0) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            AppToast.g(view.getContext(), R.string.vad_permission_small, 0, null, 12);
        }
    }
}
