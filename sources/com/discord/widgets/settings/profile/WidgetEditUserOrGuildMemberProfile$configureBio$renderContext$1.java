package com.discord.widgets.settings.profile;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1 extends FunctionReferenceImpl implements Function1<SpoilerNode<?>, Unit> {
    public WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1(EditUserOrGuildMemberProfileViewModel2 editUserOrGuildMemberProfileViewModel2) {
        super(1, editUserOrGuildMemberProfileViewModel2, EditUserOrGuildMemberProfileViewModel2.class, "handleBioIndexClicked", "handleBioIndexClicked(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        Intrinsics3.checkNotNullParameter(spoilerNode, "p1");
        ((EditUserOrGuildMemberProfileViewModel2) this.receiver).handleBioIndexClicked(spoilerNode);
    }
}
