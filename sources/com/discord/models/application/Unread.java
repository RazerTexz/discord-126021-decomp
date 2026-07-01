package com.discord.models.application;

import b.d.b.a.a;
import com.discord.models.message.Message;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Unread.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Unread {
    public static final Unread$Companion Companion = new Unread$Companion(null);
    private final int count;
    private final Unread$Marker marker;

    public Unread() {
        this(null, 0, 3, null);
    }

    public Unread(Unread$Marker unread$Marker) {
        this(unread$Marker, 0, 2, null);
    }

    public Unread(Unread$Marker unread$Marker, int i) {
        m.checkNotNullParameter(unread$Marker, "marker");
        this.marker = unread$Marker;
        this.count = i;
    }

    public static /* synthetic */ Unread copy$default(Unread unread, Unread$Marker unread$Marker, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            unread$Marker = unread.marker;
        }
        if ((i2 & 2) != 0) {
            i = unread.count;
        }
        return unread.copy(unread$Marker, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Unread$Marker getMarker() {
        return this.marker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final Unread copy(Unread$Marker marker, int count) {
        m.checkNotNullParameter(marker, "marker");
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
        return m.areEqual(this.marker, unread.marker) && this.count == unread.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final Unread$Marker getMarker() {
        return this.marker;
    }

    public int hashCode() {
        Unread$Marker unread$Marker = this.marker;
        return ((unread$Marker != null ? unread$Marker.hashCode() : 0) * 31) + this.count;
    }

    public String toString() {
        StringBuilder sbU = a.U("Unread(marker=");
        sbU.append(this.marker);
        sbU.append(", count=");
        return a.B(sbU, this.count, ")");
    }

    public /* synthetic */ Unread(Unread$Marker unread$Marker, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new Unread$Marker() : unread$Marker, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Unread(Unread$Marker unread$Marker, List<Message> list) {
        this(unread$Marker, Unread$Companion.access$getTotalMessages(Companion, unread$Marker, list));
        m.checkNotNullParameter(unread$Marker, "marker");
        m.checkNotNullParameter(list, "messages");
    }
}
