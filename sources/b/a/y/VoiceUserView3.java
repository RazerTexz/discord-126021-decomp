package b.a.y;

import com.discord.views.VoiceUserView;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.y.h0, reason: use source file name */
/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView3 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ VoiceUserView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUserView3(VoiceUserView voiceUserView) {
        super(0);
        this.this$0 = voiceUserView;
    }

    @Override // kotlin.jvm.functions.Function0
    public Boolean invoke() {
        VoiceUserView voiceUserView = this.this$0;
        return Boolean.valueOf(voiceUserView.displayVoiceState == VoiceUserView.a.RINGING && voiceUserView.animateAvatarWhenRinging);
    }
}
