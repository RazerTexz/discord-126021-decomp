package b.a.z.a.a;

import com.discord.stores.StoreStream;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import rx.functions.Action1;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Action1 {
    public final /* synthetic */ long j;

    public /* synthetic */ b(long j) {
        this.j = j;
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        int i = WidgetChannelSettingsPermissionsAddMember.j;
        StoreStream.getGatewaySocket().requestGuildMembers(this.j, (String) obj);
    }
}
