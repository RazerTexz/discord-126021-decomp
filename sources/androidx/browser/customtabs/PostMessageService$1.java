package androidx.browser.customtabs;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x.a.a.a;
import x.a.a.c$a;

/* JADX INFO: loaded from: classes.dex */
public class PostMessageService$1 extends c$a {
    public final /* synthetic */ PostMessageService this$0;

    public PostMessageService$1(PostMessageService postMessageService) {
        this.this$0 = postMessageService;
    }

    @Override // x.a.a.c
    public void onMessageChannelReady(@NonNull a aVar, @Nullable Bundle bundle) throws RemoteException {
        aVar.onMessageChannelReady(bundle);
    }

    @Override // x.a.a.c
    public void onPostMessage(@NonNull a aVar, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
        aVar.onPostMessage(str, bundle);
    }
}
