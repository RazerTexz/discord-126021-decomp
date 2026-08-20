package com.discord.models.domain;

import androidx.browser.customtabs.CustomTabsCallback;
import com.discord.api.guildmember.GuildMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate {
    public static final String EVERYONE_ID = "everyone";
    private final List<Group> groups;
    private final long guildId;
    private final String id;
    private final List<Operation> operations;

    /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
    public static final /* data */ class Group {
        private final int count;
        private final String id;
        private final Type type;

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static final class Parser implements Model.Parser<Group> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Group parse(final Model.JsonReader reader) throws IOException {
                C12238m.checkNotNullParameter(reader, "reader");
                final Ref$IntRef ref$IntRef = new Ref$IntRef();
                ref$IntRef.element = 0;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = "";
                reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Group$Parser$parse$1
                    @Override // p658rx.functions.Action1
                    public final void call(String str) throws IOException {
                        if (str != null) {
                            int iHashCode = str.hashCode();
                            if (iHashCode != 3355) {
                                if (iHashCode == 94851343 && str.equals("count")) {
                                    Ref$IntRef ref$IntRef2 = ref$IntRef;
                                    Integer numNextIntOrNull = reader.nextIntOrNull();
                                    C12238m.checkNotNullExpressionValue(numNextIntOrNull, "reader.nextIntOrNull()");
                                    ref$IntRef2.element = numNextIntOrNull.intValue();
                                    return;
                                }
                            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                                Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                                T t = (T) reader.nextString("");
                                C12238m.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                                ref$ObjectRef2.element = t;
                                return;
                            }
                        }
                        reader.skipValue();
                    }
                });
                return new Group((String) ref$ObjectRef.element, ref$IntRef.element);
            }
        }

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public enum Type {
            ROLE,
            OFFLINE,
            ONLINE
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0033  */
        public Group(String str, int i) {
            Type type;
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
            this.id = str;
            this.count = i;
            int iHashCode = str.hashCode();
            if (iHashCode != -1548612125) {
                if (iHashCode == -1012222381 && str.equals(CustomTabsCallback.ONLINE_EXTRAS_KEY)) {
                    type = Type.ONLINE;
                } else {
                    type = Type.ROLE;
                }
            } else if (str.equals("offline")) {
                type = Type.OFFLINE;
            } else {
                type = Type.ROLE;
            }
            this.type = type;
        }

        public static /* synthetic */ Group copy$default(Group group, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = group.id;
            }
            if ((i2 & 2) != 0) {
                i = group.count;
            }
            return group.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final Group copy(String id2, int count) {
            C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
            return new Group(id2, count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Group)) {
                return false;
            }
            Group group = (Group) other;
            return C12238m.areEqual(this.id, group.id) && this.count == group.count;
        }

        public final int getCount() {
            return this.count;
        }

        public final String getId() {
            return this.id;
        }

        public final Type getType() {
            return this.type;
        }

        public int hashCode() {
            String str = this.id;
            return ((str != null ? str.hashCode() : 0) * 31) + this.count;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Group(id=");
            sbM833U.append(this.id);
            sbM833U.append(", count=");
            return C1643a.m814B(sbM833U, this.count, ")");
        }
    }

    /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
    public static abstract class Operation {
        private final Item item;
        private final List<Item> items;

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static final /* data */ class Delete extends Operation {
            private final int index;

            /* JADX WARN: Multi-variable type inference failed */
            public Delete(int i) {
                super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                this.index = i;
            }

            public static /* synthetic */ Delete copy$default(Delete delete, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = delete.index;
                }
                return delete.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Delete copy(int index) {
                return new Delete(index);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Delete) && this.index == ((Delete) other).index;
                }
                return true;
            }

            public final int getIndex() {
                return this.index;
            }

            public int hashCode() {
                return this.index;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Delete(index="), this.index, ")");
            }
        }

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static final /* data */ class Insert extends Operation {
            private final int index;
            private final Item item;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Insert(int i, Item item) {
                super(item, null, 2, 0 == true ? 1 : 0);
                C12238m.checkNotNullParameter(item, "item");
                this.index = i;
                this.item = item;
            }

            public static /* synthetic */ Insert copy$default(Insert insert, int i, Item item, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = insert.index;
                }
                if ((i2 & 2) != 0) {
                    item = insert.getItem();
                }
                return insert.copy(i, item);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Item component2() {
                return getItem();
            }

            public final Insert copy(int index, Item item) {
                C12238m.checkNotNullParameter(item, "item");
                return new Insert(index, item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Insert)) {
                    return false;
                }
                Insert insert = (Insert) other;
                return this.index == insert.index && C12238m.areEqual(getItem(), insert.getItem());
            }

            public final int getIndex() {
                return this.index;
            }

            @Override // com.discord.models.domain.ModelGuildMemberListUpdate.Operation
            public Item getItem() {
                return this.item;
            }

            public int hashCode() {
                int i = this.index * 31;
                Item item = getItem();
                return i + (item != null ? item.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Insert(index=");
                sbM833U.append(this.index);
                sbM833U.append(", item=");
                sbM833U.append(getItem());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static final /* data */ class Invalidate extends Operation {
            private final IntRange range;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Invalidate(IntRange intRange) {
                super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                C12238m.checkNotNullParameter(intRange, "range");
                this.range = intRange;
            }

            public static /* synthetic */ Invalidate copy$default(Invalidate invalidate, IntRange intRange, int i, Object obj) {
                if ((i & 1) != 0) {
                    intRange = invalidate.range;
                }
                return invalidate.copy(intRange);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final IntRange getRange() {
                return this.range;
            }

            public final Invalidate copy(IntRange range) {
                C12238m.checkNotNullParameter(range, "range");
                return new Invalidate(range);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Invalidate) && C12238m.areEqual(this.range, ((Invalidate) other).range);
                }
                return true;
            }

            public final IntRange getRange() {
                return this.range;
            }

            public int hashCode() {
                IntRange intRange = this.range;
                if (intRange != null) {
                    return intRange.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Invalidate(range=");
                sbM833U.append(this.range);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static abstract class Item {

            /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
            public static final /* data */ class GroupItem extends Item {
                private final Group group;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public GroupItem(Group group) {
                    super(null);
                    C12238m.checkNotNullParameter(group, "group");
                    this.group = group;
                }

                public static /* synthetic */ GroupItem copy$default(GroupItem groupItem, Group group, int i, Object obj) {
                    if ((i & 1) != 0) {
                        group = groupItem.group;
                    }
                    return groupItem.copy(group);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Group getGroup() {
                    return this.group;
                }

                public final GroupItem copy(Group group) {
                    C12238m.checkNotNullParameter(group, "group");
                    return new GroupItem(group);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof GroupItem) && C12238m.areEqual(this.group, ((GroupItem) other).group);
                    }
                    return true;
                }

                public final Group getGroup() {
                    return this.group;
                }

                public int hashCode() {
                    Group group = this.group;
                    if (group != null) {
                        return group.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("GroupItem(group=");
                    sbM833U.append(this.group);
                    sbM833U.append(")");
                    return sbM833U.toString();
                }
            }

            /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
            public static final /* data */ class MemberItem extends Item {
                private final GuildMember member;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public MemberItem(GuildMember guildMember) {
                    super(null);
                    C12238m.checkNotNullParameter(guildMember, "member");
                    this.member = guildMember;
                }

                public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, GuildMember guildMember, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guildMember = memberItem.member;
                    }
                    return memberItem.copy(guildMember);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final GuildMember getMember() {
                    return this.member;
                }

                public final MemberItem copy(GuildMember member) {
                    C12238m.checkNotNullParameter(member, "member");
                    return new MemberItem(member);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof MemberItem) && C12238m.areEqual(this.member, ((MemberItem) other).member);
                    }
                    return true;
                }

                public final GuildMember getMember() {
                    return this.member;
                }

                public int hashCode() {
                    GuildMember guildMember = this.member;
                    if (guildMember != null) {
                        return guildMember.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("MemberItem(member=");
                    sbM833U.append(this.member);
                    sbM833U.append(")");
                    return sbM833U.toString();
                }
            }

            /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
            public static final class Parser implements Model.Parser<Item> {
                public static final Parser INSTANCE = new Parser();

                private Parser() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.discord.models.domain.Model.Parser
                public Item parse(final Model.JsonReader reader) throws IOException {
                    final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
                    ref$ObjectRefM844c0.element = null;
                    final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    ref$ObjectRef.element = null;
                    reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item$Parser$parse$1
                        @Override // p658rx.functions.Action1
                        public final void call(String str) throws IOException {
                            if (str != null) {
                                int iHashCode = str.hashCode();
                                if (iHashCode != -1077769574) {
                                    if (iHashCode == 98629247 && str.equals("group")) {
                                        ref$ObjectRefM844c0.element = (T) ModelGuildMemberListUpdate.Group.Parser.INSTANCE.parse(reader);
                                        return;
                                    }
                                } else if (str.equals("member")) {
                                    ref$ObjectRef.element = (T) ((GuildMember) InboundGatewayGsonParser.fromJson(reader, GuildMember.class));
                                    return;
                                }
                            }
                            reader.skipValue();
                        }
                    });
                    T t = ref$ObjectRef.element;
                    if (((GuildMember) t) != null) {
                        GuildMember guildMember = (GuildMember) t;
                        C12238m.checkNotNull(guildMember);
                        return new MemberItem(guildMember);
                    }
                    T t2 = ref$ObjectRefM844c0.element;
                    if (((Group) t2) == null) {
                        throw new IllegalArgumentException("either member or group must be present.");
                    }
                    Group group = (Group) t2;
                    C12238m.checkNotNull(group);
                    return new GroupItem(group);
                }
            }

            private Item() {
            }

            public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static final class Parser implements Model.Parser<Operation> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public Operation parse(final Model.JsonReader reader) throws IOException {
                final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
                ref$ObjectRefM844c0.element = null;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                ref$ObjectRef2.element = null;
                final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = null;
                final Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                ref$ObjectRef4.element = null;
                reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1
                    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                    @Override // p658rx.functions.Action1
                    public final void call(String str) throws IOException {
                        if (str != null) {
                            switch (str.hashCode()) {
                                case 3553:
                                    if (str.equals("op")) {
                                        ref$ObjectRefM844c0.element = (T) reader.nextStringOrNull();
                                        return;
                                    }
                                    break;
                                case 3242771:
                                    if (str.equals("item")) {
                                        ref$ObjectRef2.element = (T) ModelGuildMemberListUpdate.Operation.Item.Parser.INSTANCE.parse(reader);
                                        return;
                                    }
                                    break;
                                case 100346066:
                                    if (str.equals("index")) {
                                        ref$ObjectRef.element = (T) reader.nextIntOrNull();
                                        return;
                                    }
                                    break;
                                case 100526016:
                                    if (str.equals("items")) {
                                        ref$ObjectRef4.element = (T) reader.nextList(new Model.JsonReader.ItemFactory<ModelGuildMemberListUpdate.Operation.Item>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1.3
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                            public final ModelGuildMemberListUpdate.Operation.Item get() {
                                                return ModelGuildMemberListUpdate.Operation.Item.Parser.INSTANCE.parse(reader);
                                            }
                                        });
                                        return;
                                    }
                                    break;
                                case 108280125:
                                    if (str.equals("range")) {
                                        Ref$ObjectRef ref$ObjectRef5 = ref$ObjectRef3;
                                        List<T> listNextList = reader.nextList(new Model.JsonReader.ItemFactory<Integer>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Parser$parse$1.1
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                            public final Integer get() {
                                                return reader.nextIntOrNull();
                                            }
                                        });
                                        Object obj = listNextList.get(0);
                                        C12238m.checkNotNullExpressionValue(obj, "it[0]");
                                        int iIntValue = ((Number) obj).intValue();
                                        Object obj2 = listNextList.get(1);
                                        C12238m.checkNotNullExpressionValue(obj2, "it[1]");
                                        ref$ObjectRef5.element = (T) new IntRange(iIntValue, ((Number) obj2).intValue());
                                        return;
                                    }
                                    break;
                            }
                        }
                        reader.skipValue();
                    }
                });
                String str = (String) ref$ObjectRefM844c0.element;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -2130463047:
                            if (str.equals("INSERT")) {
                                Integer num = (Integer) ref$ObjectRef.element;
                                C12238m.checkNotNull(num);
                                int iIntValue = num.intValue();
                                Item item = (Item) ref$ObjectRef2.element;
                                C12238m.checkNotNull(item);
                                return new Insert(iIntValue, item);
                            }
                            break;
                        case -1785516855:
                            if (str.equals("UPDATE")) {
                                Integer num2 = (Integer) ref$ObjectRef.element;
                                C12238m.checkNotNull(num2);
                                int iIntValue2 = num2.intValue();
                                Item item2 = (Item) ref$ObjectRef2.element;
                                C12238m.checkNotNull(item2);
                                return new Update(iIntValue2, item2);
                            }
                            break;
                        case -1346757317:
                            if (str.equals("INVALIDATE")) {
                                IntRange intRange = (IntRange) ref$ObjectRef3.element;
                                C12238m.checkNotNull(intRange);
                                return new Invalidate(intRange);
                            }
                            break;
                        case 2560667:
                            if (str.equals("SYNC")) {
                                IntRange intRange2 = (IntRange) ref$ObjectRef3.element;
                                C12238m.checkNotNull(intRange2);
                                List list = (List) ref$ObjectRef4.element;
                                C12238m.checkNotNull(list);
                                return new Sync(intRange2, list);
                            }
                            break;
                        case 2012838315:
                            if (str.equals("DELETE")) {
                                Integer num3 = (Integer) ref$ObjectRef.element;
                                C12238m.checkNotNull(num3);
                                return new Delete(num3.intValue());
                            }
                            break;
                    }
                }
                StringBuilder sbM833U = C1643a.m833U("Invalid operation type: ");
                sbM833U.append((String) ref$ObjectRefM844c0.element);
                throw new IllegalArgumentException(sbM833U.toString());
            }
        }

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static final /* data */ class Sync extends Operation {
            private final List<Item> items;
            private final IntRange range;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Sync(IntRange intRange, List<? extends Item> list) {
                super(null, list, 1, 0 == true ? 1 : 0);
                C12238m.checkNotNullParameter(intRange, "range");
                C12238m.checkNotNullParameter(list, "items");
                this.range = intRange;
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Sync copy$default(Sync sync, IntRange intRange, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    intRange = sync.range;
                }
                if ((i & 2) != 0) {
                    list = sync.getItems();
                }
                return sync.copy(intRange, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final IntRange getRange() {
                return this.range;
            }

            public final List<Item> component2() {
                return getItems();
            }

            public final Sync copy(IntRange range, List<? extends Item> items) {
                C12238m.checkNotNullParameter(range, "range");
                C12238m.checkNotNullParameter(items, "items");
                return new Sync(range, items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Sync)) {
                    return false;
                }
                Sync sync = (Sync) other;
                return C12238m.areEqual(this.range, sync.range) && C12238m.areEqual(getItems(), sync.getItems());
            }

            @Override // com.discord.models.domain.ModelGuildMemberListUpdate.Operation
            public List<Item> getItems() {
                return this.items;
            }

            public final IntRange getRange() {
                return this.range;
            }

            public int hashCode() {
                IntRange intRange = this.range;
                int iHashCode = (intRange != null ? intRange.hashCode() : 0) * 31;
                List<Item> items = getItems();
                return iHashCode + (items != null ? items.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Sync(range=");
                sbM833U.append(this.range);
                sbM833U.append(", items=");
                sbM833U.append(getItems());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
        public static final /* data */ class Update extends Operation {
            private final int index;
            private final Item item;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Update(int i, Item item) {
                super(item, null, 2, 0 == true ? 1 : 0);
                C12238m.checkNotNullParameter(item, "item");
                this.index = i;
                this.item = item;
            }

            public static /* synthetic */ Update copy$default(Update update, int i, Item item, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = update.index;
                }
                if ((i2 & 2) != 0) {
                    item = update.getItem();
                }
                return update.copy(i, item);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public final Item component2() {
                return getItem();
            }

            public final Update copy(int index, Item item) {
                C12238m.checkNotNullParameter(item, "item");
                return new Update(index, item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Update)) {
                    return false;
                }
                Update update = (Update) other;
                return this.index == update.index && C12238m.areEqual(getItem(), update.getItem());
            }

            public final int getIndex() {
                return this.index;
            }

            @Override // com.discord.models.domain.ModelGuildMemberListUpdate.Operation
            public Item getItem() {
                return this.item;
            }

            public int hashCode() {
                int i = this.index * 31;
                Item item = getItem();
                return i + (item != null ? item.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Update(index=");
                sbM833U.append(this.index);
                sbM833U.append(", item=");
                sbM833U.append(getItem());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Operation(Item item, List<? extends Item> list) {
            this.item = item;
            this.items = list;
        }

        public Item getItem() {
            return this.item;
        }

        public List<Item> getItems() {
            return this.items;
        }

        public /* synthetic */ Operation(Item item, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : item, (i & 2) != 0 ? null : list);
        }
    }

    /* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
    public static final class Parser implements Model.Parser<ModelGuildMemberListUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelGuildMemberListUpdate parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefM844c0 = C1643a.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Parser$parse$1
                @Override // p658rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != -1306538777) {
                            if (iHashCode != -1237460524) {
                                if (iHashCode != 3355) {
                                    if (iHashCode == 110258 && str.equals("ops")) {
                                        ref$ObjectRef2.element = (T) reader.nextList(new Model.JsonReader.ItemFactory<ModelGuildMemberListUpdate.Operation>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Parser$parse$1.1
                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                            public final ModelGuildMemberListUpdate.Operation get() {
                                                return ModelGuildMemberListUpdate.Operation.Parser.INSTANCE.parse(reader);
                                            }
                                        });
                                        return;
                                    }
                                } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                                    ref$ObjectRef.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                            } else if (str.equals("groups")) {
                                ref$ObjectRef3.element = (T) reader.nextList(new Model.JsonReader.ItemFactory<ModelGuildMemberListUpdate.Group>() { // from class: com.discord.models.domain.ModelGuildMemberListUpdate$Parser$parse$1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                    public final ModelGuildMemberListUpdate.Group get() {
                                        return ModelGuildMemberListUpdate.Group.Parser.INSTANCE.parse(reader);
                                    }
                                });
                                return;
                            }
                        } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID)) {
                            ref$ObjectRefM844c0.element = (T) reader.nextLongOrNull();
                            return;
                        }
                    }
                    reader.skipValue();
                }
            });
            Long l = (Long) ref$ObjectRefM844c0.element;
            C12238m.checkNotNull(l);
            long jLongValue = l.longValue();
            String str = (String) ref$ObjectRef.element;
            if (str == null) {
                str = ModelGuildMemberListUpdate.EVERYONE_ID;
            }
            String str2 = str;
            List list = (List) ref$ObjectRef2.element;
            C12238m.checkNotNull(list);
            List list2 = (List) ref$ObjectRef3.element;
            C12238m.checkNotNull(list2);
            return new ModelGuildMemberListUpdate(jLongValue, str2, list, list2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModelGuildMemberListUpdate(long j, String str, List<? extends Operation> list, List<Group> list2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(list, "operations");
        C12238m.checkNotNullParameter(list2, "groups");
        this.guildId = j;
        this.id = str;
        this.operations = list;
        this.groups = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelGuildMemberListUpdate copy$default(ModelGuildMemberListUpdate modelGuildMemberListUpdate, long j, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelGuildMemberListUpdate.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = modelGuildMemberListUpdate.id;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = modelGuildMemberListUpdate.operations;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = modelGuildMemberListUpdate.groups;
        }
        return modelGuildMemberListUpdate.copy(j2, str2, list3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<Operation> component3() {
        return this.operations;
    }

    public final List<Group> component4() {
        return this.groups;
    }

    public final ModelGuildMemberListUpdate copy(long guildId, String id2, List<? extends Operation> operations, List<Group> groups) {
        C12238m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(operations, "operations");
        C12238m.checkNotNullParameter(groups, "groups");
        return new ModelGuildMemberListUpdate(guildId, id2, operations, groups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildMemberListUpdate)) {
            return false;
        }
        ModelGuildMemberListUpdate modelGuildMemberListUpdate = (ModelGuildMemberListUpdate) other;
        return this.guildId == modelGuildMemberListUpdate.guildId && C12238m.areEqual(this.id, modelGuildMemberListUpdate.id) && C12238m.areEqual(this.operations, modelGuildMemberListUpdate.operations) && C12238m.areEqual(this.groups, modelGuildMemberListUpdate.groups);
    }

    public final List<Group> getGroups() {
        return this.groups;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getId() {
        return this.id;
    }

    public final List<Operation> getOperations() {
        return this.operations;
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.id;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Operation> list = this.operations;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Group> list2 = this.groups;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelGuildMemberListUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", operations=");
        sbM833U.append(this.operations);
        sbM833U.append(", groups=");
        return C1643a.m824L(sbM833U, this.groups, ")");
    }
}
