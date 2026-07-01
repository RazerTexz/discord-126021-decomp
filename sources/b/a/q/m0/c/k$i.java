package b.a.q.m0.c;

import com.discord.utilities.logging.Logger;
import org.webrtc.Logging$ExternalReporter;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$i implements Logging$ExternalReporter {
    public final /* synthetic */ k a;

    public k$i(k kVar) {
        this.a = kVar;
    }

    @Override // org.webrtc.Logging$ExternalReporter
    public final void e(String str, String str2, Throwable th) {
        Logger logger = this.a.n;
        d0.z.d.m.checkNotNullExpressionValue(str, "tag");
        d0.z.d.m.checkNotNullExpressionValue(str2, "message");
        Logger.e$default(logger, str, str2, th, null, 8, null);
    }
}
