package com.discord.utilities.notices;

import android.view.View;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticeBuilders$requestRatingModalBuilder$1 extends o implements Function1<View, Unit> {
    public static final NoticeBuilders$requestRatingModalBuilder$1 INSTANCE = new NoticeBuilders$requestRatingModalBuilder$1();

    public NoticeBuilders$requestRatingModalBuilder$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        StoreStream.Companion.getReviewRequest().onReviewRequestShown();
    }
}
