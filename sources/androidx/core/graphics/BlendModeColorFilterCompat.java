package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build$VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class BlendModeColorFilterCompat {
    private BlendModeColorFilterCompat() {
    }

    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int i, @NonNull BlendModeCompat blendModeCompat) {
        if (Build$VERSION.SDK_INT >= 29) {
            BlendMode blendModeObtainBlendModeFromCompat = BlendModeUtils.obtainBlendModeFromCompat(blendModeCompat);
            if (blendModeObtainBlendModeFromCompat != null) {
                return new BlendModeColorFilter(i, blendModeObtainBlendModeFromCompat);
            }
            return null;
        }
        PorterDuff$Mode porterDuff$ModeObtainPorterDuffFromCompat = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat);
        if (porterDuff$ModeObtainPorterDuffFromCompat != null) {
            return new PorterDuffColorFilter(i, porterDuff$ModeObtainPorterDuffFromCompat);
        }
        return null;
    }
}
