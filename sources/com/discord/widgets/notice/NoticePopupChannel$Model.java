package com.discord.widgets.notice;

import android.graphics.drawable.Drawable;
import android.view.View;
import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: NoticePopupChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NoticePopupChannel$Model {
    private final DraweeSpanStringBuilder noticeBody;
    private Drawable noticeBodyBackgroundDrawable;
    private Drawable noticeBodyImageDrawable;
    private String noticeBodyImageUrl;
    private final Drawable noticeIconTopRight;
    private final String noticeIconUrl;
    private final List<Sticker> noticeStickers;
    private final CharSequence noticeSubtitle;
    private final CharSequence noticeTitle;
    private final Function1<View, Unit> onClickTopRightIcon;

    /* JADX WARN: Multi-variable type inference failed */
    public NoticePopupChannel$Model(CharSequence charSequence, CharSequence charSequence2, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, Drawable drawable, String str2, Drawable drawable2, Drawable drawable3, Function1<? super View, Unit> function1, List<Sticker> list) {
        m.checkNotNullParameter(charSequence, "noticeTitle");
        m.checkNotNullParameter(draweeSpanStringBuilder, "noticeBody");
        m.checkNotNullParameter(function1, "onClickTopRightIcon");
        this.noticeTitle = charSequence;
        this.noticeSubtitle = charSequence2;
        this.noticeBody = draweeSpanStringBuilder;
        this.noticeIconUrl = str;
        this.noticeBodyBackgroundDrawable = drawable;
        this.noticeBodyImageUrl = str2;
        this.noticeBodyImageDrawable = drawable2;
        this.noticeIconTopRight = drawable3;
        this.onClickTopRightIcon = function1;
        this.noticeStickers = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NoticePopupChannel$Model copy$default(NoticePopupChannel$Model noticePopupChannel$Model, CharSequence charSequence, CharSequence charSequence2, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, Drawable drawable, String str2, Drawable drawable2, Drawable drawable3, Function1 function1, List list, int i, Object obj) {
        return noticePopupChannel$Model.copy((i & 1) != 0 ? noticePopupChannel$Model.noticeTitle : charSequence, (i & 2) != 0 ? noticePopupChannel$Model.noticeSubtitle : charSequence2, (i & 4) != 0 ? noticePopupChannel$Model.noticeBody : draweeSpanStringBuilder, (i & 8) != 0 ? noticePopupChannel$Model.noticeIconUrl : str, (i & 16) != 0 ? noticePopupChannel$Model.noticeBodyBackgroundDrawable : drawable, (i & 32) != 0 ? noticePopupChannel$Model.noticeBodyImageUrl : str2, (i & 64) != 0 ? noticePopupChannel$Model.noticeBodyImageDrawable : drawable2, (i & 128) != 0 ? noticePopupChannel$Model.noticeIconTopRight : drawable3, (i & 256) != 0 ? noticePopupChannel$Model.onClickTopRightIcon : function1, (i & 512) != 0 ? noticePopupChannel$Model.noticeStickers : list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getNoticeTitle() {
        return this.noticeTitle;
    }

    public final List<Sticker> component10() {
        return this.noticeStickers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getNoticeSubtitle() {
        return this.noticeSubtitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DraweeSpanStringBuilder getNoticeBody() {
        return this.noticeBody;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNoticeIconUrl() {
        return this.noticeIconUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Drawable getNoticeBodyBackgroundDrawable() {
        return this.noticeBodyBackgroundDrawable;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNoticeBodyImageUrl() {
        return this.noticeBodyImageUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Drawable getNoticeBodyImageDrawable() {
        return this.noticeBodyImageDrawable;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Drawable getNoticeIconTopRight() {
        return this.noticeIconTopRight;
    }

    public final Function1<View, Unit> component9() {
        return this.onClickTopRightIcon;
    }

    public final NoticePopupChannel$Model copy(CharSequence noticeTitle, CharSequence noticeSubtitle, DraweeSpanStringBuilder noticeBody, String noticeIconUrl, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, Drawable noticeIconTopRight, Function1<? super View, Unit> onClickTopRightIcon, List<Sticker> noticeStickers) {
        m.checkNotNullParameter(noticeTitle, "noticeTitle");
        m.checkNotNullParameter(noticeBody, "noticeBody");
        m.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
        return new NoticePopupChannel$Model(noticeTitle, noticeSubtitle, noticeBody, noticeIconUrl, noticeBodyBackgroundDrawable, noticeBodyImageUrl, noticeBodyImageDrawable, noticeIconTopRight, onClickTopRightIcon, noticeStickers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoticePopupChannel$Model)) {
            return false;
        }
        NoticePopupChannel$Model noticePopupChannel$Model = (NoticePopupChannel$Model) other;
        return m.areEqual(this.noticeTitle, noticePopupChannel$Model.noticeTitle) && m.areEqual(this.noticeSubtitle, noticePopupChannel$Model.noticeSubtitle) && m.areEqual(this.noticeBody, noticePopupChannel$Model.noticeBody) && m.areEqual(this.noticeIconUrl, noticePopupChannel$Model.noticeIconUrl) && m.areEqual(this.noticeBodyBackgroundDrawable, noticePopupChannel$Model.noticeBodyBackgroundDrawable) && m.areEqual(this.noticeBodyImageUrl, noticePopupChannel$Model.noticeBodyImageUrl) && m.areEqual(this.noticeBodyImageDrawable, noticePopupChannel$Model.noticeBodyImageDrawable) && m.areEqual(this.noticeIconTopRight, noticePopupChannel$Model.noticeIconTopRight) && m.areEqual(this.onClickTopRightIcon, noticePopupChannel$Model.onClickTopRightIcon) && m.areEqual(this.noticeStickers, noticePopupChannel$Model.noticeStickers);
    }

    public final DraweeSpanStringBuilder getNoticeBody() {
        return this.noticeBody;
    }

    public final Drawable getNoticeBodyBackgroundDrawable() {
        return this.noticeBodyBackgroundDrawable;
    }

    public final Drawable getNoticeBodyImageDrawable() {
        return this.noticeBodyImageDrawable;
    }

    public final String getNoticeBodyImageUrl() {
        return this.noticeBodyImageUrl;
    }

    public final Drawable getNoticeIconTopRight() {
        return this.noticeIconTopRight;
    }

    public final String getNoticeIconUrl() {
        return this.noticeIconUrl;
    }

    public final List<Sticker> getNoticeStickers() {
        return this.noticeStickers;
    }

    public final CharSequence getNoticeSubtitle() {
        return this.noticeSubtitle;
    }

    public final CharSequence getNoticeTitle() {
        return this.noticeTitle;
    }

    public final Function1<View, Unit> getOnClickTopRightIcon() {
        return this.onClickTopRightIcon;
    }

    public int hashCode() {
        CharSequence charSequence = this.noticeTitle;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.noticeSubtitle;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        DraweeSpanStringBuilder draweeSpanStringBuilder = this.noticeBody;
        int iHashCode3 = (iHashCode2 + (draweeSpanStringBuilder != null ? draweeSpanStringBuilder.hashCode() : 0)) * 31;
        String str = this.noticeIconUrl;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        Drawable drawable = this.noticeBodyBackgroundDrawable;
        int iHashCode5 = (iHashCode4 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        String str2 = this.noticeBodyImageUrl;
        int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.noticeBodyImageDrawable;
        int iHashCode7 = (iHashCode6 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Drawable drawable3 = this.noticeIconTopRight;
        int iHashCode8 = (iHashCode7 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31;
        Function1<View, Unit> function1 = this.onClickTopRightIcon;
        int iHashCode9 = (iHashCode8 + (function1 != null ? function1.hashCode() : 0)) * 31;
        List<Sticker> list = this.noticeStickers;
        return iHashCode9 + (list != null ? list.hashCode() : 0);
    }

    public final void setNoticeBodyBackgroundDrawable(Drawable drawable) {
        this.noticeBodyBackgroundDrawable = drawable;
    }

    public final void setNoticeBodyImageDrawable(Drawable drawable) {
        this.noticeBodyImageDrawable = drawable;
    }

    public final void setNoticeBodyImageUrl(String str) {
        this.noticeBodyImageUrl = str;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(noticeTitle=");
        sbU.append(this.noticeTitle);
        sbU.append(", noticeSubtitle=");
        sbU.append(this.noticeSubtitle);
        sbU.append(", noticeBody=");
        sbU.append((Object) this.noticeBody);
        sbU.append(", noticeIconUrl=");
        sbU.append(this.noticeIconUrl);
        sbU.append(", noticeBodyBackgroundDrawable=");
        sbU.append(this.noticeBodyBackgroundDrawable);
        sbU.append(", noticeBodyImageUrl=");
        sbU.append(this.noticeBodyImageUrl);
        sbU.append(", noticeBodyImageDrawable=");
        sbU.append(this.noticeBodyImageDrawable);
        sbU.append(", noticeIconTopRight=");
        sbU.append(this.noticeIconTopRight);
        sbU.append(", onClickTopRightIcon=");
        sbU.append(this.onClickTopRightIcon);
        sbU.append(", noticeStickers=");
        return a.L(sbU, this.noticeStickers, ")");
    }
}
