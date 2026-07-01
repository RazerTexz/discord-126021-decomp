package b.a.a.a;

import android.os.Bundle;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$e extends o implements Function0<Long> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$e(a aVar) {
        super(0);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Long invoke() {
        Bundle arguments = this.this$0.getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
        Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
        return Long.valueOf(lValueOf.longValue());
    }
}
