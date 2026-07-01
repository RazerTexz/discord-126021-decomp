package com.discord.widgets.servers;

import com.discord.restapi.RestAPIParams$GuildMember;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$setupRoles$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetServerSettingsEditMember$Model $data;
    public final /* synthetic */ WidgetServerSettingsEditMember this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditMember$setupRoles$1(WidgetServerSettingsEditMember widgetServerSettingsEditMember, WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model) {
        super(1);
        this.this$0 = widgetServerSettingsEditMember;
        this.$data = widgetServerSettingsEditMember$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetServerSettingsEditMember.access$getBinding$p(this.this$0).e.clearFocus();
        ArrayList arrayList = new ArrayList();
        if (this.$data.getUserRoles().contains(Long.valueOf(j))) {
            Iterator<Long> it = this.$data.getUserRoles().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                if (jLongValue != j) {
                    arrayList.add(Long.valueOf(jLongValue));
                }
            }
        } else {
            arrayList.addAll(this.$data.getUserRoles());
            arrayList.add(Long.valueOf(j));
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().changeGuildMember(this.$data.getGuild().getId(), this.$data.getUser().getId(), RestAPIParams$GuildMember.Companion.createWithRoles(arrayList)), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetServerSettingsEditMember$setupRoles$1$1.INSTANCE, 60, (Object) null);
    }
}
