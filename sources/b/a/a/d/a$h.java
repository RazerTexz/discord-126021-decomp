package b.a.a.d;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: UserActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$h extends o implements Function0<f> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$h(a aVar) {
        super(0);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public f invoke() {
        a aVar = this.this$0;
        KProperty[] kPropertyArr = a.j;
        return new f(aVar.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", 0L), this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L), null, null, 12);
    }
}
