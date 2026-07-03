package p007b.p008a.p018d;

import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.g */
/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0864g extends AbstractC12240o implements Function3<Integer, String, Exception, Unit> {
    public final /* synthetic */ String $tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0864g(String str) {
        super(3);
        this.$tag = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public Unit invoke(Integer num, String str, Exception exc) {
        int iIntValue = num.intValue();
        String str2 = str;
        Exception exc2 = exc;
        C12238m.checkNotNullParameter(str2, "message");
        if (iIntValue == 4) {
            AppLog.f14950g.mo8367i(this.$tag + ' ' + str2, exc2);
        } else if (iIntValue == 5) {
            AppLog.f14950g.mo8370w(this.$tag + ' ' + str2, exc2);
        } else if (iIntValue == 6 || iIntValue == 7) {
            Logger.e$default(AppLog.f14950g, this.$tag + ' ' + str2, exc2, null, 4, null);
        }
        return Unit.f27425a;
    }
}
