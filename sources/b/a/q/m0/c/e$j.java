package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$j extends d0.z.d.o implements Function1<Connection, Unit> {
    public final /* synthetic */ MediaEngineConnection$InputMode $inputMode;
    public final /* synthetic */ MediaEngineConnection$c $inputModeOptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$j(MediaEngineConnection$c mediaEngineConnection$c, MediaEngineConnection$InputMode mediaEngineConnection$InputMode) {
        super(1);
        this.$inputModeOptions = mediaEngineConnection$c;
        this.$inputMode = mediaEngineConnection$InputMode;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Connection connection) {
        Connection connection2 = connection;
        d0.z.d.m.checkNotNullParameter(connection2, "$receiver");
        connection2.setVADLeadingFramesToBuffer(this.$inputModeOptions.f2800b);
        connection2.setVADTrailingFramesToSend(this.$inputModeOptions.c);
        connection2.setVADTriggerThreshold(this.$inputModeOptions.a);
        connection2.setVADAutoThreshold(this.$inputModeOptions.d ? 3 : -1);
        connection2.setVADUseKrisp(this.$inputModeOptions.e);
        connection2.setAudioInputMode(this.$inputMode.getNumeral());
        connection2.enableForwardErrorCorrection(true);
        connection2.setExpectedPacketLossRate(0.3f);
        return Unit.a;
    }
}
