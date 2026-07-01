package b.a.a.f.a;

import android.content.Context;
import b.a.d.d0;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreAudioManagerV2$State;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: AudioOutputSelectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends d0<d$a> {
    public final StoreAudioManagerV2 j;

    public d() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(StoreAudioManagerV2 storeAudioManagerV2, Observable observable, int i) {
        super(d$a$b.a);
        StoreAudioManagerV2 audioManagerV2 = (i & 1) != 0 ? StoreStream.Companion.getAudioManagerV2() : null;
        Observable<StoreAudioManagerV2$State> observableObserveAudioManagerState = (i & 2) != 0 ? audioManagerV2.observeAudioManagerState() : null;
        m.checkNotNullParameter(audioManagerV2, "storeAudioManager");
        m.checkNotNullParameter(observableObserveAudioManagerState, "storeStateObservable");
        this.j = audioManagerV2;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableObserveAudioManagerState), this, null, 2, null), d.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new c(this), 62, (Object) null);
    }
}
