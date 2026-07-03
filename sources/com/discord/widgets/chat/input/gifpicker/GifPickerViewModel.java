package com.discord.widgets.chat.input.gifpicker;

import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: GifPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifPickerViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifPickerViewModel$2 */
    /* JADX INFO: compiled from: GifPickerViewModel.kt */
    public static final class C78702 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C78702() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            GifPickerViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GifPickerViewModel.kt */
    public static final /* data */ class StoreState {
        private final List<ModelGifCategory> gifCategories;
        private final String trendingGifCategoryPreviewUrl;

        public StoreState(List<ModelGifCategory> list, String str) {
            C12238m.checkNotNullParameter(list, "gifCategories");
            C12238m.checkNotNullParameter(str, "trendingGifCategoryPreviewUrl");
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
            C12238m.checkNotNullParameter(gifCategories, "gifCategories");
            C12238m.checkNotNullParameter(trendingGifCategoryPreviewUrl, "trendingGifCategoryPreviewUrl");
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
            return C12238m.areEqual(this.gifCategories, storeState.gifCategories) && C12238m.areEqual(this.trendingGifCategoryPreviewUrl, storeState.trendingGifCategoryPreviewUrl);
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
            StringBuilder sbM833U = C1643a.m833U("StoreState(gifCategories=");
            sbM833U.append(this.gifCategories);
            sbM833U.append(", trendingGifCategoryPreviewUrl=");
            return C1643a.m822J(sbM833U, this.trendingGifCategoryPreviewUrl, ")");
        }
    }

    /* JADX INFO: compiled from: GifPickerViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<GifCategoryItem> gifCategoryItems;
        private final boolean isLoaded;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends GifCategoryItem> list) {
            C12238m.checkNotNullParameter(list, "gifCategoryItems");
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
            C12238m.checkNotNullParameter(gifCategoryItems, "gifCategoryItems");
            return new ViewState(gifCategoryItems);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ViewState) && C12238m.areEqual(this.gifCategoryItems, ((ViewState) other).gifCategoryItems);
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
            return C1643a.m824L(C1643a.m833U("ViewState(gifCategoryItems="), this.gifCategoryItems, ")");
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
            observable = Observable.m11076j(companion.getGifPicker().observeGifCategories(), companion.getGifPicker().observeTrendingGifCategoryPreviewUrl(), new Func2<List<? extends ModelGifCategory>, String, StoreState>() { // from class: com.discord.widgets.chat.input.gifpicker.GifPickerViewModel.1
                @Override // p658rx.functions.Func2
                public /* bridge */ /* synthetic */ StoreState call(List<? extends ModelGifCategory> list, String str) {
                    return call2((List<ModelGifCategory>) list, str);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final StoreState call2(List<ModelGifCategory> list, String str) {
                    C12238m.checkNotNullExpressionValue(list, "gifCategories");
                    C12238m.checkNotNullExpressionValue(str, "trendingGifCategoryPreviewUrl");
                    return new StoreState(list, str);
                }
            });
            C12238m.checkNotNullExpressionValue(observable, "Observable.combineLatest…egoryPreviewUrl\n    )\n  }");
        }
        this(observable);
    }

    private final void handleStoreState(StoreState storeState) {
        ArrayList arrayList = new ArrayList();
        if (storeState.getTrendingGifCategoryPreviewUrl().length() > 0) {
            arrayList.add(new GifCategoryItem.Trending(storeState.getTrendingGifCategoryPreviewUrl()));
        }
        List<ModelGifCategory> gifCategories = storeState.getGifCategories();
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(gifCategories, 10));
        Iterator<T> it = gifCategories.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GifCategoryItem.Standard((ModelGifCategory) it.next()));
        }
        arrayList.addAll(arrayList2);
        updateViewState(new ViewState(arrayList));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifPickerViewModel(Observable<StoreState> observable) {
        super(new ViewState(C12147n.emptyList()));
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GifPickerViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C78702());
    }
}
