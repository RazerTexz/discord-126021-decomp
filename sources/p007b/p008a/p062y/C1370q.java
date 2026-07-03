package p007b.p008a.p062y;

import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.views.OverlayMenuView;
import com.discord.widgets.voice.model.CallModel;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.q */
/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C1370q extends C12236k implements Function4<Long, Guild, CallModel, RtcConnection.Quality, OverlayMenuView.C7085a> {

    /* JADX INFO: renamed from: j */
    public static final C1370q f2065j = new C1370q();

    public C1370q() {
        super(4, OverlayMenuView.C7085a.class, "<init>", "<init>(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Lcom/discord/widgets/voice/model/CallModel;Lcom/discord/rtcconnection/RtcConnection$Quality;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public OverlayMenuView.C7085a invoke(Long l, Guild guild, CallModel callModel, RtcConnection.Quality quality) {
        RtcConnection.Quality quality2 = quality;
        C12238m.checkNotNullParameter(quality2, "p4");
        return new OverlayMenuView.C7085a(l, guild, callModel, quality2);
    }
}
