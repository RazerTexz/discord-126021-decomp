package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$setupFAB$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGroupInviteFriends$Model $data;
    public final /* synthetic */ WidgetGroupInviteFriends this$0;

    public WidgetGroupInviteFriends$setupFAB$2(WidgetGroupInviteFriends widgetGroupInviteFriends, WidgetGroupInviteFriends$Model widgetGroupInviteFriends$Model) {
        this.this$0 = widgetGroupInviteFriends;
        this.$data = widgetGroupInviteFriends$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Observable<Channel> observableCreateGroupDM;
        if (this.$data.getChannel() != null) {
            observableCreateGroupDM = RestAPI.Companion.getApi().addGroupRecipients(this.$data.getChannel().getId(), u.toList(this.$data.getSelectedUsers()));
        } else if (this.$data.getSelectedUsers().size() == 1) {
            observableCreateGroupDM = RestAPI.Companion.getApi().createOrFetchDM(((User) u.first(this.$data.getSelectedUsers())).getId());
        } else {
            RestAPI api = RestAPI.Companion.getApi();
            Collection<User> selectedUsers = this.$data.getSelectedUsers();
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(selectedUsers, 10));
            Iterator<T> it = selectedUsers.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((User) it.next()).getId()));
            }
            observableCreateGroupDM = api.createGroupDM(arrayList);
        }
        Observable observableJ = Observable.j(observableCreateGroupDM, ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), 0L, false, 3, null), WidgetGroupInviteFriends$setupFAB$2$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dVoiceChannelId\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGroupInviteFriends$setupFAB$2$3(this), 60, (Object) null);
    }
}
