package com.discord.widgets.settings.profile;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1 extends k implements Function1<SpoilerNode<?>, Unit> {
    public WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        super(1, settingsUserProfileViewModel, SettingsUserProfileViewModel.class, "handleBioIndexClicked", "handleBioIndexClicked(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        m.checkNotNullParameter(spoilerNode, "p1");
        ((SettingsUserProfileViewModel) this.receiver).handleBioIndexClicked(spoilerNode);
    }
}
