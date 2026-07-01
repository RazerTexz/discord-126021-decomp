package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.application.Application;
import com.discord.api.application.ApplicationType;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsEmptyGuildRoleSubscriptionsViewModel extends d0<ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState> {
    private final long guildId;

    public /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$handleMonetizationStatus(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel, List list) {
        serverSettingsEmptyGuildRoleSubscriptionsViewModel.handleMonetizationStatus(list);
    }

    public static final /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState access$requireViewState(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel) {
        return serverSettingsEmptyGuildRoleSubscriptionsViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel, ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState) {
        serverSettingsEmptyGuildRoleSubscriptionsViewModel.updateViewState(serverSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState);
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
    public ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI) {
        super(new ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState(false, null, 3, null));
        m.checkNotNullParameter(restAPI, "restApi");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.getGuildApplications(j, false), false, 1, null), this, null, 2, null), ServerSettingsEmptyGuildRoleSubscriptionsViewModel.class, (Context) null, (Function1) null, new ServerSettingsEmptyGuildRoleSubscriptionsViewModel$2(this), (Function0) null, (Function0) null, new ServerSettingsEmptyGuildRoleSubscriptionsViewModel$1(this), 54, (Object) null);
    }
}
