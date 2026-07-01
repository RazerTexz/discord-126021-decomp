package com.discord.models.application;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.message.Message;
import d0.t.ReversedViews3;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Unread.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Unread {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int count;
    private final Marker marker;

    /* JADX INFO: compiled from: Unread.kt */
    public static final class Companion {
        private Companion() {
        }

        private final int getTotalMessages(Marker marker, List<Message> messages) {
            int i = 0;
            if (!messages.isEmpty() && marker.getMessageId() != null) {
                Iterator it = ReversedViews3.asReversed(messages).iterator();
                while (it.hasNext()) {
                    long id2 = ((Message) it.next()).getId();
                    Long messageId = marker.getMessageId();
                    if (messageId != null && id2 == messageId.longValue()) {
                        return i;
                    }
                    i++;
                }
            }
            return i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: Unread.kt */
    public static final /* data */ class Marker {
        private final long channelId;
        private final Long messageId;

        public Marker(long j, Long l) {
            this.channelId = j;
            this.messageId = l;
        }

        public static /* synthetic */ Marker copy$default(Marker marker, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = marker.channelId;
            }
            if ((i & 2) != 0) {
                l = marker.messageId;
            }
            return marker.copy(j, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getMessageId() {
            return this.messageId;
        }

        public final Marker copy(long channelId, Long messageId) {
            return new Marker(channelId, messageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Marker)) {
                return false;
            }
            Marker marker = (Marker) other;
            return this.channelId == marker.channelId && Intrinsics3.areEqual(this.messageId, marker.messageId);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Long getMessageId() {
            return this.messageId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            Long l = this.messageId;
            return iA + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Marker(channelId=");
            sbU.append(this.channelId);
            sbU.append(", messageId=");
            return outline.G(sbU, this.messageId, ")");
        }

        public Marker() {
            this(0L, 0L);
        }

        public Marker(long j, long j2, Long l) {
            this(j, (l == null || l.longValue() != j2) ? Long.valueOf(j2) : null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Unread() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public Unread(Marker marker) {
        this(marker, 0, 2, null);
    }

    public Unread(Marker marker, int i) {
        Intrinsics3.checkNotNullParameter(marker, "marker");
        this.marker = marker;
        this.count = i;
    }

    public static /* synthetic */ Unread copy$default(Unread unread, Marker marker, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            marker = unread.marker;
        }
        if ((i2 & 2) != 0) {
            i = unread.count;
        }
        return unread.copy(marker, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Marker getMarker() {
        return this.marker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final Unread copy(Marker marker, int count) {
        Intrinsics3.checkNotNullParameter(marker, "marker");
        return new Unread(marker, count);
    }

    public final Unread createWithEmptyCount() {
        return new Unread(this.marker, 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Unread)) {
            return false;
        }
        Unread unread = (Unread) other;
        return Intrinsics3.areEqual(this.marker, unread.marker) && this.count == unread.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final Marker getMarker() {
        return this.marker;
    }

    public int hashCode() {
        Marker marker = this.marker;
        return ((marker != null ? marker.hashCode() : 0) * 31) + this.count;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Unread(marker=");
        sbU.append(this.marker);
        sbU.append(", count=");
        return outline.B(sbU, this.count, ")");
    }

    public /* synthetic */ Unread(Marker marker, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new Marker() : marker, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Unread(Marker marker, List<Message> list) {
        this(marker, INSTANCE.getTotalMessages(marker, list));
        Intrinsics3.checkNotNullParameter(marker, "marker");
        Intrinsics3.checkNotNullParameter(list, "messages");
    }
}
