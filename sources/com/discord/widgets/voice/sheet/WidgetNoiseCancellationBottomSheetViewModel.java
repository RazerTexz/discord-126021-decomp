package com.discord.widgets.voice.sheet;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheetViewModel extends AbstractC0859d0<ViewState> {
    private final PublishSubject<Event> eventSubject;
    private final StoreMediaSettings mediaSettingsStore;

    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int toastResId;

            public ShowToast(@StringRes int i) {
                super(null);
                this.toastResId = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.toastResId;
                }
                return showToast.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getToastResId() {
                return this.toastResId;
            }

            public final ShowToast copy(@StringRes int toastResId) {
                return new ShowToast(toastResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.toastResId == ((ShowToast) other).toastResId;
                }
                return true;
            }

            public final int getToastResId() {
                return this.toastResId;
            }

            public int hashCode() {
                return this.toastResId;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("ShowToast(toastResId="), this.toastResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
    public static abstract class ViewState {
        private ViewState() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetNoiseCancellationBottomSheetViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ WidgetNoiseCancellationBottomSheetViewModel(StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onNoiseCancellationButtonPressed() {
        this.mediaSettingsStore.setVoiceConfiguration(StoreMediaSettings.NoiseProcessing.Cancellation);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(new Event.ShowToast(C5419R.string.noise_cancellation_on));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoiseCancellationBottomSheetViewModel(StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.mediaSettingsStore = storeMediaSettings;
        this.eventSubject = PublishSubject.m11133k0();
    }
}
