package com.discord.widgets.user.profile;

import com.discord.models.member.GuildMember;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$ViewState$Loaded$guildMemberColorId$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel$ViewState$Loaded$guildMemberColorId$2(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        String avatarHash;
        GuildMember guildMember = this.this$0.getGuildMember();
        return (guildMember == null || (avatarHash = guildMember.getAvatarHash()) == null) ? this.this$0.getAvatarColorId() : avatarHash;
    }
}
