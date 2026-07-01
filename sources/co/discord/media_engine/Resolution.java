package co.discord.media_engine;

import b.d.b.a.a;

/* JADX INFO: compiled from: Statistics.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Resolution {
    private final int height;
    private final int width;

    public Resolution(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ Resolution copy$default(Resolution resolution, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = resolution.width;
        }
        if ((i3 & 2) != 0) {
            i2 = resolution.height;
        }
        return resolution.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final Resolution copy(int width, int height) {
        return new Resolution(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Resolution)) {
            return false;
        }
        Resolution resolution = (Resolution) other;
        return this.width == resolution.width && this.height == resolution.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        StringBuilder sbU = a.U("Resolution(width=");
        sbU.append(this.width);
        sbU.append(", height=");
        return a.B(sbU, this.height, ")");
    }
}
