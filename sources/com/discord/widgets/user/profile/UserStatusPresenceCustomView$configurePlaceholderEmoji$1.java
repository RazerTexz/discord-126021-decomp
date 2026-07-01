package com.discord.widgets.user.profile;

import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserStatusPresenceCustomView$configurePlaceholderEmoji$1 extends o implements Function1<ImageRequestBuilder, Unit> {
    public static final UserStatusPresenceCustomView$configurePlaceholderEmoji$1 INSTANCE = new UserStatusPresenceCustomView$configurePlaceholderEmoji$1();

    public UserStatusPresenceCustomView$configurePlaceholderEmoji$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
        invoke2(imageRequestBuilder);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
        m.checkNotNullParameter(imageRequestBuilder, "it");
        imageRequestBuilder.l = UserStatusPresenceCustomView.access$getCUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR$cp();
    }
}
