package b.a.y;

import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.views.OverlayMenuView$a;
import com.discord.widgets.voice.model.CallModel;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class q extends d0.z.d.k implements Function4<Long, Guild, CallModel, RtcConnection$Quality, OverlayMenuView$a> {
    public static final q j = new q();

    public q() {
        super(4, OverlayMenuView$a.class, "<init>", "<init>(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/rtcconnection/RtcConnection$Quality;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public OverlayMenuView$a invoke(Long l, Guild guild, CallModel callModel, RtcConnection$Quality rtcConnection$Quality) {
        RtcConnection$Quality rtcConnection$Quality2 = rtcConnection$Quality;
        d0.z.d.m.checkNotNullParameter(rtcConnection$Quality2, "p4");
        return new OverlayMenuView$a(l, guild, callModel, rtcConnection$Quality2);
    }
}
