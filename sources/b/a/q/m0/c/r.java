package b.a.q.m0.c;

import androidx.annotation.NonNull;
import com.hammerandchisel.libdiscord.Discord$GetRankedRtcRegionsCallback;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Discord$GetRankedRtcRegionsCallback {
    public final /* synthetic */ Function1 a;

    public r(Function1 function1) {
        this.a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$GetRankedRtcRegionsCallback
    public final /* synthetic */ void onRankedRtcRegions(@NonNull String[] strArr) {
        d0.z.d.m.checkNotNullParameter(strArr, "p0");
        d0.z.d.m.checkNotNullExpressionValue(this.a.invoke(strArr), "invoke(...)");
    }
}
