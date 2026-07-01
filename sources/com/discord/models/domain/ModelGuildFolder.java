package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelGuildFolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildFolder {
    private final Integer color;
    private final List<Long> guildIds;
    private final Long id;
    private final String name;

    /* JADX INFO: compiled from: ModelGuildFolder.kt */
    public static final class Parser implements Model.Parser<ModelGuildFolder> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelGuildFolder parse(final Model.JsonReader reader) throws IOException {
            final Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextObject(new Action1<String>() { // from class: com.discord.models.domain.ModelGuildFolder$Parser$parse$1
                @Override // rx.functions.Action1
                public final void call(String str) throws IOException {
                    if (str != null) {
                        int iHashCode = str.hashCode();
                        if (iHashCode != -1847996308) {
                            if (iHashCode != 3355) {
                                if (iHashCode != 3373707) {
                                    if (iHashCode == 94842723 && str.equals(ModelAuditLogEntry.CHANGE_KEY_COLOR)) {
                                        ref$ObjectRef2.element = (T) reader.nextIntOrNull();
                                        return;
                                    }
                                } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                    ref$ObjectRef3.element = (T) reader.nextStringOrNull();
                                    return;
                                }
                            } else if (str.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                                ref$ObjectRefC0.element = (T) reader.nextLongOrNull();
                                return;
                            }
                        } else if (str.equals("guild_ids")) {
                            ref$ObjectRef.element = (T) reader.nextList(new Model.JsonReader.ItemFactory<Long>() { // from class: com.discord.models.domain.ModelGuildFolder$Parser$parse$1.1
                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                                public final Long get() {
                                    return reader.nextLongOrNull();
                                }
                            });
                            return;
                        }
                    }
                    reader.skipValue();
                }
            });
            Long l = (Long) ref$ObjectRefC0.element;
            List list = (List) ref$ObjectRef.element;
            Intrinsics3.checkNotNull(list);
            return new ModelGuildFolder(l, list, (Integer) ref$ObjectRef2.element, (String) ref$ObjectRef3.element);
        }
    }

    public ModelGuildFolder(Long l, List<Long> list, Integer num, String str) {
        Intrinsics3.checkNotNullParameter(list, "guildIds");
        this.id = l;
        this.guildIds = list;
        this.color = num;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelGuildFolder copy$default(ModelGuildFolder modelGuildFolder, Long l, List list, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelGuildFolder.id;
        }
        if ((i & 2) != 0) {
            list = modelGuildFolder.guildIds;
        }
        if ((i & 4) != 0) {
            num = modelGuildFolder.color;
        }
        if ((i & 8) != 0) {
            str = modelGuildFolder.name;
        }
        return modelGuildFolder.copy(l, list, num, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    public final List<Long> component2() {
        return this.guildIds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ModelGuildFolder copy(Long id2, List<Long> guildIds, Integer color, String name) {
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        return new ModelGuildFolder(id2, guildIds, color, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildFolder)) {
            return false;
        }
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) other;
        return Intrinsics3.areEqual(this.id, modelGuildFolder.id) && Intrinsics3.areEqual(this.guildIds, modelGuildFolder.guildIds) && Intrinsics3.areEqual(this.color, modelGuildFolder.color) && Intrinsics3.areEqual(this.name, modelGuildFolder.name);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final List<Long> getGuildIds() {
        return this.guildIds;
    }

    public final Long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        List<Long> list = this.guildIds;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.color;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.name;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelGuildFolder(id=");
        sbU.append(this.id);
        sbU.append(", guildIds=");
        sbU.append(this.guildIds);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }

    public /* synthetic */ ModelGuildFolder(Long l, List list, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, list, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str);
    }
}
