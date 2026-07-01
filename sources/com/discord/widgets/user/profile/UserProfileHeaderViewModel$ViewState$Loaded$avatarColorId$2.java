package com.discord.widgets.user.profile;

import com.discord.utilities.colors.RepresentativeColorsKt;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$ViewState$Loaded$avatarColorId$2 extends o implements Function0<String> {
    public final /* synthetic */ UserProfileHeaderViewModel$ViewState$Loaded this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel$ViewState$Loaded$avatarColorId$2(UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded) {
        super(0);
        this.this$0 = userProfileHeaderViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return RepresentativeColorsKt.getColorId(this.this$0.getUser());
    }
}
