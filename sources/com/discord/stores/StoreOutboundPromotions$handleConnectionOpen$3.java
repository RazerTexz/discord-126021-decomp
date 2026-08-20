package com.discord.stores;

import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$3 extends AbstractC12240o implements Function1<Error, Unit> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$3$1 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63171 extends AbstractC12240o implements Function0<Unit> {
        public C63171() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreOutboundPromotions$handleConnectionOpen$3.this.this$0.state = StoreOutboundPromotions.State.Failed.INSTANCE;
            StoreOutboundPromotions$handleConnectionOpen$3.this.this$0.markChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreOutboundPromotions$handleConnectionOpen$3(StoreOutboundPromotions storeOutboundPromotions) {
        super(1);
        this.this$0 = storeOutboundPromotions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        C12238m.checkNotNullParameter(error, "it");
        this.this$0.dispatcher.schedule(new C63171());
    }
}
