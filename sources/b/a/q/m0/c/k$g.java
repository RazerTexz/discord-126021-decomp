package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import com.hammerandchisel.libdiscord.Discord$LocalVoiceLevelChangedCallback;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$g implements Discord$LocalVoiceLevelChangedCallback {
    public final /* synthetic */ Function1 a;

    public k$g(Function1 function1) {
        this.a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$LocalVoiceLevelChangedCallback
    public final void onLocalVoiceLevelChanged(float f, int i) {
        this.a.invoke(new MediaEngine$LocalVoiceStatus(f, (i & 1) != 0));
    }
}
