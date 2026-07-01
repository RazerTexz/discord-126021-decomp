package com.discord.widgets.user.profile;

import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$configureBanner$1 extends o implements Function1<ImageRequestBuilder, Unit> {
    public final /* synthetic */ Ref$BooleanRef $bannerColorUpdatedFromViewState;
    public final /* synthetic */ UserProfileHeaderViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ UserProfileHeaderView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderView$configureBanner$1(UserProfileHeaderView userProfileHeaderView, Ref$BooleanRef ref$BooleanRef, UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = userProfileHeaderView;
        this.$bannerColorUpdatedFromViewState = ref$BooleanRef;
        this.$viewState = userProfileHeaderViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
        invoke2(imageRequestBuilder);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
        m.checkNotNullParameter(imageRequestBuilder, "imageRequestBuilder");
        imageRequestBuilder.l = new UserProfileHeaderView$configureBanner$1$1(this);
    }
}
