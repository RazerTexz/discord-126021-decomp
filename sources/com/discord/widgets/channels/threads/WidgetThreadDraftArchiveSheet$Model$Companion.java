package com.discord.widgets.channels.threads;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet$Model$Companion {
    private WidgetThreadDraftArchiveSheet$Model$Companion() {
    }

    public final Observable<WidgetThreadDraftArchiveSheet$Model> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getThreadDraft().observeDraftState(), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getChannelsSelected().observeSelectedChannel(), WidgetThreadDraftArchiveSheet$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…, guild, channel)\n      }");
        Observable<WidgetThreadDraftArchiveSheet$Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetThreadDraftArchiveSheet$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
