package com.discord.utilities.notices;

import android.view.View;
import b.d.b.a.a;
import d0.z.d.m;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NoticeBuilders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class NoticeBuilders$DialogData {
    private final CharSequence bodyText;
    private final CharSequence cancelText;
    private final Integer extraLayoutId;
    private final CharSequence headerText;
    private final Map<Integer, Function1<View, Unit>> listenerMap;
    private final CharSequence okText;

    /* JADX WARN: Multi-variable type inference failed */
    public NoticeBuilders$DialogData(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map<Integer, ? extends Function1<? super View, Unit>> map, Integer num) {
        m.checkNotNullParameter(charSequence, "headerText");
        m.checkNotNullParameter(charSequence2, "bodyText");
        this.headerText = charSequence;
        this.bodyText = charSequence2;
        this.okText = charSequence3;
        this.cancelText = charSequence4;
        this.listenerMap = map;
        this.extraLayoutId = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NoticeBuilders$DialogData copy$default(NoticeBuilders$DialogData noticeBuilders$DialogData, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = noticeBuilders$DialogData.headerText;
        }
        if ((i & 2) != 0) {
            charSequence2 = noticeBuilders$DialogData.bodyText;
        }
        CharSequence charSequence5 = charSequence2;
        if ((i & 4) != 0) {
            charSequence3 = noticeBuilders$DialogData.okText;
        }
        CharSequence charSequence6 = charSequence3;
        if ((i & 8) != 0) {
            charSequence4 = noticeBuilders$DialogData.cancelText;
        }
        CharSequence charSequence7 = charSequence4;
        if ((i & 16) != 0) {
            map = noticeBuilders$DialogData.listenerMap;
        }
        Map map2 = map;
        if ((i & 32) != 0) {
            num = noticeBuilders$DialogData.extraLayoutId;
        }
        return noticeBuilders$DialogData.copy(charSequence, charSequence5, charSequence6, charSequence7, map2, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getHeaderText() {
        return this.headerText;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CharSequence getBodyText() {
        return this.bodyText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final CharSequence getOkText() {
        return this.okText;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final CharSequence getCancelText() {
        return this.cancelText;
    }

    public final Map<Integer, Function1<View, Unit>> component5() {
        return this.listenerMap;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getExtraLayoutId() {
        return this.extraLayoutId;
    }

    public final NoticeBuilders$DialogData copy(CharSequence headerText, CharSequence bodyText, CharSequence okText, CharSequence cancelText, Map<Integer, ? extends Function1<? super View, Unit>> listenerMap, Integer extraLayoutId) {
        m.checkNotNullParameter(headerText, "headerText");
        m.checkNotNullParameter(bodyText, "bodyText");
        return new NoticeBuilders$DialogData(headerText, bodyText, okText, cancelText, listenerMap, extraLayoutId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NoticeBuilders$DialogData)) {
            return false;
        }
        NoticeBuilders$DialogData noticeBuilders$DialogData = (NoticeBuilders$DialogData) other;
        return m.areEqual(this.headerText, noticeBuilders$DialogData.headerText) && m.areEqual(this.bodyText, noticeBuilders$DialogData.bodyText) && m.areEqual(this.okText, noticeBuilders$DialogData.okText) && m.areEqual(this.cancelText, noticeBuilders$DialogData.cancelText) && m.areEqual(this.listenerMap, noticeBuilders$DialogData.listenerMap) && m.areEqual(this.extraLayoutId, noticeBuilders$DialogData.extraLayoutId);
    }

    public final CharSequence getBodyText() {
        return this.bodyText;
    }

    public final CharSequence getCancelText() {
        return this.cancelText;
    }

    public final Integer getExtraLayoutId() {
        return this.extraLayoutId;
    }

    public final CharSequence getHeaderText() {
        return this.headerText;
    }

    public final Map<Integer, Function1<View, Unit>> getListenerMap() {
        return this.listenerMap;
    }

    public final CharSequence getOkText() {
        return this.okText;
    }

    public int hashCode() {
        CharSequence charSequence = this.headerText;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.bodyText;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.okText;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.cancelText;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Map<Integer, Function1<View, Unit>> map = this.listenerMap;
        int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
        Integer num = this.extraLayoutId;
        return iHashCode5 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("DialogData(headerText=");
        sbU.append(this.headerText);
        sbU.append(", bodyText=");
        sbU.append(this.bodyText);
        sbU.append(", okText=");
        sbU.append(this.okText);
        sbU.append(", cancelText=");
        sbU.append(this.cancelText);
        sbU.append(", listenerMap=");
        sbU.append(this.listenerMap);
        sbU.append(", extraLayoutId=");
        return a.F(sbU, this.extraLayoutId, ")");
    }

    public /* synthetic */ NoticeBuilders$DialogData(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, charSequence2, (i & 4) != 0 ? null : charSequence3, (i & 8) != 0 ? null : charSequence4, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : num);
    }
}
