package androidx.core.view;

import android.graphics.Point;
import android.view.Display$Mode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCompat$ModeCompat {
    private final boolean mIsNative;
    private final Display$Mode mMode;
    private final Point mPhysicalSize;

    public DisplayCompat$ModeCompat(@NonNull Point point) {
        Preconditions.checkNotNull(point, "physicalSize == null");
        this.mPhysicalSize = point;
        this.mMode = null;
        this.mIsNative = true;
    }

    public int getPhysicalHeight() {
        return this.mPhysicalSize.y;
    }

    public int getPhysicalWidth() {
        return this.mPhysicalSize.x;
    }

    @Deprecated
    public boolean isNative() {
        return this.mIsNative;
    }

    @Nullable
    @RequiresApi(23)
    public Display$Mode toMode() {
        return this.mMode;
    }

    @RequiresApi(23)
    public DisplayCompat$ModeCompat(@NonNull Display$Mode display$Mode, boolean z2) {
        Preconditions.checkNotNull(display$Mode, "mode == null, can't wrap a null reference");
        this.mPhysicalSize = new Point(display$Mode.getPhysicalWidth(), display$Mode.getPhysicalHeight());
        this.mMode = display$Mode;
        this.mIsNative = z2;
    }

    @RequiresApi(23)
    public DisplayCompat$ModeCompat(@NonNull Display$Mode display$Mode, @NonNull Point point) {
        Preconditions.checkNotNull(display$Mode, "mode == null, can't wrap a null reference");
        Preconditions.checkNotNull(point, "physicalSize == null");
        this.mPhysicalSize = point;
        this.mMode = display$Mode;
        this.mIsNative = true;
    }
}
