package p007b.p008a.p062y;

import com.discord.views.VoiceUserView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.y.h0 */
/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1334h0 extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ VoiceUserView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1334h0(VoiceUserView voiceUserView) {
        super(0);
        this.this$0 = voiceUserView;
    }

    @Override // kotlin.jvm.functions.Function0
    public Boolean invoke() {
        VoiceUserView voiceUserView = this.this$0;
        return Boolean.valueOf(voiceUserView.displayVoiceState == VoiceUserView.EnumC7097a.RINGING && voiceUserView.animateAvatarWhenRinging);
    }
}
