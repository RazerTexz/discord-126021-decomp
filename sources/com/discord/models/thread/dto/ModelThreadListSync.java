package com.discord.models.thread.dto;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.gson.stream.JsonToken;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelThreadListSync.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelThreadListSync {
    private final long guildId;
    private final List<ThreadMember> members;
    private final List<Message> mostRecentMessages;
    private final List<Channel> threads;

    /* JADX INFO: compiled from: ModelThreadListSync.kt */
    public static final class Parser implements Model.Parser<ModelThreadListSync> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList] */
        @Override // com.discord.models.domain.Model.Parser
        public ModelThreadListSync parse(final Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            final Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = -1L;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = new ArrayList();
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1
                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -1337936983:
                                if (str.equals("threads")) {
                                    ref$ObjectRef.element = (T) reader.nextList(new Model.JsonReader.ItemFactory<Channel>() { // from class: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1.1
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                        public final Channel get() {
                                            return (Channel) InboundGatewayGsonParser.fromJson(reader, Channel.class);
                                        }
                                    });
                                    return;
                                }
                                break;
                            case -1306538777:
                                if (str.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                                    Ref$LongRef ref$LongRef2 = ref$LongRef;
                                    Long lNextLongOrNull = reader.nextLongOrNull();
                                    Intrinsics3.checkNotNull(lNextLongOrNull);
                                    ref$LongRef2.element = lNextLongOrNull.longValue();
                                    return;
                                }
                                break;
                            case 948881689:
                                if (str.equals("members")) {
                                    if (reader.peek() != JsonToken.BEGIN_ARRAY) {
                                        reader.nextObject(new Action1<String>() { // from class: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1.3
                                            @Override // rx.functions.Action1
                                            public final void call(String str2) {
                                                ThreadMember threadMember = (ThreadMember) InboundGatewayGsonParser.fromJson(reader, ThreadMember.class);
                                                Intrinsics3.checkNotNullExpressionValue(str2, "threadId");
                                                ((List) ref$ObjectRef2.element).add(new ThreadMember(Long.parseLong(str2), threadMember.getUserId(), threadMember.getFlags(), threadMember.getJoinTimestamp(), threadMember.getMuted(), threadMember.getMuteConfig()));
                                            }
                                        });
                                        return;
                                    }
                                    Ref$ObjectRef ref$ObjectRef4 = ref$ObjectRef2;
                                    T t = (T) reader.nextList(new Model.JsonReader.ItemFactory<ThreadMember>() { // from class: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1.2
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                        public final ThreadMember get() {
                                            return (ThreadMember) InboundGatewayGsonParser.fromJson(reader, ThreadMember.class);
                                        }
                                    });
                                    Intrinsics3.checkNotNullExpressionValue(t, "reader.nextList { Inboun…readMember::class.java) }");
                                    ref$ObjectRef4.element = t;
                                    return;
                                }
                                break;
                            case 1472794100:
                                if (str.equals("most_recent_messages")) {
                                    ref$ObjectRef3.element = (T) reader.nextList(new Model.JsonReader.ItemFactory<Message>() { // from class: com.discord.models.thread.dto.ModelThreadListSync$Parser$parse$1.4
                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                        public final Message get() {
                                            return (Message) InboundGatewayGsonParser.fromJson(reader, Message.class);
                                        }
                                    });
                                    return;
                                }
                                break;
                        }
                    }
                    reader.skipValue();
                }
            });
            long j = ref$LongRef.element;
            List listEmptyList = (List) ref$ObjectRef.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new ModelThreadListSync(j, listEmptyList, (List) ref$ObjectRef2.element, (List) ref$ObjectRef3.element);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModelThreadListSync(long j, List<Channel> list, List<? extends ThreadMember> list2, List<Message> list3) {
        Intrinsics3.checkNotNullParameter(list, "threads");
        this.guildId = j;
        this.threads = list;
        this.members = list2;
        this.mostRecentMessages = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelThreadListSync copy$default(ModelThreadListSync modelThreadListSync, long j, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelThreadListSync.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            list = modelThreadListSync.threads;
        }
        List list4 = list;
        if ((i & 4) != 0) {
            list2 = modelThreadListSync.members;
        }
        List list5 = list2;
        if ((i & 8) != 0) {
            list3 = modelThreadListSync.mostRecentMessages;
        }
        return modelThreadListSync.copy(j2, list4, list5, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<Channel> component2() {
        return this.threads;
    }

    public final List<ThreadMember> component3() {
        return this.members;
    }

    public final List<Message> component4() {
        return this.mostRecentMessages;
    }

    public final ModelThreadListSync copy(long guildId, List<Channel> threads, List<? extends ThreadMember> members, List<Message> mostRecentMessages) {
        Intrinsics3.checkNotNullParameter(threads, "threads");
        return new ModelThreadListSync(guildId, threads, members, mostRecentMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelThreadListSync)) {
            return false;
        }
        ModelThreadListSync modelThreadListSync = (ModelThreadListSync) other;
        return this.guildId == modelThreadListSync.guildId && Intrinsics3.areEqual(this.threads, modelThreadListSync.threads) && Intrinsics3.areEqual(this.members, modelThreadListSync.members) && Intrinsics3.areEqual(this.mostRecentMessages, modelThreadListSync.mostRecentMessages);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final List<ThreadMember> getMembers() {
        return this.members;
    }

    public final List<Message> getMostRecentMessages() {
        return this.mostRecentMessages;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Channel> list = this.threads;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<ThreadMember> list2 = this.members;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.mostRecentMessages;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelThreadListSync(guildId=");
        sbU.append(this.guildId);
        sbU.append(", threads=");
        sbU.append(this.threads);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", mostRecentMessages=");
        return outline.L(sbU, this.mostRecentMessages, ")");
    }
}
