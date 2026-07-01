package com.discord.widgets.notice;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticePopupChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopupChannel$enqueue$2 extends o implements Function1<NoticePopupChannel$Model, Unit> {
    public final /* synthetic */ String $noticeName;
    public final /* synthetic */ Function1 $onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticePopupChannel$enqueue$2(String str, Function1 function1) {
        super(1);
        this.$noticeName = str;
        this.$onClick = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NoticePopupChannel$Model noticePopupChannel$Model) {
        invoke2(noticePopupChannel$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NoticePopupChannel$Model noticePopupChannel$Model) {
        if (noticePopupChannel$Model != null) {
            NoticePopup.enqueue$default(NoticePopup.INSTANCE, this.$noticeName, noticePopupChannel$Model.getNoticeTitle(), noticePopupChannel$Model.getNoticeSubtitle(), noticePopupChannel$Model.getNoticeBody(), noticePopupChannel$Model.getNoticeBodyBackgroundDrawable(), noticePopupChannel$Model.getNoticeBodyImageUrl(), noticePopupChannel$Model.getNoticeBodyImageDrawable(), noticePopupChannel$Model.getNoticeStickers(), noticePopupChannel$Model.getNoticeIconUrl(), null, noticePopupChannel$Model.getNoticeIconTopRight(), null, null, noticePopupChannel$Model.getOnClickTopRightIcon(), this.$onClick, 6656, null);
        }
    }
}
