package b.a.y;

import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.views.OverlayMenuView;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: b.a.y.q, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class OverlayMenuView2 extends FunctionReferenceImpl implements Function4<Long, Guild, CallModel, RtcConnection.Quality, OverlayMenuView.a> {
    public static final OverlayMenuView2 j = new OverlayMenuView2();

    public OverlayMenuView2() {
        super(4, OverlayMenuView.a.class, "<init>", "<init>(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/rtcconnection/RtcConnection$Quality;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public OverlayMenuView.a invoke(Long l, Guild guild, CallModel callModel, RtcConnection.Quality quality) {
        RtcConnection.Quality quality2 = quality;
        Intrinsics3.checkNotNullParameter(quality2, "p4");
        return new OverlayMenuView.a(l, guild, callModel, quality2);
    }
}
