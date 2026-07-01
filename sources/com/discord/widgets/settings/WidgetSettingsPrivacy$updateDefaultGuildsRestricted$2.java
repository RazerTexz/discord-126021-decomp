package com.discord.widgets.settings;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$updateDefaultGuildsRestricted$2 extends o implements Function1<Set<? extends Long>, Unit> {
    public final /* synthetic */ boolean $defaultGuildsRestricted;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$updateDefaultGuildsRestricted$2(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2) {
        super(1);
        this.this$0 = widgetSettingsPrivacy;
        this.$defaultGuildsRestricted = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
        invoke2((Set<Long>) set);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<Long> set) {
        StoreStream.Companion.getUserSettings().setDefaultGuildsRestricted(this.this$0.getAppActivity(), this.$defaultGuildsRestricted, set);
    }
}
