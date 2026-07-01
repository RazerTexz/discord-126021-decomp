package com.discord.stores;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppComponent;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$2 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ AppComponent $appComponent;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ StoreCalls$call$1 $doCall$1;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ Function0 $onError;
    public final /* synthetic */ StoreCalls this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCalls$call$2(StoreCalls storeCalls, long j, AppComponent appComponent, Context context, StoreCalls$call$1 storeCalls$call$1, Function0 function0, FragmentManager fragmentManager) {
        super(1);
        this.this$0 = storeCalls;
        this.$channelId = j;
        this.$appComponent = appComponent;
        this.$context = context;
        this.$doCall$1 = storeCalls$call$1;
        this.$onError = function0;
        this.$fragmentManager = fragmentManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        Observable<R> observableA = StoreStream.Companion.getUserRelationships().observe(j).A(new StoreCalls$call$2$1(this));
        m.checkNotNullExpressionValue(observableA, "StoreStream\n          .g…            }\n          }");
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), this.$appComponent, null, 2, null);
        Context context = this.$context;
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, this.this$0.getClass(), context, (Function1) null, new StoreCalls$call$2$3(this, j), (Function0) null, (Function0) null, new StoreCalls$call$2$2(this), 52, (Object) null);
    }
}
