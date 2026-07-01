package com.discord.api.guild;

import b.d.b.a.outline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildMaxVideoChannelUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class GuildMaxVideoChannelUsers {

    /* JADX INFO: compiled from: GuildMaxVideoChannelUsers.kt */
    public static final /* data */ class Limited extends GuildMaxVideoChannelUsers {
        private final int limit;

        public Limited(int i) {
            super(null);
            this.limit = i;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Limited) && this.limit == ((Limited) other).limit;
            }
            return true;
        }

        public int hashCode() {
            return this.limit;
        }

        public String toString() {
            return outline.B(outline.U("Limited(limit="), this.limit, ")");
        }
    }

    /* JADX INFO: compiled from: GuildMaxVideoChannelUsers.kt */
    public static final class Unlimited extends GuildMaxVideoChannelUsers {
        public static final Unlimited INSTANCE = new Unlimited();

        public Unlimited() {
            super(null);
        }
    }

    public GuildMaxVideoChannelUsers() {
    }

    public GuildMaxVideoChannelUsers(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
