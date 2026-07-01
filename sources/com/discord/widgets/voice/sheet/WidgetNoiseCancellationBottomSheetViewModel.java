package com.discord.widgets.voice.sheet;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheetViewModel extends AppViewModel<ViewState> {
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
                return outline.B(outline.U("ShowToast(toastResId="), this.toastResId, ")");
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
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onNoiseCancellationButtonPressed() {
        this.mediaSettingsStore.setVoiceConfiguration(StoreMediaSettings.NoiseProcessing.Cancellation);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowToast(R.string.noise_cancellation_on));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoiseCancellationBottomSheetViewModel(StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.mediaSettingsStore = storeMediaSettings;
        this.eventSubject = PublishSubject.k0();
    }
}
