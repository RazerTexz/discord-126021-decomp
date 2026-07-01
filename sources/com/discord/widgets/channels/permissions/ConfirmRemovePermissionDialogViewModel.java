package com.discord.widgets.channels.permissions;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.restapi.RestAPIParams$ChannelPermissionOverwrites;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialogViewModel extends d0<ConfirmRemovePermissionDialogViewModel$ViewState> {
    private final long channelId;
    private final StoreChannels channelStore;
    private final PermissionOwner permissionOwner;

    public /* synthetic */ ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(permissionOwner, j, (i & 4) != 0 ? StoreStream.Companion.getChannels() : storeChannels);
    }

    public static final /* synthetic */ void access$handleSubmissionComplete(ConfirmRemovePermissionDialogViewModel confirmRemovePermissionDialogViewModel) {
        confirmRemovePermissionDialogViewModel.handleSubmissionComplete();
    }

    private final PermissionOverwrite getNewPermissionOverwrite() {
        List<PermissionOverwrite> listEmptyList;
        PermissionOverwrite$Type permissionOverwrite$Type;
        Object next;
        PermissionOverwrite permissionOverwrite;
        Channel channel = this.channelStore.getChannel(this.channelId);
        if (channel == null || (listEmptyList = channel.v()) == null) {
            listEmptyList = n.emptyList();
        }
        PermissionOwner permissionOwner = this.permissionOwner;
        if (permissionOwner instanceof PermissionOwner$Role) {
            permissionOverwrite$Type = PermissionOverwrite$Type.ROLE;
        } else {
            if (!(permissionOwner instanceof PermissionOwner$Member)) {
                throw new NoWhenBranchMatchedException();
            }
            permissionOverwrite$Type = PermissionOverwrite$Type.MEMBER;
        }
        Iterator<T> it = listEmptyList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            permissionOverwrite = (PermissionOverwrite) next;
        } while (!(permissionOverwrite.getType() == permissionOverwrite$Type && permissionOverwrite.e() == this.permissionOwner.getEntityId()));
        PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) next;
        if (permissionOverwrite2 == null) {
            return null;
        }
        PermissionOverwrite permissionOverwriteB = PermissionOverwrite.b(permissionOverwrite2, 0L, null, (-20971537) & permissionOverwrite2.getAllow(), 0L, 11);
        if (permissionOverwriteB.getAllow() == 0 && permissionOverwriteB.getDeny() == 0) {
            return null;
        }
        return permissionOverwriteB;
    }

    private final void handleSubmissionComplete() {
        updateViewState(ConfirmRemovePermissionDialogViewModel$ViewState$Complete.INSTANCE);
    }

    public final void submit() {
        updateViewState(new ConfirmRemovePermissionDialogViewModel$ViewState$Default(true));
        PermissionOverwrite newPermissionOverwrite = getNewPermissionOverwrite();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(newPermissionOverwrite != null ? RestAPI.Companion.getApi().updatePermissionOverwrites(this.channelId, newPermissionOverwrite.e(), RestAPIParams$ChannelPermissionOverwrites.Companion.fromPermissionOverwrite(newPermissionOverwrite)) : RestAPI.Companion.getApi().deletePermissionOverwrites(this.channelId, this.permissionOwner.getEntityId()), false, 1, null), this, null, 2, null), ConfirmRemovePermissionDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ConfirmRemovePermissionDialogViewModel$submit$1(this), 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels) {
        super(new ConfirmRemovePermissionDialogViewModel$ViewState$Default(false));
        m.checkNotNullParameter(permissionOwner, "permissionOwner");
        m.checkNotNullParameter(storeChannels, "channelStore");
        this.permissionOwner = permissionOwner;
        this.channelId = j;
        this.channelStore = storeChannels;
    }
}
