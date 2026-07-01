package com.discord.api.auth;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OAuthScope.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class OAuthScope {
    private final String scopeName;

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ActivitiesRead extends OAuthScope {
        public static final ActivitiesRead INSTANCE = new ActivitiesRead();

        public ActivitiesRead() {
            super("activities.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ActivitiesWrite extends OAuthScope {
        public static final ActivitiesWrite INSTANCE = new ActivitiesWrite();

        public ActivitiesWrite() {
            super("activities.write", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ApplicationsBuildsRead extends OAuthScope {
        public static final ApplicationsBuildsRead INSTANCE = new ApplicationsBuildsRead();

        public ApplicationsBuildsRead() {
            super("applications.builds.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ApplicationsBuildsUpload extends OAuthScope {
        public static final ApplicationsBuildsUpload INSTANCE = new ApplicationsBuildsUpload();

        public ApplicationsBuildsUpload() {
            super("applications.builds.upload", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ApplicationsCommands extends OAuthScope {
        public static final ApplicationsCommands INSTANCE = new ApplicationsCommands();

        public ApplicationsCommands() {
            super("applications.commands", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ApplicationsCommandsUpdate extends OAuthScope {
        public static final ApplicationsCommandsUpdate INSTANCE = new ApplicationsCommandsUpdate();

        public ApplicationsCommandsUpdate() {
            super("applications.commands.update", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ApplicationsEntitlements extends OAuthScope {
        public static final ApplicationsEntitlements INSTANCE = new ApplicationsEntitlements();

        public ApplicationsEntitlements() {
            super("applications.entitlements", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class ApplicationsStoreUpdate extends OAuthScope {
        public static final ApplicationsStoreUpdate INSTANCE = new ApplicationsStoreUpdate();

        public ApplicationsStoreUpdate() {
            super("applications.store.update", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class Bot extends OAuthScope {
        public static final Bot INSTANCE = new Bot();

        public Bot() {
            super("bot", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class Connections extends OAuthScope {
        public static final Connections INSTANCE = new Connections();

        public Connections() {
            super("connections", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class DMChannelsRead extends OAuthScope {
        public static final DMChannelsRead INSTANCE = new DMChannelsRead();

        public DMChannelsRead() {
            super("dm_channels.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class Email extends OAuthScope {
        public static final Email INSTANCE = new Email();

        public Email() {
            super(NotificationCompat.CATEGORY_EMAIL, null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class GdmJoin extends OAuthScope {
        public static final GdmJoin INSTANCE = new GdmJoin();

        public GdmJoin() {
            super("gdm.join", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class Guilds extends OAuthScope {
        public static final Guilds INSTANCE = new Guilds();

        public Guilds() {
            super("guilds", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class GuildsJoin extends OAuthScope {
        public static final GuildsJoin INSTANCE = new GuildsJoin();

        public GuildsJoin() {
            super("guilds.join", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class GuildsMembersRead extends OAuthScope {
        public static final GuildsMembersRead INSTANCE = new GuildsMembersRead();

        public GuildsMembersRead() {
            super("guilds.members.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class Identify extends OAuthScope {
        public static final Identify INSTANCE = new Identify();

        public Identify() {
            super("identify", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final /* data */ class Invalid extends OAuthScope {
        private final String rawValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Invalid(String str) {
            super("invalid", null);
            Intrinsics3.checkNotNullParameter(str, "rawValue");
            this.rawValue = str;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getRawValue() {
            return this.rawValue;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Invalid) && Intrinsics3.areEqual(this.rawValue, ((Invalid) other).rawValue);
            }
            return true;
        }

        public int hashCode() {
            String str = this.rawValue;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.J(outline.U("Invalid(rawValue="), this.rawValue, ")");
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class MessagesRead extends OAuthScope {
        public static final MessagesRead INSTANCE = new MessagesRead();

        public MessagesRead() {
            super("messages.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class RelationshipsRead extends OAuthScope {
        public static final RelationshipsRead INSTANCE = new RelationshipsRead();

        public RelationshipsRead() {
            super("relationships.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class Rpc extends OAuthScope {
        public static final Rpc INSTANCE = new Rpc();

        public Rpc() {
            super("rpc", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class RpcActivitiesWrite extends OAuthScope {
        public static final RpcActivitiesWrite INSTANCE = new RpcActivitiesWrite();

        public RpcActivitiesWrite() {
            super("rpc.activities.write", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class RpcNotificationsRead extends OAuthScope {
        public static final RpcNotificationsRead INSTANCE = new RpcNotificationsRead();

        public RpcNotificationsRead() {
            super("rpc.notifications.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class RpcVoiceRead extends OAuthScope {
        public static final RpcVoiceRead INSTANCE = new RpcVoiceRead();

        public RpcVoiceRead() {
            super("rpc.voice.read", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class RpcVoiceWrite extends OAuthScope {
        public static final RpcVoiceWrite INSTANCE = new RpcVoiceWrite();

        public RpcVoiceWrite() {
            super("rpc.voice.write", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class Voice extends OAuthScope {
        public static final Voice INSTANCE = new Voice();

        public Voice() {
            super("voice", null);
        }
    }

    /* JADX INFO: compiled from: OAuthScope.kt */
    public static final class WebhookIncoming extends OAuthScope {
        public static final WebhookIncoming INSTANCE = new WebhookIncoming();

        public WebhookIncoming() {
            super("webhook.incoming", null);
        }
    }

    public OAuthScope(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.scopeName = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getScopeName() {
        return this.scopeName;
    }
}
