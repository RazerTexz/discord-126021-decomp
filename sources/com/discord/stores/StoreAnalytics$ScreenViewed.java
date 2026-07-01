package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.app.AppComponent;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreAnalytics$ScreenViewed {
    private final Class<? extends AppComponent> screen;
    private final long timestamp;

    public StoreAnalytics$ScreenViewed(Class<? extends AppComponent> cls, long j) {
        m.checkNotNullParameter(cls, "screen");
        this.screen = cls;
        this.timestamp = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoreAnalytics$ScreenViewed copy$default(StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed, Class cls, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = storeAnalytics$ScreenViewed.screen;
        }
        if ((i & 2) != 0) {
            j = storeAnalytics$ScreenViewed.timestamp;
        }
        return storeAnalytics$ScreenViewed.copy(cls, j);
    }

    public final Class<? extends AppComponent> component1() {
        return this.screen;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final StoreAnalytics$ScreenViewed copy(Class<? extends AppComponent> screen, long timestamp) {
        m.checkNotNullParameter(screen, "screen");
        return new StoreAnalytics$ScreenViewed(screen, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreAnalytics$ScreenViewed)) {
            return false;
        }
        StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed = (StoreAnalytics$ScreenViewed) other;
        return m.areEqual(this.screen, storeAnalytics$ScreenViewed.screen) && this.timestamp == storeAnalytics$ScreenViewed.timestamp;
    }

    public final Class<? extends AppComponent> getScreen() {
        return this.screen;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        Class<? extends AppComponent> cls = this.screen;
        return b.a(this.timestamp) + ((cls != null ? cls.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ScreenViewed(screen=");
        sbU.append(this.screen);
        sbU.append(", timestamp=");
        return a.C(sbU, this.timestamp, ")");
    }
}
