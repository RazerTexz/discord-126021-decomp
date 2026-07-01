package com.discord.gateway.io;

import b.d.b.a.a;
import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import com.discord.api.commands.GuildApplicationCommands;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.forum.ForumUnreads;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import com.discord.api.guildjoinrequest.GuildJoinRequestDelete;
import com.discord.api.guildmember.GuildMemberRemove;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.api.presence.Presence;
import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.api.role.GuildRoleCreate;
import com.discord.api.role.GuildRoleDelete;
import com.discord.api.role.GuildRoleUpdate;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMemberUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.api.voice.server.VoiceServer;
import com.discord.api.voice.state.VoiceState;
import com.discord.gateway.opcodes.Opcode;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.ModelChannelUnreadUpdate$Parser;
import com.discord.models.domain.ModelGuildIntegration$Update;
import com.discord.models.domain.ModelGuildMemberListUpdate$Parser;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelPayload$Hello;
import com.discord.models.domain.ModelReadState$Parser;
import com.discord.models.domain.ModelUserNote$Update$Parser;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.StreamCreateOrUpdate$Parser;
import com.discord.models.domain.StreamDelete$Parser;
import com.discord.models.domain.StreamServerUpdate$Parser;
import com.discord.models.thread.dto.ModelThreadListSync$Parser;
import com.discord.utilities.fcm.NotificationData;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Incoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class IncomingParser implements Model {
    private Object data;
    private final Function1<String, Unit> log;
    private Opcode opcode;
    private Integer seq;
    private String type;

    /* JADX WARN: Multi-variable type inference failed */
    public IncomingParser(Function1<? super String, Unit> function1) {
        m.checkNotNullParameter(function1, "log");
        this.log = function1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0208, code lost:
    
        if (r3.equals("THREAD_CREATE") != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x020a, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.channel.Channel.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0218, code lost:
    
        if (r3.equals("MESSAGE_REACTION_REMOVE") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0222, code lost:
    
        if (r3.equals("CHANNEL_RECIPIENT_ADD") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x022c, code lost:
    
        if (r3.equals("MESSAGE_DELETE") != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0236, code lost:
    
        if (r3.equals(com.discord.utilities.fcm.NotificationData.TYPE_MESSAGE_CREATE) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0238, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.message.Message.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0248, code lost:
    
        if (r3.equals("INTERACTION_SUCCESS") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0264, code lost:
    
        if (r3.equals("CALL_UPDATE") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x026e, code lost:
    
        if (r3.equals("GUILD_UPDATE") != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02f2, code lost:
    
        if (r3.equals("GUILD_MEMBER_UPDATE") != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030e, code lost:
    
        if (r3.equals("MESSAGE_DELETE_BULK") != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0310, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelMessageDelete());
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0335, code lost:
    
        if (r3.equals("CHANNEL_UPDATE") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0351, code lost:
    
        if (r3.equals("CALL_DELETE") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x035a, code lost:
    
        if (r3.equals("CALL_CREATE") != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x035c, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelCall());
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x036f, code lost:
    
        if (r3.equals("GUILD_DELETE") != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0378, code lost:
    
        if (r3.equals("GUILD_CREATE") != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x037a, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.guild.Guild.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x039c, code lost:
    
        if (r3.equals("CHANNEL_RECIPIENT_REMOVE") != false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x039e, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.channel.ChannelRecipient.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x03ae, code lost:
    
        if (r3.equals("CHANNEL_DELETE") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03b7, code lost:
    
        if (r3.equals("CHANNEL_CREATE") != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03b9, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.channel.Channel.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03c7, code lost:
    
        if (r3.equals("RELATIONSHIP_REMOVE") != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03d1, code lost:
    
        if (r3.equals("STAGE_INSTANCE_UPDATE") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0417, code lost:
    
        if (r3.equals("INTERACTION_CREATE") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0419, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.interaction.InteractionStateUpdate.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x045f, code lost:
    
        if (r3.equals("MESSAGE_REACTION_ADD") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0469, code lost:
    
        if (r3.equals("STAGE_INSTANCE_DELETE") != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0472, code lost:
    
        if (r3.equals("GUILD_MEMBER_ADD") != false) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0474, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.guildmember.GuildMember.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0484, code lost:
    
        if (r3.equals("GUILD_BAN_ADD") != false) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0486, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelBan());
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0499, code lost:
    
        if (r3.equals(com.discord.utilities.fcm.NotificationData.TYPE_STAGE_INSTANCE_CREATE) != false) goto L228;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x049b, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.stageinstance.StageInstance.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x04ab, code lost:
    
        if (r3.equals(com.discord.utilities.fcm.NotificationData.TYPE_RELATIONSHIP_ADD) != false) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x04ad, code lost:
    
        r6.data = r7.parse(new com.discord.models.domain.ModelUserRelationship());
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0516, code lost:
    
        if (r3.equals("MESSAGE_REACTION_REMOVE_ALL") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0520, code lost:
    
        if (r3.equals("GUILD_JOIN_REQUEST_UPDATE") != false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0560, code lost:
    
        if (r3.equals("USER_CONNECTIONS_INTEGRATION_JOINING") != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0562, code lost:
    
        r7.skipValue();
        r6.data = kotlin.Unit.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x05d8, code lost:
    
        if (r3.equals("GUILD_JOIN_REQUEST_CREATE") != false) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x05da, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.guildjoinrequest.GuildJoinRequestCreateOrUpdate.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x05e9, code lost:
    
        if (r3.equals("MESSAGE_REACTION_REMOVE_EMOJI") != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x05eb, code lost:
    
        r6.data = com.discord.models.deserialization.gson.InboundGatewayGsonParser.fromJson(r7, com.discord.api.message.reaction.MessageReactionUpdate.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0115, code lost:
    
        if (r3.equals("THREAD_UPDATE") != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0168, code lost:
    
        if (r3.equals("GUILD_BAN_REMOVE") != false) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0184, code lost:
    
        if (r3.equals("INTERACTION_FAILURE") != false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x018e, code lost:
    
        if (r3.equals("MESSAGE_UPDATE") != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01aa, code lost:
    
        if (r3.equals("USER_CONNECTIONS_UPDATE") != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01db, code lost:
    
        if (r3.equals("THREAD_DELETE") != false) goto L108;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.discord.models.domain.Model
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void assignField(Model$JsonReader reader) throws IOException {
        m.checkNotNullParameter(reader, "reader");
        String strNextName = reader.nextName();
        if (strNextName != null) {
            int iHashCode = strNextName.hashCode();
            if (iHashCode != 100) {
                if (iHashCode != 3553) {
                    if (iHashCode != 115) {
                        if (iHashCode == 116 && strNextName.equals("t")) {
                            this.type = reader.nextString(this.type);
                            return;
                        }
                    } else if (strNextName.equals("s")) {
                        this.seq = reader.nextIntOrNull();
                        return;
                    }
                } else if (strNextName.equals("op")) {
                    this.opcode = Opcode.Companion.fromApiInt(reader.nextInt(-1));
                    return;
                }
            } else if (strNextName.equals("d")) {
                Opcode opcode = this.opcode;
                if (opcode == null) {
                    m.throwUninitializedPropertyAccessException("opcode");
                }
                int iOrdinal = opcode.ordinal();
                if (iOrdinal != 1) {
                    if (iOrdinal == 10) {
                        this.data = Boolean.valueOf(reader.nextBoolean(false));
                        return;
                    } else if (iOrdinal != 11) {
                        reader.skipValue();
                        return;
                    } else {
                        this.data = reader.parse(new ModelPayload$Hello());
                        return;
                    }
                }
                String str = this.type;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -2137365335:
                            break;
                        case -2067017195:
                            break;
                        case -2050181436:
                            if (str.equals("GUILD_JOIN_REQUEST_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildJoinRequestDelete.class);
                            }
                            break;
                        case -2026522382:
                            if (str.equals("SESSIONS_REPLACE")) {
                                this.data = reader.nextList(new IncomingParser$assignField$2(reader));
                            }
                            break;
                        case -2002723137:
                            if (str.equals("GUILD_SCHEDULED_EVENT_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEvent.class);
                            }
                            break;
                        case -1985887378:
                            if (str.equals("GUILD_SCHEDULED_EVENT_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEvent.class);
                            }
                            break;
                        case -1967037287:
                            if (str.equals("THREAD_MEMBER_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ThreadMemberUpdate.class);
                            }
                            break;
                        case -1921449515:
                            if (str.equals("APPLICATION_COMMAND_AUTOCOMPLETE_RESPONSE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ApplicationCommandAutocompleteResult.class);
                            }
                            break;
                        case -1893369777:
                            break;
                        case -1862771270:
                            if (str.equals("THREAD_MEMBER_LIST_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ThreadMemberListUpdate.class);
                            }
                            break;
                        case -1825641445:
                            if (str.equals("GUILD_MEMBERS_CHUNK")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildMembersChunk.class);
                            }
                            break;
                        case -1580624828:
                            if (str.equals("EMBEDDED_ACTIVITY_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, EmbeddedActivityInboundUpdate.class);
                            }
                            break;
                        case -1553569310:
                            break;
                        case -1553064252:
                            break;
                        case -1533134522:
                            if (str.equals("FORUM_UNREADS")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ForumUnreads.class);
                            }
                            break;
                        case -1489275252:
                            if (str.equals(NotificationData.TYPE_GUILD_SCHEDULED_EVENT_UPDATE)) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEvent.class);
                            }
                            break;
                        case -1484942443:
                            if (str.equals("GUILD_SCHEDULED_EVENT_USER_REMOVE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEventUserUpdate.class);
                            }
                            break;
                        case -1467383482:
                            if (str.equals("USER_REQUIRED_ACTION_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, UserRequiredActionUpdate.class);
                            }
                            break;
                        case -1446088218:
                            if (str.equals("GUILD_STICKERS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildStickersUpdate.class);
                            }
                            break;
                        case -1327124998:
                            break;
                        case -1263316859:
                            break;
                        case -1261304891:
                            break;
                        case -1248965304:
                            break;
                        case -1246481100:
                            break;
                        case -1238538557:
                            break;
                        case -1201943215:
                            if (str.equals("GUILD_MEMBER_LIST_UPDATE")) {
                                this.data = ModelGuildMemberListUpdate$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case -960563390:
                            if (str.equals("USER_NOTE_UPDATE")) {
                                this.data = ModelUserNote$Update$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case -903406451:
                            if (str.equals("PRESENCE_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, Presence.class);
                            }
                            break;
                        case -850953239:
                            break;
                        case -843352707:
                            if (str.equals("GUILD_INTEGRATIONS_UPDATE")) {
                                this.data = reader.parse(new ModelGuildIntegration$Update());
                            }
                            break;
                        case -778017807:
                            if (str.equals("USER_SETTINGS_UPDATE")) {
                                this.data = reader.parse(new ModelUserSettings());
                            }
                            break;
                        case -767350043:
                            if (str.equals("GUILD_APPLICATION_COMMANDS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildApplicationCommands.class);
                            }
                            break;
                        case -749868974:
                            break;
                        case -718889877:
                            break;
                        case -675064872:
                            break;
                        case -658229113:
                            break;
                        case -548091546:
                            break;
                        case -510741638:
                            if (str.equals("TYPING_START")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, TypingUser.class);
                            }
                            break;
                        case -273749272:
                            break;
                        case -256913513:
                            break;
                        case -233612803:
                            break;
                        case -216777044:
                            break;
                        case -207118083:
                            if (str.equals("CHANNEL_UNREAD_UPDATE")) {
                                this.data = ModelChannelUnreadUpdate$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case -161616987:
                            break;
                        case -135720355:
                            if (str.equals("GUILD_MEMBER_REMOVE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildMemberRemove.class);
                            }
                            break;
                        case -107601202:
                            break;
                        case -45642698:
                            if (str.equals("FRIEND_SUGGESTION_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, FriendSuggestion.class);
                            }
                            break;
                        case -39955806:
                            break;
                        case -28806939:
                            if (str.equals("FRIEND_SUGGESTION_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, FriendSuggestionDelete.class);
                            }
                            break;
                        case 77848963:
                            if (str.equals("READY")) {
                                this.log.invoke("Ready payload data received.");
                                long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
                                this.data = reader.parse(new ModelPayload());
                                Function1<String, Unit> function1 = this.log;
                                StringBuilder sbU = a.U("Ready payload deserialized in ");
                                sbU.append(ClockFactory.get().currentTimeMillis() - jCurrentTimeMillis);
                                sbU.append(" ms.");
                                function1.invoke(sbU.toString());
                            }
                            break;
                        case 85547718:
                            if (str.equals("STREAM_SERVER_UPDATE")) {
                                this.data = StreamServerUpdate$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case 151900580:
                            if (str.equals("THREAD_MEMBERS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, ThreadMembersUpdate.class);
                            }
                            break;
                        case 239698613:
                            break;
                        case 279835082:
                            break;
                        case 391412669:
                            if (str.equals("USER_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, User.class);
                            }
                            break;
                        case 789496470:
                            break;
                        case 998188116:
                            break;
                        case 1015023875:
                            break;
                        case 1190664927:
                            break;
                        case 1249854210:
                            break;
                        case 1268388049:
                            break;
                        case 1276846319:
                            if (str.equals("GUILD_EMOJIS_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildEmojisUpdate.class);
                            }
                            break;
                        case 1281125393:
                            if (str.equals("MESSAGE_ACK")) {
                                this.data = ModelReadState$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case 1285223808:
                            break;
                        case 1389895301:
                            if (str.equals("USER_GUILD_SETTINGS_UPDATE")) {
                                this.data = reader.parse(new ModelNotificationSettings());
                            }
                            break;
                        case 1476675193:
                            if (str.equals("GUILD_ROLE_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildRoleCreate.class);
                            }
                            break;
                        case 1478484999:
                            break;
                        case 1493510952:
                            if (str.equals("GUILD_ROLE_DELETE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildRoleDelete.class);
                            }
                            break;
                        case 1511636001:
                            break;
                        case 1570092061:
                            break;
                        case 1616207515:
                            if (str.equals("STREAM_CREATE")) {
                                this.data = StreamCreateOrUpdate$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case 1622830784:
                            break;
                        case 1633043274:
                            if (str.equals("STREAM_DELETE")) {
                                this.data = StreamDelete$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case 1689894925:
                            if (str.equals("PRESENCES_REPLACE")) {
                                this.data = reader.nextList(new IncomingParser$assignField$1(reader));
                            }
                            break;
                        case 1699412580:
                            if (str.equals("VOICE_STATE_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, VoiceState.class);
                            }
                            break;
                        case 1737758480:
                            if (str.equals("GUILD_SCHEDULED_EVENT_USER_ADD")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildScheduledEventUserUpdate.class);
                            }
                            break;
                        case 1781835934:
                            break;
                        case 1882183896:
                            if (str.equals("VOICE_SERVER_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, VoiceServer.class);
                            }
                            break;
                        case 1901414427:
                            if (str.equals("INTERACTION_MODAL_CREATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, InteractionModalCreate.class);
                            }
                            break;
                        case 1928220071:
                            if (str.equals("THREAD_LIST_SYNC")) {
                                this.data = ModelThreadListSync$Parser.INSTANCE.parse(reader);
                            }
                            break;
                        case 1990123078:
                            if (str.equals("GUILD_ROLE_UPDATE")) {
                                this.data = InboundGatewayGsonParser.fromJson(reader, GuildRoleUpdate.class);
                            }
                            break;
                        case 2129655400:
                            if (str.equals("STREAM_UPDATE")) {
                                this.data = StreamCreateOrUpdate$Parser.INSTANCE.parse(reader);
                            }
                            break;
                    }
                }
                reader.skipValue();
                return;
            }
        }
        reader.skipValue();
    }

    public final Incoming build() {
        String str = this.type;
        Integer num = this.seq;
        Opcode opcode = this.opcode;
        if (opcode == null) {
            m.throwUninitializedPropertyAccessException("opcode");
        }
        return new Incoming(str, num, opcode, this.data);
    }
}
