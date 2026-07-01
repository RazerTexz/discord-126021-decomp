package com.discord.widgets.mobile_reports;

import androidx.core.app.NotificationCompat;
import com.discord.api.report.MenuAPIResponse;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: MobileReportsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MobileReportsViewModel$1<T1, T2, R> implements Func2<MobileReportsViewModel$StoreState, MenuAPIResponse, Pair<? extends MobileReportsViewModel$StoreState, ? extends MenuAPIResponse>> {
    public static final MobileReportsViewModel$1 INSTANCE = new MobileReportsViewModel$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends MobileReportsViewModel$StoreState, ? extends MenuAPIResponse> call(MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState, MenuAPIResponse menuAPIResponse) {
        return call2(mobileReportsViewModel$StoreState, menuAPIResponse);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<MobileReportsViewModel$StoreState, MenuAPIResponse> call2(MobileReportsViewModel$StoreState mobileReportsViewModel$StoreState, MenuAPIResponse menuAPIResponse) {
        return o.to(mobileReportsViewModel$StoreState, menuAPIResponse);
    }
}
