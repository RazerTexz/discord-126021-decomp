package com.discord.views;

import android.widget.TextView;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScope$ActivitiesRead;
import com.discord.api.auth.OAuthScope$ActivitiesWrite;
import com.discord.api.auth.OAuthScope$ApplicationsBuildsRead;
import com.discord.api.auth.OAuthScope$ApplicationsBuildsUpload;
import com.discord.api.auth.OAuthScope$ApplicationsCommands;
import com.discord.api.auth.OAuthScope$ApplicationsCommandsUpdate;
import com.discord.api.auth.OAuthScope$ApplicationsEntitlements;
import com.discord.api.auth.OAuthScope$ApplicationsStoreUpdate;
import com.discord.api.auth.OAuthScope$Bot;
import com.discord.api.auth.OAuthScope$Connections;
import com.discord.api.auth.OAuthScope$DMChannelsRead;
import com.discord.api.auth.OAuthScope$Email;
import com.discord.api.auth.OAuthScope$GdmJoin;
import com.discord.api.auth.OAuthScope$Guilds;
import com.discord.api.auth.OAuthScope$GuildsJoin;
import com.discord.api.auth.OAuthScope$GuildsMembersRead;
import com.discord.api.auth.OAuthScope$Identify;
import com.discord.api.auth.OAuthScope$Invalid;
import com.discord.api.auth.OAuthScope$MessagesRead;
import com.discord.api.auth.OAuthScope$RelationshipsRead;
import com.discord.api.auth.OAuthScope$Rpc;
import com.discord.api.auth.OAuthScope$RpcActivitiesWrite;
import com.discord.api.auth.OAuthScope$RpcNotificationsRead;
import com.discord.api.auth.OAuthScope$RpcVoiceRead;
import com.discord.api.auth.OAuthScope$RpcVoiceWrite;
import com.discord.api.auth.OAuthScope$Voice;
import com.discord.api.auth.OAuthScope$WebhookIncoming;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: OAuthPermissionViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OAuthPermissionViews {
    public static final void a(TextView textView, OAuthScope oAuthScope) throws OAuthPermissionViews$InvalidScopeException {
        int i;
        m.checkNotNullParameter(textView, "$this$setScopePermissionText");
        m.checkNotNullParameter(oAuthScope, "scope");
        if (m.areEqual(oAuthScope, OAuthScope$Identify.INSTANCE)) {
            i = 2131895255;
        } else if (m.areEqual(oAuthScope, OAuthScope$Email.INSTANCE)) {
            i = 2131895250;
        } else if (m.areEqual(oAuthScope, OAuthScope$Connections.INSTANCE)) {
            i = 2131895248;
        } else if (m.areEqual(oAuthScope, OAuthScope$Guilds.INSTANCE)) {
            i = 2131895252;
        } else if (m.areEqual(oAuthScope, OAuthScope$GuildsJoin.INSTANCE)) {
            i = 2131895253;
        } else if (m.areEqual(oAuthScope, OAuthScope$GuildsMembersRead.INSTANCE)) {
            i = 2131895254;
        } else if (m.areEqual(oAuthScope, OAuthScope$GdmJoin.INSTANCE)) {
            i = 2131895251;
        } else if (m.areEqual(oAuthScope, OAuthScope$Bot.INSTANCE)) {
            i = 2131895247;
        } else if (m.areEqual(oAuthScope, OAuthScope$WebhookIncoming.INSTANCE)) {
            i = 2131895266;
        } else if (m.areEqual(oAuthScope, OAuthScope$Rpc.INSTANCE)) {
            i = 2131895258;
        } else if (m.areEqual(oAuthScope, OAuthScope$RpcNotificationsRead.INSTANCE)) {
            i = 2131895260;
        } else if (m.areEqual(oAuthScope, OAuthScope$RpcVoiceRead.INSTANCE)) {
            i = 2131895261;
        } else if (m.areEqual(oAuthScope, OAuthScope$RpcVoiceWrite.INSTANCE)) {
            i = 2131895262;
        } else if (m.areEqual(oAuthScope, OAuthScope$RpcActivitiesWrite.INSTANCE)) {
            i = 2131895259;
        } else if (m.areEqual(oAuthScope, OAuthScope$MessagesRead.INSTANCE)) {
            i = 2131895256;
        } else if (m.areEqual(oAuthScope, OAuthScope$ApplicationsBuildsUpload.INSTANCE)) {
            i = 2131895241;
        } else if (m.areEqual(oAuthScope, OAuthScope$ApplicationsBuildsRead.INSTANCE)) {
            i = 2131895240;
        } else if (m.areEqual(oAuthScope, OAuthScope$ApplicationsCommands.INSTANCE)) {
            i = 2131895242;
        } else if (m.areEqual(oAuthScope, OAuthScope$ApplicationsCommandsUpdate.INSTANCE)) {
            i = 2131895244;
        } else if (m.areEqual(oAuthScope, OAuthScope$ApplicationsStoreUpdate.INSTANCE)) {
            i = 2131895246;
        } else if (m.areEqual(oAuthScope, OAuthScope$ApplicationsEntitlements.INSTANCE)) {
            i = 2131895245;
        } else if (m.areEqual(oAuthScope, OAuthScope$ActivitiesRead.INSTANCE)) {
            i = 2131895238;
        } else if (m.areEqual(oAuthScope, OAuthScope$ActivitiesWrite.INSTANCE)) {
            i = 2131895239;
        } else if (m.areEqual(oAuthScope, OAuthScope$RelationshipsRead.INSTANCE)) {
            i = 2131895257;
        } else if (m.areEqual(oAuthScope, OAuthScope$Voice.INSTANCE)) {
            i = 2131895265;
        } else {
            if (!m.areEqual(oAuthScope, OAuthScope$DMChannelsRead.INSTANCE)) {
                if (!(oAuthScope instanceof OAuthScope$Invalid)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new OAuthPermissionViews$InvalidScopeException(((OAuthScope$Invalid) oAuthScope).getRawValue());
            }
            i = 2131895249;
        }
        textView.setText(i);
    }
}
