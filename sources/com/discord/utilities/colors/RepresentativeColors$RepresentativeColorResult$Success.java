package com.discord.utilities.colors;

import androidx.annotation.ColorInt;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: RepresentativeColors.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class RepresentativeColors$RepresentativeColorResult$Success extends RepresentativeColors$RepresentativeColorResult {
    private final int color;

    public RepresentativeColors$RepresentativeColorResult$Success(@ColorInt int i) {
        super(null);
        this.color = i;
    }

    public static /* synthetic */ RepresentativeColors$RepresentativeColorResult$Success copy$default(RepresentativeColors$RepresentativeColorResult$Success representativeColors$RepresentativeColorResult$Success, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = representativeColors$RepresentativeColorResult$Success.color;
        }
        return representativeColors$RepresentativeColorResult$Success.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final RepresentativeColors$RepresentativeColorResult$Success copy(@ColorInt int color) {
        return new RepresentativeColors$RepresentativeColorResult$Success(color);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RepresentativeColors$RepresentativeColorResult$Success) && this.color == ((RepresentativeColors$RepresentativeColorResult$Success) other).color;
        }
        return true;
    }

    public final int getColor() {
        return this.color;
    }

    public int hashCode() {
        return this.color;
    }

    public String toString() {
        return a.B(a.U("Success(color="), this.color, ")");
    }
}
