package com.discord.widgets.settings;

import com.discord.views.CheckedSetting;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$toggleConsent$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ CheckedSetting $toggle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$toggleConsent$1(CheckedSetting checkedSetting) {
        super(1);
        this.$toggle = checkedSetting;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        this.$toggle.setEnabled(true);
    }
}
