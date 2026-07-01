package com.discord.widgets.settings.profile;

import androidx.fragment.app.FragmentManager;
import b.a.a.b.c;
import b.a.a.b.c$b;
import com.discord.utilities.analytics.Traits$Location$Page;
import com.discord.utilities.icon.IconUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ SettingsUserProfileViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$1(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$viewState = settingsUserProfileViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "dataUrl");
        if (this.$viewState.getCanHaveAnimatedAvatars() || !IconUtils.INSTANCE.isDataUrlForGif(str)) {
            WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0).updateAvatar(str);
            return;
        }
        c$b c_b = c.k;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        c$b.a(c_b, parentFragmentManager, 4, this.this$0.getString(2131894485), null, Traits$Location$Page.USER_SETTINGS, "User Profile", null, null, false, false, 968);
    }
}
