package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.channels.permissions.PermissionOwner;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialogViewModel extends AbstractC0859d0<ViewState> {
    private final long channelId;
    private final StoreChannels channelStore;
    private final PermissionOwner permissionOwner;

    /* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
        public static final class Complete extends ViewState {
            public static final Complete INSTANCE = new Complete();

            private Complete() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
        public static final /* data */ class Default extends ViewState {
            private final boolean isSubmitting;

            public Default(boolean z2) {
                super(null);
                this.isSubmitting = z2;
            }

            public static /* synthetic */ Default copy$default(Default r0, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = r0.isSubmitting;
                }
                return r0.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            public final Default copy(boolean isSubmitting) {
                return new Default(isSubmitting);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Default) && this.isSubmitting == ((Default) other).isSubmitting;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isSubmitting;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                return C1643a.m827O(C1643a.m833U("Default(isSubmitting="), this.isSubmitting, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel$submit$1 */
    /* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
    public static final class C75221 extends AbstractC12240o implements Function1<Void, Unit> {
        public C75221() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            ConfirmRemovePermissionDialogViewModel.this.handleSubmissionComplete();
        }
    }

    public /* synthetic */ ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(permissionOwner, j, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels);
    }

    private final PermissionOverwrite getNewPermissionOverwrite() {
        List<PermissionOverwrite> listEmptyList;
        PermissionOverwrite.Type type;
        Object next;
        PermissionOverwrite permissionOverwrite;
        Channel channel = this.channelStore.getChannel(this.channelId);
        if (channel == null || (listEmptyList = channel.m7655v()) == null) {
            listEmptyList = C12147n.emptyList();
        }
        PermissionOwner permissionOwner = this.permissionOwner;
        if (permissionOwner instanceof PermissionOwner.Role) {
            type = PermissionOverwrite.Type.ROLE;
        } else {
            if (!(permissionOwner instanceof PermissionOwner.Member)) {
                throw new NoWhenBranchMatchedException();
            }
            type = PermissionOverwrite.Type.MEMBER;
        }
        Iterator<T> it = listEmptyList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            permissionOverwrite = (PermissionOverwrite) next;
        } while (!(permissionOverwrite.getType() == type && permissionOverwrite.m8131e() == this.permissionOwner.getEntityId()));
        PermissionOverwrite permissionOverwrite2 = (PermissionOverwrite) next;
        if (permissionOverwrite2 == null) {
            return null;
        }
        PermissionOverwrite permissionOverwriteM8127b = PermissionOverwrite.m8127b(permissionOverwrite2, 0L, null, (-20971537) & permissionOverwrite2.getAllow(), 0L, 11);
        if (permissionOverwriteM8127b.getAllow() == 0 && permissionOverwriteM8127b.getDeny() == 0) {
            return null;
        }
        return permissionOverwriteM8127b;
    }

    private final void handleSubmissionComplete() {
        updateViewState(ViewState.Complete.INSTANCE);
    }

    public final void submit() {
        updateViewState(new ViewState.Default(true));
        PermissionOverwrite newPermissionOverwrite = getNewPermissionOverwrite();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(newPermissionOverwrite != null ? RestAPI.INSTANCE.getApi().updatePermissionOverwrites(this.channelId, newPermissionOverwrite.m8131e(), RestAPIParams.ChannelPermissionOverwrites.INSTANCE.fromPermissionOverwrite(newPermissionOverwrite)) : RestAPI.INSTANCE.getApi().deletePermissionOverwrites(this.channelId, this.permissionOwner.getEntityId()), false, 1, null), this, null, 2, null), (Class<?>) ConfirmRemovePermissionDialogViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75221());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels) {
        super(new ViewState.Default(false));
        C12238m.checkNotNullParameter(permissionOwner, "permissionOwner");
        C12238m.checkNotNullParameter(storeChannels, "channelStore");
        this.permissionOwner = permissionOwner;
        this.channelId = j;
        this.channelStore = storeChannels;
    }
}
