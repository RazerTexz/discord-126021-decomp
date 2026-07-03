package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class BlendModeUtils {

    /* JADX INFO: renamed from: androidx.core.graphics.BlendModeUtils$1 */
    public static /* synthetic */ class C02231 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$core$graphics$BlendModeCompat;

        static {
            BlendModeCompat.values();
            int[] iArr = new int[29];
            $SwitchMap$androidx$core$graphics$BlendModeCompat = iArr;
            try {
                iArr[BlendModeCompat.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[BlendModeCompat.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    private BlendModeUtils() {
    }

    @Nullable
    @RequiresApi(29)
    public static BlendMode obtainBlendModeFromCompat(@NonNull BlendModeCompat blendModeCompat) {
        switch (blendModeCompat) {
            case CLEAR:
                return BlendMode.CLEAR;
            case SRC:
                return BlendMode.SRC;
            case DST:
                return BlendMode.DST;
            case SRC_OVER:
                return BlendMode.SRC_OVER;
            case DST_OVER:
                return BlendMode.DST_OVER;
            case SRC_IN:
                return BlendMode.SRC_IN;
            case DST_IN:
                return BlendMode.DST_IN;
            case SRC_OUT:
                return BlendMode.SRC_OUT;
            case DST_OUT:
                return BlendMode.DST_OUT;
            case SRC_ATOP:
                return BlendMode.SRC_ATOP;
            case DST_ATOP:
                return BlendMode.DST_ATOP;
            case XOR:
                return BlendMode.XOR;
            case PLUS:
                return BlendMode.PLUS;
            case MODULATE:
                return BlendMode.MODULATE;
            case SCREEN:
                return BlendMode.SCREEN;
            case OVERLAY:
                return BlendMode.OVERLAY;
            case DARKEN:
                return BlendMode.DARKEN;
            case LIGHTEN:
                return BlendMode.LIGHTEN;
            case COLOR_DODGE:
                return BlendMode.COLOR_DODGE;
            case COLOR_BURN:
                return BlendMode.COLOR_BURN;
            case HARD_LIGHT:
                return BlendMode.HARD_LIGHT;
            case SOFT_LIGHT:
                return BlendMode.SOFT_LIGHT;
            case DIFFERENCE:
                return BlendMode.DIFFERENCE;
            case EXCLUSION:
                return BlendMode.EXCLUSION;
            case MULTIPLY:
                return BlendMode.MULTIPLY;
            case HUE:
                return BlendMode.HUE;
            case SATURATION:
                return BlendMode.SATURATION;
            case COLOR:
                return BlendMode.COLOR;
            case LUMINOSITY:
                return BlendMode.LUMINOSITY;
            default:
                return null;
        }
    }

    @Nullable
    public static PorterDuff.Mode obtainPorterDuffFromCompat(@Nullable BlendModeCompat blendModeCompat) {
        if (blendModeCompat == null) {
            return null;
        }
        switch (blendModeCompat) {
            case CLEAR:
                return PorterDuff.Mode.CLEAR;
            case SRC:
                return PorterDuff.Mode.SRC;
            case DST:
                return PorterDuff.Mode.DST;
            case SRC_OVER:
                return PorterDuff.Mode.SRC_OVER;
            case DST_OVER:
                return PorterDuff.Mode.DST_OVER;
            case SRC_IN:
                return PorterDuff.Mode.SRC_IN;
            case DST_IN:
                return PorterDuff.Mode.DST_IN;
            case SRC_OUT:
                return PorterDuff.Mode.SRC_OUT;
            case DST_OUT:
                return PorterDuff.Mode.DST_OUT;
            case SRC_ATOP:
                return PorterDuff.Mode.SRC_ATOP;
            case DST_ATOP:
                return PorterDuff.Mode.DST_ATOP;
            case XOR:
                return PorterDuff.Mode.XOR;
            case PLUS:
                return PorterDuff.Mode.ADD;
            case MODULATE:
                return PorterDuff.Mode.MULTIPLY;
            case SCREEN:
                return PorterDuff.Mode.SCREEN;
            case OVERLAY:
                return PorterDuff.Mode.OVERLAY;
            case DARKEN:
                return PorterDuff.Mode.DARKEN;
            case LIGHTEN:
                return PorterDuff.Mode.LIGHTEN;
            default:
                return null;
        }
    }
}
