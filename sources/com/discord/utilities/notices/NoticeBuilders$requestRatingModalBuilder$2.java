package com.discord.utilities.notices;

import android.content.Context;
import android.view.View;
import com.discord.stores.StoreStream;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticeBuilders$requestRatingModalBuilder$2 extends o implements Function1<View, Unit> {
    public static final NoticeBuilders$requestRatingModalBuilder$2 INSTANCE = new NoticeBuilders$requestRatingModalBuilder$2();

    public NoticeBuilders$requestRatingModalBuilder$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        StoreStream.Companion.getReviewRequest().onUserAcceptedRequest();
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        UriHandler.directToPlayStore$default(context, null, null, 6, null);
    }
}
