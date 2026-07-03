package p007b.p008a.p041q.p044m0.p045c;

import androidx.annotation.NonNull;
import com.hammerandchisel.libdiscord.Discord;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.r */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1240r implements Discord.GetRankedRtcRegionsCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Function1 f1754a;

    public C1240r(Function1 function1) {
        this.f1754a = function1;
    }

    @Override // com.hammerandchisel.libdiscord.Discord.GetRankedRtcRegionsCallback
    public final /* synthetic */ void onRankedRtcRegions(@NonNull String[] strArr) {
        C12238m.checkNotNullParameter(strArr, "p0");
        C12238m.checkNotNullExpressionValue(this.f1754a.invoke(strArr), "invoke(...)");
    }
}
