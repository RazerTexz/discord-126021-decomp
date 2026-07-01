package com.discord.widgets.notice;

import android.os.Build;
import android.os.Build$VERSION;
import com.discord.models.domain.ModelOAuth2Token;
import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink$onViewBound$1 extends o implements Function1<List<? extends ModelOAuth2Token>, Unit> {
    public final /* synthetic */ WidgetNoticeNuxSamsungLink this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoticeNuxSamsungLink$onViewBound$1(WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink) {
        super(1);
        this.this$0 = widgetNoticeNuxSamsungLink;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelOAuth2Token> list) {
        invoke2((List<ModelOAuth2Token>) list);
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelOAuth2Token> list) {
        boolean z2;
        m.checkNotNullExpressionValue(list, "authedApps");
        boolean z3 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                } else if (m.areEqual(String.valueOf(((ModelOAuth2Token) it.next()).getApplication().getId()), "591317049637339146")) {
                    if (Build$VERSION.SDK_INT >= 28 && t.equals(Build.MANUFACTURER, "samsung", true)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
            } while (!z2);
        } else {
            z3 = false;
            break;
        }
        if (z3) {
            this.this$0.dismiss();
        }
    }
}
