package com.discord.widgets.chat.input.gifpicker;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/* JADX INFO: compiled from: GifPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifPickerViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifPickerViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: GifPickerViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            GifPickerViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GifPickerViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<ModelGifCategory> gifCategories;
        private final String trendingGifCategoryPreviewUrl;

        public StoreState(List<ModelGifCategory> list, String str) {
            Intrinsics3.checkNotNullParameter(list, "gifCategories");
            Intrinsics3.checkNotNullParameter(str, "trendingGifCategoryPreviewUrl");
            this.gifCategories = list;
            this.trendingGifCategoryPreviewUrl = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.gifCategories;
            }
            if ((i & 2) != 0) {
                str = storeState.trendingGifCategoryPreviewUrl;
            }
            return storeState.copy(list, str);
        }

        public final List<ModelGifCategory> component1() {
            return this.gifCategories;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTrendingGifCategoryPreviewUrl() {
            return this.trendingGifCategoryPreviewUrl;
        }

        public final StoreState copy(List<ModelGifCategory> gifCategories, String trendingGifCategoryPreviewUrl) {
            Intrinsics3.checkNotNullParameter(gifCategories, "gifCategories");
            Intrinsics3.checkNotNullParameter(trendingGifCategoryPreviewUrl, "trendingGifCategoryPreviewUrl");
            return new StoreState(gifCategories, trendingGifCategoryPreviewUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.gifCategories, storeState.gifCategories) && Intrinsics3.areEqual(this.trendingGifCategoryPreviewUrl, storeState.trendingGifCategoryPreviewUrl);
        }

        public final List<ModelGifCategory> getGifCategories() {
            return this.gifCategories;
        }

        public final String getTrendingGifCategoryPreviewUrl() {
            return this.trendingGifCategoryPreviewUrl;
        }

        public int hashCode() {
            List<ModelGifCategory> list = this.gifCategories;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            String str = this.trendingGifCategoryPreviewUrl;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(gifCategories=");
            sbU.append(this.gifCategories);
            sbU.append(", trendingGifCategoryPreviewUrl=");
            return outline.J(sbU, this.trendingGifCategoryPreviewUrl, ")");
        }
    }

    /* JADX INFO: compiled from: GifPickerViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<GifCategoryItem> gifCategoryItems;
        private final boolean isLoaded;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends GifCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "gifCategoryItems");
            this.gifCategoryItems = list;
            this.isLoaded = !list.isEmpty();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.gifCategoryItems;
            }
            return viewState.copy(list);
        }

        public final List<GifCategoryItem> component1() {
            return this.gifCategoryItems;
        }

        public final ViewState copy(List<? extends GifCategoryItem> gifCategoryItems) {
            Intrinsics3.checkNotNullParameter(gifCategoryItems, "gifCategoryItems");
            return new ViewState(gifCategoryItems);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ViewState) && Intrinsics3.areEqual(this.gifCategoryItems, ((ViewState) other).gifCategoryItems);
            }
            return true;
        }

        public final List<GifCategoryItem> getGifCategoryItems() {
            return this.gifCategoryItems;
        }

        public int hashCode() {
            List<GifCategoryItem> list = this.gifCategoryItems;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        /* JADX INFO: renamed from: isLoaded, reason: from getter */
        public final boolean getIsLoaded() {
            return this.isLoaded;
        }

        public String toString() {
            return outline.L(outline.U("ViewState(gifCategoryItems="), this.gifCategoryItems, ")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifPickerViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifPickerViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            observable = Observable.j(companion.getGifPicker().observeGifCategories(), companion.getGifPicker().observeTrendingGifCategoryPreviewUrl(), new Func2<List<? extends ModelGifCategory>, String, StoreState>() { // from class: com.discord.widgets.chat.input.gifpicker.GifPickerViewModel.1
                @Override // rx.functions.Func2
                public /* bridge */ /* synthetic */ StoreState call(List<? extends ModelGifCategory> list, String str) {
                    return call2((List<ModelGifCategory>) list, str);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final StoreState call2(List<ModelGifCategory> list, String str) {
                    Intrinsics3.checkNotNullExpressionValue(list, "gifCategories");
                    Intrinsics3.checkNotNullExpressionValue(str, "trendingGifCategoryPreviewUrl");
                    return new StoreState(list, str);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observable, "Observable.combineLatest…egoryPreviewUrl\n    )\n  }");
        }
        this(observable);
    }

    private final void handleStoreState(StoreState storeState) {
        ArrayList arrayList = new ArrayList();
        if (storeState.getTrendingGifCategoryPreviewUrl().length() > 0) {
            arrayList.add(new GifCategoryItem.Trending(storeState.getTrendingGifCategoryPreviewUrl()));
        }
        List<ModelGifCategory> gifCategories = storeState.getGifCategories();
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(gifCategories, 10));
        Iterator<T> it = gifCategories.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GifCategoryItem.Standard((ModelGifCategory) it.next()));
        }
        arrayList.addAll(arrayList2);
        updateViewState(new ViewState(arrayList));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifPickerViewModel(Observable<StoreState> observable) {
        super(new ViewState(Collections2.emptyList()));
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GifPickerViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
