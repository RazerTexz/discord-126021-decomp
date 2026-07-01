package com.discord.widgets.voice.sheet;

import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreMediaSettings$NoiseProcessing;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheetViewModel extends d0<WidgetNoiseCancellationBottomSheetViewModel$ViewState> {
    private final PublishSubject<WidgetNoiseCancellationBottomSheetViewModel$Event> eventSubject;
    private final StoreMediaSettings mediaSettingsStore;

    public WidgetNoiseCancellationBottomSheetViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetNoiseCancellationBottomSheetViewModel(StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getMediaSettings() : storeMediaSettings);
    }

    public final Observable<WidgetNoiseCancellationBottomSheetViewModel$Event> observeEvents() {
        PublishSubject<WidgetNoiseCancellationBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onNoiseCancellationButtonPressed() {
        this.mediaSettingsStore.setVoiceConfiguration(StoreMediaSettings$NoiseProcessing.Cancellation);
        PublishSubject<WidgetNoiseCancellationBottomSheetViewModel$Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast(2131893296));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoiseCancellationBottomSheetViewModel(StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.mediaSettingsStore = storeMediaSettings;
        this.eventSubject = PublishSubject.k0();
    }
}
