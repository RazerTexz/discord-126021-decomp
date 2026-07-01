package com.discord.widgets.home;

import android.content.Context;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$configureFirstOpen$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$configureFirstOpen$2(WidgetHome widgetHome) {
        super(1);
        this.this$0 = widgetHome;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (!bool.booleanValue()) {
            StoreStream.Companion.getNux().updateNux(WidgetHome$configureFirstOpen$2$1.INSTANCE);
            return;
        }
        k kVar = new k(new WidgetHome$configureFirstOpen$2$2(this));
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Observable observableI = Observable.I(kVar.q(1000L, timeUnit), new k(WidgetHome$configureFirstOpen$2$3.INSTANCE).q(2000L, timeUnit));
        m.checkNotNullExpressionValue(observableI, "Observable\n             …, TimeUnit.MILLISECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableI, this.this$0, null, 2, null), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetHome$configureFirstOpen$2$4.INSTANCE, 62, (Object) null);
    }
}
