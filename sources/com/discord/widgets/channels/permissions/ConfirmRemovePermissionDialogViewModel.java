package com.discord.widgets.channels.permissions;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.permissions.PermissionOwner;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Subscription;

/* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialogViewModel extends AppViewModel<ViewState> {
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
                return outline.O(outline.U("Default(isSubmitting="), this.isSubmitting, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel$submit$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConfirmRemovePermissionDialogViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
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
        if (channel == null || (listEmptyList = channel.v()) == null) {
            listEmptyList = Collections2.emptyList();
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
        } while (!(permissionOverwrite.getType() == type && permissionOverwrite.e() == this.permissionOwner.getEntityId()));
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
        updateViewState(ViewState.Complete.INSTANCE);
    }

    public final void submit() {
        updateViewState(new ViewState.Default(true));
        PermissionOverwrite newPermissionOverwrite = getNewPermissionOverwrite();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(newPermissionOverwrite != null ? RestAPI.INSTANCE.getApi().updatePermissionOverwrites(this.channelId, newPermissionOverwrite.e(), RestAPIParams.ChannelPermissionOverwrites.INSTANCE.fromPermissionOverwrite(newPermissionOverwrite)) : RestAPI.INSTANCE.getApi().deletePermissionOverwrites(this.channelId, this.permissionOwner.getEntityId()), false, 1, null), this, null, 2, null), (Class<?>) ConfirmRemovePermissionDialogViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfirmRemovePermissionDialogViewModel(PermissionOwner permissionOwner, long j, StoreChannels storeChannels) {
        super(new ViewState.Default(false));
        Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        this.permissionOwner = permissionOwner;
        this.channelId = j;
        this.channelStore = storeChannels;
    }
}
