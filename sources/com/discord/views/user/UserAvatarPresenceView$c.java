package com.discord.views.user;

import b.a.y.s0.a;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceView$c extends o implements Function1<ImageRequestBuilder, Unit> {
    public final /* synthetic */ String $iconUrl;
    public final /* synthetic */ UserAvatarPresenceView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceView$c(UserAvatarPresenceView userAvatarPresenceView, String str) {
        super(1);
        this.this$0 = userAvatarPresenceView;
        this.$iconUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
        ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
        m.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
        imageRequestBuilder2.l = new a(this);
        return Unit.a;
    }
}
