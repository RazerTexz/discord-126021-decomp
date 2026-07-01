package com.discord.widgets.user.profile;

import android.graphics.Bitmap;
import com.discord.models.member.GuildMember;
import com.discord.utilities.colors.RepresentativeColorsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$updateViewState$1 extends o implements Function2<Bitmap, String, Unit> {
    public final /* synthetic */ UserProfileHeaderViewModel$ViewState$Loaded $viewState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderView$updateViewState$1(UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded) {
        super(2);
        this.$viewState = userProfileHeaderViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, String str) {
        invoke2(bitmap, str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap bitmap, String str) {
        m.checkNotNullParameter(bitmap, "bitmap");
        GuildMember guildMember = this.$viewState.getGuildMember();
        if (guildMember == null || !guildMember.hasAvatar()) {
            RepresentativeColorsKt.getUserRepresentativeColors().handleBitmap(this.$viewState.getAvatarColorId(), bitmap, str);
        } else {
            RepresentativeColorsKt.getGuildMemberRepresentativeColors().handleBitmap(this.$viewState.getGuildMemberColorId(), bitmap, str);
        }
    }
}
