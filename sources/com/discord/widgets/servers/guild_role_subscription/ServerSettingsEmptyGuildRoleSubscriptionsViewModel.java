package com.discord.widgets.servers.guild_role_subscription;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.application.ApplicationType;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Subscription;

/* JADX INFO: compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsEmptyGuildRoleSubscriptionsViewModel extends AppViewModel<ViewState> {
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Application>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
            invoke2((List<Application>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Application> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel.this.handleMonetizationStatus(list);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel = ServerSettingsEmptyGuildRoleSubscriptionsViewModel.this;
            serverSettingsEmptyGuildRoleSubscriptionsViewModel.updateViewState(ViewState.copy$default(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$requireViewState(serverSettingsEmptyGuildRoleSubscriptionsViewModel), false, null, 2, null));
        }
    }

    /* JADX INFO: compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Boolean isMonetizationEnabled;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        public ViewState(boolean z2, Boolean bool) {
            this.isLoading = z2;
            this.isMonetizationEnabled = bool;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isLoading;
            }
            if ((i & 2) != 0) {
                bool = viewState.isMonetizationEnabled;
            }
            return viewState.copy(z2, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsMonetizationEnabled() {
            return this.isMonetizationEnabled;
        }

        public final ViewState copy(boolean isLoading, Boolean isMonetizationEnabled) {
            return new ViewState(isLoading, isMonetizationEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics3.areEqual(this.isMonetizationEnabled, viewState.isMonetizationEnabled);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Boolean bool = this.isMonetizationEnabled;
            return i + (bool != null ? bool.hashCode() : 0);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final Boolean isMonetizationEnabled() {
            return this.isMonetizationEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isLoading=");
            sbU.append(this.isLoading);
            sbU.append(", isMonetizationEnabled=");
            return outline.D(sbU, this.isMonetizationEnabled, ")");
        }

        public /* synthetic */ ViewState(boolean z2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z2, (i & 2) != 0 ? null : bool);
        }
    }

    public /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ ViewState access$requireViewState(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel) {
        return serverSettingsEmptyGuildRoleSubscriptionsViewModel.requireViewState();
    }

    private final void handleMonetizationStatus(List<Application> applications) {
        Object next;
        Application application;
        Long guildId;
        Iterator<T> it = applications.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                application = (Application) next;
                guildId = application.getGuildId();
            }
        } while (!(guildId != null && guildId.longValue() == this.guildId && application.getType() == ApplicationType.GUILD_ROLE_SUBSCRIPTIONS));
        updateViewState(requireViewState().copy(false, Boolean.valueOf(((Application) next) != null)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI) {
        super(new ViewState(false, null, 3, 0 == true ? 1 : 0));
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.getGuildApplications(j, false), false, 1, null), this, null, 2, null), (Class<?>) ServerSettingsEmptyGuildRoleSubscriptionsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
