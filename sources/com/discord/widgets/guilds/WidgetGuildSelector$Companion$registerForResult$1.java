package com.discord.widgets.guilds;

import android.os.Bundle;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$Companion$registerForResult$1 extends o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ boolean $allowNullGuild;
    public final /* synthetic */ Function2 $onGuildSelected;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildSelector$Companion$registerForResult$1(String str, boolean z2, Function2 function2) {
        super(2);
        this.$requestKey = str;
        this.$allowNullGuild = z2;
        this.$onGuildSelected = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        m.checkNotNullParameter(str, "resultRequestKey");
        m.checkNotNullParameter(bundle, "bundle");
        if (m.areEqual(this.$requestKey, str)) {
            String string = bundle.getString("INTENT_EXTRA_GUILD_NAME", "");
            long j = bundle.getLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L);
            if (j > 0 || this.$allowNullGuild) {
                Function2 function2 = this.$onGuildSelected;
                Long lValueOf = Long.valueOf(j);
                m.checkNotNullExpressionValue(string, "guildName");
                function2.invoke(lValueOf, string);
            }
        }
    }
}
