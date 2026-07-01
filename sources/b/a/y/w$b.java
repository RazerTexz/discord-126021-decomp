package b.a.y;

import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.icon.IconUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w$b extends d0.z.d.o implements Function1<StoreVoiceParticipants$VoiceUser, Unit> {
    public final /* synthetic */ w this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w$b(w wVar) {
        super(1);
        this.this$0 = wVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser2 = storeVoiceParticipants$VoiceUser;
        w wVar = this.this$0;
        int i = w.f315x;
        if (storeVoiceParticipants$VoiceUser2 == null) {
            wVar.h();
        } else {
            IconUtils.setIcon$default(wVar.getImageView$app_productionGoogleRelease(), storeVoiceParticipants$VoiceUser2.getUser(), 0, null, null, storeVoiceParticipants$VoiceUser2.getGuildMember(), 28, null);
            wVar.g();
        }
        return Unit.a;
    }
}
