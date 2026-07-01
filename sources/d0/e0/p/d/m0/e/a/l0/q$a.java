package d0.e0.p.d.m0.e.a.l0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f3351b;

    public q$a(q qVar, String str) {
        d0.z.d.m.checkNotNullParameter(qVar, "this$0");
        d0.z.d.m.checkNotNullParameter(str, "className");
        this.f3351b = qVar;
        this.a = str;
    }

    public final void function(String str, Function1<? super q$a$a, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(function1, "block");
        Map mapAccess$getSignatures$p = q.access$getSignatures$p(this.f3351b);
        q$a$a q_a_a = new q$a$a(this, str);
        function1.invoke(q_a_a);
        Pair<String, k> pairBuild = q_a_a.build();
        mapAccess$getSignatures$p.put(pairBuild.getFirst(), pairBuild.getSecond());
    }

    public final String getClassName() {
        return this.a;
    }
}
