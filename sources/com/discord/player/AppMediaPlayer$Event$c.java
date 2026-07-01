package com.discord.player;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer$Event$c extends AppMediaPlayer$Event {
    public final long a;

    public AppMediaPlayer$Event$c(long j) {
        super(null);
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof AppMediaPlayer$Event$c) && this.a == ((AppMediaPlayer$Event$c) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return b.a(this.a);
    }

    public String toString() {
        return a.C(a.U("CurrentPositionUpdate(positionMs="), this.a, ")");
    }
}
