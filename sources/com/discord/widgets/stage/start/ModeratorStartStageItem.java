package com.discord.widgets.stage.start;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ModeratorStartStageItem implements MGRecyclerDataPayload {
    public static final String KEY_SCHEDULE_EVENT = "KEY_SCHEDULE_EVENT";
    public static final String KEY_START_STAGE = "KEY_START_STAGE";
    public static final int TYPE_CONTINUE = 2;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_LIST_ITEM = 1;
    public static final int TYPE_WAITING = 3;

    /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
    public static final /* data */ class Continue extends ModeratorStartStageItem {
        private final String key;
        private final int type;

        /* JADX WARN: Multi-variable type inference failed */
        public Continue() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Continue(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_CONTINUE" : str);
        }

        public static /* synthetic */ Continue copy$default(Continue r0, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = r0.getType();
            }
            if ((i2 & 2) != 0) {
                str = r0.getKey();
            }
            return r0.copy(i, str);
        }

        public final int component1() {
            return getType();
        }

        public final String component2() {
            return getKey();
        }

        public final Continue copy(int type, String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return new Continue(type, key);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Continue)) {
                return false;
            }
            Continue r3 = (Continue) other;
            return getType() == r3.getType() && Intrinsics3.areEqual(getKey(), r3.getKey());
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            int type = getType() * 31;
            String key = getKey();
            return type + (key != null ? key.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Continue(type=");
            sbU.append(getType());
            sbU.append(", key=");
            sbU.append(getKey());
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Continue(int i, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "key");
            this.type = i;
            this.key = str;
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
    public static final /* data */ class Header extends ModeratorStartStageItem {
        private final String key;
        private final int type;

        /* JADX WARN: Multi-variable type inference failed */
        public Header() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Header(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_HEADER" : str);
        }

        public static /* synthetic */ Header copy$default(Header header, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = header.getType();
            }
            if ((i2 & 2) != 0) {
                str = header.getKey();
            }
            return header.copy(i, str);
        }

        public final int component1() {
            return getType();
        }

        public final String component2() {
            return getKey();
        }

        public final Header copy(int type, String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return new Header(type, key);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Header)) {
                return false;
            }
            Header header = (Header) other;
            return getType() == header.getType() && Intrinsics3.areEqual(getKey(), header.getKey());
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            int type = getType() * 31;
            String key = getKey();
            return type + (key != null ? key.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Header(type=");
            sbU.append(getType());
            sbU.append(", key=");
            sbU.append(getKey());
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Header(int i, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "key");
            this.type = i;
            this.key = str;
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
    public static abstract class ListItem extends ModeratorStartStageItem {
        private final int iconBgColorRes;
        private final int iconRes;
        private final String key;
        private final int type;

        /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
        public static final /* data */ class Event extends ListItem {
            private final GuildScheduledEvent event;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Event(GuildScheduledEvent guildScheduledEvent) {
                super(0, String.valueOf(guildScheduledEvent.getId()), R.drawable.ic_event_20dp, R.color.status_green_600, 1, null);
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
                this.event = guildScheduledEvent;
            }

            public static /* synthetic */ Event copy$default(Event event, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEvent = event.event;
                }
                return event.copy(guildScheduledEvent);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildScheduledEvent getEvent() {
                return this.event;
            }

            public final Event copy(GuildScheduledEvent event) {
                Intrinsics3.checkNotNullParameter(event, "event");
                return new Event(event);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Event) && Intrinsics3.areEqual(this.event, ((Event) other).event);
                }
                return true;
            }

            public final GuildScheduledEvent getEvent() {
                return this.event;
            }

            public int hashCode() {
                GuildScheduledEvent guildScheduledEvent = this.event;
                if (guildScheduledEvent != null) {
                    return guildScheduledEvent.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Event(event=");
                sbU.append(this.event);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
        public static abstract class StaticOption extends ListItem {
            private final int iconBgColorRes;
            private final int iconRes;
            private final String key;
            private final int subtitleRes;
            private final int titleRes;

            /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
            public static final /* data */ class ScheduleEvent extends StaticOption {
                private final String key;

                /* JADX WARN: Multi-variable type inference failed */
                public ScheduleEvent() {
                    this(null, 1, 0 == true ? 1 : 0);
                }

                public /* synthetic */ ScheduleEvent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? ModeratorStartStageItem.KEY_SCHEDULE_EVENT : str);
                }

                public static /* synthetic */ ScheduleEvent copy$default(ScheduleEvent scheduleEvent, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = scheduleEvent.getKey();
                    }
                    return scheduleEvent.copy(str);
                }

                public final String component1() {
                    return getKey();
                }

                public final ScheduleEvent copy(String key) {
                    Intrinsics3.checkNotNullParameter(key, "key");
                    return new ScheduleEvent(key);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof ScheduleEvent) && Intrinsics3.areEqual(getKey(), ((ScheduleEvent) other).getKey());
                    }
                    return true;
                }

                @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem.StaticOption, com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return this.key;
                }

                public int hashCode() {
                    String key = getKey();
                    if (key != null) {
                        return key.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("ScheduleEvent(key=");
                    sbU.append(getKey());
                    sbU.append(")");
                    return sbU.toString();
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ScheduleEvent(String str) {
                    super(str, R.drawable.ic_event_20dp, R.color.brand_new_500, R.string.schedule_event, R.string.schedule_event_description, null);
                    Intrinsics3.checkNotNullParameter(str, "key");
                    this.key = str;
                }
            }

            /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
            public static final /* data */ class StartStage extends StaticOption {
                private final String key;

                /* JADX WARN: Multi-variable type inference failed */
                public StartStage() {
                    this(null, 1, 0 == true ? 1 : 0);
                }

                public /* synthetic */ StartStage(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? ModeratorStartStageItem.KEY_START_STAGE : str);
                }

                public static /* synthetic */ StartStage copy$default(StartStage startStage, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = startStage.getKey();
                    }
                    return startStage.copy(str);
                }

                public final String component1() {
                    return getKey();
                }

                public final StartStage copy(String key) {
                    Intrinsics3.checkNotNullParameter(key, "key");
                    return new StartStage(key);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof StartStage) && Intrinsics3.areEqual(getKey(), ((StartStage) other).getKey());
                    }
                    return true;
                }

                @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem.StaticOption, com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return this.key;
                }

                public int hashCode() {
                    String key = getKey();
                    if (key != null) {
                        return key.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("StartStage(key=");
                    sbU.append(getKey());
                    sbU.append(")");
                    return sbU.toString();
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public StartStage(String str) {
                    super(str, R.drawable.ic_channel_stage_24dp, R.color.status_green_600, R.string.stage_channel_start_title, R.string.stage_channel_start_subtitle, null);
                    Intrinsics3.checkNotNullParameter(str, "key");
                    this.key = str;
                }
            }

            public /* synthetic */ StaticOption(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i, i2, i3, i4);
            }

            @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem
            public int getIconBgColorRes() {
                return this.iconBgColorRes;
            }

            @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem
            public int getIconRes() {
                return this.iconRes;
            }

            @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getSubtitleRes() {
                return this.subtitleRes;
            }

            public final int getTitleRes() {
                return this.titleRes;
            }

            private StaticOption(String str, int i, int i2, @StringRes int i3, @StringRes int i4) {
                super(0, str, i, i2, 1, null);
                this.key = str;
                this.iconRes = i;
                this.iconBgColorRes = i2;
                this.titleRes = i3;
                this.subtitleRes = i4;
            }
        }

        public /* synthetic */ ListItem(int i, String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 1 : i, str, i2, i3);
        }

        public int getIconBgColorRes() {
            return this.iconBgColorRes;
        }

        public int getIconRes() {
            return this.iconRes;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        private ListItem(int i, String str, @DrawableRes int i2, @ColorRes int i3) {
            super(null);
            this.type = i;
            this.key = str;
            this.iconRes = i2;
            this.iconBgColorRes = i3;
        }
    }

    /* JADX INFO: compiled from: ModeratorStartStageItem.kt */
    public static final /* data */ class Waiting extends ModeratorStartStageItem {
        private final String key;
        private final int type;
        private final List<UserGuildMember> users;

        public /* synthetic */ Waiting(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_WAITING" : str, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Waiting copy$default(Waiting waiting, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = waiting.getType();
            }
            if ((i2 & 2) != 0) {
                str = waiting.getKey();
            }
            if ((i2 & 4) != 0) {
                list = waiting.users;
            }
            return waiting.copy(i, str, list);
        }

        public final int component1() {
            return getType();
        }

        public final String component2() {
            return getKey();
        }

        public final List<UserGuildMember> component3() {
            return this.users;
        }

        public final Waiting copy(int type, String key, List<UserGuildMember> users) {
            Intrinsics3.checkNotNullParameter(key, "key");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new Waiting(type, key, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Waiting)) {
                return false;
            }
            Waiting waiting = (Waiting) other;
            return getType() == waiting.getType() && Intrinsics3.areEqual(getKey(), waiting.getKey()) && Intrinsics3.areEqual(this.users, waiting.users);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final List<UserGuildMember> getUsers() {
            return this.users;
        }

        public int hashCode() {
            int type = getType() * 31;
            String key = getKey();
            int iHashCode = (type + (key != null ? key.hashCode() : 0)) * 31;
            List<UserGuildMember> list = this.users;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Waiting(type=");
            sbU.append(getType());
            sbU.append(", key=");
            sbU.append(getKey());
            sbU.append(", users=");
            return outline.L(sbU, this.users, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Waiting(int i, String str, List<UserGuildMember> list) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "key");
            Intrinsics3.checkNotNullParameter(list, "users");
            this.type = i;
            this.key = str;
            this.users = list;
        }
    }

    private ModeratorStartStageItem() {
    }

    public /* synthetic */ ModeratorStartStageItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
