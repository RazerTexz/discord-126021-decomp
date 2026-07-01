package com.discord.widgets.settings.profile;

import androidx.fragment.app.FragmentManager;
import b.a.y.b0;
import b.a.y.b0$a;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2 extends o implements Function0<Unit> {
    public final /* synthetic */ List $avatarSheetOptions;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, List list) {
        super(0);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$avatarSheetOptions = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b0$a b0_a = b0.k;
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        b0_a.a(childFragmentManager, "", this.$avatarSheetOptions, false, new WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2$1(this));
    }
}
