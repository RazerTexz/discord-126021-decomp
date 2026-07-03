package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(@NonNull PointF pointF, float f, @NonNull PointF pointF2, float f2) {
        this.mStart = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.mStartFraction = f;
        this.mEnd = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.mEndFraction = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.mStartFraction, pathSegment.mStartFraction) == 0 && Float.compare(this.mEndFraction, pathSegment.mEndFraction) == 0 && this.mStart.equals(pathSegment.mStart) && this.mEnd.equals(pathSegment.mEnd);
    }

    @NonNull
    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    @NonNull
    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int iHashCode = this.mStart.hashCode() * 31;
        float f = this.mStartFraction;
        int iHashCode2 = (this.mEnd.hashCode() + ((iHashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31)) * 31;
        float f2 = this.mEndFraction;
        return iHashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PathSegment{start=");
        sbM833U.append(this.mStart);
        sbM833U.append(", startFraction=");
        sbM833U.append(this.mStartFraction);
        sbM833U.append(", end=");
        sbM833U.append(this.mEnd);
        sbM833U.append(", endFraction=");
        sbM833U.append(this.mEndFraction);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
