package defpackage;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.rtcconnection.audio.DiscordAudioManager$AudioDevice;
import com.discord.stores.StoreMediaSettings$SelfMuteFailure;
import com.discord.stores.StoreStream;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.DiscordOverlayService$Companion;
import com.discord.views.OverlayMenuView;
import com.discord.views.OverlayMenuView$a;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class i implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public i(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i;
        int i2 = this.j;
        if (i2 == 0) {
            DiscordOverlayService$Companion discordOverlayService$Companion = DiscordOverlayService.Companion;
            Context context = ((OverlayMenuView) this.k).getContext();
            m.checkNotNullExpressionValue(context, "context");
            discordOverlayService$Companion.launchForVoiceChannelSelect(context);
            ((OverlayMenuView) this.k).getOnDismissRequested$app_productionGoogleRelease().invoke();
            return;
        }
        if (i2 == 1) {
            List<DiscordAudioManager$AudioDevice> audioDevices = ((OverlayMenuView$a) this.k).c.getAudioManagerState().getAudioDevices();
            if ((audioDevices instanceof Collection) && audioDevices.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = audioDevices.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((DiscordAudioManager$AudioDevice) it.next()).isAvailable && (i = i + 1) < 0) {
                        n.throwCountOverflow();
                    }
                }
            }
            if (i > 1) {
                StoreStream.Companion.getAudioManagerV2().toggleSpeakerOutput();
                return;
            } else {
                m.checkNotNullExpressionValue(view, "it");
                b.a.d.m.g(view.getContext(), 2131886903, 0, null, 12);
                return;
            }
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw null;
            }
            ((OverlayMenuView) this.k).getOnDismissRequested$app_productionGoogleRelease().invoke();
            StoreStream.Companion.getVoiceChannelSelected().clear();
            return;
        }
        if (((OverlayMenuView$a) this.k).c.isSuppressed()) {
            m.checkNotNullExpressionValue(view, "view");
            b.a.d.m.g(view.getContext(), 2131896118, 0, null, 12);
        } else {
            if (((OverlayMenuView$a) this.k).c.isMuted()) {
                m.checkNotNullExpressionValue(view, "view");
                b.a.d.m.g(view.getContext(), 2131895586, 0, null, 12);
                return;
            }
            StoreMediaSettings$SelfMuteFailure storeMediaSettings$SelfMuteFailure = StoreStream.Companion.getMediaSettings().toggleSelfMuted();
            if (storeMediaSettings$SelfMuteFailure == null || storeMediaSettings$SelfMuteFailure.ordinal() != 0) {
                return;
            }
            m.checkNotNullExpressionValue(view, "view");
            b.a.d.m.g(view.getContext(), 2131897019, 0, null, 12);
        }
    }
}
