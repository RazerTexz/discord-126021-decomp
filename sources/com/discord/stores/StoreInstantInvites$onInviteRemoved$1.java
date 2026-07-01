package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelInvite;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$onInviteRemoved$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ StoreInstantInvites this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$onInviteRemoved$1(StoreInstantInvites storeInstantInvites, ModelInvite modelInvite) {
        super(0);
        this.this$0 = storeInstantInvites;
        this.$invite = modelInvite;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map map;
        Guild guild = this.$invite.guild;
        Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
        String str = this.$invite.code;
        if (lValueOf == null || (map = (Map) StoreInstantInvites.access$getInvites$p(this.this$0).get(lValueOf)) == null || ((ModelInvite) map.remove(str)) == null) {
            return;
        }
        this.this$0.markChanged();
    }
}
