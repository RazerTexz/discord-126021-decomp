package com.discord.widgets.settings.profile;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1 extends Lambda implements Function1<String, Unit> {
    public static final WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1 INSTANCE = new WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1();

    public WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
    }
}
