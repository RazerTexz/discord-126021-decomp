package p000;

import android.content.Context;
import android.view.View;
import com.discord.C5419R;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.views.OverlayMenuView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p007b.p008a.p018d.C0876m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: i */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC12497i implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f26474j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f26475k;

    public ViewOnClickListenerC12497i(int i, Object obj) {
        this.f26474j = i;
        this.f26475k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        int i2 = this.f26474j;
        if (i2 == 0) {
            DiscordOverlayService.Companion companion = DiscordOverlayService.INSTANCE;
            Context context = ((OverlayMenuView) this.f26475k).getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            companion.launchForVoiceChannelSelect(context);
            ((OverlayMenuView) this.f26475k).getOnDismissRequested$app_productionGoogleRelease().invoke();
            return;
        }
        if (i2 == 1) {
            List<DiscordAudioManager.AudioDevice> audioDevices = ((OverlayMenuView.C7085a) this.f26475k).f19104c.getAudioManagerState().getAudioDevices();
            if ((audioDevices instanceof Collection) && audioDevices.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = audioDevices.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((DiscordAudioManager.AudioDevice) it.next()).isAvailable && (i = i + 1) < 0) {
                        C12147n.throwCountOverflow();
                    }
                }
            }
            if (i > 1) {
                StoreStream.INSTANCE.getAudioManagerV2().toggleSpeakerOutput();
                return;
            } else {
                C12238m.checkNotNullExpressionValue(view, "it");
                C0876m.m169g(view.getContext(), C5419R.string.audio_devices_toggle_unavailable, 0, null, 12);
                return;
            }
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw null;
            }
            ((OverlayMenuView) this.f26475k).getOnDismissRequested$app_productionGoogleRelease().invoke();
            StoreStream.INSTANCE.getVoiceChannelSelected().clear();
            return;
        }
        if (((OverlayMenuView.C7085a) this.f26475k).f19104c.isSuppressed()) {
            C12238m.checkNotNullExpressionValue(view, "view");
            C0876m.m169g(view.getContext(), C5419R.string.suppressed_permission_body, 0, null, 12);
        } else {
            if (((OverlayMenuView.C7085a) this.f26475k).f19104c.isMuted()) {
                C12238m.checkNotNullExpressionValue(view, "view");
                C0876m.m169g(view.getContext(), C5419R.string.server_muted_dialog_body, 0, null, 12);
                return;
            }
            StoreMediaSettings.SelfMuteFailure selfMuteFailure = StoreStream.INSTANCE.getMediaSettings().toggleSelfMuted();
            if (selfMuteFailure == null || selfMuteFailure.ordinal() != 0) {
                return;
            }
            C12238m.checkNotNullExpressionValue(view, "view");
            C0876m.m169g(view.getContext(), C5419R.string.vad_permission_small, 0, null, 12);
        }
    }
}
