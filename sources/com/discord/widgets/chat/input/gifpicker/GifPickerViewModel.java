package com.discord.widgets.chat.input.gifpicker;

import android.content.Context;
import b.a.d.d0;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GifPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifPickerViewModel extends d0<GifPickerViewModel$ViewState> {
    public GifPickerViewModel() {
        this(null, 1, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GifPickerViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = Observable.j(storeStream$Companion.getGifPicker().observeGifCategories(), storeStream$Companion.getGifPicker().observeTrendingGifCategoryPreviewUrl(), GifPickerViewModel$1.INSTANCE);
            m.checkNotNullExpressionValue(observable, "Observable.combineLatest…egoryPreviewUrl\n    )\n  }");
        }
        this(observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GifPickerViewModel gifPickerViewModel, GifPickerViewModel$StoreState gifPickerViewModel$StoreState) {
        gifPickerViewModel.handleStoreState(gifPickerViewModel$StoreState);
    }

    private final void handleStoreState(GifPickerViewModel$StoreState storeState) {
        ArrayList arrayList = new ArrayList();
        if (storeState.getTrendingGifCategoryPreviewUrl().length() > 0) {
            arrayList.add(new GifCategoryItem$Trending(storeState.getTrendingGifCategoryPreviewUrl()));
        }
        List<ModelGifCategory> gifCategories = storeState.getGifCategories();
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(gifCategories, 10));
        Iterator<T> it = gifCategories.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GifCategoryItem$Standard((ModelGifCategory) it.next()));
        }
        arrayList.addAll(arrayList2);
        updateViewState(new GifPickerViewModel$ViewState(arrayList));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifPickerViewModel(Observable<GifPickerViewModel$StoreState> observable) {
        super(new GifPickerViewModel$ViewState(n.emptyList()));
        m.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), GifPickerViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GifPickerViewModel$2(this), 62, (Object) null);
    }
}
