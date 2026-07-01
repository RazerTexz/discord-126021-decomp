package b.a.d;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: b.a.d.g, reason: use source file name */
/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppLog2 extends Lambda implements Function3<Integer, String, Exception, Unit> {
    public final /* synthetic */ String $tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLog2(String str) {
        super(3);
        this.$tag = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public Unit invoke(Integer num, String str, Exception exc) {
        int iIntValue = num.intValue();
        String str2 = str;
        Exception exc2 = exc;
        Intrinsics3.checkNotNullParameter(str2, "message");
        if (iIntValue == 4) {
            AppLog.g.i(this.$tag + ' ' + str2, exc2);
        } else if (iIntValue == 5) {
            AppLog.g.w(this.$tag + ' ' + str2, exc2);
        } else if (iIntValue == 6 || iIntValue == 7) {
            Logger.e$default(AppLog.g, this.$tag + ' ' + str2, exc2, null, 4, null);
        }
        return Unit.a;
    }
}
