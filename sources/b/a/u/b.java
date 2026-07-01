package b.a.u;

import com.discord.stores.StoreMessagesHolder;
import rx.functions.Action1;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Action1 {
    public final /* synthetic */ StoreMessagesHolder j;

    public /* synthetic */ b(StoreMessagesHolder storeMessagesHolder) {
        this.j = storeMessagesHolder;
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        this.j.a(obj);
    }
}
